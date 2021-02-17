package quiz_Day20;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class MS_MainClass {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String stNum = null;
		String name;
		int kor;
		int eng;
		int mat;
		int avg;
		String grade;
		int select;
		int num;
		
		while(true) {
			System.out.println("1.�л� �˻�");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.print(">>>");
			select = sc.nextInt();
			switch(select) {
			case 1: 
				System.out.print("ã�� �л� �й� �Է� : ");
				stNum = sc.next();
				File path = new File("C://Users//Hyunwoo//Desktop//KG�ڷ�//�� ����//"+stNum+".txt");
				if(path.exists()) {
					FileInputStream fis = new FileInputStream(path);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					MemberShip fc = (MemberShip)ois.readObject();
				
					fc.print();
					
					ois.close(); bis.close(); fis.close();
					
				}else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
				
				break;
			case 2: 
				System.out.print("��� �л� �й� �Է� : ");
				stNum = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG�ڷ�//�� ����//"+stNum+".txt");
				if(path.exists()) {
					
					System.out.println("�ش� �л��� �̹� �����մϴ�!!!");
				}else {
					
					MemberShip member = new MemberShip();
					
					System.out.print("�̸� �Է� : ");
					name = sc.next();
					System.out.print("�������� �Է� : ");
					kor = sc.nextInt();
					System.out.print("�������� �Է� : ");
					eng = sc.nextInt();
					System.out.print("�������� �Է� : ");
					mat = sc.nextInt();
					avg = (kor+eng+mat)/3;
					if(avg>=90) {
						grade = (String)"A";
					}else if(avg<90 && avg>=80) {
						grade = (String)"B";
					}else if(avg<80 && avg>=70) {
						grade = (String)"C";
					}else if(avg<70 && avg>=60) {
						grade = (String)"D";
					}else grade = (String)"F";
					
					member.setstNum(stNum);
					member.setName(name);
					member.setKor(kor);
					member.setEng(eng);
					member.setMat(mat);
					member.setGrade(grade);
					
					path.createNewFile();
					FileOutputStream fos = new FileOutputStream(path);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos);
					
					oos.writeObject(member);
					
					oos.close(); bos.close(); fos.close();
					
					System.out.println("�л������� ���� �Ǿ����ϴ�.");
				}
				
				break;
			case 3: 
				System.out.print("������ �л� �й��� �Է� : ");
				stNum = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG�ڷ�//�� ����//"+stNum+".txt");
				if(path.exists()) {
					while(true) {
						/*FileInputStream fis = new FileInputStream(path);
						BufferedInputStream bis = new BufferedInputStream(fis);
						ObjectInputStream ois = new ObjectInputStream(bis);
						MemberShip fc = (MemberShip)ois.readObject();
						ois.close(); bis.close(); fis.close();*/
						System.out.println("������ ���� �Է�");
						System.out.println("1.�̸� 2.���� 3.���� 4.���� 5.����");
						System.out.print(">>>");
						num = sc.nextInt();
						
						switch(num){
						
							case 1:
								System.out.print("������ �̸� : ");
								name = sc.next();
								//fc.setName(name);
								//FileOutputStream fos = new FileOutputStream(path);
								//BufferedOutputStream bos = new BufferedOutputStream(fos);
								//ObjectOutputStream oos = new ObjectOutputStream(bos);
								
								//oos.writeObject(fc);
								
								//oos.close(); bos.close(); fos.close();
								break;
							case 2:
								System.out.print("������ ���� ���� : ");
								kor = sc.nextInt();
								//fc.setKor(kor);
								break;
							case 3:
								System.out.print("������ ���� ���� : ");
								eng = sc.nextInt();
								//fc.setEng(eng);
								break;
							case 4:
								System.out.print("������ ���� ���� : ");
								mat = sc.nextInt();
								//fc.setMat(mat);
								break;
							case 5:
								System.out.println("���������� �����մϴ�.");
								
								
								return;
							default :
								System.out.println("�߸� �����̽��ϴ�. �ٽ�!!!");
								break;
						}
						
					}
				}else {
					System.out.println("������ �л��� ��ϵǾ� ���� �ʽ��ϴ�.");
				}
				break;
			case 4: 
				System.out.println("���α׷��� �����մϴ�.");
				
				return;
			default : 
				System.out.println("�߸� �����̽��ϴ�. �ٽ�!!");
				break;
			}
		}
	}
}
