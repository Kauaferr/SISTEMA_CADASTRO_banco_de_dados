package faminha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TESTE extends JFrame {

	private JPanel contentPane;
	private JTextField nome_pessoa;
	private JTextField email_pessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TESTE frame = new TESTE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TESTE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = email_pessoa.getText();
				String nome = nome_pessoa.getText();
				conexaosql conexao = new conexaosql();
				String sql1 = "INSERT INTO clientes (id, nome, email) " + "VALUES ( default," + "'" + nome + "'" + "," +  "'" + email + "'" + ")";
				int res1 = conexao.executaSQL(sql1);
				JOptionPane.showMessageDialog(null , "CLIENTE: " + nome_pessoa.getText() + " ESTÁ CADASTRADO!!");

			}
		});
		btnNewButton.setBounds(25, 210, 197, 29);
		contentPane.add(btnNewButton);
		
		nome_pessoa = new JTextField();
		nome_pessoa.setBounds(25, 46, 197, 38);
		contentPane.add(nome_pessoa);
		nome_pessoa.setColumns(10);
		
		email_pessoa = new JTextField();
		email_pessoa.setBounds(25, 136, 197, 38);
		contentPane.add(email_pessoa);
		email_pessoa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME DO CLIENTE");
		lblNewLabel.setBounds(25, 24, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E- MAIL CLIENTE");
		lblNewLabel_1.setBounds(25, 115, 98, 14);
		contentPane.add(lblNewLabel_1);
	}
}
