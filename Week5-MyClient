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
    System.out.println("message1 = " + str);
    dout.write(("AUTH user\n").getBytes());
    dout.flush();
    String str1 = in.readLine();
    System.out.println("message2 = " + str1);
    dout.write(("REDY\n").getBytes());
    dout.flush();
    String str2 = in.readLine();
    System.out.println("message3 = " + str2);
    dout.write(("GETS All\n").getBytes());
    dout.flush();
    String str3 = in.readLine();
    System.out.println("message4 = " + str3);
    dout.write(("OK\n").getBytes());
    dout.flush();
    String str4 = in.readLine();
    System.out.println("message5 = " + str4);
    dout.write(("OK\n").getBytes());
    dout.flush();
    for (int i = 0; i < 184; i++) {
    String str5 = in.readLine();
    System.out.println(str5);
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
    String str28 = in.readLine();
    System.out.println("Message9 = " + str28);
    dout.write(("QUIT\n").getBytes());
    dout.flush();
    dout.close();
    s.close();
    }
}

//this has been hardcoded, ideal solution is to store all Gets All responses in an array and iterate through loop
//only scheduled 1 job, should schedule more
//how does atl work?
