import java.util.concurrent.*;

public class Cyclic implements Runnable {
	final static CyclicBarrier barrera=new CyclicBarrier(10);
	static int[] vec={1,2,3,4,5,6,7,8,9,10};
	static int[] fvec=new int[vec.length];
	int nH;

	public Cyclic(int nHilo) {nH=nHilo;}

	public void run() {
		fvec[nH]=vec[nH]*vec[nH];
		try {
			barrera.await();
		} catch(BrokenBarrierException e) {}
		catch(InterruptedException e) {}
		fvec[nH]+=fvec[nH];
	}

	public static void main(String[] args) throws Exception {
		
	}
}