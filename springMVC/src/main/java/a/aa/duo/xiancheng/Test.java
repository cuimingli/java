package a.aa.duo.xiancheng;

public class Test {
    public static void main(String args[]){
        Store<Apple> store = new Store<Apple>();
        new AppleConsumer().bindStore(store).consume();
        for(int i = 0;i<30;i++){
            new AppleProducer().bindStore(store).setName(i + "").production();
        }
    }
}
