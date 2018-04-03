package Team1;


import java.awt.Font;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Board_show extends JFrame{
   //DS ��������� ��� �� ���� ���� ��ġ�� ������
   JPanel mainPanel = new JPanel();
   JLabel lblNewLabel = new JLabel("����");
   JTextField textField = new JTextField();
   JLabel label = new JLabel("��ȣ");
   JTextField textField_1 = new JTextField();
   JLabel label_1 = new JLabel("��¥");
   JTextField textField_2 = new JTextField();
   //DS �̹����� ���� �� ���� ����
   JLabel imgLabel;
   JTextArea textArea_1 = new JTextArea();
   JTextArea textArea_2 = new JTextArea();
   JTextArea textArea_3 = new JTextArea();
   JButton edit_button = new JButton("\uC218\uC815/\uC0AD\uC81C");
   //DS DB��� ����
   private File target = new File("DB","board.txt");
   private Image img = null;
   //DS �̹��� ��ΰ� ���� �� ���� ����
   private File imgPath;
   //DS �Խ��� ��ȣ�� ���� �Ǵ� ����
   private int number;
   //DS Ŭ���� �Խù��� map�����͸� ������ ������ map,list����
   private Map<Integer,List<Object>> map = new HashMap<>();
   private List<Object> list = new ArrayList();
   
   
   //main�� �ϴ� �������� �����ڿ��� ����
   public Board_show(int number) {
	   //DS �����ڿ��� �Խù� ��ȣ�� ���� �޾� number������ �����Ѵ�
	  this.number = number;
	  //DS DB���� ��ü map�����͸� �ҷ��ͼ� number�� �ش��ϴ� map�����͸��� list�� �����Ѵ�
	  try{
		  //DS DB���� �о���� ��Ʈ�� ����
		  ObjectInputStream mapInput = new ObjectInputStream(
		  new BufferedInputStream(new FileInputStream(target)));
		  //DS DB���� ��ü map ������ �ҷ��� ���� map�� ����
		  map = (Map<Integer,List<Object>>)mapInput.readObject();
		  //DS ���� map���� number(�Խù� ��ȣ)�� �ش��ϴ� key���� value���� ���� list�� ����
		  list = map.get(number);
		  //System.out.println(list.get(1)); //DS DB���� ������ �ش� �Խù� ������ Ȯ���� �� �ִ�
	  }catch(Exception e) {
		  System.out.println("DB���� �����͸� ������ �� ����");
	  }
	  
	  //DS �����ڸ� ���� �Խù� Ȯ�� ���� �� ������ ��ȸ���� 1�� �����ϴ� �޼ҵ� ȣ��
	  BoardControl bc = new BoardControl();
	  bc.viewAdd(map,number);
	  
	  //DS �����ڿ��� list�� 2�ε��� �����͸� �޾� �̹��� ��θ� �����ϰ� 
	  //�̹��� ��θ� ImageŸ������ ��ȯ�� �����Ѵ�
	  try {
	    	imgPath = (File)list.get(2);
			img = ImageIO.read(imgPath);
		} catch (IOException e) {
			System.out.println("�̹��� ������ �����ϴ�.");
		}
	  //DS ImageŸ���� ������ ImageIcon���� ��ȯ �� ���� Ŭ���� Ÿ���� JLabel�� �����Ѵ�
	  imgLabel = new JLabel(new ImageIcon(img));
	  
      this.display();//ȭ�� ���� ���� ó��
      this.event();//�̺�Ʈ ���� ó��
      this.menu();//�޴� ���� ó��
      
      this.setTitle("�Խ��� ���� Ȯ��");
      this.setSize(1000, 600);
      //this.setLocation(100, 100);
      //��ġ�� �ü���� �����ϵ��� �Ѵ�
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.setVisible(true);
   }

   private void display() {
      this.setContentPane(mainPanel);
      mainPanel.setLayout(null);
      
     
      lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
      lblNewLabel.setBounds(12, 10, 28, 21);
      mainPanel.add(lblNewLabel);
      
      
      label.setFont(new Font("����", Font.PLAIN, 14));
      label.setBounds(254, 10, 28, 21);
      mainPanel.add(label);
      
      
      label_1.setFont(new Font("����", Font.PLAIN, 14));
      label_1.setBounds(495, 10, 28, 21);
      mainPanel.add(label_1);
      textField.setEditable(false);
      
      
      textField.setBounds(47, 11, 145, 26);
      mainPanel.add(textField);
      //DS list�� 0�ε���(����)�� �ʵ忡 ä��
      textField.setText((String)list.get(0));
      textField_1.setEditable(false);
      
      
      textField_1.setColumns(10);
      textField_1.setBounds(294, 11, 145, 26);
      mainPanel.add(textField_1);
      //DS Main_Form���� ���� �Խ��� ��ȣ(number)�� �ʵ忡 ä��
      textField_1.setText(String.valueOf(number));
      textField_2.setEditable(false);
      
      textField_2.setColumns(10);
      textField_2.setBounds(535, 11, 167, 26);
      mainPanel.add(textField_2);
      //DS list�� 5�ε���(��¥)�� �ʵ忡 ä��
      textField_2.setText((String)list.get(5));
      
      //DS �̹� �����ڿ��� ���� �̹����� ��� �ִ� imgLabel������ ���� ��ġ�� �����Ѵ�
      imgLabel.setBounds(12, 41, 481, 320);
      mainPanel.add(imgLabel);
      textArea_1.setEditable(false);
      
      
      textArea_1.setBounds(505, 41, 197, 320);
      mainPanel.add(textArea_1);
      textArea_1.setText((String)list.get(3));
      
      JScrollPane scroll = new JScrollPane(textArea_1);
      scroll.setBounds(505, 41, 197, 320);
      mainPanel.add(scroll);
      textArea_2.setEditable(false);
      
      
      textArea_2.setBounds(12, 371, 690, 130);
      mainPanel.add(textArea_2);
      
      JScrollPane scroll_1 = new JScrollPane(textArea_2);
      scroll_1.setBounds(12, 371, 690, 130);
      mainPanel.add(scroll_1);
      textArea_3.setEditable(false);
      
      
      textArea_3.setBounds(720,30,240,500);
      mainPanel.add(textArea_3);
      
      
      edit_button.setBounds(605, 511, 97, 45);
      mainPanel.add(edit_button);
   }

   private void event() {
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      //DS ���� ��ư�� ������ �� �̺�Ʈ ����
      edit_button.addActionListener(e->{
    	  Board_main bm = new Board_main(number);
      });
      
   }

   private void menu() {
      
   }



//   public static void main(String[] args) {
//      /*
////��Ų ��ġ
//      try {
//         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//      } catch (Exception e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      */
//      //â�� ���̻� ���� ������ �ʰ� Ȯ���Ų Ŭ������ �ν��Ͻ��� ����
//	   Board_main window = new Board_main();
//      
//   }
}