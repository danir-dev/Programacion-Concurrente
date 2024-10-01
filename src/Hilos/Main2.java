package Hilos;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        // getState()

        Thread thread = new Thread(() -> { //NEW
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Throw new RuntimeException(e);
            }
            System.out.println("Hola, soy un hilo");
        });

        System.out.println("Estado actual del hilo: " + thread.getState());

        thread.start(); //Runnable

        System.out.println("Estado despúes de iniciar el hilo: " + thread.getState());

        thread.sleep(1000);

        System.out.println("Estado despúes de un tiempo de ejecución: " + thread.getState());

        // Blocked

        // Waiting

        thread.join();

        System.out.println("Estado despúes de unirse al hilo: " + thread.getState());
        
    }

}
