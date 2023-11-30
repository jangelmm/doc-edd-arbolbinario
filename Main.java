import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbolBinario = new ArbolBinario();
        int opcion;
       
        do{
            System.out.println("1. Agregar un elemento");
            System.out.println("2. Buscar un elemento");
            System.out.println("3. Imprimir Inorden");
            System.out.println("4. Imprimir Preorden");
            System.out.println("5. Imprimir Postorden");
            System.out.println("6. Contar Hojas");
            System.out.println("7. Contar Nodos");
            System.out.println("8. Contar Padres");
            System.out.println("9. Agregar de forma recursiva");
            System.out.println("10. Borrar Nodo");
            System.out.println("11. Borrar Todos los Nodos");
            System.out.println("12. Buscar de forma recursiva");
            System.out.println("13. Eliminar de forma recursiva");
            System.out.println("0. Salir");
            System.out.print("Seleccione su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Digite un elemento a agregar: "); int elemento1 = scanner.nextInt();
                    if(arbolBinario.agregar(elemento1)){
                        System.out.println("Elemento agregado con exito");
                    }
                    else{
                        System.out.println("Fallo al agregar el elemento");
                    }
                break;
                case 2:
                    System.out.print("Digite el elemento a buscar: "); int elemento2 = scanner.nextInt();
                    if(arbolBinario.buscarBool(elemento2)){
                        System.out.println("El elemento se encuentra en el arbol");
                    }
                    else{
                        System.out.println("El elemento no se encuentra en el arbol");
                    }
                break;
                case 3:
                    arbolBinario.inorden();
                    System.out.println();
                break;
                case 4:
                    arbolBinario.preorden();
                    System.out.println();
                break;
                case 5:
                    arbolBinario.postorden();
                    System.out.println();
                break;
                case 6:
                    System.out.println("El numero de Hojas del Arbol Binario es: " + arbolBinario.contarHojas());
                break;
                case 7:
                    System.out.println("El numero de Nodos en el Arbol Binario es: " +  arbolBinario.contarNodos());
                break;
                case 8:
                    System.out.println("El numero de padres en el Arbol Binario es: "+ arbolBinario.contarPadres());
                break;
                case 9:
                    System.out.print("Digite un elemento a agregar: "); int elemento9 = scanner.nextInt();
                    if(arbolBinario.agregarRecursiva(elemento9)){
                        System.out.println("Elemento agregado con exito");
                    }
                    else{
                        System.out.println("Fallo al agregar el elemento");
                    }
                break;
                case 10:
                    System.out.print("Digite el elemento a borrar: "); int elemento10 = scanner.nextInt();
                    if(arbolBinario.eliminar(elemento10)){
                        System.out.println("Elemento eliminado con éxito");
                    }
                    else{
                        System.out.println("Fallo al eliminar el elemento");
                    }
                break;
                case 11:
                    arbolBinario.eliminarTodo();
                break;
                case 12:
                    System.out.print("Digite el elemento a buscar: "); int elemento12 = scanner.nextInt();
                    if(arbolBinario.buscarNodo(elemento12)){
                        System.out.println("El elemento SI se encuentra en el Arbol Binario");
                    }
                    else{
                        System.out.println("El elemento NO se encuentra en el Arbol Binario");
                    }
                break;
                case 13:
                    System.out.print("Digite el elemento a borrar: "); int elemento13 = scanner.nextInt();
                    System.out.println("Elemento retornado: " + arbolBinario.eliminarRecursivo(elemento13));
                break;
                default:
                    System.out.println("opcion no valida, intente de nuevo");
                    break;
            }
            System.out.println();
        }while(opcion != 0);
    }
}
