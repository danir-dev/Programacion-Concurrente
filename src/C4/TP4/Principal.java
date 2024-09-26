package C4.TP4;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Integer> miLista = new ArrayList<>();
        Productor prod = new Productor(miLista, 0);
        prod.start();

        for (int i = 0; i < 10; i++) {
            Consumidor cons = new Consumidor(miLista, i);
            cons.start();
        }
        
    }

}
