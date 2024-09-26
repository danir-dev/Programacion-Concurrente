package C1.T1;

/*
    En este ejemplo:

    - Animal: Es la clase base, define el método hacerRuido() de forma genérica.
    - Perro y Gato: Heredan de Animal y redefinen el método hacerRuido() para proporcionar una implementación específica.
 */

class Animal {
    public void hacerRuido() {
        System.out.println("El animal hace ruido");
    }
}

class Perro extends Animal {
    @Override
    public void hacerRuido() {
        System.out.println("Guau!");
    }
}

class Gato extends Animal {
    @Override
    public void hacerRuido() {
        System.out.println("Miau!");
    }
}

/*

    EJEMPLO PERO EN PYTHON

    # En este ejemplo, se ha redefinido el operador + para que funcione con objetos de tipo Vector, realizando una suma de vectores.

    class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __add__(self, other):
        return Vector(self.x + other.x, self.y + other.y)

    def __str__(self):
        return f"({self.x}, {self.y})"

    v1 = Vector(2,3)
    v2 = Vector(5, 7)
    v3 = v1 + v2
    print(v3)  # Output: (7, 10)

 */