package eridal.calcu.pedazos;

public class Pedazo {

  private Numero valor;
  private Operador oper;

  private Pedazo (Numero valor) {
    this.valor = valor;
    this.oper = null;
  }

  private Pedazo (Operador oper) {
    this.valor = null;
    this.oper = oper;
  }

  public String toString() {
    return esNumero()
      ? String.valueOf(valor)
      : oper.toString()
    ;
  }

  public static Pedazo numeroEntero(Number valor) {
    return new Pedazo(
      Numero.createEntero(valor)
    );
  }

  public static Pedazo numeroDecimal(Number valor) {
    return new Pedazo(
        Numero.createDecimal(valor)
    );
  }

  public static Pedazo operador(String tipo) {
    return new Pedazo(
      new Operador(tipo)
    );
  }

  public boolean esNumero() {
    return valor != null;
  }

  public boolean esOperador() {
    return oper != null;
  }

  public Numero toNumero() {
    return valor;
  }

  public Operador toOperador() {
    return oper;
  }
}
