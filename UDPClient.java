import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String[] args)throws IOException
    {
        byte [] senddata = new byte[1024];
        byte [] receivedata = new byte[1024];
        System.out.println("Enter the Message : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IPAddress = InetAddress.getByName("LocalHost");
        DatagramSocket ds = new DatagramSocket();
        String Sentence = br.readLine();
        senddata = Sentence.getBytes();
        DatagramPacket dp = new DatagramPacket(senddata, senddata.length,IPAddress,8888);
        ds.send(dp);
        DatagramPacket dp1 = new DatagramPacket(receivedata, receivedata.length);
        ds.receive(dp1);
        String message = new String(dp1.getData());
        System.out.println("Receive from server" +message);
        ds.close();

    }
}
