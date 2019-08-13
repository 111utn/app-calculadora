package eridal.calcu.opers;

/**
 * Representa un operador de multiplicacion: <code>1 * 2</code>
 */
public class Multip extends OpBase {

  static final String SIMBOLO = "*";

  @Override protected String getSimbolo() {
    return SIMBOLO;
  }

  @Override protected double aplicar(double izq, double der) {
    return izq * der;
  }
}
