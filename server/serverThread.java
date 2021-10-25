
import java.io.*;
import java.net.*;
import java.util.*;

public class serverThread extends Thread{
    private Socket s;
    private ArrayList<serverThread> threads;
    private PrintWriter out;
    public serverThread(Socket s,ArrayList<serverThread> threads){
        this.s=s;
        this.threads=threads;
    }
    @Override
    public void run() {
        try {
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));

            out=new PrintWriter(s.getOutputStream(),true);
            while (true) {
                String outputString=in.readLine();
                if(outputString.equals("exit")) {
                    break;
                }
                printToALlClients(outputString);

            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error occured in main: " + e.getStackTrace());

        }
        
    }
    public void printToALlClients(String outputString) {
        for( serverThread sT: threads) {
            sT.out.println(outputString);
        }

    }
}