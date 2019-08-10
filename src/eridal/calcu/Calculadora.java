package eridal.calcu;

import java.util.Arrays;
import java.util.Scanner;

import eridal.calcu.pedazos.Pedazo;
import eridal.calcu.pedazos.Pedazos;

public class Calculadora {

  /**
   * Entrada del usuario, deconstruida en operadores y operandos
   */
  private Pedazo[] entrada;


  /**
   * El tipo de error encontrado al evaluar el ingreso del usuario
   */
  private String error;

  public static void main(String[] args) {

    final Scanner sc = new Scanner(System.in);
    final Calculadora calcu = new Calculadora();

    System.out.print("> ");

    while (sc.hasNext()) {

      final String input = sc.nextLine();
      final Number salida = calcu.procesar(input);

      if (salida != null) {
        System.out.println(salida);
      }
      else {
        System.err.println(calcu.error);
      }

      System.out.print("> ");
    }

    sc.close();
  }

  /**
   * Procesa la entrada del usuario y genera una salida
   *
   * Esta forma de proceso no es la ideal, pero aun no sabemos
   * control de errores. Por ahora queda asi.
   *
   *
   * @return Number resultado de la operacion, or `null` si ocurrio algun error
   */
  private Number procesar(final String input) {

    final boolean fueOK = reconocer(input);

    if (fueOK) {
      return resolver();
    }

    return null;
  }

  /**
   * @return `true` si pudo reconocer el ingreso completo
   */
  private boolean reconocer(final String input) {

    final Pedazo[] pedazos = new Pedazo[1000]; // maximo 1000 pedazos por ahora

    int cant = 0;

    final Scanner sc = new Scanner(input);

    while (sc.hasNext()) {

      if (reconocerNumeros(sc, pedazos, cant)) {
        cant += 1;
      }
      else if (reconocerOperadores(sc, pedazos, cant)) {
        cant += 1;
      }
      else {
        final String nidea = sc.next();
        error = "error: " + nidea + " no reconocido";
        sc.close();
        return false;
      }
    }

    entrada = Arrays.copyOf(pedazos, cant);

    sc.close();

    return true;
  }

  /**
   * @return `true` si pudo reconocer un numero
   */
  private boolean reconocerNumeros(final Scanner sc, final  Object[] pedazos, final int pos) {

    if (sc.hasNextInt()) {
      final int valor = sc.nextInt();
      pedazos[pos] = Pedazos.numeroEntero(valor);
      return true;
    }

    if (sc.hasNextLong()) {
      final long valor = sc.nextLong();
      pedazos[pos] = Pedazos.numeroEntero(valor);
      return true;
    }

    if (sc.hasNextFloat()) {
      final float valor = sc.nextFloat();
      pedazos[pos] = Pedazos.numeroDecimal(valor);
      return true;
    }

    if (sc.hasNextDouble()) {
      final double valor = sc.nextDouble();
      pedazos[pos] = Pedazos.numeroDecimal(valor);
      return true;
    }

    return false;
  }

  private static final String[] OPERADORES = {
    "\\+",
    "-",
    "\\*",
    "/",
  };

  /**
   * @return `true` si pudo reconocer un operador
   */
  private boolean reconocerOperadores(final Scanner sc, final  Object[] pedazos, final int pos) {

    for (String operador : OPERADORES) {
      if (sc.hasNext(operador)) {
        String op = sc.next(operador);
        pedazos[pos] = Pedazos.operador(op);
        return true;
      }
    }

    return false;
  }

  /**
   * Resuelve la expresion y obtiene el resultado final
   *
   * CUIDADO:
   *   El metodo actual NO resuelve operaciones segun las reglas matematicas,
   *   sino por el order mismo de aparicion de los operadores.
   *
   *   Ej: "1 + 2 * 3" es resuelto como ((1 + 2) * 3) = 9
   *
   *
   * @return Number resultado de la operacion, or `null` si ocurrio algun error
   */
  private Number resolver() {

    if (entrada.length == 0) {
      return null;
    }

    Numero num = null;
    Operador opr = null;

    for (Pedazo pedazo : entrada) {

      if (pedazo.esNumero()) {
        if (num == null) {
          num = pedazo.toNumero();
        }
        else if (opr == null) {
          error = "error: se esperaba operador, encontrado " + pedazo;
          return null;
        }
        else {
          num = opr.aplicar(num, pedazo.toNumero());
          opr = null;
        }
      }
      else if (pedazo.esOperador()) {
        if (num == null) {
          error = "error: se esperaba operando, encontrado " + pedazo;
          return null;
        }
        else {
          opr = pedazo.toOperador();
        }
      }
    }

    if (opr != null) {
      error = "error: se esperaba operando, encontrado " + opr;
      return null;
    }

    if (num == null) {
      error = "error: operacion vacia";
      return null;
    }

    return num.getValor();
  }
}
