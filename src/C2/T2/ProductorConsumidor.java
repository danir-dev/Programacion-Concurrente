package C2.T2;

import java.util.concurrent.*;

public class ProductorConsumidor {
    private static final int BUFFER_SIZE = 10;
    private int[] buffer = new int[BUFFER_SIZE];
    private int count = 0;
    private int in = 0;
    private int out = 0;

    // Semáforos
    private Semaphore empty = new Semaphore(BUFFER_SIZE);
    private Semaphore full = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public void productor() {
        while (true) {
            int item = producir(); // Simula la producción de un item
            try {
                empty.acquire(); // Espera si el buffer está lleno
                mutex.acquire();
                buffer[in] = item;
                in = (in + 1) % BUFFER_SIZE;
                mutex.release();
                full.release(); // Notifica al consumidor que hay un nuevo item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumidor() {
        while (true) {
            try {
                full.acquire(); // Espera si el buffer está vacío
                mutex.acquire();
                int item = buffer[out];
                out = (out + 1) % BUFFER_SIZE;
                mutex.release();
                empty.release(); // Notifica al productor que hay un espacio libre
                consumir(item); // Simula el consumo del item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ProductorConsumidor pc = new ProductorConsumidor();
        Thread t1 = new Thread(pc::productor);
        Thread t2 = new Thread(pc::consumidor);
        t1.start();
        t2.start();
    }
}

/*

    SIN SEMAFOROS

    var buffer: array[1..N] of dato; // Buffer de tamaño N
    var lleno: boolean; // True si el buffer está lleno, False si está vacío

    process Productor
    begin
    loop
        produce(x);
        while lleno do
        // Esperar hasta que el buffer esté vacío
        end while;
        poner(x, buffer);
        lleno := true;
    end loop;
    end;

    process Consumidor
    begin
    loop
        while not lleno do
        // Esperar hasta que el buffer esté lleno
        end while;
        sacar(x, buffer);
        lleno := false;
        consumir(x);
    end loop;
    end;

 */


/*

    CON SEMAFOROS

    // Variables globales
    buffer[BUFFER_SIZE]
    count, in, out
    semáforo empty = BUFFER_SIZE
    semáforo full = 0
    semáforo mutex = 1

    productor()
        bucle infinito
            producir un item
            P(empty) // Espera si el buffer está lleno
            P(mutex)
            colocar item en buffer
            in = (in + 1) mod BUFFER_SIZE
            V(mutex)
            V(full) // Notifica al consumidor

    consumidor()
        bucle infinito
            P(full) // Espera si el buffer está vacío
            P(mutex)
            tomar item del buffer
            out = (out + 1) mod BUFFER_SIZE
            V(mutex)
            V(empty)
            consumir item



    Explicación

    Semáforos:
    
    - empty: Indica el número de espacios vacíos en el buffer.
    - full: Indica el número de espacios llenos en el buffer.
    - mutex: Garantiza el acceso exclusivo al buffer.
    
    Lógica:
    
    - El productor espera hasta que haya espacio en el buffer (P(empty)), obtiene el mutex, coloca el item y notifica al consumidor (V(full)).
    - El consumidor espera hasta que haya un item en el buffer (P(full)), obtiene el mutex, toma el item y notifica al productor (V(empty)).
    
    Ventajas:
    
    - Sincronización clara y eficiente.
    - Evita condiciones de carrera.
    - Fácil de entender y modificar.

*/