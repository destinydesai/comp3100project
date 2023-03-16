import java.io.*;
import java.net.*;

public class MyClient {
  public static void main(String[] args) throws Exception {
    Socket s = new Socket("localhost", 50000);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    BufferedReader in = new BufferedReader (new InputStreamReader(s.getInputStream()));
    
    dout.write(("HELO\n").getBytes());
    dout.flush();
    String str = in.readLine();
    System.out.println("message = " + str);
    dout.write(("AUTH user\n").getBytes());
    dout.flush();
    String str1 = in.readLine();
    System.out.println("message = " + str1);
    dout.write(("REDY\n").getBytes());
    dout.flush();
    String str2 = in.readLine();
    System.out.println("message = " + str2);
    dout.write(("QUIT\n").getBytes());
    dout.flush();
    dout.close();
    s.close();
    }
}
