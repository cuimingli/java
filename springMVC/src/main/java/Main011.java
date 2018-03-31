public class Main011 {
    public static void main(String[] str) {
        // 用户信息
        User user = new User();
        user.setCardCode("510522177709096836");
        user.setSex("男");
        user.setName("无名氏");
        user.setHomeAddress("地球村第七号店铺");

        // 具体代理
        RealProxy realClient = new RealProxy();
        realClient.setUser(user);

        // 代理
        Proxy proxy = new Proxy(realClient);
        proxy.buyTicket();
    }
}
