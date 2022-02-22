public class Main {

    static Integer counter;

    static class IncrementingThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
            super.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final IncrementingThread incThread1 = new IncrementingThread();
        incThread1.start();
        final IncrementingThread incThread2 = new IncrementingThread();
        incThread2.start();
        incThread1.join();
        incThread2.join();
        System.out.println("Result=" + counter);
    }

}

