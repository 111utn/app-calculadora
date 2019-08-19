package eridal.calcu;

import java.util.Scanner;

import eridal.calcu.runtime.Calcu;

public class Calculadora {

  public static void main(String[] args) {

    final Scanner sc = new Scanner(System.in);

    final Calcu calcu = new Calcu();

    System.out.print("> ");

    while (sc.hasNext()) {

      final String input = sc.nextLine();
      final Number salida = calcu.resolver(input);

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
}
