import java.util.concurrent.Callable;

public class AThread implements Callable<String> {
	private int id;
	
	public AThread(int id){
		this.id = id;
	}

	/*public String call() throws Exception {
	    System.out.println("线程:" + id+ "-> 运行-----");
	    try{
	    	Thread.sleep(5000);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    System.out.println("线程:" + id+ "-> 结束.");
		return "返回的字符串" + id;
	}*/

	public String call()throws Exception{
		System.out.println("线程:"+id+ "->运行-------");
		try{
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("线程:" +id+ "->结束.");
		return "返回的字符串"+ id;
	}
}
