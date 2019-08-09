package eridal.calcu.opers;

import eridal.calcu.Operador;

public class Opers {

  public static Operador get(final String tipo) {

    if (Suma.SIMBOLO.equals(tipo)) {
      return new Suma();
    }

    if (Resta.SIMBOLO.equals(tipo)) {
      return new Resta();
    }

    if (Multip.SIMBOLO.equals(tipo)) {
      return new Multip();
    }

    return new Division();
  }

  public static String makeString(String nombre) {
    return String.format("Op[%s]", nombre);
  }
}
