package dif_e_Integracion;

public class TrapezoCompuesto {

    public static double funcion(double x) {
        return Math.exp(-x * x);
    }

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        int n = 1;
        double h = calcularH(a, b, n);

        double integralAnterior =
                (h / 2.0) * (funcion(a) + funcion(b));

        double errorAbsoluto = Double.POSITIVE_INFINITY;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            h = calcularH(a, b, n);

            double suma = (funcion(a) + funcion(b)) / 2.0;

            for (int k = 1; k < n; k++) {
                suma += funcion(a + k * h);
            }

            double integralNueva = h * suma;

            errorAbsoluto =
                    Math.abs(integralNueva - integralAnterior);

            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}
