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

import model.Departamento;
import model.ModelException;
import model.dao.DaoDepartamento;

public class JanelaDepartamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSigla;
	private JTextField tfNome;

	
	public JanelaDepartamento() {
		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Siglas = new JLabel("Sigla :");
		Siglas.setBounds(10, 41, 38, 33);
		contentPane.add(Siglas);

		tfSigla = new JTextField();
		tfSigla.setBounds(48, 44, 150, 26);
		contentPane.add(tfSigla);
		tfSigla.setColumns(Departamento.TAMANHO_SIGLA);

		JLabel Nome = new JLabel("Nome :");
		Nome.setBounds(10, 105, 46, 14);
		contentPane.add(Nome);

		tfNome = new JTextField();
		tfNome.setBounds(48, 99, 302, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btOK = new JButton("Ok");
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sigla = tfSigla.getText();
				String nome = tfNome.getName();
				try {
					Departamento novo = new Departamento(sigla, nome);
					JOptionPane.showMessageDialog(btOK, "Departamento Criado ");
					DaoDepartamento dao = new DaoDepartamento();
					dao.adicionar(novo);
					setVisible(false);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(btOK, e1.getMessage());
				}

			}
		});
		btOK.setBounds(48, 161, 89, 23);
		contentPane.add(btOK);

		JButton btOCancelar = new JButton("Cancelar");
		btOCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btOCancelar.setBounds(316, 161, 89, 23);
		contentPane.add(btOCancelar);
		this.setVisible(true);
	}
}
