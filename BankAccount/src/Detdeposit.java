import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.ListSelectionModel;



public class Detdeposit extends JFrame{

	private JPanel contentPane;
	private JTextField Money;
	public static String inputFile;
	private JTextArea textArea ;
	private JList list;
	private static JPanel panel;
	public void setInputFile(String inputFile){
		this.inputFile = inputFile;
	}
	public String getInputFile(){
		System.out.println(inputFile);
		return inputFile;
	}

	public static void main(final String id) throws IOException {
		// TODO Auto-generated method stub
		String tempString = null;
		File file = new File("Regest.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while ((tempString = reader.readLine()) != null) {
        	String[] str = tempString.split("/");
        	if(id.equals(str[ 0 ])){
        		inputFile = str[ 0 ]+"/"+str[ 1 ]+"/"+str[ 2 ]+"/"+str[ 3 ]+"/"+str[ 4 ]+"/"+str[ 5 ]+"/"+str[ 6 ];
        		Detdeposit det = new Detdeposit(inputFile);
        		det.setInputFile(inputFile);
//        		det.getInputFile();      		
        		EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Detdeposit frame = new Detdeposit(id);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
        		
        	}
        }
        reader.close();		
	}

	public Detdeposit(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(37, 122, 514, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u91D1\u989D");
		label.setBounds(56, 48, 72, 18);
		panel.add(label);
		//������
		Money = new JTextField();
		Money.setBounds(105, 45, 86, 24);
		panel.add(Money);
		Money.setColumns(10);
		//ȷ��
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.WHITE);
		button.setBounds(56, 246, 113, 27);
		panel.add(button);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.setBackground(Color.WHITE);
		back.setBounds(212, 246, 113, 27);
		panel.add(back);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 144, 227);
		panel.add(textArea);
		textArea.setLineWrap(true);
		
		String[] listtype = {"clear","un-clear"};			
		list = new JList(listtype);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(56, 93, 135, 40);
		panel.add(list);
		
		back.addActionListener(new BackListener());
		button.addActionListener(new ButtonListener());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 582, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u5B58\u6B3E\u754C\u9762");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		label_1.setBounds(218, 27, 205, 50);
		panel_1.add(label_1);
		setLocationRelativeTo(null);
	}
	//�޸Ľ��
	public class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String selection = (String) list.getSelectedValue();
			String textfont = Money.getText();
			if(textfont.isEmpty()){
				textArea.setText("������");
				Money.requestFocus();
			}else if(isNum(textfont)==false){
				textArea.setText("����������");
				Money.requestFocus();
			}
			else if(selection==null){
				textArea.setText("ѡ������");
			}else{
				int a = Integer.parseInt(textfont);
				String[] duanluo = inputFile.split("/");
				if(selection=="clear"){
					//ֱ�Ӱ�Ǯ���ȥ��								
					int b = Integer.parseInt(duanluo[6]);
					int c = b+a;
					String cc = String.valueOf(c);
					String str = inputFile.toString().replace(duanluo[6], cc);
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
				            String str1 = sb.toString().replace(inputFile, str);
				            FileWriter fout = new FileWriter("Regest.txt");// �����ļ������
				            fout.write(str1.toCharArray());// ���滻��ɵ��ַ���д���ļ���
				            fout.close();// �ر������
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					 textArea.setText("clear�˻�ֱ�Ӵ��ȥǮ��");
				}else if(selection =="un-clear"){
					try{    
						FileWriter fw = new FileWriter("unclearfunt.txt",true);
						BufferedWriter writer = new BufferedWriter(fw);
						String aa = duanluo[0] + "/" + a;
						writer.write(aa);
						writer.newLine();
						writer.close();
					}catch(IOException ex){
						ex.printStackTrace();
					}
					textArea.setText("un-clear�˻����Ժ����л���ȥ");
				}				 				 
			}						
		}

		private boolean isNum(String ta) {
			return ta.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		}
	}
	public class BackListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Home.main(null);
			setVisible(false);
		}
	}
}
