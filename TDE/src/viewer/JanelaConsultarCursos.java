package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.cursos.CtrlManterCursos;
import model.Curso;

public class JanelaConsultarCursos extends JanelaAbstrata<CtrlManterCursos>{
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private Curso[] conjCursos;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarCursos(CtrlManterCursos ctrl, Curso[] conjCursos) {
		super(ctrl);
		setTitle("Departamentos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		btSair.setBounds(335, 227, 89, 23);
		contentPane.add(btSair);

		this.atualizarDados(conjCursos);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirCurso();
			}
		});
		btIncluir.setBounds(10, 227, 89, 23);
		contentPane.add(btIncluir);

		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso d = obterLinhaSelecionada();
				if (d != null) 
					ctrl.iniciarExcluirDepartamento(d);
				else
					notificar("Selecione um Curso para exclusão");
			}
		});
		btExcluir.setBounds(121, 227, 89, 23);
		contentPane.add(btExcluir);

		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso d = obterLinhaSelecionada();
				if (d != null) 
					ctrl.iniciarAlterarDepartamento(d);
				else
					notificar("Selecione um departamento para alteração");
			}
		});
		btAlterar.setBounds(231, 227, 89, 23);
		contentPane.add(btAlterar);

		this.setVisible(true);
	}

	public void atualizarDados(Curso[] conjCursos) {
		this.conjCursos = conjCursos;
		HelperTableModel h = new HelperTableModel(this.conjCursos);
		if (this.tabela == null)
			this.tabela = new JTable(h.getTableModel());
		else
			this.tabela.setModel(h.getTableModel());
		new MeuHeaderListener(this.tabela);
	}

	/**
	 * Retorna qual objeto
	 * 
	 * @return
	 */
	public Curso obterLinhaSelecionada() {
		int numLinhaSelecionada = this.tabela.getSelectedRow();
		if (numLinhaSelecionada != -1)
			return this.conjCursos[numLinhaSelecionada];
		return null;
	}
}
