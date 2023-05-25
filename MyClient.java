
import java.io.*;
import java.net.*;
import java.util.*;

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
    str = in.readLine();
    System.out.println("message1 = " + str); //should be OK
    //get.property user.name
    dout.write(("AUTH " + username + "\n").getBytes());
    dout.flush();
    str = in.readLine();
    System.out.println("message2 = " + str); //should be OK
    dout.write(("REDY\n").getBytes());
    dout.flush();
    str = in.readLine();
    System.out.println("message3 = " + str); //should be JOBN, JCPL or NONE
    String[] tempy = str.split (" ");
    parser = tempy[0];
    String[] jobDetails = str.split(" ");
    
    dout.write(("GETS Capable " + jobDetails[4] + " " + jobDetails[5] + " " + jobDetails[6] + "\n").getBytes());
    dout.flush();
    str = in.readLine();
    System.out.println("message4 = " + str); //should be DATA x xxx
    String[] GETSparser = str.split(" ");
    int nServers = Integer.parseInt(GETSparser[1]);
    
    dout.write(("OK\n").getBytes());
    dout.flush();
    ArrayList<ArrayList<String>> serverList = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < nServers; i++) {
      str = in.readLine();
      String[] serverDetails = str.split(" ");
      String serverName = serverDetails[0];
      String serverID = serverDetails[1];
      String nCores = serverDetails[4];
      ArrayList<String> arr = new ArrayList<>();
      arr.add(serverName);
      arr.add(serverID);
      arr.add(nCores);
      serverList.add(arr);
      System.out.println("message5 = "+ str);
    }
    
    int[] arrCores = new int[serverList.size()];
    for(int i=0; i<serverList.size(); i++) {
      arrCores[i] = Integer.parseInt(serverList.get(i).get(2));
      Arrays.sort(arrCores);
    }
    
    ArrayList<Integer> tempList = new ArrayList<Integer>();
    for(int i = 0; i<serverList.size();i++) {
      int largest = arrCores[arrCores.length-1];
      if(Integer.parseInt(serverList.get(i).get(2)) == largest) {
      tempList.add(i);
      }
    }
    
    dout.write(("OK\n").getBytes());
    dout.flush();
    str = in.readLine();
    System.out.println("message6 = " + str);
    
    int count = 0;
    int serverTab = 1;
    
    while(!(parser.equals("NONE"))) {
      if (count == 0) {
        dout.write(("SCHD " + jobDetails[2] + " " + serverList.get(tempList.get(0)).get(0) + " " + serverList.get(tempList.get(0)).get(1) + "\n").getBytes());
        str = in.readLine();
        System.out.println("Job details: " + str);
      } else {
        dout.write(("REDY\n").getBytes());
        dout.flush();
        str = in.readLine();
        jobDetails = str.split(" ");
        parser = jobDetails[0];
        if(parser.equals("JOBN")) {
          System.out.println("message = " + str);
          if(tempList.size()==1) {
            dout.write(("SCHD " + jobDetails[2] + " " + serverList.get(tempList.get(0)).get(0) + " " + serverList.get(tempList.get(0)).get(1) + "\n").getBytes());
            str = in.readLine();
            System.out.println("JOb deets: " + str);
            } else {
              dout.write(("SCHD " + jobDetails[2] + " " + serverList.get(tempList.get(serverTab)).get(0) + " " + serverList.get(tempList.get(serverTab)).get(1) + "\n").getBytes());
              str = in.readLine();
              System.out.println("JOb deets: " + str);
              serverTab++;
              if(serverTab==tempList.size()) serverTab = 0;
            }
        }
      }
      
      count++;
    }
    
    /*
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
    
    */
    
    dout.write(("QUIT\n").getBytes());
    dout.flush();
    str = in.readLine();
    dis.close();
    dout.close();
    s.close();
    }
}
