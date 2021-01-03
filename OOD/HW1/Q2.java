package com.company;

public class Main {
	//part 1
    public static void main(String[] args) {
	int i = 987654321;
	String x;
	x = String.valueOf(i);
	int length = x.length();
	System.out.println(length);

	//part 2
	double d = 1234897.123555;
	String y;
	y = String.valueOf(d);
	String[] result = y.split("\\.");
	System.out.println(result[0].length() + result[1].length());
    }
}
