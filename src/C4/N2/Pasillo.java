package C4.N2;

public class Pasillo {
    private boolean ocupado = false;

    public synchronized boolean estaOcupado() {
        return ocupado;
    }

    public synchronized void ocupar() {
        ocupado = true;
    }

    public synchronized void liberar() {
        ocupado = false;
    }
}

