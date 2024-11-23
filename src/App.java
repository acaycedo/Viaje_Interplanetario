
import java.util.Scanner;

public class App {
    static String[] planets = { "Marte", "Mercurio", "Venus", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double[] distances = { 78.0, 91.0, 41.0, 628.0, 1275.0, 2724.0, 4351.0 };
    static String[] descripciones = {
            "Marte es conocido como el planeta rojo debido a su color característico.",
            "Mercurio es el planeta más cercano al Sol.",
            "Venus es el planeta más parecido a la Tierra en términos de tamaño y composición.",
            "Júpiter es el gigante gaseoso más grande del Sistema Solar.",
            "Saturno es famoso por sus impresionantes anillos, compuestos por hielo y roca.",
            "Urano es un gigante helado que se distingue por su color azul verdoso.",
            "Neptuno es el planeta más alejado del Sol."
    };
    //Se establecio una variable global tipo entero para poder usarla en cualquier funcion y no repetir
    static Integer option;
    //Se establecio una variable global tipo Scanner para poder usarla en cualquier funcion y no repetir
    static Scanner scanner = new Scanner(System.in);
    //consumo de la nave por cada 100 km
    static double velocitySelected = 0.0; //Se establece variable global para encerrar el resultado otorgado por un usuario al escoger la velocidad
    static String planetS = ""; //Se establece variable global para encerrar el resultado otorgado por un usuario al escoger un planeta
    static double distance = 0.0;

    public static void main(String[] args) throws Exception {

        System.out.println(" ==================================================");
        System.out.println("       BIENVENIDO A ESTE VIAJE INTERPLANETARIO!");
        System.out.println("  PREPARA TUS MALETAS Y VAMOS A ESTA GRAN AVENTURA!");
        System.out.println("  (recuerda tu punto inicial es el planeta Tierra)");
        System.out.println(" ==================================================");

        /*
         * loadBarr();
         */

        do {
            System.out.println("|||   OPCIONES DISPONIBLES PARA EMPEZAR EL VIAJE  |||");
            System.out.println("||       Selecciona para el proceso del viaje!     ||");
            System.out.println("|1.-------------Seleccionar Planeta-----------------|");
            System.out.println("|2.-------------Seleccionar Velocidad.--------------|");
            System.out.println("|3.-------------Seleccionar una nave espacial.------|");
            System.out.println("|4.-------------Seleccionar Recursos.---------------|");
            System.out.println("|5.-------------Salir.------------------------------|");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    planetS = selectPlanet(option);
                    
                    break;
                case 2:
                    if (planetS=="") {
                        System.out.println("¡Por favor, selecciona primero un planeta!\n");
                    } else {
                        velocitySelected = selectVelocity(); // Utilizamos planetS para mostrar información de velocidad
                    }
                    break;
                case 3:
                    selectNave();
                    break;
                case 4:
                    selectResources(velocitySelected);
                    break;
                case 5:
                    System.out.println("Gracias por viajar con nosotros. Vueleve pronto ;D");
                    break;

                default:
                    System.err.println("Ingrese una opcion valida.");
                    break;
            }

            /*
             * if (option != 0) {
             * pressEnter();
             * }
             */

        } while (option != 4);

        scanner.close();
    }

    /*
     * private static void loadBarr() throws InterruptedException {
     * int total = 100; // Total de "pasos" o caracteres para completar la barra de
     * carga
     * int progreso = 0; // El progreso actual
     * int longitudBarra = 20; // Longitud total de la barra de carga
     * 
     * // Simulacion o recorrido de un for para simular la carga y dado la longitud
     * // calculara el numero de caracteres faltantes
     * for (int i = 0; i < total; i++) {
     * // Calculamos la cantidad de "#" para llenar la barra de carga
     * 
     * progreso = (i * longitudBarra) / total;
     * 
     * // Construimos el inicio de la barra de carga
     * String barra = "[";
     * 
     * for (int j = 0; j < longitudBarra; j++) {
     * if (j < progreso) {
     * barra += "#"; // Parte llena de la barra
     * } else {
     * barra += " "; // Parte vacía de la barra
     * }
     * }
     * barra += "]";
     * 
     * // Imprimimos la barra de carga y el porcentaje
     * System.out.print("\r" + barra + " " + i + "%");
     * 
     * // Pausa para simular el tiempo de carga
     * 
     * Thread.sleep(55); // 100 ms de pausa entre cada actualización
     * 
     * }
     * 
     * // Después de completar la carga
     * System.out.println("\nTodos los sistemas en linea!\n");
     * }
     */

    private static String selectPlanet(int option) {
        String planetS = "";
        boolean start = true;
        do {
            
            System.out.println("               ----------------------------------    ");
            System.out.println("                PLANETAS DISPONIBLES PARA VIAJAR     ");
            System.out.println("               ----------------------------------    ");
            System.out.println("|Estimado tripulante, seleccione uno de los siguientes planetas para viajar!|");
            printAllPlanets(); // Se trae el metodo usado para traer cada uno de los planetas disponibles en el array
            System.out.println("0. Volver al menú principal");
            option = scanner.nextInt();

            
            if (option == 0) {
                System.out.println("Regresando al menú principal...");
                break;
            } else if (option >= 1 && option <= planets.length) {  
                String planet = planets[option - 1];
                
                System.out.println("Planeta escogido :" + planet);
                // se corrige y se quita el Break, ya que lo que quiero es parar el ciclo y poder retornar el valor otorgado
                planetS = planet;
                distance = distances[option - 1] * 1_000_000;
                System.out.println(distance);
                 // planetS toma el valor escogido y lo retorna
                start = false; // finaliza el ciclo
            } else {
                System.err.println("Opción inválida. Por favor, intente de nuevo.");
            }
            
        } while (start);
        return planetS; //retorna el planeta seleccionado
    }

    // Metodo para seleccionar la velocidad por parte del usuario
    private static double selectVelocity(){
        String planet = planetS;
        String description = descripciones[option - 1]; // Obtener la descripción del planeta
        showInfoPlanet(planet, distance, description); // Envia la información seleccionada por el
                                                       // usuario
        calculateTime(planet, distance);
        //Retorna el valor de obtenido por los calculos
        System.out.println(distance);
        return velocitySelected;
    }

    private static void printPlanet(int option) {
        // Metodo solo para imprimir un planeta segun la opcion
        System.out.println(planets[option]+" que esta a una distancia de: " + distances[option]+ " millones de km.");

    }

    private static void printAllPlanets() {
        int counter = 1;
        // Metodo para imprimir todos los planetas disponibles dentro del array
        for (int i = 0; i < planets.length; i++) {
            System.out.print(counter + ". ");
            counter++;
            printPlanet(i);
        }
    }

    private static void showInfoPlanet(String planet, double distance, String description) {
        System.out.println("===============================================");
        System.out.println("Que bien! Vamos a ir a: " + planet + ".");
        System.out.println("Distancia desde la Tierra a " + planet + ": " + distance + " millones de km.");
        System.out.println("Te recuerdo que " + planet + ": " + description);
        System.out.println("===============================================");
    }

    private static double calculateTime(String planet, double distance) {
        System.out.print("Por favor, ingresa la velocidad de tu nave (en km/h): ");
        double velocity = scanner.nextDouble();

        double time = distance / velocity; // Tiempo en horas
        int days = (int) (time / 24); // Convertir a días
        int hours = (int) (time % 24); // Horas restantes
        // el (int) elimina la parte decimal, lo que significa que se obtiene solo la
        // parte entera de un número.

        System.out.println("===============================================");
        System.out.printf("Distancia desde la Tierra a %s: %.0f km.%n", planet, distance);
        System.out.println("Velocidad de la nave: " + velocity + " km/h.");
        System.out.println("Tiempo estimado de viaje: " + days + " días y " + hours + " horas.");
        System.out.println("////////////////////////////////////////////////");

        velocitySelected = velocity;
        return velocitySelected;
    }

    private static double selectResources(double velocitySelected) {
        // Se crea un metodo para seleccionar recursos
        // ES DE PRUEBA MIENTRAS SE TRABAJA
        double calculateFuel;
        double resourSelect;
        double spent = 8.8;
        System.out.println(velocitySelected);
        System.out.println("CALCULO DE RECURSOS");
        System.out.println("Datos del Usuario: ");
        System.out.println("Haciendo Calculos.... espere un momento");

        spent = 1 + 0.05 * (velocitySelected - 100)/10;
        distance = distance * 1_000_000;
        calculateFuel = (distance / 100) * spent * velocitySelected;
        System.out.println("El consumo de combustible para recorrer " + distance + " km a " 
                           + velocitySelected + " km/h es: " + calculateFuel + " litros.");
        
        resourSelect = calculateFuel;


        return resourSelect; //retorna el valor obtenido luego de calcular lo que consumira en conbustible a una determinada distancia por litro
        // no esta completada solo es idea la formula esta mal xd

    }

    private static void selectNave() {
    }

    /*
     * private static void pressEnter() {
     * System.out.println("Presione ENTER para continuar");
     * scanner.nextLine();
     * }
     */
}
