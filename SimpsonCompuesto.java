package dif_e_Integracion;

public class SimpsonCompuesto {

    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapezoCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            if (k % 2 != 0) {
                sumaImpares += TrapezoCompuesto.funcion(xk);
            } else {
                sumaPares += TrapezoCompuesto.funcion(xk);
            }
        }

        double sumaTotal = TrapezoCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapezoCompuesto.funcion(b);

        return (h / 3) * sumaTotal;
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        int n = 2;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        while (errorAbsoluto > tolerancia) {
            n *= 2;

            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(
                    integralNueva - integralAnterior);

            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}
