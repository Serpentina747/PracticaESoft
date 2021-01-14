import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;  
class Handbol{

    public static void main(String args[]){
        Vector<Equip> equips = new Vector<Equip>();
        Vector<Jugador> jugadorsEquip1 = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquip1Banqueta = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquip2 = new Vector<Jugador>();
        Vector<Jugador> jugadorsEquip2Banqueta = new Vector<Jugador>();
        Vector<Arbitre> arbitres = new Vector<Arbitre>();
        Vector<Entrenador> entrenadors = new Vector<Entrenador>();

        int pet;
        Scanner sc = new Scanner(System.in);
        System.out.println("APLICACIO DEL PARTIT D'HANDBOL");
        llegirDades(equips, jugadorsEquip1, jugadorsEquip1Banqueta, jugadorsEquip2, jugadorsEquip2Banqueta, arbitres, entrenadors);
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
    public static void llegirDades(Vector<Equip> equips, Vector<Jugador> jugadorsEquip1, Vector<Jugador> jugadorsEquip1Banqueta,
                    Vector<Jugador> jugadorsEquip2, Vector<Jugador> jugadorsEquip2Banqueta, Vector<Arbitre> arbitres,
                        Vector<Entrenador> entrenadors){
            try{
                File myObj = new File("info.txt");
                Scanner myReader = new Scanner(myObj);
                llegirEquips(equips, myReader);
                /*llegirArbitres(arbitres, myReader);*/
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
        myReader.close();
    }
    public static void llegirArbitres(Vector<Arbitre> arbitres, Scanner myReader){
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
                    /*Arbitre a = new Persona(nom, cognom, Integer.parseInt(codi));
                    arbitres.add(a);
                    data = myReader.next();
                    i = 0;
                    break;*/
            }
        }
    }
 }
