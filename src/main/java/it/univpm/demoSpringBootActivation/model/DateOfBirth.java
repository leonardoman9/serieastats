package it.univpm.demoSpringBootActivation.model;

public class DateOfBirth {
	private int year;
	private int month;
	private int day;
	public DateOfBirth(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public DateOfBirth() {
		this.year = 1900;
		this.month = 1;
		this.day = 1;
	}
	public DateOfBirth(String first, String second, String third) {
		this.year = Integer.parseInt(first);
		this.month= Integer.parseInt(second);
		this.day = Integer.parseInt(third);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
