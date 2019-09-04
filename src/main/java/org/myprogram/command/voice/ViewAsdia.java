package org.myprogram.command.voice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.speech.recognition.Recognizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ViewAsdia extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton iniciaPrograma;
	
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

        iniciaPrograma = new JButton();
        jLabelFondo = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        iniciaPrograma.setBackground(new Color(0, 51, 51));
        iniciaPrograma.setForeground(new Color(255,255,255));
        iniciaPrograma.setOpaque (true);
        iniciaPrograma.setFont(new Font("Tahoma", 1, 18));
        iniciaPrograma.setText("Iniciar");
        iniciaPrograma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                iniciaProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(iniciaPrograma, new AbsoluteConstraints(130, 550, 150, -1));

        jLabelFondo.setIcon(new ImageIcon("C:\\opt\\git-hub-projects\\respaldo\\programing-voice-asdia\\src\\main\\resources\\img\\asdia-fondo.gif")); // NOI18N
        getContentPane().add(jLabelFondo, new AbsoluteConstraints(0, 0, 403, 625));

        pack();
	}
 
	private void iniciaProgramaActionPerformed(ActionEvent evt) {                                               
		iniciarReconocimieto();
    }                                              

	
	private void iniciarReconocimieto() {
		programas = new ReconocedorVoz();
		programas.iniciarRec();
	}

}