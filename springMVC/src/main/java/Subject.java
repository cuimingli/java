public interface Subject {

    /**
     * 注册一个观察者
     * @param observer
     */
    public void registerObserver(Observer observer);


    /**
     * 移除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    public void notifyObservers();
}
