import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
public class LtcpImpl extends UnicastRemoteObject implements InterfaceLtcp {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int porta;
   static Ltcp ltcp;
	
	

	public LtcpImpl(int pORT, String nome)throws RemoteException {
		porta = pORT;
		ltcp = new Ltcp();
		ltcp.setPort(porta);
		ltcp.setNome(nome);
	}

	@Override
	public int receiveMessage(String msg) throws RemoteException {
		
		return 66;
	}
	
	public boolean conectarCliente() throws RemoteException {
		
		ltcp.setProc((float) (ltcp.getProc() + (Math.random()*10)));
		ltcp.setNclientes(ltcp.getNclientes() + 1);
		System.out.println("cliente conectado em ltcp "+ ltcp.getNome());
		System.out.println("ltcp com procesamento de : "+ltcp.getProc());
		System.out.println("ltcp com numero de clientes de : "+ltcp.getNclientes());
		ltcp.atualizaServidor(ltcp.getPort(),ltcp.getProc(),ltcp.getNclientes());
		return true;
	
	}
	public boolean downloadHTTP() throws RemoteException{
		
	OutputStream out = null;
	HttpURLConnection connection = null;
    InputStream in = null;
    try {
    	String urlDosite = javax.swing.JOptionPane.showInputDialog("digite a url");
	
    	 URL url = new URL(urlDosite); 
		//C:\Users\Thaisa\Downloads
		// deve se digitar C:\\Users\\Thaisa\\Downloads\\nomedoarquivo.extensao
		String localDoFile = javax.swing.JOptionPane.showInputDialog("digite o local aonde deseja armazena e seu nome");
		
		//cria um arquivo vazio para salvar a informaçao
		out = new BufferedOutputStream(new FileOutputStream(localDoFile));
		
		
        connection = (HttpURLConnection) url.openConnection();
       
       // int contentLength = connection.getContentLength();
        
      //pega  byte a byte do arquivo
        in = connection.getInputStream();
 
       
        byte[] buffer = new byte[1024];
        int numero;
        while ((numero = in.read(buffer)) != -1) {
            out.write(buffer, 0, numero);
           
        }
        javax.swing.JOptionPane.showMessageDialog(null,"download realizado com sucesso");
       
    } catch (Exception exception) {
    	javax.swing.JOptionPane.showMessageDialog(null,"Nao foi possivel realizar o download");
        exception.printStackTrace();
        return false;
    }
    
    finally {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException ioe) {
            
        }
    }
    return true;
	
	
	
	}

	@Override
	public boolean abriArquivo() throws RemoteException {
		try {
			String caminho = javax.swing.JOptionPane.showInputDialog("digite o local e nome.extençao do arquivo que deseja abrir");   

			Runtime.getRuntime().exec("explorer"+ caminho);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	

	@Override
	public boolean listaArquivos() throws RemoteException {
		String caminho = javax.swing.JOptionPane.showInputDialog("digite o diretorio a ser listado");   
        StringBuilder sb = new StringBuilder();   
       
        try{
        File raiz = new File(caminho);   
           
        for(File f: raiz.listFiles()) {   
            if(f.isFile()) {   
                System.out.println(f.getName());   
                sb.append(f.getName());   
                sb.append("\n");   
            }   
        }   
        }
        catch (Exception e) {
			return false;
		}
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString()); 

	return true;
		
	}

	public boolean listaArquivosPar(String caminho) throws RemoteException {
		StringBuilder sb = new StringBuilder();   
	       
        try{
        File raiz = new File(caminho);   
           
        for(File f: raiz.listFiles()) {   
            if(f.isFile()) {   
                System.out.println(f.getName());   
                sb.append(f.getName());   
                sb.append("\n");   
            }   
        }   
        }
        catch (Exception e) {
			return false;
		}
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString()); 

	return true;
		
	}

	public boolean downloadHTTP(String urlDosite, String localDoFile) {
		OutputStream out = null;
		HttpURLConnection connection = null;
	    InputStream in = null;
	    try {
	    	//String urlDosite = javax.swing.JOptionPane.showInputDialog("digite a url");
		
	    	 URL url = new URL(urlDosite); 
			//C:\Users\Thaisa\Downloads
			// deve se digitar C:\\Users\\Thaisa\\Downloads\\nomedoarquivo.extensao
			//String localDoFile = javax.swing.JOptionPane.showInputDialog("digite o local aonde deseja armazena e seu nome");
			
			//cria um arquivo vazio para salvar a informaçao
			out = new BufferedOutputStream(new FileOutputStream(localDoFile));
			
			
	        connection = (HttpURLConnection) url.openConnection();
	       
	       // int contentLength = connection.getContentLength();
	        
	      //pega  byte a byte do arquivo
	        in = connection.getInputStream();
	 
	       
	        byte[] buffer = new byte[1024];
	        int numero;
	        while ((numero = in.read(buffer)) != -1) {
	            out.write(buffer, 0, numero);
	           
	        }
	        javax.swing.JOptionPane.showMessageDialog(null,"download realizado com sucesso");
	       
	    } catch (Exception exception) {
	    	javax.swing.JOptionPane.showMessageDialog(null,"Nao foi possivel realizar o download");
	        exception.printStackTrace();
	        return false;
	    }
	    
	    finally {
	        try {
	            if (in != null) {
	                in.close();
	            }
	            if (out != null) {
	                out.close();
	            }
	        } catch (IOException ioe) {
	            
	        }
	    }
	    return true;
		
		
		
	}
	
 
  
}