package org.myprogram.command.voice.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.RuleGrammar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jrichardsz.poc.jsapi.Lee;
import org.myprogram.command.voice.Programas;

public class Reconocedor extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btn;
	public Image fondo;
	public ImageIcon MicrophoneIcon;
	static Recognizer oreja;
	String palabra;

	public static void main (String[] args){
		Reconocedor Reconocedor = new Reconocedor();
		Reconocedor.setVisible(true);
		
	}
	
	public Reconocedor() {
		
		setLayout(null);
		setSize(135,155);
		setResizable(false);
		setLocation(900,100);
		setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		Inicio();
		//Image microImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/micro.png"));
		
		MicrophoneIcon = new ImageIcon("micro.png");		
		
		Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		btn = new JButton(MicrophoneIcon);
		btn.setBounds(50,50,60,60); 
		btn.setFocusable(false);	//El bot�n no atrae el foco
		btn.setBorder(null);	//Bot�n sin borde
		btn.setBorderPainted(false);	//Bot�n sin borde pintado
		btn.setOpaque(false);	//Fondo del b�ton transparente
		btn.setContentAreaFilled(false);	//Bot�n sin relleno
		btn.setCursor(cursor);	//Establece el cursor para el bot�n
		btn.setFocusPainted(false); //El foco no esta pintado
		btn.addActionListener(this);	//A�ade un ActionListener al bot�n
		add(btn);
	}

	public void Inicio() {
	setVisible(false);
		JOptionPane.showMessageDialog(null, " Prepare su Microfono!! ","Bienvenido",JOptionPane.INFORMATION_MESSAGE);
	return;
	}

	public void iniciarRec() {
  
		JOptionPane.showMessageDialog(null, "Pronuncie Aplicacion a Ejecutar");
		
			try{
			//Se configura al reconocedor para que entienda el idioma ingl�s
			oreja = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
			oreja.allocate();
			Lee.hablar("Hola, cual es tu nombre");
			FileReader grammar1 =new FileReader("Programas.txt"); //ruta donde esta el archivo con las Frases
			RuleGrammar rg = oreja.loadJSGF(grammar1);//Establece la forma en que debe de estar estructurado el archive grammar 
			rg.setEnabled(true); //accesa al archivo
			oreja.addResultListener(new Programas());  //Se hace referencia a la clase de escucha del reconocedor
            
			for(int i=0;i<=23;i++){
				System.out.println("");
			}
			System.out.println("Pronuncia un programa");
			oreja.commitChanges();
			oreja.requestFocus();
			oreja.resume();
		} catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}	
	return;
	}

	public void salir() {	
       	JOptionPane.showMessageDialog(null, "GRACIAS POR PROBAR NUESTRO SISTEMA!!");
		System.exit(0);
	}

	public void actionPerformed(ActionEvent event) { 
		if ( (event.getSource() == btn)) {
			iniciarRec();
		return;
		}
    }
}