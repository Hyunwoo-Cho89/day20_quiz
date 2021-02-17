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
			System.out.println("1.학생 검색");
			System.out.println("2.등록");
			System.out.println("3.종료");
			System.out.print(">>>");
			select = sc.nextInt();
			switch(select) {
			case 1: 
				System.out.print("찾을 학생 학번 입력 : ");
				num = sc.next();
				File path = new File("C://Users//Hyunwoo//Desktop//KG자료//Membership//"+num+".txt");
				if(path.exists()) {
					FileInputStream fos = new FileInputStream(path);
					BufferedInputStream bos = new BufferedInputStream(fos);
					ObjectInputStream oos = new ObjectInputStream(bos);
					
					MemberShip fc = (MemberShip)oos.readObject();
				
					fc.print();
					
					oos.close(); bos.close(); fos.close();
					
				}else {
					System.out.println("해당 학생은 존재하지 않습니다.");
				}
				
				break;
			case 2: 
				System.out.print("등록 학생 학번 입력 : ");
				num = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG자료//Membership//"+num+".txt");
				if(path.exists()) {
					
					System.out.println("해당 학생은 이미 존재합니다!!!");
				}else {
					
					MemberShip member = new MemberShip();
					
					System.out.print("이름 입력 : ");
					name = sc.next();
					System.out.print("국어점수 입력 : ");
					kor = sc.nextInt();
					System.out.print("영여점수 입력 : ");
					eng = sc.nextInt();
					System.out.print("수학점수 입력 : ");
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
					
					System.out.println("학생정보가 저장 되었습니다.");
				}
				
				break;
			case 3: 
				System.out.println("프로그램을 종료합니다.");
				return;
			default : 
				System.out.println("잘못 누르셨습니다. 다시!!");
				break;
			}
		}
	}
}
