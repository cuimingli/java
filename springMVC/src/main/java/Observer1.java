public class Observer1 implements Observer {

    public Subject subject;

    public Observer1(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }
    public void update(String msg) {
       System.out.println("observer1 的到的 3D 号码 --->" + msg+ ",我要记下来.");
    }
}
