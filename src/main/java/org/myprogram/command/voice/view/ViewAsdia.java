package org.myprogram.command.voice.view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ViewAsdia extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Reconocedor reconocedor;
    
	/**
     * Creates new form ViewAsdia
     */
    public ViewAsdia() {
        initComponents();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        jLabelFondo = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelFondo.setIcon(new ImageIcon("C:\\opt\\git-hub-projects\\respaldo\\programing-voice-asdia\\src\\main\\resources\\img\\asdia-fondo.gif"));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
            .addComponent(jLabelFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelFondo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        reconocedor = new Reconocedor();
        reconocedor.iniciarRec();
    }                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      ViewAsdia view = new ViewAsdia();
      view.setVisible(true);
    }
                     
    private JLabel jLabelFondo;
                      
}