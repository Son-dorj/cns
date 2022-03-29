import java.net.*;
import java.io.*;
public class TCPS{
public static void main(String args[]) throws Exception
{
	ServerSocket sersock=new ServerSocket(4000);
	System.out.println("Ready for connection");
	Socket sock=sersock.accept();
	System.out.println("successful connection ");
	InputStream istream=sock.getInputStream();
	BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
	String filename=fileRead.readLine();
	BufferedReader contentRead=new BufferedReader(new FileReader(filename));
	OutputStream ostream =sock.getOutputStream();
	PrintWriter pwrite =new PrintWriter(ostream,true);
	String str;
	while((str=contentRead.readLine())!=null)
		pwrite.println(str);
	sock.close();
	fileRead.close();
	contentRead.close();
	pwrite.close();
	sersock.close();
}
}
