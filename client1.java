import java.io.*;
import java.net.*;
class client1
{
public static void main(String args[]) throws IOException
{
byte receive[]=new byte[1024];
InetAddress add=InetAddress.getByName("224.0.0.3");
MulticastSocket mc=new MulticastSocket(8080);
mc.joinGroup(add);
while(true)
{
DatagramPacket dp=new DatagramPacket(receive,receive.length);
mc.receive(dp);
String msg1=new String(receive);
System.out.println("Client1 received the message: "+msg1+'\n');
}
}
}