package C4.TP4;

import java.util.ArrayList;

public class Persona extends Thread {

    ArrayList<Integer> Lista;

    private int id;
    private long tiempoEsperaEntrada;
    private long tiempoEnZoo;
    private long tiempoEnPasillo;

    public Persona(ArrayList<Integer> Lista, int id) {
        this.Lista = Lista;
        this.id = id;
        // Inicializar tiempos de espera aleatoriamente dentro de los rangos especificados
        this.tiempoEsperaEntrada = (long) (Math.random() * 101) + 100; // Entre 100 y 200ms
        this.tiempoEnZoo = (long) (Math.random() * 301) + 400; // Entre 400 y 700ms
        this.tiempoEnPasillo = (long) 50;
    }

    @Override
    public synchronized void run() {
        

        esperandoZoologico();
        estarEnPasillo();
        estarEnZoologico();
        salirZoologico();
    }

    private synchronized void esperandoZoologico() {
        try {
            System.out.println("Persona " + id + " esperando para entrar...");
            Thread.sleep(tiempoEsperaEntrada);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void estarEnPasillo() {
        try {
            System.out.println("Persona " + id + " en el pasillo...");
            Thread.sleep(tiempoEnPasillo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void estarEnZoologico() {
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
            Thread.sleep(tiempoEnPasillo); // Tiempo para pasar por la puerta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
