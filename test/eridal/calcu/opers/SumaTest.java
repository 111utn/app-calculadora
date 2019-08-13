package eridal.calcu.opers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eridal.calcu.Numero;
import eridal.calcu.numeros.Decimal;
import eridal.calcu.numeros.Entero;

public class SumaTest {

  @Test
  public void testPropiedadSimbolo() {
    assertEquals("+", Suma.SIMBOLO);
  }

  @Test
  public void testGetSimbolo() {
    final Suma s = new Suma();
    assertEquals("+", s.getSimbolo());
  }

  @Test
  public void testOpEnteroConEntero() {

    final Entero a = new Entero(2);
    final Entero b = new Entero(6);

    final Suma s = new Suma();

    final Numero resultado1 = s.aplicar(a, b);
    final Numero resultado2 = s.aplicar(b, a);

    final long esperado = 8; // 2 + 6

    assertEquals(esperado, resultado1.getValorEntero());
    assertEquals(esperado, resultado2.getValorEntero());
  }

  @Test
  public void testOpEnteroConDecimal() {

    final Entero a = new Entero(2);
    final Decimal b = new Decimal(6.3);

    final Suma s = new Suma();

    final Numero resultado1 = s.aplicar(a, b);
    final Numero resultado2 = s.aplicar(b, a);

    final double esperado = 8.3; // 2 + 6.3

    assertEquals(esperado, resultado1.getValorDecimal());
    assertEquals(esperado, resultado2.getValorDecimal());
  }

  @Test
  public void testOpDecimalConDecimal() {

    final Decimal a = new Decimal(2.25);
    final Decimal b = new Decimal(6.3);

    final Suma s = new Suma();

    final Numero resultado1 = s.aplicar(a, b);
    final Numero resultado2 = s.aplicar(b, a);

    final double esperado = 8.55; // 2.25 + 6.3

    assertEquals(esperado, resultado1.getValorDecimal());
    assertEquals(esperado, resultado2.getValorDecimal());
  }
}