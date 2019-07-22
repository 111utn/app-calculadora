package eridal.calcu;

import java.util.Arrays;
import java.util.Scanner;

public class Calculadora {

  /**
   * Entrada del usuario, deconstruida en operadores y operandos
   */
  private static Object[] entrada;

  /**
   * El resultado de evaluar el ingreso del usuario
   */
  private static String salida;

  /**
   * El tipo de error encontrado al evaluar el ingreso del usuario
   */
  private static String error;


  public static void main(String[] args) {

    final Scanner sc = new Scanner(System.in);

    System.out.print("> ");

    while (sc.hasNext()) {

      final String input = sc.nextLine();

      if (procesar(input)) {
        System.out.println(salida);
      }
      else {
        System.err.println(error);
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
   * @return boolean `true` si la entrada pudo ser analizada correctamente
   */
  private static boolean procesar(final String input) {

    final boolean fueOK = reconocer(input);

    if (fueOK) {
      salida = String.valueOf(entrada.length); // por ahora la salida es la cantidad de cosas encontradas
    }

    return fueOK;
  }

  /**
   * @return `true` si pudo reconocer el ingreso completo
   */
  private static boolean reconocer(final String input) {

    final Object[] pedazos = new Object[1000]; // maximo 1000 pedazos por ahora

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
  private static boolean reconocerNumeros(final Scanner sc, final  Object[] pedazos, final int pos) {

    if (sc.hasNextInt()) {
      final int valor = sc.nextInt();
      pedazos[pos] = valor;
      return true;
    }

    if (sc.hasNextLong()) {
      final long valor = sc.nextLong();
      pedazos[pos] = valor;
      return true;
    }

    if (sc.hasNextFloat()) {
      final float valor = sc.nextFloat();
      pedazos[pos] = valor;
      return true;
    }

    if (sc.hasNextDouble()) {
      final double valor = sc.nextDouble();
      pedazos[pos] = valor;
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
  private static boolean reconocerOperadores(final Scanner sc, final  Object[] pedazos, final int pos) {

    for (String operador : OPERADORES) {
      if (sc.hasNext(operador)) {
        String op = sc.next(operador);
        pedazos[pos] = op;
        return true;
      }
    }

    return false;
  }
}
