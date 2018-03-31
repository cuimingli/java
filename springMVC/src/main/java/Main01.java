
public class Main01 {
	public static void main(String args[]){
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		Thread1 mth1 = new Thread1("A");
		Thread1 mth2 = new Thread1("B");
		mth1.start();
		mth2.start();
		try{
			mth1.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		try{
			mth2.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
	}

}
