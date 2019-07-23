package eridal.calcu.pedazos;

public class Operador {

  private final String tipo;

  public Operador(String tipo) {
    this.tipo = tipo;
  }

  @Override public String toString() {
    return String.format("Operador[%s]", tipo);
  }

  public Numero aplicar(Numero izq, Numero der) {

    final boolean resultadoDecimal = izq.esDecimal()
                                  || der.esDecimal()
                                  || "/".equals(tipo)
                                  ;

    if (resultadoDecimal) {
      final double i = izq.getValorDecimal();
      final double d = der.getValorDecimal();
      final double resultado = calcular(i, d);
      return Numero.createDecimal(resultado);
    }
    else {
      final long i = izq.getValorEntero();
      final long d = der.getValorEntero();
      final long resultado = calcular(i, d);
      return Numero.createEntero(resultado);
    }
  }

  private long calcular (long a, long b) {

    if ("+".equals(tipo)) {
      return a + b;
    }
    if ("-".equals(tipo)) {
      return a - b;
    }

    // multiplicar
    return a * b;
  }

  private double calcular (double a, double b) {

    if ("+".equals(tipo)) {
      return a + b;
    }
    if ("-".equals(tipo)) {
      return a - b;
    }
    if ("*".equals(tipo)) {
      return a * b;
    }

    // dividir
    return a / b;
  }
}
