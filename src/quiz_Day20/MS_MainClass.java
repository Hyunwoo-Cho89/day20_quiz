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
				
					System.out.println("�й� : "+fc.getNum());
					System.out.println("�̸� : "+fc.getName());
					System.out.println("���� : "+fc.getKor());
					System.out.println("���� : "+fc.getEng());
					System.out.println("���� : "+fc.getMat());
					System.out.println("��� : "+fc.getGrade());
					
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
					System.out.print("��� �Է� : ");
					grade = sc.next();
					
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
					System.out.println("���Ϸ� ���� �Ǿ����ϴ�.");
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
