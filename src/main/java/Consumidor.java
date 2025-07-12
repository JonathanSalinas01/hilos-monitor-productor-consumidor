public class Consumidor extends Thread{
    private Monitor buffer;
    private int caracteresPorProducir;
    private int sleep;

    public Consumidor(Monitor buffer, int caracteresPorProducir, int sleep) {
        this.buffer = buffer;
        this.caracteresPorProducir = caracteresPorProducir;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            char c;
            for (int i = 0; i < this.caracteresPorProducir; i++) {
                c = buffer.sacarCaracter();
                System.out.println("Consumí: " + c + " (" + (int) (Math.random()*this.sleep) + ")");
                sleep((int) (Math.random()*this.sleep));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
