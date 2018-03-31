import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]){
	/*	try{
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//记录客户端的数量
			int count = 0;
     		System.out.println("***服务器即将启动,等待客户端的链接***");	
		  while(true){
			  socket = serverSocket.accept();
			  //创建新的线程
			  ServerThread serverThread = new ServerThread(socket);
			  //启动线程
			  serverThread.start();
			  count ++;
			  System.out.println("客户端的数量:" + count);
		  }
			

		}catch(IOException e){
			e.printStackTrace();
		}*/
	   try{
	   	  ServerSocket serverSocket  = new ServerSocket(8888);
	   	  Socket socket = null;
	   	  //记录客户端的数量
		   int count = 0;
		   while(true){
		   	socket = serverSocket.accept();
		   	//创建了新线程
			   ServerThread serverThread = new ServerThread(socket);
			   //启动线程
			   serverThread.start();
			   count ++;
			   System.out.println("客户端的数量:" + count);
		   }


	   }catch (IOException e){
	   	e.printStackTrace();
	   }
		
	}

}
