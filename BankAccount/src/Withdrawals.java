import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;

public class Withdrawals extends JFrame {
	private JPanel contentPane;
	public static String id;
	public static String inputFile;
	public void setID(String id){
		this.id = id;
	}
	public String getID(){
		System.out.println(id);
		return id;
	}
	public static void main(final String id) throws IOException {
		Withdrawals det = new Withdrawals(id);
		det.setID(id);
		det.getID();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawals frame = new Withdrawals(id);
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
	public Withdrawals(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLanding = new JLabel("Landing");
		lblLanding.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblLanding.setBounds(215, 27, 174, 47);
		panel.add(lblLanding);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//取款
		JButton withdraw = new JButton("\u53D6\u6B3E");
		withdraw.setBackground(Color.WHITE);
		withdraw.setBounds(29, 79, 113, 27);
		panel_1.add(withdraw);
		withdraw.addActionListener(new ButtonListener());
		//存款
		JButton detpos = new JButton("\u5B58\u6B3E");
		detpos.setBackground(Color.WHITE);
		detpos.setBounds(29, 138, 113, 27);
		panel_1.add(detpos);
		setLocationRelativeTo(null);
		detpos.addActionListener(new detposListener());
	}
	//取款
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {	
			String tempString = null;
			File file = new File("Regest.txt");
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file));
				while ((tempString = reader.readLine()) != null) {
		        	String[] str = tempString.split("/");
		        	if(id.equals(str[ 0 ])){
		        		inputFile = str[ 0 ]+"/"+str[ 1 ]+"/"+str[ 2 ]+"/"+str[ 3 ]+"/"+str[ 4 ]+"/"+str[ 5 ]+"/"+str[ 6 ];
		        		String[] duanluo = inputFile.split("/");
		        		String cc = duanluo[5];
		        		if(cc.equals("SaveAcc")){
		        			Detwithdrawals2.main(id);
		        			setVisible(false);
		        		}else{
		        			Detwithdrawals.main(id);
		        			setVisible(false);
		        		}
		        	}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			setVisible(false);
		}
	}
	//存款
	public class detposListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				Detdeposit.main(id);
				setVisible(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
