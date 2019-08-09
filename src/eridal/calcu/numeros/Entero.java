package eridal.calcu.numeros;

import eridal.calcu.Numero;

public class Entero implements Numero {

  private final long valor;

  public Entero(long valor) {
    this.valor = valor;
  }

  @Override public String toString() {
    return String.format("Entero[%d]", valor);
  }

  @Override public boolean esDecimal() {
    return false;
  }

  @Override public Number getValor() {
    return valor;
  }

  @Override public double getValorDecimal() {
    return valor;
  }

  @Override public long getValorEntero() {
    return valor;
  }

}
