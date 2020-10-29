package RMI;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//Remote Method Invocation
public class Server {
  public static final String UNIQ_BINDING_NAME = "server.reverse";

  public static void main(String[] args) throws IOException, AlreadyBoundException, InterruptedException {
    final Reverse service = new ReverseImpl();
    final Registry registry = LocateRegistry.createRegistry(2099);
    Remote stub = UnicastRemoteObject.exportObject(service, 0);
    registry.bind(UNIQ_BINDING_NAME, stub);
    Thread.sleep(Integer.MAX_VALUE);
    InputStream in = new InputStream() {
      @Override
      public int read() throws IOException {
        return 0;
      }
    };
    if(in.available() > 0) {

    }
  }
}
