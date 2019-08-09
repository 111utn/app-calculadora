package eridal.calcu.pedazos;

import eridal.calcu.numeros.Decimal;
import eridal.calcu.numeros.Entero;

public class Pedazos {

  public static Pedazo numeroEntero(long valor) {
    return new Pedazo(
      new Entero(valor)
    );
  }

  public static Pedazo numeroDecimal(double valor) {
    return new Pedazo(
        new Decimal(valor)
    );
  }

  public static Pedazo operador(String tipo) {
    return new Pedazo(
      new Operador(tipo)
    );
  }

}
