import java.net.*;
import java.io.*;
public class UDPC{
public static void main(String args[])
{
	DatagramSocket skt=null;
	try
	{
		skt=new DatagramSocket();
		String msg="SONAM DORJI";
		byte[] b=msg.getBytes();
		InetAddress host = InetAddress.getByName("127.0.0.1");
		int serverSocket=6788;
		DatagramPacket request=new DatagramPacket (b,b.length,host,serverSocket);
		skt.send(request);
		byte[] buf =new byte[1000];
		DatagramPacket reply=new DatagramPacket(buf,buf.length);
		skt.receive(reply);
		System.out.println("client received " +new String(reply.getData()));
		skt.close();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}

