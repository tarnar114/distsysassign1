
import java.io.*;
import java.net.*;


/**
 * clientThread
 */
public class clientThread extends Thread{
    private Socket socket;
    private BufferedReader input;
    public clientThread(Socket s) throws IOException{
        this.socket=s;
        this.input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void run() {
        try {
            while(true){
                String res=input.readLine();
                System.out.println(res);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally{
            try {
                input.close();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    
}