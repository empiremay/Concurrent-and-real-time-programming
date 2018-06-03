/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 18/11/2016
*/
/**
* Clase algDekker
*/
/* Algoritmo de Dekker */
class algDekker {
    /* Iteraciones que dara cada hilo */
    static final int iteraciones = 1000000;
    /* Recurso compartido */
    static volatile int enteroCompartido = 0;
    /* Representa el deseo del hilo P de entrar en la seccion critica */
    static volatile boolean wantp = false;
    /* Representa el deseo del hilo Q de entrar en la seccion critica */
    static volatile boolean wantq = false;
    /* Representa el deseo del hilo R de entrar en la seccion critica */
    static volatile boolean wantr = false;
    /* Representa de quien es el turno */
    static volatile int turn = 1;
    /**
    * Clase P que extiende de Thread
    */
    class P extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                if(i%50==0) {
                    System.out.print(enteroCompartido);
                }
                /* Seccion no critica */
                wantp = true;
                while (wantq && wantr) {
                    if (turn == 2) {
                        wantp = false;
                        while (turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                    else if(turn == 3) {
                        wantp = false;
                        while (turn == 3)
                            Thread.yield();
                        wantp = true;
                    }
                }

                /* Seccion critica */
                ++enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 2;
                wantp = false;
                //wantq=false;
            }
        }
    }
    /**
    * Clase Q que extiende de Thread
    */
    class Q extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                if(i%50==0) {
                    System.out.println(enteroCompartido);
                }
                /* Seccion no critica */
                wantq = true;
                while (wantr && wantp) {
                    if (turn == 3) {
                        wantq = false;
                        while (turn == 3)
                            Thread.yield();
                        wantq = true;
                    }
                    else if(turn==1) {
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantq = true;
                    }
                }

                /* Seccion critica */
                --enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 3;
                wantq = false;
                //wantr=false;
            }
        }
    }
   /**
    * Clase R que extiende de Thread
    */
    class R extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                if(i%50==0) {
                    System.out.println(enteroCompartido);
                }
                /* Seccion no critica */
                wantr = true;
                while (wantp && wantq) {
                    if (turn == 1) {
                        wantr = false;
                        while (turn == 1)
                            Thread.yield();
                        wantr = true;
                    }
                    else if(turn==2) {
                        wantr = false;
                        while (turn == 2)
                            Thread.yield();
                        wantr = true;
                    }
                }

                /* Seccion critica */
                ++enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 1;
                wantr = false;
                //wantp=false;
            }
        }
    }

    algDekker() {
        Thread p = new P();
        Thread q = new Q();
        Thread r = new R();
        p.start();
        q.start();
        r.start();
        
        try {
            p.join();
            q.join();
            r.join();
            System.out.println("El valor del recurso compartido es " + enteroCompartido);
            System.out.println("Deberia ser 1000000.");
        }
        catch (InterruptedException e) {}
    }
    /**
    * Funcion principal de la clase
    */
    public static void main(String[] args) {
        new algDekker();
    }
}
