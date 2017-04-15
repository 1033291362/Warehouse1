import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;


public class suspend extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	public static String inputFile;
	private JButton resus;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblid;
	private JLabel label;
	private JButton back;
	String a="12345";
	public void setInputFile(String inputFile){
		this.inputFile = inputFile;
	}
	public String getInputFile(){
		System.out.println(inputFile);
		return inputFile;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					suspend frame = new suspend();
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
	public suspend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("\u51BB\u7ED3\u9875\u9762");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		label.setBounds(204, 33, 166, 42);
		panel.add(label);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(52, 113, 489, 308);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 114, 183);
		panel_1.add(textArea);
		textArea.setLineWrap(true);
		
		resus = new JButton("\u89E3\u9664\u51BB\u7ED3");
		resus.setBackground(Color.WHITE);
		resus.setBounds(212, 246, 113, 27);
		panel_1.add(resus);
		
		JButton btnNewButton = new JButton("\u51BB\u7ED3");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(56, 246, 113, 27);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(122, 116, 86, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblid = new JLabel("\u8F93\u5165ID\uFF1A");
		lblid.setBounds(56, 119, 72, 18);
		panel_1.add(lblid);
		
		back = new JButton("back");
		back.setBackground(Color.WHITE);
		back.setBounds(349, 246, 113, 27);
		panel_1.add(back);
		back.addActionListener(new backListener());
		
		btnNewButton.addActionListener(new actionListener());
		resus.addActionListener(new resusListener());
	}
	public class backListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Bank.main(null);
			setVisible(false);
		}
	}
	public class actionListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String id = "id"+textField.getText()+"*";
			if(textField.getText().equals("")){
				textArea.setText("���붳���˺�");
				textField.requestFocus();
			}else{
				String tempString = null;
				ArrayList<String> list = new ArrayList<String>();
				try {
		            File file = new File("Regest.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while ((tempString = reader.readLine()) != null) {
		            	String[] str = tempString.split("/");
		            	if(id.equals(str[ 0 ])){
		            		textArea.setText("�����id,�����Ӱ���������");
		            		inputFile = str[ 0 ]+"/"+str[ 1 ]+"/"+str[ 2 ]+"/"+str[ 3 ]+"/"+str[ 4 ]+"/"+str[ 5 ]+"/"+str[ 6 ];
		            		suspend det = new suspend();
		            		det.setInputFile(inputFile);
		            		det.getInputFile(); 
		            		a="54321";
		            		String cc = "suspend" + textField.getText() + "*";
		            		String strinput = inputFile.toString().replace(str[0], cc);
		            		try {
					            FileReader fis = new FileReader("Regest.txt");// �����ļ�������
					            char[] data = new char[1024];// ���������ַ�����
					            int rn = 0;
					            StringBuilder sb = new StringBuilder();// �����ַ���������
					            while ((rn = fis.read(data)) > 0) {// ��ȡ�ļ����ݵ��ַ���������
					                String str1 = String.valueOf(data, 0, rn);
					                sb.append(str1);
					            }
					            fis.close();// �ر�������
					            // �ӹ������������ַ��������滻�����ı�
					            String str1 = sb.toString().replace(inputFile, strinput);
					            FileWriter fout = new FileWriter("Regest.txt");// �����ļ������
					            fout.write(str1.toCharArray());// ���滻��ɵ��ַ���д���ļ���
					            fout.close();// �ر������
					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
		            		textArea.setText("�˺��Ѷ��᣺"+ textField.getText());	            		
		            	}
		            }
		            if(a=="12345"){
		            	textArea.setText("û������˻�");
		            }
		            reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}
	public class resusListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String id = "suspend"+textField.getText()+"*";
			if(textField.getText().equals("")){
				textArea.setText("����ⶳ�˺�");
				textField.requestFocus();
			}else{
				String tempString = null;
				ArrayList<String> list = new ArrayList<String>();
				try {
		            File file = new File("Regest.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while ((tempString = reader.readLine()) != null) {
		            	String[] str = tempString.split("/");
		            	if(id.equals(str[ 0 ])){
		            		inputFile = str[ 0 ]+"/"+str[ 1 ]+"/"+str[ 2 ]+"/"+str[ 3 ]+"/"+str[ 4 ]+"/"+str[ 5 ]+"/"+str[ 6 ];
		            		suspend det = new suspend();
		            		det.setInputFile(inputFile);
		            		det.getInputFile(); 
		            		
		            		String cc = "id" + textField.getText() + "*";
		            		String strinput = inputFile.toString().replace(str[0], cc);
		            		try {
					            FileReader fis = new FileReader("Regest.txt");// �����ļ�������
					            char[] data = new char[1024];// ���������ַ�����
					            int rn = 0;
					            StringBuilder sb = new StringBuilder();// �����ַ���������
					            while ((rn = fis.read(data)) > 0) {// ��ȡ�ļ����ݵ��ַ���������
					                String str1 = String.valueOf(data, 0, rn);
					                sb.append(str1);
					            }
					            fis.close();// �ر�������
					            // �ӹ������������ַ��������滻�����ı�
					            String str1 = sb.toString().replace(inputFile, strinput);
					            FileWriter fout = new FileWriter("Regest.txt");// �����ļ������
					            fout.write(str1.toCharArray());// ���滻��ɵ��ַ���д���ļ���
					            fout.close();// �ر������
					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
		            		textArea.setText("�˺��ѽ�����᣺"+ textField.getText());	            		
		            	}
		            }
		            reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
	}
}
