import java.math.BigInteger;

public class Main {

  public static void main(String[] args) {

  }

  public static BigInteger fib(BigInteger n) {
    if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
      return BigInteger.ONE;
    }
    return n.compareTo(BigInteger.TWO) == 1 ? getPositiveFibonacciWithLogarithmicComplexity(n)
        : getNegativeOrZeroFibonacciWithLinearComplexity(n);
  }

  private static BigInteger getPositiveFibonacciWithLogarithmicComplexity(BigInteger n) {
    BigInteger[][] matrixToPower = new BigInteger[][]{{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
    BigInteger[][] matrixPowered = raiseMatrixToPower(matrixToPower, n.subtract(BigInteger.TWO).intValue());
    return multiplyMatrices(matrixPowered, new BigInteger[][]{{BigInteger.ONE}, {BigInteger.ONE}})[1][0];
  }

  private static BigInteger[][] raiseMatrixToPower(BigInteger[][] base, long exponent) {
    BigInteger[][] total = new BigInteger[][]{{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
    long floorOfLogExponentBaseTwo;
    while (exponent > 0) {
      floorOfLogExponentBaseTwo = (long) (Math.log(exponent) / Math.log(2));
      total = multiplyMatrices(total, squareMatrixConsecutivelyNTimes(base, floorOfLogExponentBaseTwo));
      exponent -= Math.pow(2, floorOfLogExponentBaseTwo);
    }
    return total;
  }

  private static BigInteger[][] squareMatrixConsecutivelyNTimes(BigInteger[][] base, long exponent) {
    for (int i = 0; i < exponent; i++) {
      base = multiplyMatrices(base, base);
    }
    return base;
  }

  private static BigInteger[][] multiplyMatrices(BigInteger[][] A, BigInteger[][] B) {
    BigInteger[][] result = new BigInteger[A.length][B[0].length];
    BigInteger sumProduct = new BigInteger("0");
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        for (int k = 0; k < B.length; k++) {
          sumProduct = sumProduct.add(A[i][k].multiply(B[k][j]));
        }
        result[i][j] = sumProduct;
        sumProduct = BigInteger.ZERO;
      }
    }
    return result;
  }

  private static BigInteger getNegativeOrZeroFibonacciWithLinearComplexity(BigInteger n) {
    BigInteger fib1 = BigInteger.ONE;
    BigInteger fib2 = BigInteger.ONE;
    for (int i = 0; i < Math.abs(n.intValue()); i++) {
      fib1 = fib2.subtract(fib1);
      fib2 = fib2.subtract(fib1);
    }
    return fib2.subtract(fib1);
  }
}
