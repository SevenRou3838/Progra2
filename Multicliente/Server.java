import java.net.ServerSocket;

public class Server {
    
    int port;
    ServerSocket server;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedInputStream bis;
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();
    int nClients=0;
    Thread thread;
    ClientHandler client;    
}
public Server(int port){
    this.port=port;
}
public void powerUp(){
    try{
        server=new ServerSocket(port);
        while(!server.isClosed()){
            socket=server.accept();
            bis=new BufferedInputStream(socket.getInputStream());
            dis=new DataInputStream(bis);
            dos=new DataOutputStream(socket.getOutputStream());
            client=new ClientHandler(socket,dis,dos,"client"+nClients);
            thread=new Thread(client);
            thread.start();
            nClients++;
        }        
    }
    catch(IOException e){
        System.out.println("no sirvio");
        e.printlnStackTrace();
    }
}
public static void main(String arg[]){
    Server server=new Server(12000);
    Server.powerUp();

}
