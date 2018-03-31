public class Proxy implements IProxy {
    private RealProxy realClient;

    public Proxy(RealProxy realClient) {
        this.realClient = realClient;
    }


    public void buyTicket() {
        realClient.buyTicket();
    }
}
