import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner lecturaMonedaOrigen = new Scanner(System.in);
        Scanner lecturaMonedaDestino = new Scanner(System.in);
        Scanner lecturaMonedaCantidad = new Scanner(System.in);
        Scanner lecturaSalir = new Scanner(System.in);


        String MonedaOrigen, MonedaDestino;
        double MonedaCantidad;
        int opcionSalir;

        ConsultaConversion objConsultaConversion = new ConsultaConversion();

        boolean salir = false; //variable para validar el fin del while
        while (!salir) {

            System.out.println("--------- CONVERSOR DE MONEDA --------- más códigos de moneda soportados en: https://www.exchangerate-api.com/docs/supported-currencies");
            System.out.println("| CÓDIGO | PAIS |");
            System.out.println("  USD      Dolar\n  COP      Peso Colombiano\n  PEN      Sol Peruano\n  BOB      Bolivianos\n  ARS      Peso Argentino\n  BRL      Real Brasileño");

            try {

                System.out.println("\nEscribe el CÓDIGO de una moneda de origen: ");
                MonedaOrigen = lecturaMonedaOrigen.nextLine();

                System.out.println("Escribe el CÓDIGO de una moneda de destino: ");
                MonedaDestino = lecturaMonedaDestino.nextLine();

                System.out.println("Escribe la cantidad a convertir: ");
                MonedaCantidad = lecturaMonedaCantidad.nextDouble();

                Moneda moneda = objConsultaConversion.consultaConversion(MonedaOrigen, MonedaDestino, MonedaCantidad);
                System.out.println("Resultado: "+moneda.conversion_result()+" "+MonedaDestino+"\n");

                System.out.println("Precione 0 para salir | cualquier tecla para continuar en el conversor");
                opcionSalir = lecturaSalir.nextInt();

                salir = opcionSalir == 0;


            } catch (NumberFormatException e) {
                System.out.println("Moneda no encontrada." + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Conversor de monedas finalizado.");
            }
        }




    }
}
