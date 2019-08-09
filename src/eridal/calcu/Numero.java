package eridal.calcu;

public interface Numero {

  /**
   * @return `true` si este numero es decimal
   */
  public boolean esDecimal();

  /**
   * @return el valor en format `long` o `double`,
   *          segun el numero sea entero o decimal
   */
  public Number getValor();

  /**
   * @return el valor en formato decimal
   */
  public double getValorDecimal();

  /**
   * @return el valor en formato entero
   */
  public long getValorEntero();
}
