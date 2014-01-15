

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class GUI extends JFrame {

	JPanel painelTela1;
	JPanel painelTela11;
	DefaultComboBoxModel combo;
	JComboBox comboOpcao;
	JButton botao1 ;
	ServicosCliente sc;

	/**
	 * Launch the application.
	 */



	public GUI() {
		super("Gerenciador de transferencia de arquivos");

		this.setSize(300,300);
		this.setLocation(450, 120);
		this.inicializarComponentes();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		try{
		sc = new ServicosCliente();
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void inicializarComponentes(){
		painelTela1 = new JPanel();
		ButtonListener ouvinte = new ButtonListener();

		painelTela1.setLayout(new GridLayout(4,4,20,30));

		JLabel label1 = new JLabel("O que você deseja fazer?");
		label1.isForegroundSet();
		painelTela1.add(label1);

		combo = new DefaultComboBoxModel();
		comboOpcao = new JComboBox(combo);
		combo.addElement(null);
		combo.addElement("Listar arquivos");
		combo.addElement("abri arquivo");
		combo.addElement("Download de um arquivo");
		combo.addElement("Desconectar");
		combo.addElement("lista de filmes");
		combo.addElement("resolver uma equaçao");
		
		painelTela1.add(comboOpcao);
		botao1 = new JButton("Confirma");
		botao1.addActionListener(ouvinte);
		painelTela1.add(botao1);
		Container contentPane = this.getContentPane();
		contentPane.add(painelTela1);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object obj = e.getSource();

			if(obj == botao1){
				String a =(String) combo.getSelectedItem();
				if(a.equalsIgnoreCase("Listar arquivos")){

					sc.ListaArquivos();

				}   

				if(a.equalsIgnoreCase("Download de um arquivo")){
					sc.DownloadArquivosHTTP();

				}
				if(a.equalsIgnoreCase("Desconectar")){

					sc.desconectar();

				}
				if(a.equalsIgnoreCase("abri arquivo")){

					sc.abriArquivo();

				}
				if(a.equalsIgnoreCase("lista de filmes")){

					sc.listarFilmes();

				}
				if(a.equalsIgnoreCase("resolver uma equaçao")){

					sc.resolverEquacao();

				}



			}


		}

	}
	public static void main(String[] args) {

		try {
			GUI frame = new GUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}


