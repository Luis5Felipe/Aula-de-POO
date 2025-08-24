package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public JanelaPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btDepartamento = new JButton("Departamento");
		btDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaDepartamento();
			}
		});
		btDepartamento.setBounds(21, 104, 141, 65);
		contentPane.add(btDepartamento);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btFechar.setBounds(255, 104, 147, 65);
		contentPane.add(btFechar);
		this.setVisible(true);
	}

}
