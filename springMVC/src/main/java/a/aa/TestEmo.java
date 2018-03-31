package a.aa;

public class TestEmo {
    public static void main(String args[]){
        OurThread mt1 = new OurThread("A");
        OurThread mt2 = new OurThread("B");
        OurThread mt3 = new OurThread("C");
        new Thread(mt1).start();
        new Thread(mt2).start();
        new Thread(mt3).start();
       }
}
