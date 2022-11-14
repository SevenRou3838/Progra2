import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

class Server{
    int port;
    ServerSocket server;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedInputStream bis;
    static Vector<ClientHandler> clients=new Vector<ClientHandler>();
    int nClients=0;
    Thread thread;
    ClientHandler client;

    public Server(int port){
        this.port=port;
    }

    public void powerUp(){
        try {
            server=new ServerSocket(port);
            while(!server.isClosed()){
                socket=server.accept();
                bis=new BufferedInputStream(socket.getInputStream());
                dis=new DataInputStream(bis);
                dos=new DataOutputStream(socket.getOutputStream());
                client=new ClientHandler(socket, dis, dos,"client"+nClients);
                thread=new Thread(client);
                clients.add(client);
                thread.start();
                nClients++;
            }
        } catch (IOException e) {
            System.out.println("no sirvio");
            e.printStackTrace();
        }
    }
    public static void main(String arg[]){
        Server server=new Server(12000);
        server.powerUp();
    }

}

class ClientHandler implements Runnable{
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String msg;
    String name;
    BufferedInputStream bis;
    public ClientHandler(Socket socket,DataInputStream dis,DataOutputStream dos,String name){
        this.socket=socket;
        this.dis=dis;
        this.dos=dos;
        this.name=name;
    }

    @Override
    public void run() {
        while(socket.isConnected()){
            try {
                bis=new BufferedInputStream(socket.getInputStream());
                dis=new DataInputStream(bis);
                while(socket.isConnected()){
                    msg=dis.readUTF();
                    StringTokenizer st=new StringTokenizer(msg,"#");
                    String content=st.nextToken();
                    String name=st.nextToken();
                    System.out.println(name);
                    System.out.println(content);
                    for(int i=0;i<Server.clients.size();i++){
                        ClientHandler ch=Server.clients.get(i);
                        if(ch.name.equals(name)){
                            String txt="from: "+name+" msg: "+content;
                            System.out.println(txt);
                            dos.writeUTF(txt);
                        }
                    }
                }
            } catch (IOException e) {
                if(socket.isConnected()){
                    try {
                        socket.close();
                    } catch (IOException e1) {
                        
                        e1.printStackTrace();
                    }
                }
                e.printStackTrace();
            }

        }
    }
}