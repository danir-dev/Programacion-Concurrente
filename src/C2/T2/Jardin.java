package C2.T2;

/*

    Explicación del código:

    - ReentrantLock: Es un mecanismo de sincronización que nos permite crear regiones críticas. 
                     Al llamar a lock(), un hilo adquiere el bloqueo y ningún otro hilo puede entrar en esa sección de código hasta que el primer hilo llame a unlock().
    - entrar() y salir(): Estos métodos representan las acciones de entrar y salir del jardín. 
                          Dentro de estos métodos, se adquiere el lock, se actualiza el contador y se libera el lock.
    - Hilos: Creamos múltiples hilos para simular diferentes personas entrando y saliendo del jardín. 
             Cada hilo llama repetidamente a los métodos entrar() y salir().

    ¿Cómo funciona?


    - Cada vez que un hilo quiere entrar o salir del jardín, primero adquiere el lock.
    - Esto asegura que solo un hilo pueda acceder a la variable visitantes a la vez.
    - El hilo actualiza el contador y luego libera el lock, permitiendo que otro hilo pueda entrar en la región crítica.

 */

import java.util.concurrent.locks.ReentrantLock;

public class Jardin {
    private int visitantes = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void entrar() {
        lock.lock(); // Adquiere el lock (región crítica)
        visitantes++;
        System.out.println("Una persona ha entrado. Total: " + visitantes);
        lock.unlock(); // Libera el lock
    }

    public void salir() {
        lock.lock(); // Adquiere el lock (región crítica)
        visitantes--;
        System.out.println("Una persona ha salido. Total: " + visitantes);
        lock.unlock(); // Libera el lock
    }

    public static void main(String[] args) {
        Jardin jardin = new Jardin();

        // Crear múltiples hilos para simular personas entrando y saliendo
        Thread[] personas = new Thread[10];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    jardin.entrar();
                    try {
                        Thread.sleep(100); // Simula un tiempo dentro del jardín
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    jardin.salir();
                }
            });
            personas[i].start();
        }
    }
}
