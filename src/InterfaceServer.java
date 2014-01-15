import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface InterfaceServer extends Remote {
	
    
    public String conectarMensager(String msg) throws RemoteException;
    public boolean conectarLtcp(String msg,int port) throws RemoteException;
    public boolean UpdateLtcp(int port, float proc, int nc) throws RemoteException;
}