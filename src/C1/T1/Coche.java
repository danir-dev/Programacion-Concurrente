package C1.T1;

/*
    En este ejemplo, la clase Coche hereda los atributos color y velocidad de la clase Vehiculo, y además tiene su propio atributo numeroPuertas.
 */

// Clase padre (Vehículo)
class Vehiculo {
    String color;
    int velocidad;

    public void acelerar() {
        // Código para acelerar el vehículo
    }
}

// Clase hija (Coche) que hereda de Vehiculo
class Coche extends Vehiculo {
    int numeroPuertas;
}
