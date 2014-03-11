import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;



public class Ltcp {
	public static int PORT;
	public static String nome;

	private  int nclientes;
	private  float proc;
	static InterfaceServer msg;
	
	public Ltcp(){
		
		nclientes =0;
		proc = 0;
		
		
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        PORT = Integer.parseInt(args[0]);
        System.out.println(PORT);
        nome = args[1];
        System.out.println(nome);
		//cria e exporta uma instancia de registro
        LocateRegistry.createRegistry(PORT);
        InterfaceLtcp ltcp = new LtcpImpl(PORT, nome);
        Naming.rebind("ltcp_"+nome, ltcp);
        System.out.println("ltcp_"+nome+".ltcp criado  ");
       
        msg =(InterfaceServer) java.rmi.Naming.lookup("server");
       
        msg.conectarLtcp(nome, PORT);
    
       
       
        
    }
	public void atualizaServidor(int port, float proc, int nc){
		
		try{
			
		boolean foi =msg.UpdateLtcp(port,proc,nc);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int getNclientes() {
		return nclientes;
	}
	public void setNclientes(int nclientes) {
		this.nclientes = nclientes;
	}
	public float getProc() {
		return proc;
	}
	public void setProc(float proc) {
		this.proc = proc;
	}
	public int getPort() {
		return PORT;
	}
	public void setPort(int port) {
		PORT = port;
	}
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=nome;
		
		
	}
	
}