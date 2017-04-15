import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Detwithdrawals extends JFrame {
	private JPanel contentPane;
	private JTextField Money;
	public static String id;
	private JTextArea textArea;
	public static String inputFile;
	public void setInputFile(String inputFile){
		this.inputFile = inputFile;
	}
	public String getInputFile(){
		System.out.println(inputFile);
		return inputFile;
	}

	public static void main(final String id) throws IOException {
	
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
        					Detwithdrawals frame = new Detwithdrawals(id);
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        	}
		}
	}

	public Detwithdrawals(String id) {
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
		
		JLabel label = new JLabel("\u53D6\u6B3E");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		label.setBounds(231, 27, 146, 42);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(37, 122, 514, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton action = new JButton("\u786E\u5B9A");
		action.setBackground(Color.WHITE);
		action.setBounds(56, 246, 113, 27);
		panel_1.add(action);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.setBackground(Color.WHITE);
		back.setBounds(212, 246, 113, 27);
		panel_1.add(back);
		
		textArea = new JTextArea();
		textArea.setBounds(339, 46, 144, 183);
		panel_1.add(textArea);
		textArea.setLineWrap(true);
		
		JLabel label_1 = new JLabel("\u91D1\u989D");
		label_1.setBounds(56, 119, 72, 18);
		panel_1.add(label_1);
		
		Money = new JTextField();
		Money.setColumns(10);
		Money.setBounds(108, 116, 86, 24);
		panel_1.add(Money);
		
		JButton btnClose = new JButton("close");
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(349, 246, 113, 27);
		panel_1.add(btnClose);
		setLocationRelativeTo(null);
		back.addActionListener(new BackListener());
		action.addActionListener(new ButtonListener());
		btnClose.addActionListener(new CloseListener());
	}
	public class CloseListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Home.main(null);
			setVisible(false);
		}
	}
	public class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String[] duanluo = inputFile.split("/");
			String duan = duanluo[0];
			try {
				Withdrawals.main(duan);
				setVisible(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String textfund = Money.getText();
			if(textfund.isEmpty()){
				textArea.setText("输入金额");
				Money.requestFocus();
			}else if(isNum(textfund)==false){
				textArea.setText("写啥呢");
				Money.requestFocus();
			}else{
				int a = Integer.parseInt(textfund);
				String[] duanluo = inputFile.split("/");
				int b = Integer.parseInt(duanluo[6]);
				int c = b-a;
				String cc = String.valueOf(c);
				String str = inputFile.toString().replace(duanluo[6], cc);
				if(duanluo[5].equals("SaveAcc")){
					if(c<=0){
						textArea.setText("账户余额不足\n");
						textArea.append("剩余金额："+ duanluo[6]);
					}else{
						textArea.setText("取款成功\n"+"剩余金额：" + cc+"返回上一级或返回主界面");
						try {
				            FileReader fis = new FileReader("Regest.txt");// 创建文件输入流
				            char[] data = new char[1024];// 创建缓冲字符数组
				            int rn = 0;
				            StringBuilder sb = new StringBuilder();// 创建字符串构建器
				            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
				                String str1 = String.valueOf(data, 0, rn);
				                sb.append(str1);
				            }
				            fis.close();// 关闭输入流
				            // 从构建器中生成字符串，并替换搜索文本
				            String str1 = sb.toString().replace(inputFile, str);
				            FileWriter fout = new FileWriter("Regest.txt");// 创建文件输出流
				            fout.write(str1.toCharArray());// 把替换完成的字符串写入文件内
				            fout.close();// 关闭输出流
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					}
				}else if(duanluo[5].equals("JuniorAcc")){
					if(c<=0){
						textArea.setText("账户余额不足\n");
						textArea.append("剩余金额："+ duanluo[6]);
					}else{
						textArea.setText("取款成功\n"+"剩余金额：" + cc+"返回上一级或返回主界面");
						try {
				            FileReader fis = new FileReader("Regest.txt");// 创建文件输入流
				            char[] data = new char[1024];// 创建缓冲字符数组
				            int rn = 0;
				            StringBuilder sb = new StringBuilder();// 创建字符串构建器
				            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
				                String str1 = String.valueOf(data, 0, rn);
				                sb.append(str1);
				            }
				            fis.close();// 关闭输入流
				            // 从构建器中生成字符串，并替换搜索文本
				            String str1 = sb.toString().replace(inputFile, str);
				            FileWriter fout = new FileWriter("Regest.txt");// 创建文件输出流
				            fout.write(str1.toCharArray());// 把替换完成的字符串写入文件内
				            fout.close();// 关闭输出流
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					}
				}else if(duanluo[5].equals("CurrentAcc")){
					if(c<=0){
						textArea.setText("账户余额不足,您有1000透支额度");
						textArea.append("账户余额不足："+ duanluo[6]);
						if(c>=-1000){
							textArea.setText("取款成功\n"+"剩余金额：" + cc+"返回上一级或返回主界面");
							try {
					            FileReader fis = new FileReader("Regest.txt");// 创建文件输入流
					            char[] data = new char[1024];// 创建缓冲字符数组
					            int rn = 0;
					            StringBuilder sb = new StringBuilder();// 创建字符串构建器
					            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
					                String str1 = String.valueOf(data, 0, rn);
					                sb.append(str1);
					            }
					            fis.close();// 关闭输入流
					            // 从构建器中生成字符串，并替换搜索文本
					            String str1 = sb.toString().replace(inputFile, str);
					            FileWriter fout = new FileWriter("Regest.txt");// 创建文件输出流
					            fout.write(str1.toCharArray());// 把替换完成的字符串写入文件内
					            fout.close();// 关闭输出流
					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
						}
					}else{
						textArea.setText("取款成功\n"+"剩余金额：" + cc);
						try {
				            FileReader fis = new FileReader("Regest.txt");// 创建文件输入流
				            char[] data = new char[1024];// 创建缓冲字符数组
				            int rn = 0;
				            StringBuilder sb = new StringBuilder();// 创建字符串构建器
				            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
				                String str1 = String.valueOf(data, 0, rn);
				                sb.append(str1);
				            }
				            fis.close();// 关闭输入流
				            // 从构建器中生成字符串，并替换搜索文本
				            String str1 = sb.toString().replace(inputFile, str);
				            FileWriter fout = new FileWriter("Regest.txt");// 创建文件输出流
				            fout.write(str1.toCharArray());// 把替换完成的字符串写入文件内
				            fout.close();// 关闭输出流
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					}
					
				}

			}
		}

		private boolean isNum(String ta) {
			return ta.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		}
	}

}
