
public class MyThreadPrinter3 implements Runnable{
	
	private String name;
	
	private Object prev;
	
	private Object self;
	
	

	public MyThreadPrinter3() {
		super();
	}



	public MyThreadPrinter3(String name, Object prev, Object self) {
		super();
		this.name = name;
		this.prev = prev;
		this.self = self;
	}



	public void run() {
		int count = 10;
		while(count > 0){
			synchronized(prev){
				synchronized(self){
					System.out.println(name);
					count--;
					self.notify();
				}
				try{
					prev.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
	}

}
