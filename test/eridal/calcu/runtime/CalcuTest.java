package eridal.calcu.runtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CalcuTest {

  /**
   * Tolerancia de error para ops con puto flotante
   */
  private static final double deltaError = 0.00001;

  public static class Sumas {

    @Test
    public void testSumaEnteroConEnteroEnEntero() {
      test(3, "1 + 2");
    }

    @Test
    public void testSumaEnteroConEnteroEnDecimal() {
      test(3.0, "1 + 2");
    }

    @Test
    public void testSumaEnteroConDecimalEnEntero() {
      test(12, "5 + 7.0");
    }

    @Test
    public void testSumaDecimalConDecimalEnEntero() {
      test(11, "3.7 + 7.3");
    }

    @Test
    public void testSumaDecimalConDecimalEnDecimal() {
      test(6.6, "4.5 + 2.1");
    }

    private static Number resolver(String input) {
      return new Calcu().resolver(input);
    }

    private static void test (double esperado, String input) {
      final Number res = resolver(input);
      assertNotNull(res);
      assertEquals(esperado, res.doubleValue(), deltaError);
    }

    private static void test (long esperado, String input) {
      final Number res = resolver(input);
      assertNotNull(res);
      assertEquals(esperado, res.longValue(), deltaError);
    }
  }

  public static class Errores {

    @Test
    public void testNoHayError() {
      final Calcu calcu = new Calcu();
      final Number res = calcu.resolver("1");
      assertNotNull(res);
      assertNull(calcu.error);
    }

    @Test
    public void testNumNum() {
      final Calcu calcu = new Calcu();
      final Number res = calcu.resolver("12 34");
      assertNull(res);
      assertNotNull(calcu.error);
    }

    @Test
    public void testPalabra() {
      test("abc", "error: abc no reconocido");
    }

    @Test
    public void testNumPalabra() {
      test("12 abc", "error: abc no reconocido");
    }

    @Test
    public void testNumOpPalabra() {
      test("12 + abc", "error: abc no reconocido");
    }

    @Test
    public void testSuma() {
      test("+", "error: se esperaba operando, encontrado Op[+]");
    }

    @Test
    public void testDiv() {
      test("/", "error: se esperaba operando, encontrado Op[/]");
    }

    @Test
    public void testNumSuma() {
      test("12 +", "error: se esperaba operando, encontrado Op[+]");
    }

    @Test
    public void testNumResta() {
      test("12 -", "error: se esperaba operando, encontrado Op[-]");
    }

    @Test
    public void testNumMult() {
      test("12 *", "error: se esperaba operando, encontrado Op[*]");
    }

    @Test
    public void testNumDiv() {
      test("12 /", "error: se esperaba operando, encontrado Op[/]");
    }

    private void test(String input, String error) {
      final Calcu calcu = new Calcu();
      final Number res = calcu.resolver(input);
      assertNull(res);
      assertEquals(error, calcu.error);
    }
  }
}
