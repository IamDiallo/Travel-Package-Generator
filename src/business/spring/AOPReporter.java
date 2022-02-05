package business.spring;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.JoinPoint;

import business.data.Hotel;


public class AOPReporter {
	private static final String REPORT_FILE = "./ProblemReport.txt";

	public void hotelEntry(JoinPoint joinPoint) {
		System.out.println("oui");
		Object[] args = joinPoint.getArgs();
		Hotel hotel = (Hotel) args[0];
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE, true));
			writer.write("Today you will stay at hotel : " + hotel.getName());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
