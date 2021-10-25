
import java.net.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<serverThread> threads=new ArrayList<>();
        try(ServerSocket serversocket=new ServerSocket(5000)) {
            while (true) {
                Socket s=serversocket.accept();
                serverThread serverThread=new serverThread(s,threads);
                
                threads.add(serverThread);
                serverThread.start();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error occured in main: " + e.getStackTrace());

        }
    }
    
}