package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reverse extends Remote {
  String revers(String str) throws RemoteException;
}
