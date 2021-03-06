package Team1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddSaving extends JFrame {

   private JPanel contentPane;
   private JTextField TF_sname;
   private JTextField TF_bname;
   private JTextField TF_term;
   private JTextField TF_maxsave;
   private JTextField TF_calculation;
   private JTextField TF_basic_interest;
   private JTextField TF_upgrade_interest;
   JPanel panel = new JPanel();
   JLabel label_7 = new JLabel("\uC0C1\uD488\uC815\uBCF4");
   JPanel panel_1 = new JPanel();
   JLabel label_6 = new JLabel("\uC0C1\uD488\uBA85");
   JLabel label = new JLabel("\uC740\uD589\uBA85");
   JLabel label_1 = new JLabel("\uC801\uAE08\uAE30\uAC04");
   JLabel label_2 = new JLabel(" \uCD5C\uB300 \uB0A9\uC785\uAC00\uB2A5 \uAE08\uC561 ");
   JLabel label_3 = new JLabel(" \uC774\uC790 \uACC4\uC0B0 \uBC29\uC2DD ");
   JLabel label_4 = new JLabel(" \uAE30\uBCF8\uAE08\uB9AC   ");
   JLabel lblNewLabel_1 = new JLabel("\uC6B0\uB300\uC870\uAC74");
   JLabel label_5 = new JLabel(" \uC6B0\uB300\uAE08\uB9AC ");
   JPanel panel_5 = new JPanel();
   JPanel panel_2 = new JPanel();
   JPanel panel_4 = new JPanel();
   JTextArea TF_upgrade_rate = new JTextArea();
   JPanel panel_3 = new JPanel();
   JButton btn_save = new JButton("\uC800\uC7A5");
   JButton btn_cancel = new JButton("\uCDE8\uC18C");
   private String sname;
   private String bname; 
   private String term;
   private String maxsave;
   private String calculation;
   private String basic_interest;
   private String upgrade_interest;
   private String upgrade_rate;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AddSaving frame = new AddSaving();
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
   public AddSaving() {
     display();
     event();
     
      
   }
  
   
private void event() {
   // TODO Auto-generated method stub
   btn_save.addActionListener(e->{                          //저장
      //값을 불러오고 
      
           try {
              Pattern sname_pattern = Pattern.compile("^[가-힣a-zA-Z0-9]{2,15}$");
               Matcher sname_match = sname_pattern.matcher(TF_sname.getText());
                if(sname_match.matches()) {
                   this.sname= TF_sname.getText();//상품
                   System.out.println("상품이름 저장됨");
                }
                else
                   System.out.println("특수문자 쓰면 안됨");
                
               Pattern bname_pattern = Pattern.compile("우리은행|국민은행|신한은행|한국투자저축은행|농협은행|기업은행");
                Matcher bname_match = bname_pattern.matcher(TF_bname.getText());
              
                if(bname_match.matches()) {
                   System.out.println("맞는 은행명");
                   this.bname= TF_bname.getText();//은행
                }
                else
                    System.out.println("우리은행,국민은행,신한은행,한국투자저축은행,농협은행,기업은행 으로 입력하세요");
                
                Pattern term_pattern = Pattern.compile("12개월");
                Matcher term_match = term_pattern.matcher(TF_term.getText());
                if(term_match.matches()) {
                   this.term= TF_term.getText();
                   System.out.println("기간입력 완료");
                }
                else {
                   System.out.println("12개월만 가능");
                }
                   
                Pattern maxsave_pattern = Pattern.compile("[1-9][0-9]{4,9}");
                Matcher maxsave_match = maxsave_pattern.matcher(TF_maxsave.getText());
                
                if(maxsave_match.matches()) {
                   this.maxsave= TF_maxsave.getText();
                   System.out.println("최대납입금 입력완료");
                }
                else
                   System.out.println("첫자리 0안되고, 만원부터 천만원대까지");
                
                Pattern calcul_pattern = Pattern.compile("단리|복리");
                Matcher calcul_match = calcul_pattern.matcher(TF_calculation.getText());
                if(calcul_match.matches()) {
                   this.calculation= TF_calculation.getText();
                   System.out.println("이자방식 입력 완료");
                }
                else
                   System.out.println("단리 혹은 복리만 입력 가능");
                
                Pattern binter_pattern = Pattern.compile("[0-9]+(.[0-9])");
                Matcher binter_match = binter_pattern.matcher(TF_basic_interest.getText());
                if(binter_match.matches()) {
                   this.basic_interest= TF_basic_interest.getText();
                   System.out.println("기본금리 입력완료");
                }
                else
                   System.out.println("소수점 첫자리 꼭 입력");
                   
                Pattern upinter_pattern = Pattern.compile("[0-9]+(.[0-9])");
                Matcher upinter_match = upinter_pattern.matcher(TF_upgrade_interest.getText());
                
                if(upinter_match.matches()) {
                   this.upgrade_interest= TF_upgrade_interest.getText();
                   System.out.println("우대금리 입력완료");
                }
                else
                   System.out.println("소수점 첫자리 꼭 입력");
                
                this. upgrade_rate = TF_upgrade_rate.getText();
                
                if(sname_match.matches()&&bname_match.matches()&&term_match.matches()&&maxsave_match.matches()&&calcul_match.matches()&&binter_match.matches()&&upinter_match.matches()){
                	System.out.println("정규식 조건 충족하여 Savings.txt에 저장메소드 실행");
                	Savings savings = new Savings(sname,bname,term,maxsave,calculation,basic_interest,upgrade_interest,upgrade_rate);
                	DBManager DBM = new DBManager();
                	DBM.savings_save(sname,savings);
                }
                
           	} catch (Exception e1){
           		e1.printStackTrace();
           		
           	}
       
       
      
//      String bname= TF_bname.getText();//은행
      
   
      
      
            
   });
   
   btn_cancel.addActionListener(e->{
       try {
              DBManager DBM = new DBManager();
              DBM.ShowSavings();
              dispose();
           } catch (Exception e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
           }
   });
}

private void display() {
   // TODO Auto-generated method stub
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 511);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    this.setVisible(true);
    
    contentPane.add(panel, BorderLayout.NORTH);
    
    label_7.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label_7);
    
    contentPane.add(panel_1, BorderLayout.WEST);
    panel_1.setLayout(new GridLayout(16, 1, 0, 0));
    
    label_6.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_6);
    
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label);
    
    label_1.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_1);
    
    label_2.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_2);
    
    label_3.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_3);
    
    label_4.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_4);
    
    label_5.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(label_5);
    
    panel_1.add(panel_5);
    
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    panel_1.add(lblNewLabel_1);
    
    contentPane.add(panel_2, BorderLayout.CENTER);
    panel_2.setLayout(null);
    
    
          
    TF_sname = new JTextField();
    TF_sname.setBounds(0, 7, 290, 24);
    TF_sname.setHorizontalAlignment(SwingConstants.LEFT);
    panel_2.add(TF_sname);
    TF_sname.setColumns(10);
    
    TF_bname = new JTextField();
    TF_bname.setBounds(0, 31, 290, 24);
    TF_bname.setHorizontalAlignment(SwingConstants.LEFT);
    TF_bname.setColumns(10);
    panel_2.add(TF_bname);
    
    TF_term = new JTextField();
    TF_term.setBounds(0, 55, 290, 24);
    TF_term.setHorizontalAlignment(SwingConstants.LEFT);
    TF_term.setColumns(10);
    panel_2.add(TF_term);
    
    TF_maxsave = new JTextField();
    TF_maxsave.setBounds(0, 79, 290, 24);
    TF_maxsave.setHorizontalAlignment(SwingConstants.LEFT);
    TF_maxsave.setColumns(10);
    panel_2.add(TF_maxsave);
    
    TF_calculation = new JTextField();
    TF_calculation.setBounds(0, 103, 290, 24);
    TF_calculation.setHorizontalAlignment(SwingConstants.LEFT);
    TF_calculation.setColumns(10);
    panel_2.add(TF_calculation);
    
    TF_basic_interest = new JTextField();
    TF_basic_interest.setBounds(0, 127, 290, 24);
    TF_basic_interest.setHorizontalAlignment(SwingConstants.LEFT);
    TF_basic_interest.setColumns(10);
    panel_2.add(TF_basic_interest);
    
    TF_upgrade_interest = new JTextField();
    TF_upgrade_interest.setBounds(0, 151, 290, 24);
    TF_upgrade_interest.setHorizontalAlignment(SwingConstants.LEFT);
    panel_2.add(TF_upgrade_interest);
    TF_upgrade_interest.setColumns(10);
    
    panel_4.setBounds(0, 175, 290, 24);
    panel_2.add(panel_4);
    panel_4.setLayout(null);
    
    TF_upgrade_rate.setBounds(0, 199, 290, 188);
    panel_2.add(TF_upgrade_rate);
    
//    scroll.setViewportView();
    
    contentPane.add(panel_3, BorderLayout.SOUTH);
    panel_3.setLayout(new GridLayout(1, 2, 0, 0));
    
    btn_save.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
       }
    });
    panel_3.add(btn_save);
    
    panel_3.add(btn_cancel);
}




}