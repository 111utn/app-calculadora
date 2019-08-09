package eridal.calcu.opers;

/**
 * Representa un operador de resta: <code>1 - 2</code>
 */
public class Resta extends OpBase {

  static final String SIMBOLO = "-";

  @Override protected String getSimbolo() {
    return SIMBOLO;
  }

  @Override public double aplicar(double izq, double der) {
    return izq - der;
  }

  @Override protected long aplicar(long izq, long der) {
    return izq - der;
  }
}
