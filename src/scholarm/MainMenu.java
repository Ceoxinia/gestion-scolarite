package scholarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
				setVisible(false);
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
				setVisible(false);
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
		examB.setForeground(new Color(255, 255, 255));
		examB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exam Jexam = new Exam();
				Jexam.setVisible(true);
				setVisible(false);
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
				setVisible(false);
				
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
				setVisible(false);
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
			    setVisible(false);
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
				setVisible(false);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/clipart1442925.png"));
		lblNewLabel.setBounds(764, 6, 30, 30);
		panel_1.add(lblNewLabel);
	}
}
