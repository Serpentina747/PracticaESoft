import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
class Handbol{

    public static void main(String args[]){
        int pet;
        Scanner sc = new Scanner(System.in);
        System.out.printf("APLICACIO DEL PARTIT D'HANDBOL\n");
        mostrarOpcions();
        while((pet = rebreOpcio(sc)) != 0){
            switch (pet) {
                case 0:
                    break;
                case 1:
                    
                    break;
            
                case 2:
                    break;

                case 3:
                    break;
                default:
                    System.out.printf("SI ET PLAU, INTRODUEIX UNA OPCIO VALIDA :-) \n");
            }
            mostrarOpcions();
        }
        System.out.printf("TANCADA LA APLICACIO, VAGI BE!");

    }
    public static void mostrarOpcions(){
        System.out.printf("+--------------------------------------------------+\n");
        System.out.printf("| (1) ENVIAR MISSATGE ALS JUGADORS DE LA BANQUETA  |\n");
        System.out.printf("| (2) EXCLOURE JUGADOR                             |\n");
        System.out.printf("| (3) FER CANVI DE JUGADORS                        |\n");
        System.out.printf("| (0) TANCAR APLICACIO                             |\n");
        System.out.printf("+-------------------------------------------------+|\n");
    }
    public static int rebreOpcio(Scanner sc){
        int t  = sc.nextInt();
        return t;
    }
 }
