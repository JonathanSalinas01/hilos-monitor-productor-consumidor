public class Productor extends Thread{
    private Monitor buffer;
    private int caracteresParaProducir;
    private int sleep;

    public Productor(Monitor buffer, int caracteres, int sleep){
        this.buffer = buffer;
        this.caracteresParaProducir = caracteres;
        this.sleep = sleep; //Tiempo de dormir entre caracter y caracter
    }

    public void run(){
        try {
            char c;
            for (int i = 0; i < this.caracteresParaProducir; i++) {
                c = (char) ('A' + i);
                buffer.ponerCaracter(c);
                System.out.println("Produje: " + c + " (" + (int) (Math.random()*this.sleep) + ")");
                sleep((int) Math.random() * this.sleep);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
