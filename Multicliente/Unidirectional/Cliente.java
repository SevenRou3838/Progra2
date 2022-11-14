import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client{
    String ipServer;
    int port;
    DataInputStream dis;
    DataOutputStream dos;
    Socket socket;
    Thread listenerServer;
    Thread sending;
    Scanner scanner;

    public Client(String ipServer,int port){
        this.ipServer=ipServer;
        this.port=port;
        scanner=new Scanner(System.in);
    }
    public static void main(String args[]){
        Client client=new Client("127.0.0.1", 12000);
        client.initSocket();
    }
    public void initSocket(){
        try {
            socket=new Socket(ipServer,port);
            dis=new DataInputStream(socket.getInputStream());
            dos=new DataOutputStream(socket.getOutputStream());
            listenerServer=new Thread(new Runnable(){
                @Override
                public void run(){
                    String msg;
                    while(true){
                        try {
                           msg= dis.readUTF();
                            System.out.println(msg);
                        
                        } catch (IOException e) {
                        
                          e.printStackTrace();
                        }
                    } 
                }
            });
            sending=new Thread(new Runnable(){
                @Override
                public void run(){
                   
                }
            });
            listenerServer.start();
            while(true){
                String msg;
                while(socket.isConnected()){
                    
                    msg= scanner.nextLine();
                    
                    try {
                       dos.writeUTF(msg);
                       if(msg.equals("out")){
                        break;
                    }
                 } catch (IOException e) {
                    
                        e.printStackTrace();
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        } catch (UnknownHostException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Server down");
            e.printStackTrace();
        }
    } 
}