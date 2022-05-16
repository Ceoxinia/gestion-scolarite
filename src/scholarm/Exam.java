package scholarm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Exam {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField codem;
	private JTextField label;
	private JTextField Coef;
	private JTextField codeMS;
	private JTextField mat;
	private JTextField note;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam window = new Exam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	ResultSet rsM;
	private JTable tableS;
	private JTable tableM;
	
	
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
	 public void tableS_load()
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
	 public void tableM_load()
	    {
	     try
	     {
	    pst = con.prepareStatement("select * from module");
	    rsM = pst.executeQuery();
	}
	     catch (SQLException e)
	     {
	     e.printStackTrace();
	  }
	    }


	/**
	 * Create the application.
	 */
	public Exam() {
		initialize();
		Connect();
		tableM_load();
		tableS_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
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
		UnitB.setBounds(0, 95, 102, 97);
		panel_2.add(UnitB);
		
		JButton examB = new JButton("Exam");
		examB.setBackground(new Color(204, 153, 204));
		examB.setOpaque(true);
		examB.setBorderPainted(false);
		examB.setForeground(new Color(255, 255, 255));
		examB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exam Jexam = new Exam();
				Jexam.setVisible(true);
				frame.setVisible(false);
			}
		});
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
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code Module :");
		lblNewLabel_1.setBounds(191, 97, 94, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Label :");
		lblNewLabel_1_1.setBounds(191, 172, 61, 16);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Coef :");
		lblNewLabel_1_2.setBounds(191, 244, 61, 16);
		panel_1.add(lblNewLabel_1_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(282, 335, 459, 16);
		panel_1.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Students Marks");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(153, 330, 175, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CodeM ");
		lblNewLabel_3.setBounds(148, 406, 61, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Matricule");
		lblNewLabel_4.setBounds(326, 406, 61, 16);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Note");
		lblNewLabel_5.setBounds(512, 406, 61, 16);
		panel_1.add(lblNewLabel_5);
		
		codem = new JTextField();
		codem.setBounds(297, 88, 130, 30);
		panel_1.add(codem);
		codem.setColumns(10);
		
		label = new JTextField();
		label.setBounds(297, 154, 130, 39);
		panel_1.add(label);
		label.setColumns(10);
		
		Coef = new JTextField();
		Coef.setBounds(297, 226, 130, 39);
		panel_1.add(Coef);
		Coef.setColumns(10);
		
		codeMS = new JTextField();
		codeMS.setBounds(122, 434, 130, 29);
		panel_1.add(codeMS);
		codeMS.setColumns(10);
		
		mat = new JTextField();
		mat.setBounds(297, 433, 130, 30);
		panel_1.add(mat);
		mat.setColumns(10);
		
		note = new JTextField();
		note.setBounds(464, 433, 130, 30);
		panel_1.add(note);
		note.setColumns(10);
		
		// +++++++++++++++++++ NEXT MODULE +++++++++++++++++++++++++//
		JButton nextmodule = new JButton("Next");
		nextmodule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			     {
				
			    rsM.next();			    
			    
			    codem.setText(rsM.getString("CodeM"));
			    label.setText(rsM.getString("libelleM"));
			    Coef.setText(rsM.getString("coef")); 
			    
			    pst = con.prepareStatement("select * from student");
			    rs = pst.executeQuery();
			    rs.next();
			    
			    mat.setText(rs.getString("Matricule"));
			    codeMS.setText(rsM.getString("CodeM"));
			    
			    
			}
			     catch (SQLException ex)
			     {
			     ex.printStackTrace();
			  }
				
				
			}
		});
		nextmodule.setForeground(Color.WHITE);
		nextmodule.setBackground(Color.BLACK);
		nextmodule.setOpaque(true);
		nextmodule.setBorderPainted(false);
		nextmodule.setBounds(652, 195, 117, 29);
		panel_1.add(nextmodule);
		
		
		// ++++++++++++++++++++++++ Next Student ++++>>>>>>//
		
		
		JButton nextstudent = new JButton("Next");
		nextstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CodeMS = codeMS.getText();
				String Mat = mat.getText();
				String Note = note.getText();
				
				try {
					pst = con.prepareStatement("insert into exam(CodeM,matricule, note)values(?,?,?)");
					pst.setString(1, CodeMS);
					pst.setString(2, Mat);
					pst.setString(3, Note );
					pst.executeUpdate();
					
					rs.next();
					
					mat.setText(rs.getString("Matricule"));
					note.setText("");
					
						
			}
				
				catch (SQLException e1)
		        {
		e1.printStackTrace();
		}
		}
		});
		nextstudent.setForeground(Color.WHITE);
		nextstudent.setBackground(Color.BLACK);
		nextstudent.setOpaque(true);
		nextstudent.setBorderPainted(false);
		nextstudent.setBounds(652, 437, 117, 29);
		panel_1.add(nextstudent);
		
		

		
	
	}
	public void setVisible(boolean b) {
		if (true) {
		frame.setVisible(true); }
		// TODO Auto-generated method stub
		
	}
	}


