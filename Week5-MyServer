import java.io.*;
import java.net.*;

public class MyServer {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(5000);
    Socket s = ss.accept();
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    BufferedReader in = new BufferedReader (new InputStreamReader(s.getInputStream()));
  

    String str = in.readLine();
    System.out.println("message = " + str);
    dout.write(("OK\n").getBytes());
    dout.flush();
    String str1 = in.readLine();
    System.out.println("message = " + str1);
    dout.write(("OK\n").getBytes());
    dout.flush();
    String str2 = in.readLine();
    System.out.println("message = " + str2);
    dout.write(("OK\n").getBytes());
    dout.flush();
    String str3 = in.readLine();
    System.out.println("message = " + str3);
    dout.write(("OK\n").getBytes());
    dout.flush();
    dout.close();
    s.close();
    ss.close();
    }
}
