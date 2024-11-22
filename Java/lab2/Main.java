import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
        int b = 1, n = 10, k = 10;
        int i = 0;
        double a = 0.1, e = 0.0001, x;
        double step = (b - a) / k;

        System.out.println("Using double type:");
        for (x = a; x <= b; x += step) {
            i++;
            double y = calcExactValue(x);
            double sn = calcApproxValue(x, n);
            double se = Math.abs((y - sn) / y);
            double en = calcApproxValue(x, e);
            double ee = Math.abs((y - en) / y);
            System.out.printf("x%s = %s, y%s = %s, sn = %s, en = %s, se = %s, ee = %s \n", i, x, i, y,
                    sn, en, se, ee);
        }

        System.out.println("Using BigDecimal type:");
        i = 0;
        for (x = a; x <= b; x += step) {
            i++;
            BigDecimal xBig = new BigDecimal(x);
            BigDecimal yBig = calcExactValue(xBig);
            BigDecimal sn = calcApproxValue(xBig, n);
            BigDecimal se = yBig.subtract(sn).abs().divide(yBig, BigDecimal.ROUND_HALF_UP);
            BigDecimal en = calcApproxValue(xBig, e);
            BigDecimal ee = yBig.subtract(en).abs().divide(yBig, BigDecimal.ROUND_HALF_UP);
            System.out.printf("x%s = %s, y%s = %s, sn = %s, en = %s, se = %s, ee = %s \n", i, xBig, i,
                    yBig, sn, se, en, ee);
        }
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static double calcExactValue(double x) {
        return Math.pow(3, x);
    }

    public static double calcApproxValue(double x, int n) {
        double sn = 1;
        double ln3 = Math.log(3);
        for (int i = 1; i <= n; i++) {
            sn += (Math.pow(ln3, i) / getFactorial(i)) * Math.pow(x, i);
        }
        return sn;
    }

    public static double calcApproxValue(double x, double e) {
        double en = 1;
        double ln3 = Math.log(3);
        for (int i = 1;; i++) {
            double term = (Math.pow(ln3, i) / getFactorial(i)) * Math.pow(x, i);
            en += term;
            if (Math.abs(term) <= e)
                break;
        }
        return en;
    }

    public static BigDecimal calcExactValue(BigDecimal x) {
        return BigDecimal.valueOf(3).pow(x.intValue());
    }

    public static BigDecimal calcApproxValue(BigDecimal x, int n) {
        BigDecimal sn = BigDecimal.ONE;
        BigDecimal ln3 = BigDecimal.valueOf(Math.log(3));
        BigDecimal term = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            term = ln3.pow(i).divide(BigDecimal.valueOf(getFactorial(i)), MathContext.DECIMAL64).multiply(x.pow(i));
            sn = sn.add(term);
        }
        return sn;
    }

    public static BigDecimal calcApproxValue(BigDecimal x, double e) {
        BigDecimal en = BigDecimal.ONE;
        BigDecimal ln3 = BigDecimal.valueOf(Math.log(3));
        BigDecimal term = BigDecimal.ONE;
        for (int i = 1;; i++) {
            term = ln3.pow(i).divide(BigDecimal.valueOf(getFactorial(i)), MathContext.DECIMAL64).multiply(x.pow(i));
            en = en.add(term);
            if (term.abs().compareTo(BigDecimal.valueOf(e)) <= 0)
                break;
        }
        return en;
    }

}