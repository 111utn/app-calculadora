package eridal.calcu.numeros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DecimalTest {

  @Test
  public void testDecimalEsDecimal() {
    final Decimal decimal = new Decimal(1.23);
    final boolean esDecimal = decimal.esDecimal();
    assertTrue(esDecimal);
  }

  @Test
  public void testToString() {
    final Decimal decimal = new Decimal(0.03);
    final String resultado = decimal.toString();
    assertEquals("Decimal[0.030000]", resultado);
  }

  @Test
  public void testGetValor() {
    final Decimal decimal = new Decimal(1.23);
    final Number valor = decimal.getValor();
    assertEquals(1.23, valor);
  }

  @Test
  public void testGetValorEntero() {
    final Decimal decimal = new Decimal(1.23);
    final long valor = decimal.getValorEntero();
    assertEquals(1, valor);
  }

  @Test
  public void testGetValorDecimal() {
    final Decimal decimal = new Decimal(1.23);
    final double valor = decimal.getValorDecimal();
    assertEquals(1.23, valor);
  }
}