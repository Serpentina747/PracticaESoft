import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;  
class Handbol{

    public static void main(String args[]){
        Vector<Equip> equips = new Vector<Equip>();
        Vector<Persona> jugadorsEquipLocalPista = new Vector<Persona>();
        Vector<Persona> jugadorsEquipLocalBanqueta = new Vector<Persona>();
        Vector<Persona> jugadorsEquipVisitantPista = new Vector<Persona>();
        Vector<Persona> jugadorsEquipVisitantBanqueta = new Vector<Persona>();
        Vector<Persona> arbitres = new Vector<Persona>();
        Vector<Persona> entrenadors = new Vector<Persona>();

        int pet;
        Scanner sc = new Scanner(System.in);
        System.out.println("APLICACIO DEL PARTIT D'HANDBOL");
        llegirDades(equips, jugadorsEquipLocalPista, jugadorsEquipLocalBanqueta, jugadorsEquipVisitantPista, jugadorsEquipVisitantBanqueta, arbitres, entrenadors);
        mostrarOpcions();
        while((pet = rebreOpcio(sc)) != 0){
            switch (pet) {
                case 0:
                    break;
                case 1:
                    enviarMissatgeJugadorsBanqueta(sc);
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
    }
    public static int rebreOpcio(Scanner sc){
        int t  = sc.nextInt();
        return t;
    }
    public static void llegirDades(Vector<Equip> equips, Vector<Persona> jugadorsEquipLocalPista, Vector<Persona> jugadorsEquipLocalBanqueta,
                    Vector<Persona> jugadorsEquipVisitantPista, Vector<Persona> jugadorsEquipVisitantBanqueta, Vector<Persona> arbitres,
                        Vector<Persona> entrenadors){
            try{
                File myObj = new File("info.txt");
                Scanner myReader = new Scanner(myObj);
                llegirEquips(equips, myReader);
                llegirArbitres(arbitres, myReader);
                llegirEntrenadors(entrenadors, myReader, equips.get(0), equips.get(1));
                System.out.println(equips.get(0));
                System.out.println(equips.get(1));
                System.out.println(arbitres.get(0));
                System.out.println(arbitres.get(1));
                System.out.println(entrenadors.get(0));
                System.out.println(entrenadors.get(1));
                /*llegirJugadors(jugadorsEquipLocalPista, myReader, false, equips.get(0));
                llegirJugadors(jugadorsEquipLocalBanqueta, myReader, true, equips.get(0));
                llegirJugadors(jugadorsEquipVisitantPista, myReader, false, equips.get(1));
                llegirJugadors(jugadorsEquipVisitantBanqueta, myReader, true, equips.get(1));*/
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
    public static void enviarMissatgeJugadorsBanqueta(Scanner sc){
        String nomEquip , msg;
        System.out.printf("IDENTIFICA EQUIP: ");
        nomEquip =  sc.next();
        System.out.printf("MISSATGE A TRANSMETRE: ");
        msg =  sc.next();
    }
    public static void llegirEquips(Vector<Equip> equips, Scanner myReader){
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
                    Equip e = new Equip(Integer.parseInt(codi), nomEquip, 12);
                    equips.add(e);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }
    public static void llegirArbitres(Vector<Persona> arbitres, Scanner myReader){
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
                    Persona a = new Arbitre(nom, cognom, Integer.parseInt(codi));
                    arbitres.add(a);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }
    public static void llegirEntrenadors(Vector<Persona> entrenadors, Scanner myReader, Equip local, Equip visitant){
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
                    Persona a = null;
                    if(aux == 0){
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), local);
                        aux = 1;
                    } else {
                        a = new Entrenador(nom, cognom, Integer.parseInt(codi), visitant);
                    }
                    entrenadors.add(a);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }
    /*public static void llegirJugadors(Vector<Persona> jugadors, Scanner myReader, boolean banqueta, Entrenador entrenador, Equip equip){
        int i = 0;
        String nom, cognom, codi, estil, alcada, pes, descripcio_rol = "";
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
                    data = myReader.next();
                    i++;
                    break;
                case 7:
                    Persona j = new Jugador(nom, cognom, Integer.parseInt(codi), estil, alcada, pes, equip, entrenador, descripcio_rol, banqueta);
                    jugadors.add(j);
                    data = myReader.next();
                    i = 0;
                    break;
            }
        }
    }*/
 }
