package viewer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		
		JButton btCurso = new JButton("curso");
		btCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaCurso();
			}
		});
		btCurso.setBounds(29, 42, 146, 73);
		contentPane.add(btCurso);
		
		JButton btAluno = new JButton("Aluno");
		btAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaAluno();
			}
		});
		btAluno.setBounds(278, 42, 146, 73);
		contentPane.add(btAluno);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btFechar.setBounds(29, 148, 146, 73);
		contentPane.add(btFechar);
		this.setVisible(true);
	}
}
