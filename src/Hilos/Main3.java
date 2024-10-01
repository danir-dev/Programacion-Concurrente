package Hilos;

public class Main3 {

    private int contador = 0;
    private final Object lock = new Object();

    public void realizarTarea() {

        int i;
        
        for (int i = 0; i < 1000; i++) {

            synchronized(lock) {
                contador++; // h1 -> 19 -> 20
                            // h2 -> 10 -> 20                
            }

            try {
                Thread.sleep(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public int obtenerContador() {
        return contador;
    }

    public static void main(String[] args) {

        Main m1 = new Main();

        Thread t1 = new Thread( () -> m1.realizarTarea());
        Thread t2 = new Thread( () -> m1.realizarTarea());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Contador: " + m1.obtenerContador());
        
    }

}
