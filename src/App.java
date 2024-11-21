
import java.util.List;
import java.util.Scanner;

public class App {
    static double[] distants = { 123, 234, 123, 2132134, 123123, 213123, 12313, 2093939 };
    static double[] velocidad = { 200000.0, 10000.1, 50000.2 };
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        
         System.out.println(" ==================================================");
         System.out.println("       BIENVENIDO A ESTE VIAJE INTERPLANETARIO");
         System.out.println("  PREPARA TUS MALETAS Y VAMOS A ESTA GRAN AVENTURA");
         System.out.println("  (recuerda tu punto inicial es el planeta Tierra)");
         System.out.println(" ==================================================");
         
         /*
         * loadBarr();
         */
         
        int option;
        do {
            System.out.println("|||   OPCIONES DISPONIBLES PARA EMPEZAR EL VIAJE  |||");
            System.out.println("||       Selecciona para el proceso del viaje!     ||");
            System.out.println("|1.-------------Seleccionar Planeta.----------------|");
            System.out.println("|2.-------------Selecciona la velocidad.------------|");
            System.out.println("|3.-------------Seleccionar Recursos.---------------|");
            System.out.println("|4.-------------Salir.------------------------------|");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    selectPlanet();
                    break;
                case 2:
                selectVelocity();
                    break;
                case 3:
                    selectResources();
                    break;
                case 4:
                    System.out.println("Gracias por viajar con nosotros. Vueleve pronto ;D");
                    break;

                default:
                    System.err.println("Ingrese una opcion valida.");
                    break;
            }

            /* if (option != 0) {
                pressEnter();
            } */

        } while (option != 4);

        scanner.close();
    }

    /* private static void loadBarr() throws InterruptedException {
        int total = 100; // Total de "pasos" o caracteres para completar la barra de carga
        int progreso = 0; // El progreso actual
        int longitudBarra = 20; // Longitud total de la barra de carga

        // Simulacion o recorrido de un for para simular la carga y dado la longitud
        // calculara el numero de caracteres faltantes
        for (int i = 0; i < total; i++) {
            // Calculamos la cantidad de "#" para llenar la barra de carga

            progreso = (i * longitudBarra) / total;

            // Construimos el inicio de la barra de carga
            String barra = "[";

            for (int j = 0; j < longitudBarra; j++) {
                if (j < progreso) {
                    barra += "#"; // Parte llena de la barra
                } else {
                    barra += " "; // Parte vacía de la barra
                }
            }
            barra += "]";

            // Imprimimos la barra de carga y el porcentaje
            System.out.print("\r" + barra + " " + i + "%");

            // Pausa para simular el tiempo de carga

            Thread.sleep(55); // 100 ms de pausa entre cada actualización

        }

        // Después de completar la carga
        System.out.println("\nTodos los sistemas en linea!\n");
    } */

    private static void selectPlanet() {
        int option;
        do {
            var planets = List.of("Marte", "Mercurio", "Venus", "Júpiter", "Saturno", "Urano", "Neptuno");

            System.out.println("                PLANETAS DISPONIBLES PARA VIAJAR     ");
            System.out.println("                ---------------------------------    ");
            System.out.println("|Estimado tripulante, seleccione uno de los siguientes planetas para viajar!|");
            System.out.println("1. Marte");
            System.out.println("2. Mercurio");
            System.out.println("3. Venus");
            System.out.println("4. Júpiter");
            System.out.println("5. Saturno");
            System.out.println("6. Urano");
            System.out.println("7. Neptuno");
            System.out.println("0. Volver al menú principal");
            option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Regresando al menú principal...");
                break;
            } else if (option >= 1 && option <= 7) {
                System.out.println("Has seleccionado viajar a " + planets.get(option - 1) + "!");
            } else {
                System.err.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (true);
    }
    
            /* // Asegurarse de que la opción esté en el rango correcto (1-7), de lo contrario, no hacer nada.
            if (option >= 1 && option <= planets.size()) {
                var planet = planets.get(option - 1);  // Ajustar para que el índice comience desde 0
                System.out.println("Has seleccionado: " + planet);
                selectPlanet=true;
            } else if (option != 0) {
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (!selectPlanet);  // El bucle continuará hasta que el usuario seleccione la opción 0.
    
        sc.close();
    } */


    private static void selectVelocity() {

    }

    private static void selectResources() {
    }

   /*  private static void pressEnter() {
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
    }
 */
}
