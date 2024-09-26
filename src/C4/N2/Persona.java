package C4.N2;

import java.util.Random;

public class Persona extends Thread {
    private int id;
    private Zoologico zoo;
    private Random random = new Random();

    public Persona(int id, Zoologico zoo) {
        this.id = id;
        this.zoo = zoo;
    }

    

    @Override
    public void run() {
        try {
            // Simular tiempo de espera antes de entrar
            Thread.sleep(random.nextInt(101) + 100);

            // Entrar al zoológico
            zoo.entrar(this);

            // Simular tiempo dentro del zoológico
            Thread.sleep(random.nextInt(301) + 400);

            // Salir del zoológico
            zoo.salir(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

