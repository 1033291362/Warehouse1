import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;



public class Bank extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank frame = new Bank();
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
	public Bank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);//æ”÷–

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton suspend = new JButton("\u51BB\u7ED3\u8D26\u6237");
		suspend.setBackground(Color.WHITE);
		suspend.setBounds(126, 294, 113, 27);
		contentPane.add(suspend);
		
		JButton clear = new JButton("\u6E05\u7A7A\u8D26\u6237");
		clear.setBackground(Color.WHITE);
		clear.setBounds(126, 243, 113, 27);
		contentPane.add(clear);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("bank system");
		lblNewLabel.setBounds(202, 29, 179, 40);
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnF = new JButton("\u8FD4\u56DE");
		btnF.setBackground(Color.WHITE);
		btnF.setBounds(91, 216, 113, 27);
		panel_1.add(btnF);
		btnF.addActionListener(new vtListener());
		suspend.addActionListener(new actionListener());
		clear.addActionListener(new clearListener());

	}
	public class actionListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			suspend.main(null);
			setVisible(false);
		}
	}
	public class vtListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Home.main(null);
			setVisible(false);
		}
	}
	public class clearListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			clear.main(null);
			setVisible(false);
		}
	}

}
