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

        int pet;
        Scanner sc = new Scanner(System.in);
        System.out.println("APLICACIO DEL PARTIT D'HANDBOL");
        llegirDades(equips, jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, 
            jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, arbitres, entrenadors, partit);
        mostrarOpcions();
        while((pet = rebreOpcio(sc)) != 0){
            switch (pet) {
                case 0:
                    break;
                case 1:
                    if(enviarMissatgeJugadorsBanqueta(sc, equips, entrenadors, partit) == -1){
                        System.out.println("AQUEST EQUIP NO PARTICIPA EN EL PARTIT");
                    }
                    break;
            
                case 2:
                    break;

                case 3:
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




    public static int rebreOpcio(Scanner sc){
        int t  = sc.nextInt();
        return t;
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
                System.out.println(equips.get(0));
                System.out.println(equips.get(1));
                System.out.println(arbitres.get(0));
                System.out.println(arbitres.get(1));
                System.out.println(entrenadors.get(0));
                System.out.println(entrenadors.get(1));
                llegirJugadors(jugadorsEquipLocalPista, myReader, false, entrenadors.get(0),equips.get(0), "D", partit);
                llegirJugadors(jugadorsEquipLocalBanqueta, myReader, true, entrenadors.get(0),equips.get(0), "D", partit);
                llegirJugadors(jugadorsEquipVisitantPista, myReader, false, entrenadors.get(1),equips.get(1), "A", partit);
                llegirJugadors(jugadorsEquipVisitantBanqueta, myReader, true, entrenadors.get(1),equips.get(1), "A", partit);

                equips.get(0).afageixPersonal(jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, entrenadors.get(0));
                equips.get(1).afageixPersonal(jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, entrenadors.get(1));

                partit.entrarEquips(equips.get(0), equips.get(1));
                partit.entrarArbitres(arbitres.get(0), arbitres.get(1));
                partit.entrarJugadors(jugadorsEquipLocalPista, "local", "pista");
                partit.entrarJugadors(jugadorsEquipLocalBanqueta, "local", "banqueta");
                partit.entrarJugadors(jugadorsEquipVisitantPista, "visitant", "pista");
                partit.entrarJugadors(jugadorsEquipVisitantBanqueta, "visitant", "banqueta");



            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }






    public static int enviarMissatgeJugadorsBanqueta(Scanner sc, Vector<Equip> equips, Vector<Entrenador> entrenadors, Partit partit){
        Entrenador e = null;
        String nomEquip , msg;
        System.out.println("Esculli l'euip en el qual vol enviar el missatge a la banqueta: ");
        System.out.println(equips.get(0) + " (Local)");
        System.out.println(equips.get(1) + " (Visitant)");
        nomEquip =  sc.next();
        System.out.printf("MISSATGE A TRANSMETRE: ");
        msg =  sc.next();
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






    //Primer equip=local, segon=visitant
    public static void llegirEquips(Vector<Equip> equips, Scanner myReader, Partit partit){
        int i = 0;
        String nomEquip = "";
        String codi = "";
        String data = myReader.next();
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
                    Equip e = new Equip(Integer.parseInt(codi), nomEquip, 12, partit);
                    equips.add(e);
                    data = myReader.next();
                    i = 0;
                    break;
            }
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
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), local, partit);
                        aux = 1;
                    } else {
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), visitant, partit);
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
 }
