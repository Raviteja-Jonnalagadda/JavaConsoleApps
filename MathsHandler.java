package com.jconsole.app;

import java.util.LinkedList;
import java.util.Scanner;

public class MathsHandler {

	private static Scanner sc = new Scanner(System.in);
	private static LinkedList<String> detail_cal = new LinkedList<String>();

	public static int calculater(int fn, String sign, int sn) {
		int ans = 0;
		switch (sign) {
		case "+":
			ans = fn + sn;
			break;

		case "-":
			ans = fn - sn;
			break;

		case "*":
			ans = fn * sn;
			break;

		case "/":
			if (fn <= 0) {
				System.out.println("cant dived with 0 or leser then 0 ");
				break;
			}
			ans = fn / sn;
			break;

		default:
			ans = 0;
			break;
		}

		return ans;
	}

	public static String operfinder(String operationval) {
		String s = operationval;
		s = s + "‰";
		LinkedList<String> lsh = new LinkedList<String>();
		int stval = 0;
		for (int i = 0; i < s.length(); i++) {
			char chr = s.charAt(i);
			if (chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '‰') {
				lsh.add(s.substring(stval, i));
				lsh.add("" + s.charAt(i));
				stval = i + 1;
			}
		}
		// System.out.println(lsh);
		int spiker = 0;
		int carry = 0;
		int fnm = 0;
		String sign = null;
		int snm = 0;
		for (int i = 0; i < lsh.size(); i++) {
			String currentval = lsh.get(i);
			if (currentval.equals("/") || currentval.equals("+") || currentval.equals("-") || currentval.equals("*")
					|| currentval.equals("‰")) {

			} else {
				if (carry == 0) {
					fnm = Integer.valueOf(lsh.get(i));
				}
				sign = String.valueOf(lsh.get(i + 1));
				if (sign.equals("‰")) {
					break;
				}
				snm = Integer.valueOf(lsh.get(i + 2));
				carry = calculater(fnm, sign, snm);
				detail_cal.add("|  " + fnm + "  " + sign + "  " + snm + " = " + carry+" |");
				fnm = carry;
				spiker = spiker + 2;
			}
		}
		System.out.println("ans --->  [ " + carry + " ]");

		return String.valueOf(carry);
	}

	public static String calc() {
		String result = null;
		while (true) {
			System.out.println("Enter the complet mathematical operation (exp :- 1+2-1*6/2)");
			String val = sc.nextLine();
			if (val.isEmpty() || val.equals(" ") || val.equals(null)) {
				System.out.println("Cant process Null values");
				continue;
			} else {
				result = operfinder(val);
				System.out.println("Do you want to see the detailed explaination \n [Y] Yes\n [N] No");
				String sum_explain = sc.nextLine();
				if (sum_explain.equalsIgnoreCase("Y")) {
					System.out.println("+----------------+   ");
					detail_cal.forEach(details -> System.out.println(details));
					System.out.println("+-----------------+   ");
				}
				break;
			}
		}
		return result;

	}
	
	public static String evodfinder(int val) {
		String even_pattren = "02468";
		String lastval = String.valueOf(val).substring(String.valueOf(val).length()-1);
		System.out.println(lastval);
		if(even_pattren.indexOf(lastval) != -1) {
			return "EVEN";
		}
		else {
			return "ODD";
		}
			}

	public static void main(String[] args) {
		//calc();
		System.out.println(evodfinder(52223245));
	}

}
