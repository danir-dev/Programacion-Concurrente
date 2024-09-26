package C1.T1;

// public class DrawableString {

// }

/*

    - Herencia de String y Point: La clase DrawableString hereda de ambas clases, lo que significa que tiene acceso a todos los atributos y métodos de String y Point.
    - Atributos y métodos heredados: Todos los atributos y métodos de String y Point están disponibles para los objetos de tipo DrawableString.
    - Uso como punto y como cadena: Se puede mover un objeto DrawableString utilizando métodos heredados de Point (como move) y se puede concatenar texto a él utilizando métodos heredados de String (como append).

    class DrawableString extends String, Point {
        
        // Constructor y otros métodos

        DrawableString dstring = new DrawableString("Hola, mundo!");
        // Mover el objeto 10 unidades a la derecha
        move(dstring, 10);
        // Agregar más texto
        dstring.append(" ¡Qué tal!");

    }

    En este ejemplo:

    - Se crea un objeto DrawableString con el texto "Hola, mundo!".
    - Se utiliza el método move (heredado de Point) para mover el objeto en el espacio.
    - Se utiliza el método append (heredado de String) para agregar más texto al objeto.

 */