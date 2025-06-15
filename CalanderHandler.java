package com.jconsole.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <center>
 * <h1>CalanderHandler</h1></center> <b>
 * <p>
 * This class is used to handel date related operation or calander related
 * operations . This class has 3 static methods
 * </p>
 * <ui>
 * <li>eroju</li>
 * <li>stdateconverter</li>
 * <li>agefinder</li> </ui>
 * 
 * <ol>
 * <li>eroju <br>
 * &nbsp;
 * <p>
 * This is a simple method method that returns todays date that uses LocalDate
 * in java or system date of the divice .
 * </p>
 * </li> <br>
 * <li>stdateconverter <br>
 * &nbsp;
 * <p>
 * This method is used to convert the inparamater string to date formate
 * (Localdate formate) the inparamater cane be like
 * 
 * @example stdateconverter("2025/04/23");<br>
 *          stdateconverter("2025-04-23");
 *          </p>
 *          </li> <br>
 *          <li>agefinder <br>
 *          &nbsp;
 *          <p>
 *          This method is used to find the age like youy live years , months ,
 *          days , houres , minites , seconds by taking a inparamater as a
 *          String date of birth
 *          </p>
 *          </li>
 * 
 *          </ol>
 *          <b>
 *          <h2>@author Raviteja .J</h2>
 */
public class CalanderHandler {

	private static LocalDate Date = null;

	public static LocalDate eroju() {
		return LocalDate.now();
	}

	public static String today(int yyyy, int mm, int dd, String changer) {
		LocalDate lc = LocalDate.of(yyyy, mm, dd);

		if (lc.isAfter(LocalDate.now())) {
			System.out.println("date is after ");
		} else {
			System.out.println(lc);
		}
		return "";
	}

	public static LocalDate stdateconverter(String dt) {
		int suparater_cnt = 0;
		char suparater = ' ';
		if (dt.isEmpty() || dt.equals("") || dt == null) {
			System.err.println("Cant process empty values ");
			return Date;
		}
		try {
			for (int i = 0; i <= dt.length() - 1; i++) {

				if (dt.charAt(i) == '-' || dt.charAt(i) == '/' || dt.charAt(i) == ',') {
					suparater_cnt++;
					suparater = dt.charAt(i);
				}
			}
			if (suparater_cnt == 2) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy" + suparater + "MM" + suparater + "dd");
				LocalDate date = LocalDate.parse(dt, formatter);
				Date = date;
				// System.out.println(date);
			}
			return Date;
		} catch (Exception e) {
			System.err.println("Date formate is missmatch kindly enter the date in [yyyy-mm-dd]");
			return Date;
		}
	}

	public static String agefinder(String dob) {
		if (dob.isEmpty() || dob.equals(" ") || dob.equals(null)) {
			System.out.println("Pass a valid date to process");
			return "Invalid date Formate";
		}

		LocalDate date = stdateconverter(dob);
		if (date.isAfter(eroju())) {
			System.out.println("You entered a future date . I think you are time michean traveler .");
			return "Invalid date of birth";
		}

		String finalvalue = null;

		int nowyear = eroju().getYear();
		int dob_years = date.getYear();

		int no_years = nowyear - dob_years;
		int no_days = date.getDayOfYear() * no_years;
		int no_months = date.getDayOfYear() * 12;
		int no_houres = no_days * 24;
		int no_minites = no_houres * 60;
		int no_seconds = no_minites * 60;

		finalvalue = "\nNo of days you live --->  " + no_days + "\nNo of months you lived --->  " + no_months
				+ "\nNo of years you lived --->  " + no_years + "\nNo of houres you lived --->  " + no_houres
				+ "\nNo of minites you lived --->  " + no_minites + "\nNo of seconds you lived --->  " + no_seconds;
		return finalvalue;
	}

	public static void main(String[] args) {
		// System.out.println(eroju());
		// today(2025,04,23,"+1");
		// stdateconverter("2025/04/23");
		System.out.println(agefinder("2002-10-04"));
		//System.out.println(eroju());
	}

}
