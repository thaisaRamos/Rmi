import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;



public class ServerImpl extends UnicastRemoteObject implements InterfaceServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  Comparator<Ltcp> comparador = new ComparadorLtsp();
	public  PriorityBlockingQueue<Ltcp> Q = new PriorityBlockingQueue<Ltcp>(6, comparador);
	
	public ServerImpl() throws RemoteException {
    }
 
    public String greeting() throws RemoteException {
        return "greeting";
    }

	@Override
	public String conectarMensager(String msg) throws RemoteException {
		String primeiro = Q.peek().getNome();
		return primeiro;
		
	}

	@Override
	public boolean conectarLtcp(String msg,int port) throws RemoteException {
		
		Ltcp ltcp = new Ltcp();
		ltcp.setPort(port);
		ltcp.setNome(msg);
		ltcp.setProc(0);
		ltcp.setNclientes(0);
		Q.add(ltcp);
		
		return true;
	}

	@Override
	public boolean UpdateLtcp(int port, float proc, int nClient) throws RemoteException {
		
				
		for (Iterator<Ltcp> iterator=Q.iterator();iterator.hasNext();){
			
			Ltcp ltcpU = iterator.next();
			
			if (ltcpU.getPort() == port){
					iterator.remove();
					ltcpU.setProc(proc);
					ltcpU.setNclientes(nClient);	
					Q.add(ltcpU);
				}
			
			}
		return false;
	}
	
	
    
}