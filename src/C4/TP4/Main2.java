package C4.TP4;

public class Main2 {
    public static void main(String[] args) {
        Zoologico2 zoo = new Zoologico2();

        // Crear hilos que simulan personas llegando al zoológico
        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    // Simular tiempo de llegada aleatorio
                    Thread.sleep((int) (Math.random() * 101) + 100);
                    zoo.entrar(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
