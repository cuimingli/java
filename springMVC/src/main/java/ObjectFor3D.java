import java.util.ArrayList;
import java.util.List;

public class ObjectFor3D implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 3d 彩票的号码
     */
    private String msg;

    public ObjectFor3D() {
        super();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0){
            observers.remove(index);
        }

    }

    public void notifyObservers() {
       for(Observer observer : observers){
           observer.update(msg);
       }
    }

   public void setMsg(String msg){
        this.msg = msg;
        notifyObservers();
   }

}
