package eridal.calcu.pedazos;

public class Pedazo {

  private boolean esNumero;
  private boolean esDecimal;

  private Number valor;
  private String operador;

  private Pedazo (Number valor, boolean esDecimal) {
    this.esNumero = true;
    this.esDecimal = esDecimal;
    this.valor = valor;
  }

  private Pedazo (String operador) {
    this.esNumero = false;
    this.esDecimal = false;
    this.valor = null;
    this.operador = operador;
  }

  public static Pedazo numeroEntero(Number valor) {
    return new Pedazo(valor, false);
  }

  public static Pedazo numeroDecimal(Number valor) {
    return new Pedazo(valor, true);
  }

  public static Pedazo operador(String tipo) {
    return new Pedazo(tipo);
  }
}
