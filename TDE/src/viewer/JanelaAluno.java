package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirAluno;
import model.Curso;
import model.dao.DaoCurso;

public class JanelaAluno extends JanelaAbstrata{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private JComboBox<Curso> cbCurso;
	private JButton btCancelar;
	private CtrlIncluirAluno ctrl;
	
	public JanelaAluno(CtrlIncluirAluno c) {
		super(c);
		setTitle("Cadastro de Aluno");
		this.ctrl = c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(10, 25, 56, 14);
		contentPane.add(lbNome);

		tfNome = new JTextField();
		tfNome.setBounds(80, 22, 200, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lbMatricula = new JLabel("Matrícula:");
		lbMatricula.setBounds(10, 65, 82, 14);
		contentPane.add(lbMatricula);

		tfMatricula = new JTextField();
		tfMatricula.setColumns(10);
		tfMatricula.setBounds(80, 62, 127, 20);
		contentPane.add(tfMatricula);

		JLabel lbCurso = new JLabel("Curso:");
		lbCurso.setBounds(10, 105, 82, 14);
		contentPane.add(lbCurso);

		DaoCurso daoCurso = new DaoCurso();
		cbCurso = new JComboBox<>(daoCurso.obterTodos().toArray(new Curso[0]));
		cbCurso.setBounds(80, 101, 200, 22);
		contentPane.add(cbCurso);

		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				int matricula = Integer.parseInt(tfMatricula.getText());
				Curso cursoSelecionado = (Curso) cbCurso.getSelectedItem();
				ctrl.CtrlIncluirNovoAluno(matricula, nome, cursoSelecionado);
			}
		});
		salvar.setBounds(100, 160, 89, 23);
		contentPane.add(salvar);

		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		btCancelar.setBounds(230, 160, 89, 23);
		contentPane.add(btCancelar);

		this.setVisible(true);
	}
	
	public void atualizarCursos(Object[] listaCursos) {
		if(this.cbCurso != null) 
			this.remove(cbCurso);
		cbCurso = new JComboBox(listaCursos);
		cbCurso.setBounds(121, 121, 221, 22);
		contentPane.add(cbCurso);
	}
}