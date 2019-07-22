package eridal.calcu;

import java.util.Scanner;

public class Calculadora {

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
   * Solo para alternar entre error y resultado
   */
  private static boolean simularError = false;

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

    final boolean fueOK = !simularError;

    if (fueOK) {
      salida = input; // por ahora la salida es lo mismo que recibimos
    } else {
      error = "Error: probando errores"; // por ahora un unico mensaje de error
    }

    simularError = ! simularError;

    return fueOK;
  }
}
