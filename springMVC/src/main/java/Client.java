import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
 public static void main(String args[]){
	try{
		//创建客户端socket,指定服务器地址和端口
		Socket socket = new Socket("localhost",8888);
		//2.获取输出流，向服务器端发送信息
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("用户名:admin;密码:456");
		pw.flush();
		socket.shutdownOutput();//关闭输出流
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("我是客户端,服务器说:" + info);
		}
		br.close();
		is.close();
		socket.close();
		os.close();
		pw.close();
	}catch(UnknownHostException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	 
 }
	
}
