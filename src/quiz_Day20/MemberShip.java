package quiz_Day20;

import java.io.Serializable;

public class MemberShip implements Serializable{
	private String num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private String grade;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void print() {
		System.out.println("�й� : "+num);
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+num);
		System.out.println("���� : "+eng);
		System.out.println("���� : "+mat);
		System.out.println("��� : "+grade);
	}
}