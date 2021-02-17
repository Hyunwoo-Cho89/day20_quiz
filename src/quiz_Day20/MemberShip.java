package quiz_Day20;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MemberShip implements Serializable{
	private String stNum;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private String grade;
	public String getstNum() {
		return stNum;
	}
	public void setstNum(String stNum) {
		this.stNum = stNum;
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
		System.out.println("학번 : "+stNum);
		System.out.println("이름 : "+name);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+mat);
		System.out.println("등급 : "+grade);
	}
}
