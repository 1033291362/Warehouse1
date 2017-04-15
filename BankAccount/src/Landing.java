import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Font;

public class Landing extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField PIN;
	private JTextArea textArea;
	private JButton back;
	private String id;
	private JList cl_uncl;
	String a="12345";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing frame = new Landing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//∑‚◊∞id

	public Landing() {
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
		
		JLabel label = new JLabel("\u767B\u9646");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 30));
		label.setBounds(221, 13, 252, 74);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(349, 38, 137, 147);
		panel_1.add(textArea);
		textArea.setLineWrap(true);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 40, 72, 18);
		panel_1.add(lblId);
		
		ID = new JTextField();
		ID.setBounds(69, 37, 86, 24);
		panel_1.add(ID);
		ID.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(24, 71, 72, 18);
		panel_1.add(lblPin);
		
		PIN = new JTextField();
		PIN.setBounds(69, 71, 86, 24);
		panel_1.add(PIN);
		PIN.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(56, 246, 113, 27);
		panel_1.add(button);
		button.setBackground(Color.WHITE);
		
		back = new JButton("\u8FD4\u56DE");
		back.setBounds(212, 246, 113, 27);
		panel_1.add(back);
		back.setBackground(Color.WHITE);
		
		back.addActionListener(new backListener());
		button.addActionListener(new ButtonListener());
	}//∑µªÿ
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Home.main(null);
			setVisible(false);
		}		
	}
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			id = "id"+ID.getText()+"*";
			String pin = "pin"+PIN.getText()+"*";	
			String pin1 = PIN.getText();
			if(ID.getText().equals("")){
				textArea.setText(" ‰»Î’À∫≈");
				ID.requestFocus();
			}else if(PIN.getText().equals("")){
				textArea.setText(" ‰»Î√‹¬Î");
				ID.requestFocus();
			}else{
				String tempString = null;
				ArrayList<String> list = new ArrayList<String>();
				try {
		            File file = new File("Regest.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while ((tempString = reader.readLine()) != null) {
		            	String[] str = tempString.split("/");
		            	if(id.equals(str[ 0 ])){
		            		if(pin.equals(str[ 1 ])){
		            			Withdrawals.main(id);
		            			setVisible(false);
		            			a = "54321";
		            		}
		            	}
		            }
		            if(a=="12345"){
		            	textArea.setText("’À∫≈ªÚ’ﬂ√‹¬Î≤ª∂‘ªÚ’À∫≈±ª∂≥Ω·");
		            }
		            reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}
			}			
		}			
	}
}
