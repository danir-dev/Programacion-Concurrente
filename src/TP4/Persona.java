package TP4;

public class Persona extends Thread {
    private int id;
    private long tiempoEsperaEntrada;
    private long tiempoEnZoo;

    public Persona(int id) {
        this.id = id;
        // Inicializar tiempos de espera aleatoriamente dentro de los rangos especificados
        this.tiempoEsperaEntrada = (long) (Math.random() * 101) + 100; // Entre 100 y 200ms
        this.tiempoEnZoo = (long) (Math.random() * 301) + 400; // Entre 400 y 700ms
    }

    @Override
    public void run() {
        entrarZoologico();
        estarEnZoologico();
        salirZoologico();
    }

    private synchronized void entrarZoologico() {
        try {
            System.out.println("Persona " + id + " esperando para entrar...");
            Thread.sleep(tiempoEsperaEntrada);
            System.out.println("Persona " + id + " entrando...");
            Thread.sleep(50); // Tiempo para pasar por la puerta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void estarEnZoologico() {
        try {
            System.out.println("Persona " + id + " dentro del zoologico");
            Thread.sleep(tiempoEnZoo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void salirZoologico() {
        try {
            System.out.println("Persona " + id + " saliendo del zoologico");
            Thread.sleep(50); // Tiempo para pasar por la puerta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
