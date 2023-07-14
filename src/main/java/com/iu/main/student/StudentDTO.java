package com.iu.main.student;

public class StudentDTO {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	
	
	public long getStudNum() {
		return studNum;
	}

	public void setStudNum(long studNum) {
		this.studNum = studNum;
	}



	private long studNum;
	
	private String name;
	
	private int korean;
	
	private int english;
	
	private int math;
	
	private int total;
	
	private double avg;
	
	public void cal() {
		this.total = this.korean+this.english+this.math;
		this.avg = this.total/3;
				
	}

}
