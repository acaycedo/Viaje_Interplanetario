import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("INSERTAR LOGO NAVE");
        System.out.println("INSERTAR BIENVENIDA");
        System.out.println("etc Y MAS DETALLES");
        loadBarr();
        showPlanet(scanner);
        var locationInit = "Tierra";

        /*
         * Seleccionar destino interplanetario
         * - Permitir al usuario elegir un planeta destino entre una lista de planetas del
         * sistema solar (Mercurio, Venus, Marte, Júpiter, Saturno, etc.).
         */

    }

    private static void loadBarr() throws InterruptedException {
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
    }

    private static void showPlanet(Scanner scanner) {
        // Planetas disponibles para viajar
        /*
         * "Ninguno", // Índice 0 no se usa
         * "Mercurio", // Mercurio
         * "Venus", // Venus
         * "Marte", // Marte
         * "Júpiter", // Júpiter
         * "Saturno", // Saturno
         * "Urano", // Urano
         * "Neptuno" // Neptuno
         * "Tierra"
         */

        int option;

        do {

            System.out.println("PLANETAS DISPONIBLES PARA VIAJAR");
            System.out.println("---------------------------------");
            System.out.println("Estimado tripulante selecciones uno de los siguientes planetas para viajar: ");
            System.out.println("1. Mercurio");
            System.out.println("2. Venus");
            System.out.println("3. Marte");
            System.out.println("4. Júpiter");
            System.out.println("5. Saturno");
            System.out.println("6. Urano");
            System.out.println("7. Neptuno");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    planetMercurio();
                    break;
                default:
                    System.err.println("Ingrese una opcion valida.");
                    break;
            }
            if (option != 0) {
                pressEnter(scanner);
            }
        } while (option != 0);
        System.out.println("Opcion no valida, por favor escoja un planeta dentro de las opciones");
    }

    private static void planetMercurio() {
        System.out.println("Hola mundo");

    }

    private static void pressEnter(Scanner scanner) {
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
    }

}
