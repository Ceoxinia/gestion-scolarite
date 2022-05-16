package scholarm;

import java.awt.BorderLayout;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import java.awt.Window.*;

public class Student {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField matricule;
	private JTextField firstname;
	private JTextField group;
	private JTextField codes;
	private JTextField lastname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/scholar_m", "root","mimi2001");
        }
        catch (ClassNotFoundException ex)
        {
          ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
 
    }
	 public void table_load()
	    {
	     try
	     {
	    pst = con.prepareStatement("select * from student");
	    rs = pst.executeQuery();
	}
	     catch (SQLException e)
	     {
	     e.printStackTrace();
	  }
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 800, 600);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 102, 600);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton studentB = new JButton("Students");
		studentB.setForeground(new Color(255, 255, 255));
		
		studentB.setBackground(new Color(204, 153, 204));
		studentB.setBounds(0, 0, 102, 96);
		studentB.setOpaque(true);
		studentB.setBorderPainted(false);
		panel_2.add(studentB);
		
		JButton UnitB = new JButton("Units");
		UnitB.setForeground(new Color(255, 255, 255));
		UnitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Units Junit = new Units();
				Junit.setVisible(true);
				frame.setVisible(false);
			}
		});
		UnitB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				UnitB.setBackground(new Color(204, 153, 204));
				UnitB.setOpaque(true);
				UnitB.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				UnitB.setBackground(new Color(153, 102, 153));
				UnitB.setOpaque(true);
				UnitB.setBorderPainted(false);
			}
		});
		UnitB.setBackground(new Color(153, 102, 153));
		UnitB.setOpaque(true);
		UnitB.setBorderPainted(false);
		UnitB.setBounds(0, 95, 102, 96);
		panel_2.add(UnitB);
		
		JButton examB = new JButton("Exam");
		examB.setForeground(new Color(255, 255, 255));
		examB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exam Jexam = new Exam();
				Jexam.setVisible(true);
				frame.setVisible(false);
			}
		});
		examB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				examB.setBackground(new Color(204, 153, 204));
				examB.setOpaque(true);
				examB.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				examB.setBackground(new Color(153, 102, 153));
				examB.setOpaque(true);
				examB.setBorderPainted(false);
			}
		});
		examB.setBackground(new Color(153, 102, 153));
		examB.setOpaque(true);
		examB.setBorderPainted(false);
		examB.setBounds(0, 190, 102, 96);
		panel_2.add(examB);
		
		JButton certB = new JButton("Certificate");
		certB.setForeground(new Color(255, 255, 255));
		certB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cert Jcert = new Cert();
				Jcert.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		certB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		certB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				certB.setBackground(new Color(204, 153, 204));
				certB.setOpaque(true);
				certB.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				certB.setBackground(new Color(153, 102, 153));
				certB.setOpaque(true);
				certB.setBorderPainted(false);
			}
		});
		certB.setBackground(new Color(153, 102, 153));
		certB.setOpaque(true);
		certB.setBorderPainted(false);
		certB.setBounds(0, 286, 102, 96);
		panel_2.add(certB);
		
		JButton List = new JButton("List");
		List.setForeground(new Color(255, 255, 255));
		List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list myslist =new list();
				myslist.setVisible(true);
				frame.setVisible(false);
			}
		});
		List.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		List.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				List.setBackground(new Color(204, 153, 204));
				List.setOpaque(true);
				List.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				List.setBackground(new Color(153, 102, 153));
				List.setOpaque(true);
				List.setBorderPainted(false);
			}
		});
		List.setBackground(new Color(153, 102, 153));
		List.setOpaque(true);
		List.setBorderPainted(false);
		List.setBounds(0, 382
			, 102, 96);
		panel_2.add(List);
		
		JButton btnNewButton_1_4 = new JButton("Report Card");
		btnNewButton_1_4.setForeground(new Color(255, 255, 255));
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bultin Jbultin = new bultin();
				Jbultin.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1_4.setBackground(new Color(204, 153, 204));
				btnNewButton_1_4.setOpaque(true);
				btnNewButton_1_4.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_4.setBackground(new Color(153, 102, 153));
				btnNewButton_1_4.setOpaque(true);
				btnNewButton_1_4.setBorderPainted(false);
			}
		});
		btnNewButton_1_4.setBackground(new Color(153, 102, 153));
		btnNewButton_1_4.setOpaque(true);
		btnNewButton_1_4.setBorderPainted(false);
		btnNewButton_1_4.setBounds(0, 478, 102, 104);
		panel_2.add(btnNewButton_1_4);
		
		JLabel Quit = new JLabel("");
		Quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		Quit.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/clipart1442925.png"));
		Quit.setBounds(764, 6, 30, 30);
		panel_1.add(Quit);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(102, 0, 698, 574);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 250, 250));
		panel.setLayout(null);
		
		
		matricule = new JTextField();
		matricule.setBackground(new Color(255, 250, 250));
		matricule.setBounds(127, 25, 238, 38);
		panel.add(matricule);
		matricule.setColumns(10);
		matricule.setBorder(null);
		
		firstname = new JTextField();
		firstname.setBackground(new Color(255, 250, 250));
		firstname.setBounds(127, 242, 195, 38);
		panel.add(firstname);
		firstname.setColumns(10);
		firstname.setBorder(null);
		
		group = new JTextField();
		group.setBackground(new Color(255, 250, 250));
		group.setBounds(96, 334, 243, 38);
		panel.add(group);
		group.setColumns(10);
		group.setBorder(null);
		
		codes = new JTextField();
		codes.setBackground(new Color(255, 250, 250));
		codes.setBounds(99, 419, 243, 38);
		panel.add(codes);
		codes.setColumns(10);
		codes.setBorder(null);
		
		lastname = new JTextField();
		lastname.setBackground(new Color(255, 250, 250));
		lastname.setBounds(130, 179, 209, 38);
		panel.add(lastname);
		lastname.setColumns(10);
		lastname.setBorder(null);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
     
				try {
			          
		            String Matricule = matricule.getText();
		 
		                pst = con.prepareStatement("select nom,prenom,groupe,CodeS from student where Matricule = ?");
		                pst.setString(1, Matricule);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String nom = rs.getString(1);
		                String prenom = rs.getString(2);
		                String groupe = rs.getString(3);
		                String CodeS = rs.getString(4);
		                
		                lastname.setText(nom);
		                firstname.setText(prenom);
		                group.setText(groupe);
		                codes.setText(CodeS);
		                
		                
		            }  
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Student doesn't exist ! ");
		            	lastname.setText(" ");
		                firstname.setText(" ");
		                group.setText(" ");
		                codes.setText(" ");
		                
		            }
		            
		        }
		catch (SQLException ex) {
		          
		        }
			}
		});
		search.setForeground(Color.WHITE);
		search.setBackground(Color.BLACK);
		search.setOpaque(true);
		search.setBorderPainted(false);
		
		search.setBounds(479, 26, 141, 38);
		
		panel.add(search);
		
		
		
		/////////////ajouterrrr///////////////////////////////////////
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Matricule = matricule.getText();
				String LastName = lastname.getText();
				String FirstName = firstname.getText();
				String CodeS = codes.getText();
				String Group = group.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) {
						
				try {
					pst = con.prepareStatement("insert into student(Matricule,nom,prenom,groupe,CodeS)values(?,?,?,?,?)");
					pst.setString(1, Matricule);
					pst.setString(2, LastName);
					pst.setString(3, FirstName);
					pst.setString(4, Group);
					pst.setString(5, CodeS);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student Added!");
					// table_load();					          
					matricule.setText("");
					lastname.setText("");
					firstname.setText("");
					codes.setText("");
					group.setText("");	
					matricule.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation Canceled ! ");
				}
				
				

				
			}
		});
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setOpaque(true);
		add.setBorderPainted(false);
		add.setBounds(380, 288, 138, 45);
		panel.add(add);
		
		
		
		
		////////////////// modifiieerrrrr///////////////
		
		
		JButton change = new JButton("Update S/G");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Matricule = matricule.getText();
				String LastName = lastname.getText();
				String FirstName = firstname.getText();
				String CodeS = codes.getText();
				String Group = group.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
					
				try {
				pst = con.prepareStatement("update student set nom= ?,prenom=?,groupe=?,CodeS=? where matricule =?");
				pst.setString(1, LastName);
				            pst.setString(2, FirstName);
				            pst.setString(3, Group);
				            pst.setString(4, CodeS);
				            pst.setString(5, Matricule);
				            pst.executeUpdate();
				            
				            JOptionPane.showMessageDialog(null, "Updated!");
				          
				            matricule.setText("");
							lastname.setText("");
							firstname.setText("");
							codes.setText("");
							group.setText("");	
							matricule.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation Canceled ! ");
				}
				
				
			}
		});
		change.setForeground(Color.WHITE);
		change.setBackground(Color.BLACK);
		change.setOpaque(true);
		change.setBorderPainted(false);
		change.setBounds(462, 367, 138, 45);
		panel.add(change);
		
		///////////////////////// Delete /////////////////////////////
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
					
				String Matricule;
				Matricule  = matricule.getText();
				try {
				pst = con.prepareStatement("delete from student where matricule=?");
				            pst.setString(1, Matricule);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Deleted!");
				          
				            matricule.setText("");
							lastname.setText("");
							firstname.setText("");
							codes.setText("");
							group.setText("");	
							matricule.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation Canceled ! ");
				}
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setBackground(Color.BLACK);
		delete.setOpaque(true);
		delete.setBorderPainted(false);
		delete.setBounds(543, 288, 138, 45);
		panel.add(delete);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule* : ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(26, 36, 119, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last name : ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 189, 119, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name :");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(26, 252, 119, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Group :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(26, 339, 76, 27);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CodeS :");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(26, 429, 61, 16);
		panel.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(118, 65, 247, 12);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(127, 217, 209, 12);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(130, 280, 209, 12);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(127, 369, 209, 12);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(127, 454, 209, 12);
		panel.add(separator_4);
	}

	public void setVisible(boolean b) {
		if (true) {
		frame.setVisible(true); }
		// TODO Auto-generated method stub
		
	}
}
