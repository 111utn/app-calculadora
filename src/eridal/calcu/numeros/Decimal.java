package eridal.calcu.numeros;

import eridal.calcu.Numero;

public class Decimal implements Numero {

  private final double valor;

  public Decimal(double valor) {
    this.valor = valor;
  }

  @Override public String toString() {
    return String.format("Decimal[%f]", valor);
  }

  @Override public boolean esDecimal() {
    return true;
  }

  @Override public Number getValor() {
    return valor;
  }

  @Override public double getValorDecimal() {
    return valor;
  }

  @Override public long getValorEntero() {
    return (long) valor;
  }
}
