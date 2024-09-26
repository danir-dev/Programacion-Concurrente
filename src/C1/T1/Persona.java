package C1.T1;

/*
    En este ejemplo, los atributos nombre y edad son privados, lo que significa que solo pueden ser accedidos y modificados desde dentro de la clase Persona. 
    Los métodos getNombre() y setEdad() proporcionan una interfaz pública para interactuar con estos atributos de forma controlada.
 */

public class Persona {
    private String nombre;
    @SuppressWarnings("unused")
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para la edad
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa");
        }
    }
}