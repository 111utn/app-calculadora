package eridal.calcu.runtime;

import eridal.calcu.Numero;
import eridal.calcu.Operador;
import eridal.calcu.parser.Parser;
import eridal.calcu.pedazos.Pedazo;

public class Calcu {

  private final Parser parser = new Parser();

  public String error;

  /**
   * Resuelve la operacion y devuelve su resultado
   *
   * @return Number resultado de la operacion, or `null` si ocurrio algun error
   */
  public Number resolver(final String input) {

    final Pedazo[] pedazos = parser.parse(input);

    if (pedazos != null) {
      return resolver(pedazos);
    }

    error = parser.error;

    return null;
  }

  /**
   * Resuelve la expresion y obtiene el resultado final
   *
   * CUIDADO:
   *   El metodo actual NO resuelve operaciones segun las reglas matematicas,
   *   sino por el order mismo de aparicion de los operadores.
   *
   *   Ej: "1 + 2 * 3" es resuelto como ((1 + 2) * 3) = 9
   *
   *
   * @return Number resultado de la operacion, or `null` si ocurrio algun error
   */
  private Number resolver(final Pedazo[] entrada) {

    if (entrada.length == 0) {
      return null;
    }

    Numero num = null;
    Operador opr = null;

    for (Pedazo pedazo : entrada) {

      if (pedazo.esNumero()) {
        if (num == null) {
          num = pedazo.toNumero();
        }
        else if (opr == null) {
          error = "error: se esperaba operador, encontrado " + pedazo;
          return null;
        }
        else {
          num = opr.aplicar(num, pedazo.toNumero());
          opr = null;
        }
      }
      else if (pedazo.esOperador()) {
        if (num == null) {
          error = "error: se esperaba operando, encontrado " + pedazo;
          return null;
        }
        else {
          opr = pedazo.toOperador();
        }
      }
    }

    if (opr != null) {
      error = "error: se esperaba operando, encontrado " + opr;
      return null;
    }

    if (num == null) {
      error = "error: operacion vacia";
      return null;
    }

    return num.getValor();
  }
}
