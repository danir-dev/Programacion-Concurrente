package C4.N2;

public class Zoologico {
    private Pasillo pasillo = new Pasillo();

    public synchronized void entrar(Persona persona) {
        try {
            // Esperar si el pasillo está ocupado
            while (pasillo.estaOcupado()) {
                wait();
            }
            pasillo.ocupar();
            System.out.println("Persona " + persona.getId() + " entró al zoológico.");
            // Simular tiempo en el pasillo
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void salir(Persona persona) {
        try {
            // Simular tiempo haciendo fila para salir
            Thread.sleep(50);
            pasillo.liberar();
            System.out.println("Persona " + persona.getId() + " salió del zoológico.");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}