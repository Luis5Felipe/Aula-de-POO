package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;

public class JanelaPrincipal extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CtrlPrograma ctrl;

	public JanelaPrincipal(CtrlPrograma c) {
		super(c);
		setTitle("Menu Principal");
		this.ctrl = c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCurso = new JButton("curso");
		btCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirCurso();
			}
		});
		btCurso.setBounds(29, 42, 146, 73);
		contentPane.add(btCurso);
		
		JButton btAluno = new JButton("Aluno");
		btAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirAluno();
			}
		});
		btAluno.setBounds(278, 42, 146, 73);
		contentPane.add(btAluno);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		btFechar.setBounds(29, 148, 146, 73);
		contentPane.add(btFechar);
	}
}
