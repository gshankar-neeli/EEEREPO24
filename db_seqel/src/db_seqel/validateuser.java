package db_seqel;
//hhsxxavw
//jhwjksbkjwbqjk

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class validateuser {

	private JFrame frame;
	private JTextField tb1;
	private final JPasswordField p1 = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					validateuser window = new validateuser();
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
	public validateuser() {
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
		
		JLabel lblNewLabel = new JLabel("LOGIN USER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(125, 11, 231, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(80, 108, 23, -5);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel rgth = new JLabel("NAME");
		rgth.setFont(new Font("Tahoma", Font.BOLD, 15));
		rgth.setBounds(99, 50, 46, 14);
		frame.getContentPane().add(rgth);
		
		JLabel fgh = new JLabel("PASSWORD");
		fgh.setFont(new Font("Tahoma", Font.BOLD, 15));
		fgh.setBounds(80, 132, 89, 14);
		frame.getContentPane().add(fgh);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String pwd=p1.getText();
				try {
					Connection con=DriverManager.getConnection
							("jdbc:mysql://localhost:3306/mydb","root","mrec");
					PreparedStatement stn=con.prepareStatement("select name,pwd from users where name=? and pwd=?");
				
					stn.setString(1,name);
					stn.setString(2,pwd);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton,"you are in");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton,"oops try again");
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(168, 190, 131, 23);
		frame.getContentPane().add(btnNewButton);
		
		tb1 = new JTextField();
		tb1.setToolTipText("PLEASE ENTER UR NAME\r\n");
		tb1.setBounds(192, 49, 107, 31);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		p1.setToolTipText("PLEASE ENTER THE PASSWORD");
		p1.setBounds(192, 126, 107, 31);
		frame.getContentPane().add(p1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\on line lab\\Desktop\\2021-login-form.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBackground(new Color(128, 128, 0));
		lblNewLabel_4.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
