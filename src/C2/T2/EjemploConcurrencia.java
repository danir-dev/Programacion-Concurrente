package C2.T2;

/*

    En este ejemplo, tenemos dos hilos (tareas) que se ejecutan de forma concurrente. 
    Uno imprime números y el otro letras. 
    Es probable que las impresiones se mezclen, ya que los hilos se ejecutan de forma independiente y comparten la misma consola.

    */

public class EjemploConcurrencia {
    public static void main(String[] args) {
        // Tarea 1: Imprimir números del 1 al 10
        Thread tarea1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Tarea 1: " + i);
            }
        });

        // Tarea 2: Imprimir letras del A al J
        Thread tarea2 = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println("Tarea 2: " + c);
            }
        });

        // Iniciar ambas tareas
        tarea1.start();
        tarea2.start();
    }
}

