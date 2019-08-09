package eridal.calcu.opers;

import eridal.calcu.Numero;
import eridal.calcu.Operador;
import eridal.calcu.numeros.Decimal;
import eridal.calcu.numeros.Entero;

/**
 * Clase base con metodos en comun para todos los operadores
 */
class OpBase implements Operador {

  @Override
  public String toString() {
    return Opers.makeString(getSimbolo());
  }

  /**
   * @return El simbolo de este operador
   */
  protected String getSimbolo() {
    return null; // template
  }

  /**
   * Aplicar el operador a los dos numeros dados
   *
   * @return El resultado de la operacion
   */
  @Override public Numero aplicar(final Numero izq,
                                  final Numero der) {

    final boolean resultadoDecimal = izq.esDecimal() || der.esDecimal();

    if (resultadoDecimal) {
      return aplicarComoDecimal(izq, der);
    } else {
      return aplicarComoEntero(izq, der);
    }
  }

  /**
   * Aplica el operador y obtiene un resultado decimal
   */
  private Numero aplicarComoDecimal(Numero izq, Numero der) {

    final double i = izq.getValorDecimal();
    final double d = der.getValorDecimal();

    final double resultado = aplicar(i, d);

    return new Decimal(resultado);
  }

  /**
   * Aplica el operador y obtiene un resultado entero
   */
  private Numero aplicarComoEntero(Numero izq, Numero der) {

    final long i = izq.getValorEntero();
    final long d = der.getValorEntero();

    final long resultado = aplicar(i, d);

    return new Entero(resultado);
  }

  /**
   * Las sub-clases van a sobrescribir estos metodos
   */
  protected double aplicar (double izq, double der) {
    return 0; // template
  }

  /**
   * Las sub-clases van a sobrescribir estos metodos
   */
  protected long aplicar(long izq, long der) {
    return 0; // template
  }
}
