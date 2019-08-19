package eridal.calcu.parser;

import java.util.Arrays;
import java.util.Scanner;

import eridal.calcu.pedazos.Pedazo;
import eridal.calcu.pedazos.Pedazos;

public class Parser {

  public String error;

  /**
   *
   * @example parse("1 + 2") == Pedazo[3] { Numero(1), Operador(Suma), Numero(2) }
   *
   * @return Lista de pedazos que componen el `input`
   */
  public Pedazo[] parse(String input) {

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
        return null;
      }
    }

    sc.close();

    return Arrays.copyOf(pedazos, cant);
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

}
