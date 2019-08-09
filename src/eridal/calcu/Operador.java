package eridal.calcu;

public interface Operador {

  /**
   * @return El resultado de aplicar el operador segun: `res = izq op der`
   */
  public Numero aplicar(Numero izq, Numero der);

}
