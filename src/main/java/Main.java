public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(3); //Monitor con capacidad de 3 caracteres
        Productor productor = new Productor(monitor, 6, 2000); //Producirá 6 caracteres, entre 0 y 4 segundos
        Consumidor consumidor = new Consumidor(monitor, 6, 4000); //Consumirá 6 caracteres, entre 0 y 4 segundos
        productor.start();
        consumidor.start();
    }
}
