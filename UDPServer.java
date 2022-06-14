import java.io.*;
import java.net.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPServer {
    public static void main(String[] args) throws IOException 
    {
        byte [] senddata = new byte[1024];
        byte [] receivedata = new byte[1024];
        System.out.println("Waiting for connection");
        while (true)
        {
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(receivedata, receivedata.length);
            ds.receive(dp);
            String message = new String(dp.getData());
            InetAddress IPAddress = dp.getAddress();
            int port = dp.getPort();
            String capitalsentence = message.toUpperCase()+'\n';
            senddata = capitalsentence.getBytes();
            DatagramPacket dp1 = new DatagramPacket(senddata, senddata.length,IPAddress,port);
            ds.send(dp1);
            System.out.println("Receive from client :"+message);
            ds.close();
       
        }

    }
}
