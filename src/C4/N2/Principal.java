package C4.N2;

public class Principal {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();

        // Crear un número determinado de personas
        for (int i = 1; i <= 10; i++) {
            Persona persona = new Persona(i, zoo);
            persona.start();
        }
    }
}

