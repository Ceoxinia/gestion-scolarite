package scholarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.colorchooser.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Component;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/* private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	} */

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/marouakhemissi/Documents/logo.png"));
		lblNewLabel.setBounds(274, 64, 524, 468);
		panel.add(lblNewLabel);
		
		username = new RoundJTextField(40);
		username.setBounds(20, 179, 242, 34);
		
		panel.add(username);
		
		password = new RoundJPasswordField(20);
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		password.setBounds(20, 265, 242, 34);
		
		panel.add(password);
		
		JButton loginButt = new JButton("authenticate");
		loginButt.setFont(new Font("Open Sans", Font.BOLD, 13));
		loginButt.setBackground(new Color(255, 250, 250));
		loginButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Username = username.getText();
				String Password = password.getText();
				
				if (Username.equals("directrice") & Password.equals("123"))
					{
					MainMenu MainM = new MainMenu();
					MainM.setVisible(true);
					setVisible(false);
					}
				
				else
					JOptionPane.showMessageDialog(null, "You entered the wrong password or username, please try again!");
			}
		});
		
		loginButt.setForeground(new Color(153, 50, 204));
		loginButt.setBounds(64, 340, 159, 34);
		loginButt.setOpaque(true);
		panel.add(loginButt);
		loginButt.setBorder(new RoundedBorder(30));
	
		
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(221, 160, 221));
		lblNewLabel_1.setBounds(41, 151, 101, 16);

		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(153, 50, 204));
		lblNewLabel_3.setBounds(41, 103, 61, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Scholarity Management");
		lblNewLabel_4.setForeground(new Color(153, 50, 204));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(430, 37, 223, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(221, 160, 221));
		lblNewLabel_2.setBounds(41, 237, 79, 16);
		panel.add(lblNewLabel_2);
	}
}
