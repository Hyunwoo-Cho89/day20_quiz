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
			System.out.println("1.학생 검색");
			System.out.println("2.등록");
			System.out.println("3.수정");
			System.out.println("4.종료");
			System.out.print(">>>");
			select = sc.nextInt();
			switch(select) {
			case 1: 
				System.out.print("찾을 학생 학번 입력 : ");
				stNum = sc.next();
				File path = new File("C://Users//Hyunwoo//Desktop//KG자료//새 폴더//"+stNum+".txt");
				if(path.exists()) {
					FileInputStream fis = new FileInputStream(path);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					MemberShip fc = (MemberShip)ois.readObject();
				
					fc.print();
					
					ois.close(); bis.close(); fis.close();
					
				}else {
					System.out.println("해당 학생은 존재하지 않습니다.");
				}
				
				break;
			case 2: 
				System.out.print("등록 학생 학번 입력 : ");
				stNum = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG자료//새 폴더//"+stNum+".txt");
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
					
					System.out.println("학생정보가 저장 되었습니다.");
				}
				
				break;
			case 3: 
				System.out.print("수정할 학생 학번을 입력 : ");
				stNum = sc.next();
				path = new File("C://Users//Hyunwoo//Desktop//KG자료//새 폴더//"+stNum+".txt");
				if(path.exists()) {
					while(true) {
						/*FileInputStream fis = new FileInputStream(path);
						BufferedInputStream bis = new BufferedInputStream(fis);
						ObjectInputStream ois = new ObjectInputStream(bis);
						MemberShip fc = (MemberShip)ois.readObject();
						ois.close(); bis.close(); fis.close();*/
						System.out.println("수정할 내용 입력");
						System.out.println("1.이름 2.국어 3.영어 4.수학 5.종료");
						System.out.print(">>>");
						num = sc.nextInt();
						
						switch(num){
						
							case 1:
								System.out.print("변경할 이름 : ");
								name = sc.next();
								//fc.setName(name);
								//FileOutputStream fos = new FileOutputStream(path);
								//BufferedOutputStream bos = new BufferedOutputStream(fos);
								//ObjectOutputStream oos = new ObjectOutputStream(bos);
								
								//oos.writeObject(fc);
								
								//oos.close(); bos.close(); fos.close();
								break;
							case 2:
								System.out.print("변경할 국어 점수 : ");
								kor = sc.nextInt();
								//fc.setKor(kor);
								break;
							case 3:
								System.out.print("변경할 영어 점수 : ");
								eng = sc.nextInt();
								//fc.setEng(eng);
								break;
							case 4:
								System.out.print("변경할 수학 점수 : ");
								mat = sc.nextInt();
								//fc.setMat(mat);
								break;
							case 5:
								System.out.println("정보수정을 종료합니다.");
								
								
								return;
							default :
								System.out.println("잘못 누르셨습니다. 다시!!!");
								break;
						}
						
					}
				}else {
					System.out.println("수정할 학생이 등록되어 있지 않습니다.");
				}
				break;
			case 4: 
				System.out.println("프로그램을 종료합니다.");
				
				return;
			default : 
				System.out.println("잘못 누르셨습니다. 다시!!");
				break;
			}
		}
	}
}
