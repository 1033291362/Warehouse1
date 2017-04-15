import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;



public class Home extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
//		FileOutStream fileStream = new FileOutStream("regist.txt");
//		try{
//			FileWriter writer = new FileWriter("Regest.txt");
//			writer.close();
//		}catch(IOException ex){
//			ex.printStackTrace();
//		}
		final Home frame = new Home();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton registered = new JButton("\u6CE8\u518C");
		registered.setBackground(Color.WHITE);
		registered.setBounds(218, 293, 113, 27);
		contentPane.add(registered);
		registered.addActionListener(new registeredListener());
		
		JButton Landing = new JButton("\u7528\u6237\u767B\u5F55");
		Landing.setBackground(Color.WHITE);
		Landing.setBounds(218, 253, 113, 27);
		contentPane.add(Landing);
		Landing.addActionListener(new WithdrawalsListener());
		
		JButton deposit = new JButton("\u5B58\u6B3E\u7CFB\u7EDF");
		deposit.setBackground(Color.WHITE);
		deposit.setBounds(218, 211, 113, 27);
		contentPane.add(deposit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u94F6\u884C\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(196, 25, 171, 62);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 258);
		contentPane.add(panel_1);
		
		JButton bank = new JButton("\u94F6\u884C\u64CD\u4F5C");
		bank.setBackground(Color.WHITE);
		bank.setBounds(218, 413, 113, 27);
		contentPane.add(bank);
		bank.addActionListener(new BankListener());
		deposit.addActionListener(new depositListener());
		
		setLocationRelativeTo(null);//æ”÷–

	}//depositListener
	public class depositListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			deposit.main(null);
			setVisible(false);
		}
	}
	//Withdrawals
	public class WithdrawalsListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Landing.main(null);
			setVisible(false);
		}
	}
	//registered
	public class registeredListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			system.main(null);
			setVisible(false);
		}
	}
	public class BankListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Bank.main(null);
			setVisible(false);
		}
	}
}
