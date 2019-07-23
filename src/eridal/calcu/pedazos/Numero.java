package eridal.calcu.pedazos;

public class Numero {

  private Number valor;
  private boolean esDecimal;

  public Numero(Number valor, boolean esDecimal) {
    this.valor = valor;
    this.esDecimal = esDecimal;
  }

  @Override public String toString() {
    return String.format("Numero[%s]", String.valueOf(valor));
  }

  public static Numero createEntero(Number valor) {
    return new Numero(valor, false);
  }

  public static Numero createDecimal(Number valor) {
    return new Numero(valor, true);
  }

  public Number getValor() {
    return valor;
  }

  public long getValorEntero() {
    return valor.longValue();
  }

  public double getValorDecimal() {
    return valor.doubleValue();
  }

  public boolean esDecimal() {
    return esDecimal;
  }

}
