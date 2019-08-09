package eridal.calcu.opers;

/**
 * Representa un operador de suma: <code>1 - 2</code>
 */
public class Suma extends OpBase {

  static final String SIMBOLO = "+";

  @Override protected String getSimbolo() {
    return SIMBOLO;
  }

  @Override protected long aplicar(long izq, long der) {
    return izq + der;
  }

  @Override protected double aplicar(double izq, double der) {
    return izq + der;
  }

}
