package Lesson4;

public class Main {
    static Object mon = new Object();
    static volatile String currentLetter = "A";
    static final int num = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentLetter != "A") {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = "B";
                        mon.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentLetter != "B") {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = "C";
                        mon.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentLetter != "C") {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentLetter = "A";
                        mon.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

}

