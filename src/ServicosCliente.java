import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServicosCliente {
	Cliente cliente;
	
	public ServicosCliente() throws RemoteException, MalformedURLException, NotBoundException {
	
	cliente = new Cliente();

	
	}
	
	public void ListaArquivos (){
		
			cliente.listarArquivos();
	}

	public void abriArquivo(){
		
		
			cliente.abriAquivo();
		
	}
	

	public void DownloadArquivosHTTP(){
		
		
		cliente.DownloadAquivoHTTP();
	
}
	public void desconectar(){
	
			cliente.desconect();
		
	}

	public void listarFilmes() {
		try{
		cliente.listarFilmes();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resolverEquacao() {
		try{
		cliente.resolverEquacao();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
