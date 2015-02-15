package me.ankur.rosalind.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Sundara on 2/15/15.
 */
public class MathUtil {
    public static BigInteger bigFactorial(long n) {
        BigInteger fac = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

    public static BigDecimal round(double d, int decimalPlaces) {
        return BigDecimal.valueOf(d).setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
    }
}
