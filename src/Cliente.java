import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.net.MalformedURLException;
 
public class Cliente {
	static InterfaceLtcp msg2;
	Registry registry;
	public Cliente() throws RemoteException, MalformedURLException, NotBoundException {
	        //cria uma referencia local para o registro remoto
			registry = LocateRegistry.getRegistry("localhost");
	        InterfaceServer msg = (InterfaceServer) registry.lookup("server");
	       
	        System.out.println(msg.conectarMensager("CONECTAR CLIENTE"));
	        String nomeLtcp = msg.conectarMensager("CONECTAR CLIENTE");
	      
	      
	        msg2 = (InterfaceLtcp) registry.lookup("ltcp_"+nomeLtcp);
	        msg2.conectarCliente();
	      
	        
	    }
	public void listarArquivos() {
		try{
			msg2.listaArquivos();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void desconect() {
		// TODO Auto-generated method stub
		
	}
	public void DownloadAquivoHTTP() {
		try{
		msg2.downloadHTTP();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void abriAquivo() {
		try{
		msg2.abriArquivo();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listarFilmes() {
		try{
		//	InterfaceServer smsg = (InterfaceServer) registry.lookup("server");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void resolverEquacao() {
		try{
			//Calculadora smsg = (InterfaceServer) registry.lookup("server");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	 
	
}