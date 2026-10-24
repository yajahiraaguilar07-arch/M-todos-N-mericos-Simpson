package dif_e_Integracion;

public class Main {

    public static void main(String[] args) {

        double a = 0.0;
        double b = 1.0;
        double tolerancia = 0.000001;

        double resultadoSimpson =
                SimpsonCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        double resultadoTrapecio =
                TrapezoCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        System.out.println("METODOS NUMERICOS");
        System.out.println("Funcion: f(x) = exp(-x^2)");
        System.out.println("Intervalo: [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia);

        System.out.println();
        System.out.println("Metodo de Simpson 1/3 compuesto:");
        System.out.printf("%.10f%n", resultadoSimpson);

        System.out.println();
        System.out.println("Metodo del trapecio compuesto:");
        System.out.printf("%.10f%n", resultadoTrapecio);

        System.out.println();
        System.out.println("Diferencia entre resultados:");
        System.out.printf("%.10f%n",
                Math.abs(resultadoSimpson - resultadoTrapecio));
    }
}
