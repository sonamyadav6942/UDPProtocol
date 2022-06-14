import java.net.*;
import java.io.*;
class Mc_Server
{
public static void main(String args[]) throws IOException
{
System.out.println("Enter message: ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String msg=br.readLine();
DatagramSocket ds=new DatagramSocket();
InetAddress add=InetAddress.getByName("224.0.0.3");
DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,add,8080);
ds.send(dp);
System.out.println("Send to client: "+msg+'\n');
}
}