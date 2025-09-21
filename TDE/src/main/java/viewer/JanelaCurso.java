package viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import controller.CtrlAbstrato;
import controller.cursos.CtrlAbstratoCursos;
import controller.cursos.CtrlExcluirCursos;
import model.Curso;

public class JanelaCurso extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel JanelaCurso;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JPanel contentPane;

	public JanelaCurso(CtrlAbstrato ctrl, Curso curso) {
		
		this(ctrl);
		
		if (curso != null) {
			tfCodigo.setText(String.valueOf(curso.getCodigo()));
			tfNome.setText(curso.getNome());
		}
		
		if(ctrl instanceof CtrlExcluirCursos) {
			tfCodigo.setEnabled(false);
			tfNome.setEnabled(false);
			
			JLabel lbMsg = new JLabel("Deseja excluir esse Departamento?");
			lbMsg.setForeground(new Color(106, 255, 0));
			lbMsg.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbMsg.setBounds(139, 150, 187, 14);
			contentPane.add(lbMsg);
		}
	}
	
	
	public JanelaCurso(CtrlAbstrato ctrl) {
		super(ctrl);
		
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JanelaCurso = new JPanel();
		JanelaCurso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JanelaCurso);
		JanelaCurso.setLayout(null);
		
		JLabel lbCodigo = new JLabel("Codigo :");
		lbCodigo.setBounds(10, 26, 46, 14);
		JanelaCurso.add(lbCodigo);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 111, 46, 14);
		JanelaCurso.add(lblNome);
		
		tfCodigo = new JTextField();
		tfCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		tfCodigo.setBounds(52, 7, 197, 53);
		JanelaCurso.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(52, 97, 197, 43);
		JanelaCurso.add(tfNome);
		tfNome.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				int codigo = Integer.parseInt(tfCodigo.getText());
				CtrlAbstratoCursos ctrl = (CtrlAbstratoCursos) getCtrl();
				ctrl.efetuar(codigo, nome);
			}
		});
		salvar.setBounds(52, 155, 89, 23);
		JanelaCurso.add(salvar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		cancelar.setBounds(251, 155, 89, 23);
		JanelaCurso.add(cancelar);
	}

}
