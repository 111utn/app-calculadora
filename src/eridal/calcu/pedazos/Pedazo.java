package eridal.calcu.pedazos;

import eridal.calcu.Numero;
import eridal.calcu.Operador;

public class Pedazo {

  private Numero valor;
  private Operador oper;

  Pedazo (Numero valor) {
    this.valor = valor;
    this.oper = null;
  }

  Pedazo (Operador oper) {
    this.valor = null;
    this.oper = oper;
  }

  public String toString() {
    return esNumero()
      ? String.valueOf(valor)
      : oper.toString()
    ;
  }

  public boolean esNumero() {
    return valor != null;
  }

  public boolean esOperador() {
    return oper != null;
  }

  public Numero toNumero() {
    return valor;
  }

  public Operador toOperador() {
    return oper;
  }
}
