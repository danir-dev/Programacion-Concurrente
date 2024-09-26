package C1.T1;

/*
    Clase Counter:

    - private long count;: Esta variable almacena el valor del contador. Al ser privada, solo puede ser accedida desde dentro de la clase.
    - public void setCount(long value): Este método establece un nuevo valor para el contador.
    - public long getValue(): Este método devuelve el valor actual del contador.

    Clase Main:

    - Counter people = new Counter();: Se crea un nuevo objeto llamado people de la clase Counter.
    - people.setCount(0);: Se inicializa el contador del objeto people con el valor 0.
    - long value = people.getValue();: Se obtiene el valor actual del contador y se almacena en la variable value.
 */

// public class Counter {
//     private long count;

//     public void setCount(long value) {
//         count = value;
//     }

//     public long getValue() {
//         return count;
//     }
// }

// public class CounterMain {
//     public static void main(String[] args) {
//         Counter people = new Counter();
//         people.setCount(0); // Inicializar el objeto people

//         // Verificar que se borre
//         long value = people.getValue();
//     }
// }