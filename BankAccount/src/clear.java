import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;




public class clear extends JFrame {

	private JPanel contentPane;
	public static String inputFile;
	private JTextArea textArea;
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
					clear frame = new clear();
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
	public clear() {
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
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblClear.setBounds(221, 37, 156, 50);
		panel.add(lblClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton clear = new JButton("clear");
		clear.setBounds(56, 246, 113, 27);
		panel_1.add(clear);
		clear.setBackground(Color.WHITE);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 144, 183);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(212, 246, 113, 27);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new backListener());
		clear.addActionListener(new ButtonListener());
		setLocationRelativeTo(null);
	}
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Home.main(null);
			setVisible(false);
		}		
	}
	public class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			String tempString = null;
			String tempString1 = null;
			ArrayList<String> list = new ArrayList<String>();
			try {
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            File file = new File("unclearfunt.txt");
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            while ((tempString = reader.readLine()) != null) {
	            	String[] str = tempString.split("/");
	            	
	        		File file1 = new File("Regest.txt");
	        		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
	        		while ((tempString1 = reader1.readLine()) != null) {
	                	String[] str1 = tempString1.split("/");
	                	if(str[0].equals(str1[ 0 ])){
	                		textArea.setText("un-clear已经清空了");
	                		System.out.println(str1[1]);
	                		inputFile = str1[ 0 ]+"/"+str1[ 1 ]+"/"+str1[ 2 ]+"/"+str1[ 3 ]+"/"+str1[ 4 ]+"/"+str1[ 5 ]+"/"+str1[ 6 ];
	                		clear det = new clear();
	                		det.setInputFile(inputFile);
	                		det.getInputFile(); 
	                		int a = Integer.parseInt(str[1]);
							String[] duanluo = inputFile.split("/");
							int b = Integer.parseInt(duanluo[6]);
							int c = b+a;
							String cc = String.valueOf(c);
							String str2 = inputFile.toString().replace(duanluo[6], cc);
							try {
					            FileReader fis = new FileReader("Regest.txt");// 创建文件输入流
					            char[] data = new char[1024];// 创建缓冲字符数组
					            int rn = 0;
					            StringBuilder sb = new StringBuilder();// 创建字符串构建器
					            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
					                String str11 = String.valueOf(data, 0, rn);
					                sb.append(str11);
					            }
					            fis.close();// 关闭输入流
					            // 从构建器中生成字符串，并替换搜索文本
					            String str11 = sb.toString().replace(inputFile, str2);
					            FileWriter fout = new FileWriter("Regest.txt");// 创建文件输出流
					            fout.write(str11.toCharArray());// 把替换完成的字符串写入文件内
					            fout.close();// 关闭输出流
					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
						
	                	}
	                	
	        		}
	        		
	        		
	            	
	            	
	            	
	            }
	            reader.close();
	        }catch(IOException ex){
				ex.printStackTrace();
			}
			File f = new File("unclearfunt.txt");  // 输入要删除的文件位置
			if(f.exists())
			    f.delete();
		}
	}
}
