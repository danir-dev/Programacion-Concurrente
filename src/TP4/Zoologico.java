package TP4;

public class Zoologico {
    private final Object puerta = new Object(); // Monitor para controlar el acceso a la puerta

    public void iniciarSimulacion(int numeroPersonas) {
        // Crear hilos (personas) y ejecutarlos
        for (int i = 1; i <= numeroPersonas; i++) {
            new Persona(i).start();
        }
    }

    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        zoo.iniciarSimulacion(100); // Ejemplo con 100 personas
    }
}