public class MyClient {
  public static void main(String[] args) throws Exception {

    Socket s = new Socket("localhost", 50000);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    BufferedReader in = new BufferedReader (new InputStreamReader(s.getInputStream()));

    //declarations and initialisations
    String username = System.getProperty("user.name"); //will be used for AUTH command
    String str = ""; //throughout code for receiving commands from server
    String parser = ""; //splits string into relevant sections to be used for identifying largest server
    int count = 0; //will be used for iterating through jobs??

    dout.write(("HELO\n").getBytes()); //starts handshake protocol
    dout.flush();
    str = in.readLine(); //should be OK from server
    //System.out.println("message1 = " + str);
    dout.write(("AUTH " + username + "\n").getBytes()); //authentication step
    dout.flush();
    str = in.readLine(); // should be OK from server
    //System.out.println("message2 = " + str1);
    dout.write(("REDY\n").getBytes()); //initiates job scheduling
    dout.flush();
    str = in.readLine(); // should be JOBN/JCPL/NONE
    //JOBN provides scheduling information (used first time)
    //JCPL is used to check what the status of the scheduling is
    //NONE is used to indicate that there are no jobs, will initiate termination of program

    // System.out.println("message3 = " + str2);

    String[] temp = str.split (" "); //splits information recived from server into array storing information temporarily until 
    //String job info?? 


    dout.write(("GETS All\n").getBytes());
    dout.flush();
    str = in.readLine();
    dout.write(("QUIT\n").getBytes());
    dout.flush();
    dout.close();

