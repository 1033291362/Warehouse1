import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Caret;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.JLayeredPane;

class Acclist{
	String name;
	String address;
	String age;
	String type;
	String accountnum;
	String pin;
	String account;
    public Acclist(String name, String address, String age, String type,String accountnum,String pin,String account) {
    	this.name=name;
        this.address=address;
        this.age = age;
        this.type = type;
        this.accountnum=accountnum;
        this.pin = pin;
        this.account = account;
    }  
	@Override
    public String toString() {
        return "\n姓名:"+name+"\n地址:"+address+"\n年龄:"+age+"\n类型:"+type+"\nID:"+accountnum+"\nPIN:"+pin+"\n总额:"+account;
    }
}

public class system extends JFrame{
	static String name;
	static String address;
	static String age;
	static String type;
	private JPanel contentPane;
	static ArrayList<String> accountlist = new ArrayList<String>();
	static ArrayList<String> namelist = new ArrayList<String>();
	static ArrayList<String> agelist = new ArrayList<String>();
	static ArrayList<String> addresslist = new ArrayList<String>();
	static ArrayList<String> typelist = new ArrayList<String>();
	static ArrayList<String> pinlist = new ArrayList<String>();
	static ArrayList<Acclist> list = new ArrayList<Acclist>();
	private JTextField textname;
	private JLabel label_1;
	private JTextField textage;
	private JLabel label_2;
	private JTextField textaddress;
	private JTextArea textArea;
	private JTextField PIN;
	private JList list_1;
	private JList list_2;
	private JList accounttype;
	private JButton back;
	private JButton button;
	private JTextField accnum;
	private Dialog d;
	private Label lab;
    private Button okBut;
    String[] str;
    String panduan = "54321";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					system frame = new system();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public system() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);//居中
		String[] listtype = {"SaveAcc","JuniorAcc","CurrentAcc"};		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 582, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_5 = new JLabel("\u6CE8\u518C\u9875\u9762");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		label_5.setBounds(215, 13, 150, 52);
		panel.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//name
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(14, 88, 30, 18);
		panel_1.add(label);
		
		textname = new JTextField();
		textname.setBounds(58, 86, 86, 24);
		panel_1.add(textname);
		textname.setBackground(Color.WHITE);
		textname.setColumns(10);
		
		label_1 = new JLabel("\u5E74\u9F84");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(14, 119, 72, 18);
		panel_1.add(label_1);
		
		textaddress = new JTextField();
		textaddress.setBounds(58, 150, 86, 24);
		panel_1.add(textaddress);
		textaddress.setBackground(Color.WHITE);
		textaddress.setColumns(10);
 				
		label_2 = new JLabel("\u5730\u5740");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(14, 150, 72, 18);
		panel_1.add(label_2);
		
		textage = new JTextField();
		textage.setBounds(58, 117, 86, 24);
		panel_1.add(textage);
		textage.setBackground(Color.WHITE);
		textage.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(14, 57, 72, 18);
		panel_1.add(label_3);
		
		PIN = new JTextField();
		PIN.setBounds(58, 55, 86, 24);
		panel_1.add(PIN);
		PIN.setBackground(Color.WHITE);
		PIN.setColumns(10);		
				//确定
		button = new JButton("\u786E\u5B9A");
		button.setBounds(7, 266, 113, 27);
		panel_1.add(button);
		button.setBackground(Color.WHITE);
				
		back = new JButton("\u8FD4\u56DE");
		back.setForeground(Color.BLACK);
		back.setBackground(Color.WHITE);
		back.setBounds(147, 266, 113, 27);
		panel_1.add(back);
		
		accounttype = new JList(listtype);
		accounttype.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		accounttype.setBounds(14, 187, 121, 66);
		panel_1.add(accounttype);
		accounttype.setBackground(Color.WHITE);
		accounttype.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accounttype.setVisibleRowCount(1);		
				
		textArea = new JTextArea();
		textArea.setBounds(274, 56, 215, 237);
		panel_1.add(textArea);
		textArea.setText("记得把这一大堆都填上"); 
		textArea.setLineWrap(true);
		
		JLabel label_4 = new JLabel("\u63D0\u793A\u6846");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBounds(274, 25, 72, 18);
		panel_1.add(label_4);
			
		JLabel label_6 = new JLabel("\u8D26\u53F7");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_6.setBounds(14, 25, 72, 18);
		panel_1.add(label_6);
		//账号
		accnum = new JTextField();
		accnum.setBounds(58, 23, 86, 24);
		panel_1.add(accnum);
		accnum.setColumns(10);
		back.addActionListener(new BackListener());
		button.addActionListener(new buttonListener());
		textname.requestFocus();
	}
	public class BackListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			Home.main(null);
			setVisible(false);
		}
	}
	public class buttonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String selection = (String) accounttype.getSelectedValue();
			String tacc=accnum.getText();
			String tacc1 = "id"+accnum.getText()+"*";
			String tn=textname.getText();
			String ta=textage.getText();
			String tad=textaddress.getText();
			String tty =selection;
			String pin = PIN.getText();
			if(accnum.getText().equals("")){
				textArea.setText("输入姓名");
				accnum.requestFocus();
			}else if(isNum(tacc)==false){
				textArea.setText("账号输入数字");
				accnum.requestFocus();
			}
			else if(textname.getText().equals("")){
				textArea.setText("输入姓名");
				textname.requestFocus();
			}
			else if(textage.getText().equals("")){
				textArea.setText("输入年龄");
				textage.requestFocus();
			}
			else if(textaddress.getText().equals("")){
				textArea.setText("输入地址");
				textaddress.requestFocus();
			}
			else if(PIN.getText().equals("")){
				textArea.setText("输入密码");
				PIN.requestFocus();
			}
			else if(isNum(ta)==false){
				textArea.setText("年龄输入数字");
				textage.requestFocus();
			}
			else if(selection==null){
				textArea.setText("选择类型");
			}
			else{
				String tempString = null;
				int ageint = Integer.parseInt(ta);
				ArrayList<String> list = new ArrayList<String>();
				try {
		            File file = new File("Regest.txt");
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while ((tempString = reader.readLine()) != null) {
		            	str = tempString.split("/");
		            	if(tacc1.equals(str[ 0 ])){
		            		JOptionPane.showMessageDialog(null, "此ID以被人注册", "提示", JOptionPane.ERROR_MESSAGE); 
		            		panduan = "12345";
		            		system.main(null);
		            		setVisible(false);
		            	}
		            }
		            if(panduan == "54321"){
		            	if(ageint>=16){
							if(selection=="JuniorAcc"){
								textArea.setText("成年人不许选JuniorAcc");
							}else{
								try {
									Regest(tacc,tn,ta,tad,tty,pin);
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
							}
						}else{
							try {
								Regest(tacc,tn,ta,tad,tty,pin);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}	
		            }
		            reader.close();
		        }catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
		private boolean isNum(String ta) {
			return ta.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		}
//		没有ID查重
		private void Regest(String acc,String a, String b, String c, String  d,String e) throws IOException{
			accountlist.add(acc);
			namelist.add(a);
			agelist.add(b);
			addresslist.add(c);
			typelist.add(d);
			pinlist.add(e);
			int len=namelist.size();
			String accountnum = accountlist.get(len-1);
			String name = namelist.get(len-1);
			String age = agelist.get(len-1);
	        String address = addresslist.get(len-1);
	        String type = typelist.get(len-1);
	        String pin = pinlist.get(len-1);
	    	String account = "0";
	        String inputFile = "id"+accountnum+"*/pin"+pin+"*/"+name+"/"+age+"/"+address+"/"+type+"/"+account;
	        list.add(new Acclist(name, address, age, type, accountnum, pin,account));
			int nn=list.size();
//			System.out.println(nn);
//			System.out.println(list.get(nn-1));
			textArea.setText("成功:"+list.get(nn-1));
			try{    
				FileWriter fw = new FileWriter("Regest.txt",true);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write(inputFile);
				writer.newLine();
				writer.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}		
			
		}
	}
}
