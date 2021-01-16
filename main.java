import java.beans.IntrospectionException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;  
class Handbol{

    public static void main(String args[]){
        Partit partit = new Partit();
        Vector<Equip> equips = new Vector<Equip>();
        Vector<Jugador> jugadorsEquipLocalPista = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquipLocalBanqueta = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquipVisitantPista = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquipVisitantBanqueta = new Vector<Jugador>();
        Vector<Arbitre> arbitres = new Vector<Arbitre>();
        Vector<Entrenador> entrenadors = new Vector<Entrenador>();
        int ultimaInstruccio;

        ultimaInstruccio = 0;
        String pet;
        Scanner sc = new Scanner(System.in);
        System.out.println("APLICACIO DEL PARTIT D'HANDBOL");
        llegirDades(equips, jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, 
            jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, arbitres, entrenadors, partit);
        mostrarOpcions();
        while(!(pet = rebreOpcio(sc)).equals("0")){
            switch (pet) {
                case "0":
                    break;
                case "1":
                    if(enviarMissatgeJugadorsBanqueta(sc, equips, entrenadors, partit) == -1){
                        System.out.println("AQUEST EQUIP NO PARTICIPA EN EL PARTIT");
                    }
                    break;
            
                case "2":
                    excloureJugador (ultimaInstruccio, jugadorsEquipLocalPista, jugadorsEquipVisitantPista, arbitres, partit);
                    break;

                case "3":
                    Jugador jPista = null, jBanqueta = null;
                    Entrenador e = null;
                    int resEscollirEq = escollirEquipIJugadors(equips, jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, jPista, jBanqueta, e, ultimaInstruccio);
                    if (resEscollirEq == -1) System.out.println("No s'ha trobat l'Equip entrat");
                    else if (resEscollirEq == -2) System.out.println("No s'ha trobat el jugador de Pista entrat");
                    else if (resEscollirEq == -3) System.out.println("No s'ha trobat el jugador de Banqueta entrat");
                    /*else if (resEscollirEq > 0)
                    {
                        //FALLA AQUI!!!!
                        //Diu que jBanqueta = null
                        System.out.println(jBanqueta);
                        canviJugadors(jPista, jBanqueta, e, ultimaInstruccio);
                    }*/
                    break;
                default:
                    System.out.println("SI ET PLAU, INTRODUEIX UNA OPCIO VALIDA :-)");
            }
            mostrarOpcions();
        }
        System.out.println("TANCADA LA APLICACIO, VAGI BE!");

    }







    public static void mostrarOpcions(){
        System.out.println("+--------------------------------------------------+");
        System.out.println("| (1) ENVIAR MISSATGE ALS JUGADORS DE LA BANQUETA  |");
        System.out.println("| (2) EXCLOURE JUGADOR                             |");
        System.out.println("| (3) FER CANVI DE JUGADORS                        |");
        System.out.println("| (0) TANCAR APLICACIO                             |");
        System.out.println("+-------------------------------------------------+|");
        System.out.print("Opcio: ");
    }




    public static String rebreOpcio(Scanner sc){
        String t  = sc.nextLine();
        return t;
    }


    public static int escollirEquipIJugadors(Vector<Equip> equips, Vector<Jugador> jugadorsEquipLocalPista, Vector<Jugador> jugadorsEquipLocalBanqueta,
                                              Vector<Jugador> jugadorsEquipVisitantPista, Vector<Jugador> jugadorsEquipVisitantBanqueta, Jugador jPista, Jugador jBanqueta, Entrenador e, int ultimaIns)
    {
        Vector<Jugador> pista = null, banqueta = null;

        System.out.println("Introdueixi nom de l'equip per fer el canvi:");
        System.out.println(equips.get(0) + " (Local)");
        System.out.println(equips.get(1) + " (Visitant)");
        System.out.print("NOM: ");
        Scanner keyboard = new Scanner(System.in);
        String nomEquip = keyboard.nextLine();

        if (equips.get(0).nomEquip().equals(nomEquip)) {pista = jugadorsEquipLocalPista; banqueta = jugadorsEquipLocalBanqueta; e=equips.get(0).entrenador();}
        else if (equips.get(1).nomEquip().equals(nomEquip)) {pista = jugadorsEquipVisitantPista; banqueta = jugadorsEquipVisitantBanqueta; e=equips.get(1).entrenador();}
        else return -1; //Equip no trobat

        System.out.println("********************Llista de jugadors a PISTA:********************\n");
        mostrarJugadors(pista);
        System.out.print("Introdueixi NOM jugador pista: ");
        String nomPista = keyboard.nextLine();

        for (Jugador j: pista) if(j.nom().equals(nomPista)) jPista=j;
        if (jPista == null) return -2; //Jugador pista no trobat

        System.out.println("********************Llista de jugadors a BANQUETA:********************\n");
        mostrarJugadors(banqueta);
        System.out.print("Introdueixi NOM jugador banqueta: ");
        String nomBanqueta = keyboard.nextLine();

        for (Jugador j: banqueta) if(j.nom().equals(nomBanqueta)) jBanqueta=j;
        if (jBanqueta == null) return -3; //Jugador banqueta no trobat

        System.out.println(jBanqueta);



        System.out.println("Esculli el rol que tindrà el jugador entrant:");

        System.out.print("Introdueixi Atac [A] o Defensa [D]: ");
        String AoD = keyboard.nextLine();
        System.out.print("Introdueixi Rol [posicio_orientacio]: ");
        String descripcio_rol = keyboard.nextLine();

        Rol rol = jBanqueta.crearRol(descripcio_rol, AoD);
        ultimaIns ++;
        Vector<Jugador> receptors = new Vector<Jugador>();
        receptors.add(jBanqueta);
        Assignacio assig = new Assignacio(ultimaIns, e, receptors, "Assignacio rol", null, e.CoV(), rol);
        //Tractar error

        e.assignarRol(assig);
        ultimaIns ++;

        Canvi canvi = new Canvi(ultimaIns, e, e.CoV(), jPista, jBanqueta);
        e.canviarJugador(canvi);

        return 1;

    }

    public static int canviJugadors(Jugador pista, Jugador banqueta, Entrenador e, int ultimaIns)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Esculli el rol que tindrà el jugador entrant:");

        System.out.print("Introdueixi Atac [A] o Defensa [D]: ");
        String AoD = keyboard.nextLine();
        System.out.print("Introdueixi Rol [posicio_orientacio]: ");
        String descripcio_rol = keyboard.nextLine();

        Rol rol = banqueta.crearRol(descripcio_rol, AoD);
        ultimaIns ++;
        Vector<Jugador> receptors = new Vector<Jugador>();
        receptors.add(banqueta);
        Assignacio assig = new Assignacio(ultimaIns, e, receptors, "Assignacio rol", null, e.CoV(), rol);
        //Tractar error

        e.assignarRol(assig);
        ultimaIns ++;

        Canvi canvi = new Canvi(ultimaIns, e, e.CoV(), pista, banqueta);
        e.canviarJugador(canvi);

        return 1;
    }


    public static void llegirDades(Vector<Equip> equips, Vector<Jugador> jugadorsEquipLocalPista, Vector<Jugador> jugadorsEquipLocalBanqueta,
                    Vector<Jugador> jugadorsEquipVisitantPista, Vector<Jugador> jugadorsEquipVisitantBanqueta, Vector<Arbitre> arbitres,
                        Vector<Entrenador> entrenadors, Partit partit){
            try{
                File myObj = new File("info.txt");
                Scanner myReader = new Scanner(myObj);
                llegirEquips(equips, myReader, partit);
                llegirArbitres(arbitres, myReader, partit);
                llegirEntrenadors(entrenadors, myReader, equips.get(0), equips.get(1), partit);

                llegirJugadors(jugadorsEquipLocalPista, myReader, false, entrenadors.get(0),equips.get(0), "D", partit);
                llegirJugadors(jugadorsEquipLocalBanqueta, myReader, true, entrenadors.get(0),equips.get(0), "D", partit);
                llegirJugadors(jugadorsEquipVisitantPista, myReader, false, entrenadors.get(1),equips.get(1), "A", partit);
                llegirJugadors(jugadorsEquipVisitantBanqueta, myReader, true, entrenadors.get(1),equips.get(1), "A", partit);
                
                equips.get(0).afageixPersonal(jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, entrenadors.get(0));
                equips.get(1).afageixPersonal(jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, entrenadors.get(1));
               
                partit.entrarEquips(equips.get(0), equips.get(1));
                partit.entrarArbitres(arbitres.get(0), arbitres.get(1));

                partit.entrarJugadors(jugadorsEquipLocalPista, "pista", "local");
                partit.entrarJugadors(jugadorsEquipLocalBanqueta, "banqueta", "local");
                partit.entrarJugadors(jugadorsEquipVisitantPista, "pista", "visitant");
                partit.entrarJugadors(jugadorsEquipVisitantBanqueta, "banqueta", "visitant");



            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }






    public static int enviarMissatgeJugadorsBanqueta(Scanner sc, Vector<Equip> equips, Vector<Entrenador> entrenadors, Partit partit){
        Entrenador e = null;
        String nomEquip , msg;
        System.out.println("Esculli l'equip en el qual vols enviar el missatge a la banqueta: ");
        System.out.println(equips.get(0) + " (Local)");
        System.out.println(equips.get(1) + " (Visitant)");
        nomEquip =  sc.nextLine();
        System.out.printf("MISSATGE A TRANSMETRE: ");
        msg =  sc.nextLine();
        Instruccio instr = null;
        if(entrenadors.get(0).equip().nomEquip().equals(nomEquip)){
            e = entrenadors.get(0);
            instr = new Instruccio(1, e, partit.jugadorsEquipLocalBanqueta(), msg, "banqueta", 'C');
        } else if(entrenadors.get(1).equip().nomEquip().equals(nomEquip)){
            e = entrenadors.get(1);
            instr = new Instruccio(1, e, partit.jugadorsEquipVisitantBanqueta(), msg, "banqueta", 'V');
        } else {return -1;}
        e.enviarMissatgeJugadors(instr);
        return 1;
        
    }





    public static void llegirEquips(Vector<Equip> equips, Scanner myReader, Partit partit){
        int i = 0;
        String nomEquip = "";
        String codi = "";
        String data = myReader.next();
        char cov = 'C';
        while (!data.equals("#")) {
            switch(i){
                case 0:
                    nomEquip = data;
                    data = myReader.next();
                    i++;
                    break;
                case 1:
                    codi = data;
                    i++;
                    break;
                case 2:
                    Equip e = new Equip(Integer.parseInt(codi), nomEquip, 12, partit, cov);
                    equips.add(e);
                    data = myReader.next();
                    i = 0;
                    break;
            }
            cov = 'V';
        }
    }







    public static void llegirArbitres(Vector<Arbitre> arbitres, Scanner myReader, Partit partit){
        int i = 0;
        String nom = "";
        String cognom = "";
        String codi = "";
        String data = myReader.next();
        while (!data.equals("#")) {
            switch(i){
                case 0:
                    nom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 1:
                    cognom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 2:
                    codi = data;
                    i++;
                    break;
                case 3:
                    Arbitre a = new Arbitre(nom, cognom, Integer.parseInt(codi), partit);
                    arbitres.add(a);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }






    public static void llegirEntrenadors(Vector<Entrenador> entrenadors, Scanner myReader, Equip local, Equip visitant, Partit partit){
        int i = 0;
        int aux = 0;
        String nom = "";
        String cognom = "";
        String codi = "";
        String data = myReader.next();
        while (!data.equals("#")) {
            switch(i){
                case 0:
                    nom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 1:
                    cognom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 2:
                    codi = data;
                    i++;
                    break;
                case 3:
                    Entrenador a = null;
                    if(aux == 0){
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), local, partit, 'C');
                        aux = 1;
                    } else {
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), visitant, partit, 'V');
                    }
                    entrenadors.add(a);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }







    public static void llegirJugadors(Vector<Jugador> jugadors, Scanner myReader, boolean banqueta, Entrenador entrenador, Equip equip, String atacODefensa, Partit partit){
        int i = 0;
        String nom="", cognom="", codi="", estil="", alcada="", pes="", descripcio_rol = "";
        String data = myReader.next();
        while (!data.equals("#")) {
            switch(i){
                case 0:
                    nom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 1:
                    cognom = data;
                    data = myReader.next();
                    i++;
                    break;
                case 2:
                    codi = data;
                    data = myReader.next();
                    i++;
                    break;
                case 3:
                    estil = data;
                    data = myReader.next();
                    i++;
                    break;
                case 4:
                    alcada = data;
                    data = myReader.next();
                    i++;
                    break;
                case 5:
                    pes = data;
                    data = myReader.next();
                    i++;
                    break;
                case 6:
                    descripcio_rol = data;
                    i++;
                    break;
                case 7:
                    Jugador j = new Jugador(nom, cognom, Integer.parseInt(codi), estil, Double.parseDouble(alcada), Double.parseDouble(pes), equip, entrenador, descripcio_rol, banqueta, atacODefensa, partit);
                    jugadors.add(j);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }

    public static void excloureJugador (int ultimaInstruccio, Vector<Jugador> local, Vector<Jugador> visitant, Vector<Arbitre> arbits, Partit partit) {

        System.out.println("********************Llista de jugadors:********************\n"); // entrar jugador
        
        System.out.println("   - Equip local:\n");
        mostrarJugadors(local);

        System.out.println("   - Equip visitant:\n");
        mostrarJugadors(visitant);
        
        System.out.println("Indica el nom del jugador"); // entrar jugador

        Scanner keyboard = new Scanner(System.in);
        String nom = keyboard.nextLine();
        
        boolean trobat = false;
        int pos = 0;

        Jugador j = null;
        char cOv = ' ';

        while (!trobat && pos<local.size()){
            if (local.get(pos).nom().compareTo(nom)==0) trobat = true;
            else pos++;
        }

        if (!trobat) {
            pos = 0;
            while (!trobat && pos<visitant.size()){
                if (visitant.get(pos).nom().compareTo(nom)==0) trobat = true;
                else pos++;
            }
        } else {
            j = local.get(pos);
            cOv = 'C';
        }

        if (!trobat) System.out.println ("Error: Jugador innexistent\n");
        else {

            mostrarArbits(arbits);
            System.out.print("Introdueixi nom de l'Àrbitre que realitzarà l'exclusió: ");
            String nomArbit = keyboard.nextLine();

            boolean trobatArbit = false;
            int i = 0;

            Arbitre a;

            while (!trobatArbit && i<arbits.size()){
                if (arbits.get(i).nom().compareTo(nomArbit)==0) trobatArbit = true;
                else i++;
            }
            
            if (!trobatArbit) {
                System.out.println("Error: Arbitre no existent\n");
            } else {
                a = arbits.get(i);

                if (cOv==' '){
                    cOv = 'V';
                    j = visitant.get(pos);
                }

                ultimaInstruccio++;
                Sancio instr = null;
                instr = new Sancio (ultimaInstruccio, a, cOv, j, "E");

                int res = partit.exclouJugador(instr);
                if (res == -1) {
                    System.out.println("Error: No s'ha pogut excloure al jugador del partit.\n");
                } else if (res == 1) System.out.println("El jugador ha estat exclos\n");
                else System.out.println ("El jugador ha estat exclos i expulsat.\n");
            }
        }

    }

    private static void mostrarJugadors(Vector<Jugador> jugadors) {

        for (int i=0; i<jugadors.size(); i++) {
            System.out.println("    -> " + jugadors.get(i) + "\n");
        }
    
     }

     private static void mostrarArbits(Vector<Arbitre> arbits) {
        for (int i=0; i<arbits.size(); i++) {
            System.out.println("    -> " + arbits.get(i) + "\n");
        }
     }

 }
