public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int count_1;
    public static int count_2 = 0;

    static {
        count_1++;
        count_2++;
    }

    private Singleton() {
        count_1++;
        count_2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}


