import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
 
public class RMIServer {
	public static final int PORT = 1099;
    public static void main(String[] args) throws RemoteException, MalformedURLException {
       LocateRegistry.createRegistry(PORT);
        InterfaceServer server = new ServerImpl();
        Naming.rebind("server", server);
        System.out.println("server.Servidor criado ");
    }

}