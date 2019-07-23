Calculadora
===========

Esta calculadora resuelve operaciones matematicas segun el orden
de aparicion de las mismas.

Las operaciones que soporta son: sumar, restar, multiplicar, y dividir.

La calculadora trabaja con numeros enteros y decimales, tanto positivos como 
negativos. Los operadores reconocen ambos tipos y produciran cambios segun sea
espeado (ej: `1 / 3` produce un decimal)

**Limitaciones**:

1. Metodo de ingreso

Dado el sencillo metodo de analisis de texto (muy sencillo) es necesario
incluir espacios entre los operadores y operandos para que sean correctamente
reconocidos, es decir que `1 + 2` sera reconocido, pero no `1+ 2` o `1 +2`.


2. Order de evaluacion

La implementacion actual resuelve las expresiones segun el order de aparicion 
de los operadores, es decir que `1 + 2 * 3` sera evaluado como `(1 + 2) * 3`
y no como es de esperarse: `1 + (2 * 3)`

