package com.company;

public class Main {

    public static void main(String[] args) {
	int tosecond = 50391;
	int hour_out = 0, min_out = 0, seconds_out = 0;
	hour_out = tosecond / 3600;
	min_out = (tosecond - hour_out * 3600) / 60;
	seconds_out = tosecond - hour_out * 3600 - min_out * 60;
	System.out.println("Hour is:" + hour_out);
    System.out.println("Min is:" + min_out);
    System.out.println("Second is:" + seconds_out);

    }
}
