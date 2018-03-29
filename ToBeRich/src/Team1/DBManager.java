package Team1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DBManager {
	File Userdb;
	private Map<String,User> userinfo;
	
	public DBManager() throws ClassNotFoundException, IOException{
		// �����
		this.Userdb = new File("DB","user.txt");
			
		if(this.Userdb.exists()){
			try{
				System.out.println("������ �̹� �־ ������ �ҷ��ɴϴ�");
				FileInputStream in = new FileInputStream(Userdb);
				BufferedInputStream bufferin = new BufferedInputStream (in);
				ObjectInputStream datain = new ObjectInputStream(bufferin);
				userinfo  = (Map<String,User>) datain.readObject();
				datain.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else{
			System.out.println("������ ���� Ƽ��Ʈ ���� ���� ������ �����մϴ�");
			
			User defalt_user = new User("guak908","asdfasdf","������","����","guak908@hanmail.net");
			Map<String,User> defalt_map = new HashMap<String,User>();
			defalt_map.put("guak908", defalt_user);
			try{
				FileOutputStream dbout = new FileOutputStream(Userdb);
				BufferedOutputStream dbbufferout = new BufferedOutputStream(dbout);
				ObjectOutputStream dbdataout = new ObjectOutputStream(dbbufferout);
				dbdataout.writeObject(defalt_map);
				dbdataout.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	

	public void signup(String fid, User user){
		// ȸ������	
		boolean singupflg = true;  // true�� ȸ������ �Ϸ� 
		
		for(Map.Entry<String,User> m : userinfo.entrySet()){
		// ���̵� ��ġ �˻� ��ġ�� singupflg == false;
			if(m.getKey().equals(fid)){
				System.out.print("�ߺ�!! ");
				singupflg = false;
			}
		}
		
		if(singupflg == true){
			System.out.println("ȸ������ ���� ");
			Map<String,User> signupinfo = new HashMap<String, User>();
			signupinfo.put(fid, user);
			Map<String, User> mergeinfo = new HashMap<String, User>();
			mergeinfo.putAll(userinfo);
			mergeinfo.putAll(signupinfo);
			try{
				FileOutputStream out = new FileOutputStream(Userdb);
				BufferedOutputStream bufferout = new BufferedOutputStream(out);
				ObjectOutputStream dataout = new ObjectOutputStream(bufferout);
				dataout.writeObject(mergeinfo);
				dataout.flush();
				dataout.close();
				System.out.println("ȸ������ �Ϸ�");
			}catch(IOException e){
				System.out.print("DB ȸ������ ���� ����");
			}		
		}else{
			System.out.print("�̹� ��ġ�ϴ� ���̵� �ֽ��ϴ�!!");
		}
	}
	
	public User login(String id , String pwd){
		int i = 0;
		int user = 0;
		boolean pass=false;
		User target_user= null;
		for(Map.Entry<String,User> m : userinfo.entrySet()){
			if(m.getKey().equals(id)&&m.getValue().getPwd().equals(pwd)){
				i+=1;
				target_user =m.getValue();
				pass=true;
			}
			user++;
		}
			
		if(i ==1){
			System.out.println("�α��� ����");
			pass=true;
			
		}else if(i ==0)
			System.out.println("�α��� ����");
			
		else {
			System.out.println("�α��� ���� �߻�(�ߺ� ID �߻�)");
			
		}
		System.out.println("��ȸ�� : "+user+"��");
		
		if(pass==true){
			return target_user;
		}else
		return null;
				
	}
	
	public void ShowUser(){
		for (Map.Entry<String, User> entry : userinfo.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().print_member());
		}
	}
	
}