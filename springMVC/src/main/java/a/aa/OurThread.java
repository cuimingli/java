package a.aa;

public class OurThread implements Runnable {
    private String name;

    public OurThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(this.name + "---->>>>" + i);
        }
    }
}

