import java.io.*;
import java.net.*;
import java.util*;

public class MyClient {
  public static void main(String[] args) throws Exception {
    Socket s = new Socket("localhost", 50000);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    BufferedReader in = new BufferedReader (new InputStreamReader(s.getInputStream()));
    String username = System.getProperty("user.name");
    String str = "";
    String parser = "";
    
    dout.write(("HELO\n").getBytes());
    dout.flush();
    str = in.readLine(); //should be OK
    //System.out.println("message1 = " + str);
    dout.write(("AUTH " + username + "\n").getBytes());
    dout.flush();
    str = in.readLine(); // should be OK
    //System.out.println("message2 = " + str1);
    dout.write(("REDY\n").getBytes());
    dout.flush();
    str = in.readLine(); // should be JOBN/JCPL/NONE
   // System.out.println("message3 = " + str2);
    //String[] tempy = str.split (" ");
    //String job info??
    dout.write(("GETS All\n").getBytes());
    dout.flush();
    str = in.readLine();
    //System.out.println("message4 = " + str3);
    dout.write(("OK\n").getBytes());
    dout.flush();
    str = in.readLine();
    //System.out.println("message5 = " + str4);
    dout.write(("OK\n").getBytes());
    dout.flush();
    for (int i = 0; i < 184; i++) {
      str = in.readLine();
    //System.out.println(str5);
    }
    dout.write(("SCHD 0 4xlarge 1\n").getBytes());
    dout.flush();
    dout.write(("SCHD 1 4xlarge 2\n").getBytes());
    dout.flush();
    dout.write(("SCHD 2 4xlarge 3\n").getBytes());
    dout.flush();
    dout.write(("SCHD 3 4xlarge 4\n").getBytes());
    dout.flush();
    dout.write(("SCHD 4 4xlarge 5\n").getBytes());
    dout.flush();
    dout.write(("SCHD 5 4xlarge 6\n").getBytes());
    dout.flush();
    str = in.readLine();
    //System.out.println("Message9 = " + str28);
    dout.write(("QUIT\n").getBytes());
    dout.flush();
    dout.close();
    s.close();
    }
}
