package eridal.calcu.opers;

import eridal.calcu.Numero;
import eridal.calcu.Operador;
import eridal.calcu.numeros.Decimal;
import eridal.calcu.numeros.Entero;

/**
 * Representa un operador de dividido: <code>1 / 2</code>
 */
public class Division implements Operador {

  private static final String SIMBOLO = "/";

  @Override
  public String toString() {
    return Opers.makeString(SIMBOLO);
  }

  @Override
  public Numero aplicar(final Numero izq,
                        final Numero der) {

    final double i = izq.getValorDecimal();
    final double d = der.getValorDecimal();

    final double resultado = i / d;
    final boolean restoCero = (i % d) == 0;

    if (restoCero) {
      return new Entero((long) resultado);
    } else {
      return new Decimal(resultado);
    }
  }
}
