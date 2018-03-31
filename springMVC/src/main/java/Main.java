
public class Main {
	public static void main(String args[]){
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		Thread1 mth1 = new Thread1("A");
		Thread1 mth2 = new Thread1("B");
		mth1.start();
		mth2.start();
		System.out.println(Thread.currentThread().getName() + "主线程运行结束");
	}

}
