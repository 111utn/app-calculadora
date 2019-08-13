package eridal.calcu.numeros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class EnteroTest {

  @Test
  public void testEnteroNoEsDecimal() {
    final Entero entero = new Entero(4);
    final boolean esDecimal = entero.esDecimal();
    assertFalse(esDecimal);
  }

  @Test
  public void testToString() {
    final Entero entero = new Entero(345);
    final String resultado = entero.toString();
    assertEquals("Entero[345]", resultado);
  }

  @Test
  public void testGetValor() {
    final Entero entero = new Entero(345);
    final long valor = entero.getValor().longValue();
    assertEquals(345, valor);
  }

  @Test
  public void testGetValorEntero() {
    final Entero entero = new Entero(234);
    final long valor = entero.getValorEntero();
    assertEquals(234, valor);
  }

  @Test
  public void testGetValorDecimal() {
    final Entero entero = new Entero(456);
    final double valor = entero.getValorDecimal() + 0.5;
    assertEquals(456.5, valor);
  }
}