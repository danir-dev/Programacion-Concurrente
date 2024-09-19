package TP4;

import java.util.ArrayList;
import java.util.Random;

public class Productor extends Thread {

    ArrayList<Integer> Lista;
    int Num;

    public Productor(ArrayList<Integer> lista, int num) {
        Lista = lista;
        Num = num;
    }

    public void run() {

        int inicio = 10, fin = 100, I = 100, S = 500;
        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            
            int numero = random.nextInt(((fin - inicio) + 1) + inicio);

            try {
                
                Thread.sleep(random.nextInt(((S - I) + 1) + I));
                synchronized(Lista) {
                    Lista.add(numero);
                    Lista.notify();
                    //Lista.notifyAll();
                    System.out.println("Prod(" + Num + "): Numero agregado: " + numero);
                }
                System.out.println("Prod(" + Num + "): Notificando...");

            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

}
