package eridal.calcu.pedazos;

public class Pedazos {

  public static Pedazo numeroEntero(long valor) {
    return new Pedazo(
      new Numero(valor, false)
    );
  }

  public static Pedazo numeroDecimal(double valor) {
    return new Pedazo(
        new Numero(valor, true)
    );
  }

  public static Pedazo operador(String tipo) {
    return new Pedazo(
      new Operador(tipo)
    );
  }

}
