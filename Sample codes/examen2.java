import java.util.concurrent.Semaphore;

public class examen2 extends Thread {
	Semaphore em=new Semaphore(0);
	static int n=3;
	int tipo;

	public examen2(int t) {tipo=t;}

	void m1() {
		synchronized(this) {
			n++;
		}
	}

	void m2() {
		try {
			em.acquire();
		} catch(InterruptedException e) {}
		n++;
		em.release();
	}

	void m3() {
		synchronized(this) {
			n++;
		}
	}

	public void run() {
		switch(tipo) {
			case 1: m1(); break;
			case 2: m2(); break;
			case 3: m3(); break;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		examen2 h1=new examen2(1);
		examen2 h2=new examen2(2);
		examen2 h3=new examen2(3);
		h1.start();
		h3.start();
		h2.start();
		h1.join();
		h2.join();
		h3.join();
		System.out.println(n);
	}
}