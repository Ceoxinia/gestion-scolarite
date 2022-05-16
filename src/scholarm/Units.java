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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;


public class Units {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Units window = new Units();
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
	public Units() {
		initialize();
		Connect();
		table_load();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField codem;
	private JTextField libellem;
	private JTextField coef;
	private JTextField codeens;
	
	
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
	    pst = con.prepareStatement("select * from module");
	    rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 102, 600);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton studentB = new JButton("Students");
		studentB.setForeground(new Color(255, 255, 255));
		studentB.setFont(new Font("Open Sans", Font.PLAIN, 13));
		studentB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student Jstudent = new Student();
				Jstudent.setVisible(true);
				frame.setVisible(false);
			}
		});
		studentB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				studentB.setBackground(new Color(204, 153, 204));
				studentB.setOpaque(true);
				studentB.setBorderPainted(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				studentB.setBackground(new Color(153, 102, 153));
				studentB.setOpaque(true);
				studentB.setBorderPainted(false);
			}
		});
	
		studentB.setBackground(new Color(153, 102, 153));
		studentB.setBounds(0, 0, 102, 97);
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
		
		UnitB.setBackground(new Color(204, 153, 204));
		UnitB.setOpaque(true);
		UnitB.setBorderPainted(false);
		UnitB.setBounds(0, 95, 102, 97);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/clipart1442925.png"));
		lblNewLabel.setBounds(764, 6, 30, 30);
		panel.add(lblNewLabel);
		
	////////// <<<<<<<<<<<<<<<<<,Searche>>>>>>>>>>>>>>>>>>>> ///
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
     
				try {
			          
		            String CodeM = codem.getText();
		 
		                pst = con.prepareStatement("select libelleM,coef,CodeEns from module where CodeM = ?");
		                pst.setString(1, CodeM);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String libelleM = rs.getString(1);
		                String Coef = rs.getString(2);
		                String CodeEns = rs.getString(3);
		               
		                
		                libellem.setText(libelleM);
		                coef.setText(Coef);
		                codeens.setText(CodeEns);
		                
		                
		            }  
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Unit doesn't exist ! ");
		            	libellem.setText(" ");
		                coef.setText(" ");
		                codeens.setText(" ");
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
		
		search.setBounds(479, 18, 141, 38);
		
		panel.add(search);
		
		
		//////////////////addd/////////////////////////////
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String libelleM = libellem.getText();
				String CodeM = codem.getText();
				String Coef = coef.getText();
				String CodeEns = codeens.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) {
						
				try {
					pst = con.prepareStatement("insert into module(CodeM,libelleM,coef,CodeEns)values(?,?,?,?)");
					pst.setString(1, CodeM);
					pst.setString(2, libelleM);
					pst.setString(3, Coef);
					pst.setString(4, CodeEns);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Unit Added!");
					table_load();					          
					libellem.setText("");
					codem.setText("");
					coef.setText("");
					codeens.setText("");
						
					codem.requestFocus();
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
		add.setBounds(114, 469, 138, 45);
		panel.add(add);
		
		JButton change = new JButton("Update Coef");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String libelleM = libellem.getText();
				String CodeM = codem.getText();
				String Coef = coef.getText();
				String CodeEns = codeens.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
					
				try {
				pst = con.prepareStatement("update module set libelleM=?,coef=?,CodeEns=? where CodeM =?");
				pst.setString(1, libelleM);
				            pst.setString(2, Coef);
				            pst.setString(3, CodeEns);
				            pst.setString(4, CodeM);
				            pst.executeUpdate();
				            
				            JOptionPane.showMessageDialog(null, "Updated!");
				    		table_load();

				          
				            libellem.setText("");
							codem.setText("");
							coef.setText("");
							codeens.setText("");
								
							codem.requestFocus();
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
		change.setBounds(269, 469, 138, 45);
		panel.add(change);
		
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
					
				String CodeM;
				CodeM  = codem.getText();
				try {
				pst = con.prepareStatement("delete from module where CodeM=?");
				            pst.setString(1, CodeM);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Deleted!");
				          
				            libellem.setText("");
							codem.setText("");
							coef.setText("");
							codeens.setText("");
								
							codem.requestFocus();
							table_load();

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
		delete.setBounds(199, 526, 138, 45);
		panel.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(431, 73, 363, 441);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(new Color(204, 153, 204));
	    scrollPane.setViewportView(table);
	    table.setShowHorizontalLines(true);
	    table.setShowVerticalLines(true);
		
		JLabel lblNewLabel_1 = new JLabel("CodeM*:");
		lblNewLabel_1.setBounds(119, 28, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LabelM :");
		lblNewLabel_2.setBounds(119, 118, 61, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Coef :");
		lblNewLabel_3.setBounds(119, 227, 61, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CodeEns :");
		lblNewLabel_4.setBounds(119, 350, 102, 16);
		panel.add(lblNewLabel_4);
		
		codem = new JTextField();
		codem.setBackground(new Color(255, 250, 250));
		codem.setBounds(192, 15, 218, 42);
		codem.setBorder(null);
		panel.add(codem);
		codem.setColumns(10);
		
		libellem = new JTextField();
		libellem.setBackground(new Color(255, 250, 250));
		libellem.setBounds(192, 104, 215, 45);
		libellem.setBorder(null);
		panel.add(libellem);
		libellem.setColumns(10);
		
		coef = new JTextField();
		coef.setBackground(new Color(255, 250, 250));
		coef.setBounds(187, 213, 220, 45);
		coef.setBorder(null);
		panel.add(coef);
		coef.setColumns(10);
		
		codeens = new JTextField();
		codeens.setBackground(new Color(255, 250, 250));
		codeens.setBounds(189, 326, 218, 52);
		codeens.setBorder(null);
		panel.add(codeens);
		codeens.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(192, 56, 232, 12);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(187, 161, 232, 12);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(192, 262, 232, 12);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(187, 386, 232, 12);
		panel.add(separator_3);
	}
	public void setVisible(boolean b) {
		if (true) {
			frame.setVisible(true); }
		// TODO Auto-generated method stub
		
	}
}
