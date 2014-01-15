import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceLtcp extends Remote {
		
		public int receiveMessage(String msg) throws RemoteException;
		public boolean conectarCliente() throws RemoteException;
		
		public boolean downloadHTTP() throws RemoteException;
		public boolean abriArquivo() throws RemoteException;
		public boolean listaArquivos() throws RemoteException;
		public boolean listaArquivosPar(String caminho) throws RemoteException;
		public boolean downloadHTTP(String urlDosite,String localDoFile) throws RemoteException;
}

