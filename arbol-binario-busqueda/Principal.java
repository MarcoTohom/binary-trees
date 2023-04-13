import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arbol tree = new Arbol();
        int op = 0, i = 0;

        // menu
        do {
            System.out.println("_____________MENU____________\n" +
                              "|1) Arbol Binario de Busqueda.|\n" +
                              "|2) Arbol BB AVL.             |\n" +
                              "|3) Salir.                    |\n" +
                              "|_____________________________|\n");
            System.out.print("Ingrese una opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    do {
                        System.out.println("__MENU ARBOL BINARIO BUSQUEDA__\n" +
                                          "|1) Insertar.                   |\n" +
                                          "|2) Eliminar.                   |\n" +
                                          "|3) Buscar.                     |\n" +
                                          "|4) Recorridos.                 |\n" +
                                          "|5) Regresar al menu general.   |\n" +
                                          "|_______________________________|\n");
                        System.out.print("Ingrese una opcion: ");
                        op = sc.nextInt();
                        switch (op) {
                            case 1:
                                System.out.print("Ingrese un nodo al arbol (Solamente numeros enteros): ");
                                int nod = sc.nextInt();
                                tree.insert(nod);
                                break;
                            case 2:
                                System.out.print("Ingrese un nodo que desee eliminar (Solamente numeros enteros): ");
                                int nod_Elim = sc.nextInt();
                                tree.delete(nod_Elim);
                                break;
                            case 3:
                                    
                                break;
                            case 4:
                                System.out.println("ARBOL BINARIO DE BUSQUEDA:");
                                tree.printTree();
                                System.out.println("Los recorridos del arbol son: \n");
                                System.out.println("Recorrido InOrden:");
                                tree.printTreeInOrder();
                                System.out.println("Recorrido PostOrden:");
                                tree.printTreePostOrder();
                                System.out.println("Recorrido PreOrden:");
                                tree.printTreePreOrder();
                                
                                break;
                            case 5:
                                i = 5;
                                break;
                            default:
                                System.out.println("CUIDADO: ¡Elija una opcion correcta!");
                                break;
                        }
                    } while (i != 5);
                    break;
                case 2:

                    break;
                case 3:
                    i = 3;
                    break;
                default:
                    System.out.println("CUIDADO: ¡Ingrese una opcion correcta!\n");
                    break;
            }
            
        } while (i != 3);

    }
}
