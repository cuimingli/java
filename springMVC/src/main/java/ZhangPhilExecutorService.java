import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ZhangPhilExecutorService {
	private final int NUMBER = 3;
	
	public ZhangPhilExecutorService(){
		ExecutorService pool = Executors.newFixedThreadPool(NUMBER);
		ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
		for(int i = 0;i<10;i++){
			AThread t = new AThread(i);
			Future<String> f = pool.submit(t);
			futures.add(f);
		}
		System.out.println("获取结果中.....");
		for(Future<String> f : futures){
			try{
				System.out.println(f.get());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("得到结果.");
		//关闭线程池
		pool.shutdown();
	}

}
