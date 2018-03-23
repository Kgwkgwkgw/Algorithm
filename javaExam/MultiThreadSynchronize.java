package javaExam;

public class MultiThreadSynchronize { 
    private int index = 0;
    
    MultiThreadSynchronize() {
    }


    public synchronized int getMax() {
        index++;
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return index;
    }


    public static void main(String[] args) {
        MultiThreadSynchronize synchronize = new MultiThreadSynchronize();
        new SyncThread(synchronize).start();
        new SyncThread(synchronize).start();
        new SyncThread(synchronize).start();
        System.out.println("dd"=="dd");
    }
}


class SyncThread extends Thread {
    private MultiThreadSynchronize synchronize;


    public SyncThread(MultiThreadSynchronize synchronize) {
        this.synchronize = synchronize;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        	int max = synchronize.getMax();
        while (max < 100) {
        			System.out.println(max+" - "+Thread.currentThread().getName());
                max = synchronize.getMax();
        }
        long end = System.currentTimeMillis();
        System.out.println("execution time : " + (end - start));
    }
}
