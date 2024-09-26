package C1.T1;

/*
    En este ejemplo:

    - Animal es la superclase.
    - Perro es la subclase y hereda de Animal.
    - Un objeto de tipo Perro puede utilizar los métodos comer() y dormir() heredados de Animal, además de su propio método ladrar().
 */

class Animal {
    String nombre;
    int edad;

    public void comer() {
        System.out.println("Estoy comiendo");
    }
}

class Perro extends Animal {
    public void ladrar() {
        System.out.println("Guau!");
    }
}