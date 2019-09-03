package org.myprogram.command.voice;

import java.awt.Image;
import java.io.FileReader;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.RuleGrammar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.jrichardsz.poc.jsapi.Lee;

public class ViewAsdia extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btn;
	public Image fondo;
	public ImageIcon MicrophoneIcon;
	static Recognizer oreja;
	String palabra;
	private JLabel jLabelFondo;
	public Thread hiloEscucha;
	private ReconocedorVoz programas;

	public ViewAsdia(ReconocedorVoz programas){
		this.programas = programas;
	}
	
	public ViewAsdia() {
		this.initComponents();
		this.setLocationRelativeTo(this);
		this.setVisible(true);
	}

	public void initComponents() {
		jLabelFondo = new JLabel();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabelFondo.setIcon(new ImageIcon(
				"C:\\opt\\git-hub-projects\\respaldo\\programing-voice-asdia\\src\\main\\resources\\img\\asdia-fondo.gif"));
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(jLabelFondo));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup().addComponent(jLabelFondo).addGap(0, 0, Short.MAX_VALUE)));
		pack();
	}
 
	
	private void iniciarReconocimieto() {
		hiloEscucha = new Thread(programas = new ReconocedorVoz(this));
		hiloEscucha.start();
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}