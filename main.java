import java.util.Scanner;

class Handbol{

    public static void main(String args[]){
        int pet;
        Scanner sc = new Scanner(System.in);
        System.out.printf("APLICACIO DEL PARTIT D'HANDBOL\n");
        while((pet = rebreOpcio(sc)) != 0){
            mostrarOpcions();
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
