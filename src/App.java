
import java.util.List;
import java.util.Scanner;

public class App {
    static double[] distants = {78.0, 91.0, 41.0, 628.0, 1275.0, 2724.0, 4351.0};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        
         System.out.println(" ==================================================");
         System.out.println("       BIENVENIDO A ESTE VIAJE INTERPLANETARIO!");
         System.out.println("  PREPARA TUS MALETAS Y VAMOS A ESTA GRAN AVENTURA!");
         System.out.println("  (recuerda tu punto inicial es el planeta Tierra)");
         System.out.println(" ==================================================");
         
         /*
         * loadBarr();
         */
         
        int option;
        do {
            System.out.println("|||   OPCIONES DISPONIBLES PARA EMPEZAR EL VIAJE  |||");
            System.out.println("||       Selecciona para el proceso del viaje!     ||");
            System.out.println("|1.-------------Seleccionar Planeta y velocidad.----|");
            System.out.println("|2.-------------Seleccionar Recursos.---------------|");
            System.out.println("|3.-------------Salir.------------------------------|");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    selectPlanet();
                    break;
                case 2:
                    selectResources();
                    break;
                case 3:
                    System.out.println("Gracias por viajar con nosotros. Vueleve pronto ;D");
                    break;

                default:
                    System.err.println("Ingrese una opcion valida.");
                    break;
            }

            /* if (option != 0) {
                pressEnter();
            } */

        } while (option != 3);

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
            String[] planets = {"Marte", "Mercurio", "Venus", "Júpiter", "Saturno", "Urano", "Neptuno"};

            System.out.println("                ---------------------------------    ");
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
                String planet = planets[option - 1];
                double distance = distants[option - 1] * 1000000; // Convertir a km
                calcularTiempo(planet, distance);
            } else {
                System.err.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (true);
    }

    private static void calcularTiempo(String planet, double distance) {
        System.out.println("Has seleccionado viajar a " + planet + ".");
        System.out.print("Por favor, ingresa la velocidad de tu nave (en km/h): ");
        double velocity = scanner.nextDouble();

        if (velocity <= 0) {
            System.err.println("La velocidad debe ser mayor que cero. Inténtalo de nuevo.");
            return;
        }

        double time = distance / velocity; // Tiempo en horas
        int days = (int) (time / 24); // Convertir a días 
        int hours = (int) (time % 24); // Horas restantes
        //el (int) elimina la parte decimal, lo que significa que se obtiene solo la parte entera de un número.

        System.out.println("###############################################");
        System.out.printf("Distancia desde la Tierra a %s: %.0f km.%n", planet, distance);
        System.out.println("Velocidad de la nave: " + velocity + " km/h.");
        System.out.println("Tiempo estimado de viaje: " + days + " días y " + hours + " horas.");
        System.out.println("###############################################");
    }


    private static void selectResources() {
    }

   /*  private static void pressEnter() {
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
    }
 */
}
