
import java.io.*;
import java.net.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        try (Socket socket=new Socket("localhost",5000)){
            //read input from server
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);

            Scanner scanner=new Scanner(System.in);
            String UserIn;
            String res;
            String clientName="empty";
            clientThread clientThread=new clientThread(socket);
            new Thread(clientThread).start();
            do{
                if (clientName.equals("empty")) {
                    System.out.println("enter name");
                    UserIn=scanner.nextLine();
                    clientName=UserIn;
                    output.println(UserIn);
                    if (UserIn.equals("exit")) {
                        break;
                    }
                } else {
                    String message = ( "(" + clientName + ")" + " message : " );
                    System.out.println(message);
                    UserIn=scanner.nextLine();
                    output.println(message+" "+UserIn);
                    if (UserIn.equals("exit")) {
                        break;
                    }
                }
            }while(!UserIn.equals("exit"));
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}