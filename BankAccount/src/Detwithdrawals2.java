import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;



public class Detwithdrawals2 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	public static String inputFile;
	public String a= "54321";

	public static void main(final String id) throws IOException  {
		String tempString = null;
		File file = new File("Regest.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while ((tempString = reader.readLine()) != null) {
        	String[] str = tempString.split("/");
        	if(id.equals(str[ 0 ])){
        		inputFile = str[ 0 ]+"/"+str[ 1 ]+"/"+str[ 2 ]+"/"+str[ 3 ]+"/"+str[ 4 ]+"/"+str[ 5 ]+"/"+str[ 6 ];
        		Detwithdrawals det = new Detwithdrawals(inputFile);
        		det.setInputFile(inputFile);
        		det.getInputFile(); 
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					Detwithdrawals2 frame = new Detwithdrawals2(id);
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        	}
		}
	}

	public Detwithdrawals2(String id)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u53D6\u6B3E");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		label.setBounds(231, 27, 146, 42);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 144, 183);
		panel_1.add(textArea);
		textArea.setLineWrap(true);
		
		JButton reservation = new JButton("\u9884\u7EA6");
		reservation.setBackground(Color.WHITE);
		reservation.setBounds(106, 64, 113, 27);
		panel_1.add(reservation);
		
		JButton action = new JButton("\u53D6\u6B3E");
		action.setBackground(Color.WHITE);
		action.setBounds(106, 226, 113, 27);
		panel_1.add(action);
		action.addActionListener(new actionListener());
		reservation.addActionListener(new reservationListener());
		
	}
	public class reservationListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String tempString = null;
			String[] duanluo = inputFile.split("/");
			try {
	            File file = new File("reservation.txt");
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            while ((tempString = reader.readLine()) != null) {
	            	String[] str = tempString.split("/");
	            	if(duanluo[0].equals(str[ 0 ])){
	            		textArea.setText("���Ѿ�ԤԼ�ɹ��˰�,����ȡ��");
	            		a = "12345";
	            	}
	            }
	            if(a=="54321"){
	            	Date now = new Date(); 
	    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    			System.out.println(dateFormat.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	    			String hehe = dateFormat.format( now ); 		
	    			String inputfile = duanluo[0]+"/" + hehe ;
	    			
	    			textArea.setText("����ԤԼ�ˣ�" + hehe);
	    			try{    
	    				FileWriter fw = new FileWriter("reservation.txt",true);
	    				BufferedWriter writer = new BufferedWriter(fw);
	    				writer.write(inputfile);
	    				writer.newLine();
	    				writer.close();
	    			}catch(IOException ex){
	    				ex.printStackTrace();
	    			}	
	            }            
	            reader.close();
	        }catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	public class actionListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String[] duanluo = inputFile.split("/");
			String panduan = duanluo[0];
			String tempString = null;
			ArrayList<String> list = new ArrayList<String>();						
			String str = inputFile.toString().replace(inputFile," " );
			try {
		        File file = new File("reservation.txt");
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        while ((tempString = reader.readLine()) != null) {
		        	String[] str1 = tempString.split("/");
		          	if(duanluo[0].equals(str1[ 0 ])){
		           		String date = str1[ 1 ];
		           		try {
		                    Date d = parseDate(date);//���ַ���ת����date����
		                    Date now = new Date(); 
			          		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			           		String hehe = dateFormat.format( now ); 
			           		long time = 1*60*1000;//30����                     ԤԼʱ�������ﰡ������
			           		Date afterDate = new Date(now .getTime() - time);
			           		long diff = afterDate.getTime() - d.getTime(); 
			           		if(diff<=0){
			           			textArea.setText("ԤԼ��ʱ�仹û��" + str1[1] +"һ����֮��");
			           			a = "12345";
			           		}else{
			           			textArea.setText("����ԤԼ������ȡǮ��" + str1[1]);
				           		a = "12345";
				           		char[] data = new char[1024];
				           		int rn = 0;
				           		StringBuilder sb = new StringBuilder();// �����ַ���������
				           		while ((rn = reader.read(data)) > 0) {// ��ȡ�ļ����ݵ��ַ���������
					                String str11 = String.valueOf(data, 0, rn);
					                sb.append(str11);
					            }
				           		String str11 = sb.toString().replace(inputFile, str);
				           		FileWriter fout = new FileWriter("reservation.txt");// �����ļ������
					            fout.write(str11.toCharArray());// ���滻��ɵ��ַ���д���ļ���
					            fout.close();
					            Detwithdrawals.main(duanluo[0]);
					            setVisible(false);
			           		}
		                } catch (ParseException e) {
		                       // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
		          	}
		        }
		        if(a == "54321"){
		         	textArea.setText("�㻹û��ԤԼ ����ԤԼȻ���һ��ȡǮ");
		       	}
		        reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}			
		}
		public Date parseDate(String s) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return format.parse(s);
	    }
		private boolean isNum(String ta) {
			// TODO Auto-generated method stub
			return ta.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		}
	}

}
