package eridal.calcu;

import java.util.Scanner;

public class Calculadora {

  public static void main(String[] args) {

    final Scanner sc = new Scanner(System.in);

    System.out.print("> ");

    while (sc.hasNext()) {

      final String input = sc.nextLine();

      System.out.println(input);
      System.out.print("> ");
    }

    sc.close();
  }
}
