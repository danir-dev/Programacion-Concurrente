package C1.T1;

/*
    En este ejemplo:

    - Point: Es la clase base. Representa un punto en un plano cartesiano con coordenadas x e y.
    - Circle: Es una subclase de Point. Además de las coordenadas heredadas de Point, tiene un atributo adicional radius para representar el radio del círculo.
 */

class Point {
    int x, y;
    // Métodos para establecer y obtener las coordenadas
}

class Circle extends Point {
    int radius;
    // Métodos para establecer y obtener el radio
}

/*

    // En este ejemplo:

    // - Creamos un objeto circle de tipo Circle.
    // - Inicializamos sus coordenadas y radio.
    // - Llamamos al método move pasando el objeto circle y un desplazamiento de 10 unidades en el eje X.
    
    // A pesar de que circle es un objeto de tipo Circle, podemos pasarlo como argumento al método move, ya que Circle es un subtipo de Point.

    Circle circle = new Circle();
    circle.setX(10);
    circle.setY(20);
    circle.setRadius(5);

    // Movemos el círculo 10 unidades a la derecha
    move(circle, 10);

 */

/*

    Ejemplo: Clase DrawableString

    En el ejemplo que presentas, se plantea la creación de una clase DrawableString que representa una cadena de texto que puede ser dibujada en una pantalla. 
    Para lograr esto, se necesita que esta clase tenga las siguientes características:

    - Propiedades de una cadena: Poder almacenar y manipular texto (heredado de String).
    - Propiedades de un punto: Poder tener una posición en el espacio (heredado de Point).

    La herencia múltiple permite crear esta clase DrawableString que hereda tanto de String como de Point, combinando así las características de ambas clases.

    // Suponiendo que tenemos clases String y Point definidas
    class DrawableString extends String, Point {
        // Constructor y otros métodos
    }

 */