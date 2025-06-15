package com.jconsole.app;

import java.util.ArrayList;
import java.util.Random;

/**
 * <center>
 * <h1><B>PassWordHandler</B>
 * <h1><br>
 * </center> <b>
 * <p>
 * This class has two methods
 * </p>
 * <ol>
 * a.)pwdgenerater :-<br>
 * <br>
 * <li>This is to generate a strong password with the combination of Upper ,
 * Lower , Special Characters and Numeric Characters .</li>
 * <li>It also sends the generated password to the pwstrengthCheker method and
 * checks the password's strength if you are not satisfied with the result then
 * again execute the pwdgenerater()</li>
 * </ol>
 * <br>
 * 
 * b.)pwstrengthCheker :-<br>
 * <br>
 * <ol>
 * <li>This is to check the Password Strength and it gives the SOP statements so
 * kindly follow or consider that</li>
 * 
 * </ol>
 * </p>
 * </b>
 * <h2>@author Raviteja. J<br>
 * @email raviteja032766@gmail.com.</h2>
 */

public class PassWordHandler {
	protected static String[] upralp = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	protected static String[] loralp = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	protected static String[] splchr = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "[", "}", "]", ";", ":",
			"'", "<", ">", ".", "/", "?", "+", "-", "~", "`" };
	protected static String[] number = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	public static String pwdgenerater() {
		Random rn = new Random();
		StringBuilder genpwd = new StringBuilder();
		int rdnm = rn.nextInt(20);
		int rdln = rn.nextInt(5);
		int rdnu = rn.nextInt(5);
		if (rdln == 0) {
			rdln = rn.nextInt(5);
		}
		// System.out.print(rdln+" "+rdnm);
		for (int i = rdnm; i <= rdnm + rdln; i++) {
			genpwd.append(upralp[rn.nextInt(26)]);
			genpwd.append(loralp[rn.nextInt(26)]);
			genpwd.append(splchr[rn.nextInt(26)]);
		}
		for (int i = rdnu; i <= rdnu + rdln; i++) {
			genpwd.append(number[i]);
		}
		System.out.println("The generated Password is --->  " + genpwd.toString());
		if (genpwd.toString().length() <= 10) {
			pwdgenerater();
		}
		System.out.println(pwstrengthCheker(genpwd.toString()));
		return genpwd.toString();
	}

	public static String pwstrengthCheker(String word) {
		if (word.length() < 10) {
			return "Password Should be atlest 10 characters ";
		}
		ArrayList<String> wrdchr = new ArrayList<String>();
		int capcnt = 0;
		int smlcnt = 0;
		int splcnt = 0;
		int numbrr = 0;
		for (int i = 0; i <= word.length() - 1; i++) {
			char a = word.charAt(i);
			wrdchr.add(String.valueOf(a));
		}  //System.out.println("The array is ---> "+wrdchr);
		for (int m = 0; m <= wrdchr.size() - 1; m++) {

			for (int j = 0; j <= upralp.length - 1; j++) {
				if (upralp[j].equals(wrdchr.get(m))) {
					capcnt++;
				}
			}
			for (int k = 0; k <= loralp.length - 1; k++) {
				if (loralp[k].equals(wrdchr.get(m))) {
					smlcnt++;
				}
			}
			for (int l = 0; l <= splchr.length - 1; l++) {
				if (splchr[l].equals(wrdchr.get(m))) {
					splcnt++;
				}
			}
			for (int n = 0; n <= number.length - 1; n++) {
				if (number[n].equals(wrdchr.get(m))) {
					numbrr++;
				}
			}
		}
		/*
		 * System.out.println("\nthe captal lettres count is --->  " + capcnt);
		 * System.out.println("the small lettres count is --->  " + smlcnt);
		 * System.out.println("the special lettres count is --->  " + splcnt);
		 * System.out.println("the special lettres count is --->  " + numbrr);
		 */

		if (capcnt <= 0 || smlcnt <= 0 || splcnt <= 0 || numbrr <= 0) {
			System.out.println(
					"Please enter a password with combination of Upper , lower , special charactes and numbers \n\n and try again . \n\n Suggisition\n");
			if (capcnt == 0) {
				return "At lease one Upper Alphabits are mandetory for a Password";
			} else if (smlcnt == 0) {
				return "At lease one Lower Alphabits are mandetory for a Password";
			} else if (splcnt == 0) {
				return "At lease one Special Alphabits are mandetory for a Password";
			} else if (numbrr == 0) {
				return "At lease one Numeric are mandetory for a Password";
			} else {
				return "Pass valid input";
			}
		} else if (capcnt >= 1 || smlcnt >= 1 || splcnt >= 1 || numbrr >= 1) {
			if (capcnt >= 3 && smlcnt >= 3 && splcnt >= 3 && numbrr >= 3) {
				return "Your Password is very Strong";
			} else if (capcnt == 3 && smlcnt == 3 && splcnt == 3 && numbrr == 3) {
				return "Your Password is Strong";
			} else if (capcnt <= 2 && smlcnt <= 2 || splcnt == 2 && numbrr == 2) {
				return "Your Password is 1 low Midiam Strong";
			} else if (capcnt == 2 && smlcnt == 2 || splcnt <= 2 && numbrr <= 2) {
				return "Your Password is 2 low midiam Strong";
			} else if (capcnt <= 2 || smlcnt == 2 && splcnt == 2 && numbrr <= 2) {
				return "Your Password is 3 low midiam Strong";
			} else if (capcnt == 2 && smlcnt == 2 && splcnt == 2 || numbrr <= 2) {
				return "Your Password is 4 low midiam Strong";
			} else if (capcnt == 2 && smlcnt == 2 && splcnt == 2 && numbrr == 2) {
				return "Your Password is Midiam Strong";
			} else {
				return "Your Password is 5 low Midiam Strong";
			}
		} else if (capcnt == 1 && smlcnt == 1 && splcnt == 1 && numbrr == 1) {
			System.out.println(
					"Your Password is week \n Suggisition Add more characters of Upper , lower , special charactes and numbers");
			return "Your Password is week";
		} else {
			return "Please pass a valid password";
		}

	}

	public static void main(String[] args) {
		pwdgenerater();
		// System.out.println(pwstrengthCheker("PASass123!@#"));
	}

}
