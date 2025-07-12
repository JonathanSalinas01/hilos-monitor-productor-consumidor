public class Monitor {
    private char[] buffer = null;
    private int tope = 0;
    private boolean lleno = false;
    private boolean vacio = true;

    public Monitor(int capacidad) {
        this.buffer = new char[capacidad];
    }

    public synchronized void ponerCaracter (char c) throws Exception{
        //Mientras el buffer esté lleno esperará, para darle oportunidad al consumidor de eliminar algun caracter
        while (lleno){
            wait(); //Espera a que haya un lugar
        }
        //seccion critica
        buffer[tope++] = c; //pone un caracter en el buffer
        vacio = false; //el buffer ya no está vacio
        lleno = tope >= buffer.length; //se asegura de que el buffer no esté lleno
        notifyAll(); //Pasa al estado ready al hilo
    }

    public synchronized char sacarCaracter() throws Exception{
        //Mientras el buufer este vacìo se le dara oportunidad al productor de producir
        while (vacio){
            wait();
        }
        char c = buffer[--tope]; //Se guarda en la variable c el caracter que se consumió
        lleno = false; //El buffer ya no está lleno
        vacio = tope <= 0; //Controla que que el buffer no esté vacío
        notifyAll(); //Pasa al esto ready al hilo
        return c; //se devuelve el caracter consumido
    }
}
