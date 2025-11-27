import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class Menu {
    private final ConversorMoneda conversor = new ConversorMoneda();
    private final CrearHttp crearHttp = new CrearHttp();
    private final Scanner scanner = new Scanner(System.in);
    public void mostrar(){

            JsonObject tasas = crearHttp.obtenerTasas();

            double USD = tasas.get("USD").getAsDouble();
            double ARS = tasas.get("ARS").getAsDouble();
            double BRL = tasas.get("BRL").getAsDouble();
            double COP = tasas.get("COP").getAsDouble();
            int opcion = 0;

            while (opcion != 7) {
                System.out.println("""
                        *****************************************
                        Bienvenido al conversor de Moneda
                        
                        1. Dolar ==> Peso Argentino
                        2. Peso Argentino ==> Dolar
                        3. Dolar ==> Real Brasileño
                        4. Real Brasileño ==> Dolar
                        5. Dolar ==> Peso Colombiano
                        6. Peso Colombiano ==> Dolar
                        7. Salir
                        
                        Elige una opción valida.
                        
                        *****************************************
                        
                        """);
                String linea = scanner.nextLine().trim();
                try {
                    opcion = Integer.parseInt(linea);
                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingresa un numero entre el 1 y 7.");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        convertirMoneda("USD ==> ARS", ARS, true);
                        break;
                    case 2:
                        convertirMoneda("ARS ==> USD", ARS, false);
                        break;
                    case 3:
                        convertirMoneda("USD ==> BRL", BRL, true);
                        break;
                    case 4:
                        convertirMoneda("BRL ==> USD", BRL, false);
                        break;
                    case 5:
                        convertirMoneda("USD ==> COP", COP, true);
                        break;
                    case 6:
                        convertirMoneda("COP ==> USD", COP, false);
                        break;
                    case 7:
                        System.out.println("Saliendo. Gracias por usar el conversor.");
                        break;
                    default:
                        System.out.println("Opción no valida. porfavor intenta de nuevo");
                }

            }

        }
        private void convertirMoneda(String titulo, double tasa, boolean usdToX) {
        System.out.println("\n---" + titulo + " ---");
        System.out.println("Ingrese el valor que desea convertir");

        String linea = scanner.nextLine().trim();
        double monto;
        try{
            monto = Double.parseDouble(linea);
        }catch (NumberFormatException e) {
            System.out.println("Monto inválido. Intenta de nuevo.");
            return;
        }
        double resultado;
        if (usdToX){
            resultado = conversor.convertir(monto, tasa);
        }else {
            if (tasa == 0.0){
                System.out.println("Tasa inválida (0). no se puede convertir.");
                return;
            }
            resultado = conversor.convertirInverso(monto, tasa);
        }
            System.out.println("Resultado: " + resultado);
    }
}
