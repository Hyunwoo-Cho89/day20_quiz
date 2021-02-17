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
		String num = null;
		String name;
		int kor;
		int eng;
		int mat;
		int avg;
		String grade;
		int select;
		
		while(true) {
			System.out.println("1.�л� �˻�");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.print(">>>");
			select = sc.nextInt();
			switch(select) {
			case 1: 
				System.out.print("ã�� �л� �й� �Է� : ");
				num = sc.next();
				File path = new File("C://Users//Hyunwoo//Desktop//KG�ڷ�//Membership//"+num+".txt");
				if(path.exists()) {
					FileInputStream fos = new FileInputStream(path);
					BufferedInputStream bos = new BufferedInputStream(fos);
					ObjectInputStream oos = new ObjectInputStream(bos);
					
					MemberShip fc = (MemberShip)oos.readObject();
				
					fc.print();
					
					oos.close(); bos.close(); fos.close();
					
				}else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
				
				break;
			case 2: 
				System.out.print("��� �л� �й� �Է� : ");
				num = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG�ڷ�//Membership//"+num+".txt");
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
					
					member.setNum(num);
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default : 
				System.out.println("�߸� �����̽��ϴ�. �ٽ�!!");
				break;
			}
		}
	}
}
