import java.util.Random;
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
    static String[] naves = { "Nova Tempest", "Solar Phantom", "Infinity Hawk", "Astral Pathfinder" };
    static String[] mensajeDesvio = {"Ou! Creo que tendremos que tomar un desvio, ya que se pueden presentar fallas si seguimos por este camino","Algo ha golpeado la nave","Hay un agujero de gusano se tomaran maniobras evasivas.","Cuidado hay cargamento que esta suelto, un personal estara pasando para arreglar el inconveniente"};
    //Se establecio una variable global tipo entero para poder usarla en cualquier funcion y no repetir
    static Integer option;
    //Se establecio una variable global tipo Scanner para poder usarla en cualquier funcion y no repetir
    static Scanner scanner = new Scanner(System.in);
    //consumo de la nave por cada 100 km
    static double velocitySelected = 0.0; //Se establece variable global para encerrar el resultado otorgado por un usuario al escoger la velocidad
    static String planetS = ""; //Se establece variable global para encerrar el resultado otorgado por un usuario al escoger un planeta
    static double distance = 0.0;
    static String selectedNave = ""; // Variable para almacenar la nave seleccionada
    static double hoursSelected = 0.0;
    static String messageEmergency="";

    public static void main(String[] args) throws Exception {

        System.out.println(" ==================================================");
        System.out.println("       BIENVENIDO A ESTE VIAJE INTERPLANETARIO!");
        System.out.println("  PREPARA TUS MALETAS Y VAMOS A ESTA GRAN AVENTURA!");
        System.out.println("  (recuerda tu punto inicial es el planeta Tierra)");
        System.out.println(" ==================================================");

        loadBarr();
        showMenu();
    }


    private static void showMenu() throws InterruptedException {
        do {
            System.out.println("|||   OPCIONES DISPONIBLES PARA EMPEZAR EL VIAJE  |||");
            System.out.println("||       Selecciona para el proceso del viaje!     ||");
            System.out.println("|1.-------------Seleccionar Planeta-----------------|");
            System.out.println("|2.-------------Seleccionar Velocidad.--------------|");
            System.out.println("|3.-------------Seleccionar una nave espacial.------|");
            System.out.println("|4.-------------Seleccionar Recursos.---------------|");
            System.out.println("|5.-------------INICIAR VIAJE!.---------------------|");
            System.out.println("|0.-------------Salir.------------------------------|");
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
                        selectVelocity(); // Utilizamos planetS para mostrar información de velocidad
                    }
                    break;
                case 3:
                    selectNave();
                    break;
                case 4:
                    if (planetS=="" || velocitySelected<=0.0 || selectedNave=="" || hoursSelected<=0.0) {
                        System.out.println("¡No puedo calcular los recursos si no se han establecido las opciones!\n");
                    } else {
                        calculateResources(velocitySelected);
                    }
                    break;
                case 5:
                    if (planetS=="" || velocitySelected<=0.0 || selectedNave=="" || hoursSelected<=0.0) {  
                        System.out.println("¡No puedo mostrar el progreso del viaje si no se han establecido las opciones!\n");
                    }else {
                    showTravelProgress(hoursSelected, distance);
                    }
                    break;
                case 0:
                    System.out.println("Cancelar Vuelo.");
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

        } while (option != 0);

        scanner.close();
    }


     private static void loadBarr() throws InterruptedException {
     int total = 100; // Total de "pasos" o caracteres para completar la barra de
     
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
                
                System.out.println("Planeta escogido :" + planet +"\n");
                // se corrige y se quita el Break, ya que lo que quiero es parar el ciclo y poder retornar el valor otorgado
                planetS = planet;
                distance = distances[option - 1] * 1_000_000;
                 // planetS toma el valor escogido y lo retorna
                start = false; // finaliza el ciclo
            } else {
                System.err.println("Opción inválida. Por favor, intente de nuevo.");
            }
            
        } while (start);
        return planetS; //retorna el planeta seleccionado
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
    // Metodo para seleccionar la velocidad por parte del usuario
    private static void selectVelocity(){
        String planet = planetS;
        String description = descripciones[option - 1]; // Obtener la descripción del planeta
        showInfoPlanet(planet, distance, description); // Envia la información seleccionada por el
        calculateVelocity(planet, distance) ; // Calcula la velocidad seleccionada por el                                             // usuario
        calculateTime(planet, distance);
        //Retorna el valor de obtenido por los calculos
    }

    private static double calculateVelocity(String planet, double distance) {
        System.out.print("Por favor, ingresa la velocidad de tu nave (en km/h): ");
        double velocity = scanner.nextDouble();

        velocitySelected = velocity;
        return velocitySelected;
    }


    private static double calculateTime(String planet, double distance) {
        double time = distance / velocitySelected; // Tiempo en horas
        int days = (int) (time / 24); // Convertir a días
        int hours = (int) (time % 24); // Horas restantes
        // el (int) elimina la parte decimal, lo que significa que se obtiene solo la
        // parte entera de un número.

        System.out.println("===============================================");
        System.out.printf("Distancia desde la Tierra a %s: %.0f km.%n", planet, distance);
        System.out.println("Velocidad de la nave: " + velocitySelected + " km/h.");
        System.out.printf("Tiempo estimado de viaje: %d días y %d horas.%n", days, hours);
        System.out.println("////////////////////////////////////////////////");
        hoursSelected = time;
        return hoursSelected;
    }
       
    
    // Método interactivo (para cuando se selecciona la opción 4 del menú)
    private static double calculateResources(double velocitySelected) {
        // Constantes de consumo
        double baseFuelConsumption = 8.8; // L/100km
        // Cálculo del consumo de oxígeno:
        // - 14 respiraciones/minuto (promedio)
        // - 60 minutos/hora = 840 respiraciones/hora
        // - 0.5 litros de aire por respiración
        // - 21% de oxígeno en el aire
        // 840 * 0.5 * 0.21 = 88.2 litros de oxígeno por hora
        double oxygenPerHour = 88.2; // Litros de oxígeno por hora
        double speedPenalty = 1.0;
        
        // Calcular tiempo de viaje
        
        // Calcular consumo de oxígeno total
        double totalOxygenNeeded = hoursSelected * oxygenPerHour;
        
        // Cálculo de combustible con penalización por velocidad
        // Esto es parte de un evento ya que cuando el usuario escoge la velocidad
        // gana una penalizacion de combustible por lo tanto consume mas combustible
        if (velocitySelected > 100) {
            //dentro de este bloque se formula la penalizacion

            //OverSpeed calcula la resta que hay de la velocidad seleccionada menos 100 que significa la velocidad maxima
            double overSpeed = velocitySelected - 100;
            //Si la velocidad es mayor a 100 entonces se aplica la penalizacion de combustible por lo tanto la nave
            //consume mas combustible
            speedPenalty = 1.0 + (0.05 * (overSpeed / 10.0));
        }
        //aplicamos el consumo base * la penalizaicon de velocidad que se obtuvo.
        double adjustedConsumption = baseFuelConsumption * speedPenalty;
        //Hacemos el calculo de la distancia dividido por 100 que son los km por litro y lo multiplicamos por el consumo ajustado
        double totalFuelNeeded = (distance / 100.0) * adjustedConsumption;

        // Mostrar resultados
        System.out.println("\nCÁLCULO DE RECURSOS");
        System.out.println("===================");
        System.out.println("Datos del viaje:");
        System.out.println("- Velocidad seleccionada: " + velocitySelected + " km/h");
        System.out.println("- Distancia a recorrer: " + distance + " km");
        System.out.printf("- Tiempo estimado: %.0f horas%n", hoursSelected);
        
        System.out.println("\nConsumo de combustible:");
        System.out.println("- Consumo Estimado: " + baseFuelConsumption + " L/100km");
        System.out.println("- Factor por velocidad: " + String.format("%.2f", speedPenalty));
        System.out.println("- Combustible total necesario: " + String.format("%.2f", totalFuelNeeded) + " litros");
        
        System.out.println("\nConsumo de oxígeno:");
        System.out.println("- Consumo por hora: " + oxygenPerHour + " litros");
        System.out.println("- Oxígeno total necesario: " + String.format("%.2f", totalOxygenNeeded) + " litros");

        if (velocitySelected > 100) {
            System.err.println("\n¡Atención! La velocidad seleccionada excede la velocidad máxima permitida.");
            System.out.println("Deseas continuar con la velocidad seleccionada? (S/N)");
            //Se crea un nuevo scanner para que el usuario pueda responder con tipo string y para usar otro metodo
            //metodo de scanner.
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                System.out.println("Por favor, ingresa la velocidad de tu nave nuevamente(en km/h): ");
                selectVelocity();
            }else{
                return totalFuelNeeded;
            }
        }
        return totalFuelNeeded; // Mantenemos el retorno del combustible por compatibilidad
    }

    private static void selectNave() {
            System.out.println("               ----------------------------------    ");
            System.out.println("                         NAVES DISPONIBLES!          ");
            System.out.println("               ----------------------------------    ");
            System.out.println("|Estimado tripulante Por favor, selecciona una nave para viajar!|");

            for (int i = 0; i < naves.length; i++) {
                System.out.println((i + 1) + ". " + naves[i]);
            }
        
            System.out.print("Ingresa el número de la nave que deseas elegir: ");
            int opcion = scanner.nextInt();
        
            // Validar la selección
            if (opcion >= 1 && opcion <= naves.length) {
                selectedNave = naves[opcion - 1];
                System.out.println("Has seleccionado la nave: " + selectedNave);
            } else {
                System.out.println("Selección inválida. Inténtalo de nuevo.");
            }
        }

    private static void iniciar() {
        System.out.println("=====================================================");
        System.out.println("               PREPARÁNDONOS PARA EL VIAJE           ");
        System.out.println("=====================================================");
        
        System.out.println("Planeta seleccionado: " + planetS);
        System.out.println("Distancia estimada desde la Tierra: " + distance + " km");
        System.out.println("Velocidad seleccionada: " + velocitySelected + " km/h");
        System.out.println("Nave seleccionada: " + selectedNave);
        
        // Calcula y muestra el consumo estimado de combustible
        double estimatedFuel = calculateResources(velocitySelected);
        System.out.println("Consumo estimado de combustible: " + String.format("%.2f", estimatedFuel) + " litros");
        
        // Mensaje final de inicio
        System.out.println("=====================================================");
        System.out.println("TODO LISTO: TU GRAN VIAJE HACIA " + planetS + " COMIENZA AHORA.");
        System.out.println("-----------------------------------------------------");
        
        // Mensaje de desvío
        System.out.println(mensajeDesvio[0]);
        System.out.println("=====================================================");
        //showTravelProgress(estimatedFuel, 88.2 * hoursSelected);
    }

    private static void showTravelProgress(double totalFuelNeeded, double totalOxygenNeeded) throws InterruptedException {
        double currentDistance = 0;
        double currentTime = 0;
        double currentFuel = totalFuelNeeded;
        double currentOxygen = totalOxygenNeeded;
        int barLength = 50; // Longitud de la barra de progreso
        Random random = new Random();

        System.out.println("\n¡INICIANDO VIAJE A " + planetS.toUpperCase() + "!");
        System.out.println("=============================================");

            while (currentDistance < distance) {
                // Limpiar consola no funciona no se por que :(
                //System.out.print("\033[H\033[2J");
                //System.out.flush();

                // Calcular porcentajes
                // Solo es para mostrarlos al final del largo de la barra.
                double distancePercent = (currentDistance / distance) * 100;
                double timePercent = (currentTime / hoursSelected) * 100;
                double fuelPercent = ((totalFuelNeeded - currentFuel) / totalFuelNeeded) * 100;
                double oxygenPercent = ((totalOxygenNeeded - currentOxygen) / totalOxygenNeeded) * 100;

                // Crear barras de progreso
                System.out.println("Progreso del viaje a " + planetS + ":");
                System.out.println("---------------------------------------------");
                
                // Barra de distancia
                System.out.printf("Distancia [");
                //igual que la barra inicial de decoracion esta formula calcula en base a procentaje el numero de
                //caracteres que se van a mostrar
                int completed = (int) (distancePercent * barLength / 100);
                for (int i = 0; i < barLength; i++) {
                    if (i < completed) System.out.print("#");
                    else System.out.print("" );
                    
                    
                }
                System.out.printf("] %.1f%%\n", distancePercent);
                System.out.printf("%.0f/%.0f km\n\n", currentDistance, distance);

                // Barra de tiempo
                System.out.printf("Tiempo    [");
                completed = (int) (timePercent * barLength / 100);
                for (int i = 0; i < barLength; i++) {
                    if (i < completed) System.out.print("#");
                    else System.out.print(" ");
                }
                System.out.printf("] %.1f%%\n", timePercent);
                System.out.printf("%.1f/%.1f horas\n\n", currentTime, hoursSelected);

                // Barra de combustible
                System.out.printf("Combustible[");
                completed = (int) (fuelPercent * barLength / 100);
                for (int i = 0; i < barLength; i++) {
                    if (i < completed) System.out.print("#");
                    else System.out.print(" ");
                }
                System.out.printf("] %.1f%%\n", fuelPercent);
                System.out.printf("%.1f/%.1f litros\n\n", currentFuel, totalFuelNeeded);

                // Barra de oxígeno
                System.out.printf("Oxígeno   [");
                completed = (int) (oxygenPercent * barLength / 100);
                for (int i = 0; i < barLength; i++) {
                    if (i < completed) System.out.print("=");
                    else System.out.print(" ");
                    randomizador(mensajeDesvio,random, completed, messageEmergency);
                }
                System.out.printf("] %.1f%%\n", oxygenPercent);
                System.out.printf("%.1f/%.1f litros\n", currentOxygen, totalOxygenNeeded);

                // Incrementar valores (simulación de progreso)
                double increment = distance / 100; // Dividimos el viaje en 100 partes
                currentDistance += increment;
                currentTime += hoursSelected / 100;
                currentFuel -= totalFuelNeeded / 100;
                currentOxygen -= totalOxygenNeeded / 100;

                
                
                // Esperar un momento antes de la siguiente actualización
                Thread.sleep(120); // 200ms entre actualizaciones

                

            }

            System.out.println("\n¡VIAJE COMPLETADO CON ÉXITO!");
            System.out.println("Has llegado a " + planetS);
            System.out.println("=============================================");
            
        
    }


    private static String randomizador(String[] mensajeDesvio, Random random, int completed, String messageEmergency) {
        if(completed > 40){
            if(random.nextInt(1000) < 3){
                
                messageEmergency = mensajeDesvio[random.nextInt(mensajeDesvio.length)];
                System.out.println("\n\n" + messageEmergency);
                System.out.println("Presione enter para continuar");
                scanner.nextLine();
                return messageEmergency;
            }
        }
        return null;
    }
}
