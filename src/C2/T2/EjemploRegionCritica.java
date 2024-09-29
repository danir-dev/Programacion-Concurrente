package C2.T2;

import java.util.concurrent.locks.ReentrantLock;

public class EjemploRegionCritica {
    @SuppressWarnings("unused")
    private int contador = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void incrementar() {
        lock.lock(); // Adquiere el lock (región crítica)
        contador++;
        lock.unlock(); // Libera el lock
    }
}