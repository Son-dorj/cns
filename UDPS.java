import java.io.*;
import java.net.*;
public class UDPS{
public static void main(String args[])
{
	DatagramSocket skt=null;
	try
	{
		System.out.println("server started");
		skt=new DatagramSocket(6788);
		byte[] buf=new byte[1000];
		while(true)
		{
			DatagramPacket request=new DatagramPacket(buf,buf.length);
			skt.receive(request);
			String[] message = (new String(request.getData())).split(" ");
			byte[] sendmsg=(message[1].toUpperCase()+" from server to client").getBytes();
			DatagramPacket reply=new DatagramPacket(sendmsg,sendmsg.length,request.getAddress(),request.getPort());
			skt.send(reply);
		}
	}
	catch(Exception x)
	{
		System.out.println(x.getMessage());
	}
}
}
