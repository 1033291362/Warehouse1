import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;



public class deposit extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextArea textArea;
	String a="12345";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit frame = new deposit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u5B58\u6B3E\u8D26\u53F7");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		label.setBounds(170, 24, 230, 58);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblid = new JLabel("\u5B58\u6B3Eid");
		lblid.setBounds(97, 124, 72, 18);
		panel_1.add(lblid);
		
		ID = new JTextField();
		ID.setBounds(207, 121, 86, 24);
		panel_1.add(ID);
		ID.setColumns(10);
		
		JButton action = new JButton("\u786E\u8BA4");
		action.setBackground(Color.WHITE);
		action.setBounds(56, 246, 113, 27);
		panel_1.add(action);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBackground(Color.WHITE);
		button.setBounds(212, 246, 113, 27);
		panel_1.add(button);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 144, 227);
		panel_1.add(textArea);
		button.addActionListener(new BackListener());
		action.addActionListener(new ButtonListener());
	}
	public class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String id = "id"+ID.getText()+"*";
			if(ID.getText().equals("")){
				textArea.setText("输入账号");
				ID.requestFocus();
			}else{
				String tempString = null;
				try {
		            File file = new File("Regest.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while ((tempString = reader.readLine()) != null) {
		            	String[] str = tempString.split("/");
		            	if(id.equals(str[ 0 ])){
		            		textArea.setText("有这个id");
		            		textArea.setText("可以存款");
	            			Detdeposit.main(id);
	            			setVisible(false);
	            			a="54321";
		            	}
		            }
		            if(a=="12345"){
		            	textArea.setText("不存在这个ID");
		            }
		            reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}
			}		
		}
	}
	public class BackListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Home.main(null);
			setVisible(false);
		}
	}
}
