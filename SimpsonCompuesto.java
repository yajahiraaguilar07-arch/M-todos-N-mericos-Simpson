package dif_e_Integracion;

public class SimpsonCompuesto {

    public static double calcularSimpson(
            double a, double b, int n) {

        if (n <= 0 || n % 2 != 0) {
            throw new IllegalArgumentException(
                    "n debe ser un numero positivo par.");
        }

        double h = TrapezoCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            if (k % 2 == 1) {
                sumaImpares += TrapezoCompuesto.funcion(xk);
            } else {
                sumaPares += TrapezoCompuesto.funcion(xk);
            }
        }

        return (h / 3.0) *
                (TrapezoCompuesto.funcion(a)
                + 4.0 * sumaImpares
                + 2.0 * sumaPares
                + TrapezoCompuesto.funcion(b));
    }

    public static int subintervalosUsados(
            double a, double b, double tolerancia) {

        int n = 2;
        double anterior = calcularSimpson(a, b, n);

        while (n < 1_048_576) {
            n *= 2;
            double actual = calcularSimpson(a, b, n);

            if (Math.abs(actual - anterior) < tolerancia) {
                return n;
            }

            anterior = actual;
        }

        return n;
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        int n = subintervalosUsados(a, b, tolerancia);
        return calcularSimpson(a, b, n);
    }
}
