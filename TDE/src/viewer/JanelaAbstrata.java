package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.CtrlAbstrato;

public class JanelaAbstrata<T extends CtrlAbstrato> extends JFrame {

	final private T ctrl;
	
	public JanelaAbstrata(T c) {
		this.ctrl = c;
	}
	
	public T getCtrl() {
		return this.ctrl;
	}
	
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public void apresentar() {
		this.setVisible(true);		
	}
	
	public void fechar() {
		this.setVisible(false);
	}
	

}
