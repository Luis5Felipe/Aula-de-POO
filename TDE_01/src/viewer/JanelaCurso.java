package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class JanelaCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel JanelaCurso;
	private JTextField tfCodigo;
	private JTextField tfNome;

	public JanelaCurso() {
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
				
				try {
					Curso curso = new Curso(codigo, nome);
					DaoCurso dao = new DaoCurso();
					dao.adicionar(curso);
					JOptionPane.showMessageDialog(salvar, "Curso Criado!");
					setVisible(false);
				}catch(ModelException e1){
					JOptionPane.showMessageDialog(salvar, e1.getMessage());
				}
			}
		});
		salvar.setBounds(52, 155, 89, 23);
		JanelaCurso.add(salvar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelar.setBounds(251, 155, 89, 23);
		JanelaCurso.add(cancelar);
		this.setVisible(true);

	}

}
