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

    final double i = izq.getValorDecimal();
    final double d = der.getValorDecimal();

    final double resultado = aplicar(i, d);
    final boolean esEntero = (resultado % 1) == 0;

    if (esEntero) {
      return new Entero((long) resultado);
    } else {
      return new Decimal(resultado);
    }
  }

  /**
   * Las sub-clases van a sobrescribir estos metodos
   */
  protected double aplicar (double izq, double der) {
    return 0; // template
  }
}
