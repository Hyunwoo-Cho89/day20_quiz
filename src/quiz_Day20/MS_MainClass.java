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
				
					System.out.println("학번 : "+fc.getNum());
					System.out.println("이름 : "+fc.getName());
					System.out.println("국어 : "+fc.getKor());
					System.out.println("영어 : "+fc.getEng());
					System.out.println("수학 : "+fc.getMat());
					System.out.println("등급 : "+fc.getGrade());
					
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
					System.out.print("등급 입력 : ");
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
					System.out.println("파일로 저장 되었습니다.");
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
