package msasuure;
//system to repo
import java.awt.EventQueue;
//raghu in the code
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class loginpage {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(132, 21, 83, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(34, 84, 81, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 136, 96, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(167, 85, 96, 19);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				String password=t2.getPassword();
				try
				{
					connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					preparedStatement st=con.prepareStatement("select name,password from login where name=? and password=?");
							st.setString(1,name);
							st.setString(2,password);
							ResultSet rs=st.executeQuery();
							if(rs.next())
							{
								JOptionPane.showMessageDialog(btnNewButton, "valid use");
								
							}
							else
							{
								JOptionPane.showMessageDialog(btnNewButton, "Invalid use");
							}
							
				}
				catch(SQLException e1)
				{
					e1.print(StrackTrace);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(144, 197, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		t2 = new JPasswordField();
		t2.setBounds(167, 133, 96, 19);
		frame.getContentPane().add(t2);
	}
}
