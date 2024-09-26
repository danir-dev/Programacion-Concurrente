package C4.TP4;

public class Zoologico2 {
    private int personasAdentro = 0;
    private Object monitor = new Object();

    public void entrar(int id) {
        synchronized (monitor) {
            while (personasAdentro > 0) {
                try {
                    monitor.wait(); // Espera si hay alguien en el pasillo o dentro
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Persona " + id + " entrando al pasillo.");
            // Simular tiempo de entrada por el pasillo (50ms)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            personasAdentro++;
            System.out.println("Persona " + id + " dentro del zoológico.");
            monitor.notify(); // Permite que otro pueda salir
        }

        // Simular tiempo dentro del zoológico (400-700ms)
        try {
            Thread.sleep((int) (Math.random() * 301) + 400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (monitor) {
            personasAdentro--;
            System.out.println("Persona " + id + " saliendo del pasillo.");
            // Simular tiempo de salida por el pasillo (50ms)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Persona " + id + " fuera del zoológico.");
            monitor.notify(); // Permite que otro pueda entrar
        }
    }
}