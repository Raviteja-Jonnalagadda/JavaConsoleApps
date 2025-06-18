/**
 * The HtmlPageBuilder class provides methods to dynamically generate HTML pages
 * with various form elements based on user input. It supports creating different
 * input fields, options, redirections, and themes for the generated HTML page.
 * 
 * <p>This class is designed as a console-based application where users can input
 * field types, names, options, and themes to build a complete HTML form page.</p>
 * 
 * <p>Usage flow includes: selecting field types, entering field names, configuring
 * options, choosing themes, and finally generating the HTML page output.</p>
 * 
 * <p>Note: This class uses static methods and variables for simplicity and state management.</p>
 * @author Raviteja J
 */

package com.jconsole.app;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class HtmlPageBuilder {

     /**
     * Scanner instance for user input.
     */
	protected static Scanner sc = new Scanner(System.in);
     /**
     * Theme preference for the page ('D' for Dark, 'L' for Light).
     */
	protected static String page_theam = null;
     /**
     * Background color of the page.
     */
	protected static String bgcolor = null;
	
	protected static String txcolor = null;
	protected static int opt_num = 1;
	protected static LinkedHashMap<String, String> field_options = new LinkedHashMap<String, String>();
	protected static StringBuilder fieldnamebuilder = new StringBuilder();
	protected static String dispval = null;
	protected static String inval = null;

	public static String commandprocesser(String fldtyp, String fldnam) {

		if (fldtyp.isEmpty() || fldtyp.equals(" ") || fldtyp.equals(null)) {
			return "NULFLD";
		}
		char[] a = fldnam.toCharArray();
		String lab_name = null;
		for (char b : a) {
			if (b == '_') {
				fieldnamebuilder.append(" ");
			} else {
				fieldnamebuilder.append(b);
			}
		}
		lab_name = fieldnamebuilder.toString();
		fieldnamebuilder.delete(0, fieldnamebuilder.toString().length());
		StringBuilder sb = new StringBuilder();
		String field = null;
		switch (fldtyp) {

		case "IPT":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='text' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;

		case "IPN":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='number' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;

		case "IPP":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='password' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;

		case "IPF":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='file' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;

		case "IPE":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='email' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;

		case "IPTL":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='tel' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		case "IPC":
			field = "\n  <tr>\n  <td><input type ='checkbox' id ='" + fldnam + "' name ='" + fldnam + "' /><label for='"
					+ fldnam + "' id='lab_" + fldnam + "'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lab_name
					+ "</label></td>\n  </tr> \n";
			break;
		case "IPB":
			field = "\n  <tr>\n    <td><input type ='button' value ='" + lab_name + "' id ='bt_" + fldnam + "' name ='"
					+ fldnam + "' /></td>\n  </tr> \n";
			break;
		case "IPCL":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='color' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		case "IPH":
			field = "\n  <tr>\n     <td><input type ='hidden' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		case "IPR":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='range' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		case "IPTM":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='time' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		case "IPSL":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td>\n      <Select id ='" + fldnam + "' > \n" + field_options.get(lab_name)
					+ "      </Select>\n</td>\n  </tr> \n";
			break;
		case "IPRD":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td>\n      " + field_options.get(lab_name) + "      </td>\n  </tr> \n";
			break;
		case "IPS":
			field = "\n  <tr>\n    <td><input type ='submit' value ='" + lab_name + "' id ='" + fldnam + "' name ='"
					+ fldnam + "' /></td>\n  </tr> \n";
			break;
		case "IPHD":
			field = "\n  <tr>\n    <td><h2 id ='" + fldnam + "'>" + lab_name + " </h2></td>\n  </tr> \n";
			break;
		case "IPA":
			System.out.println(field_options + "  Present Finding is --->  " + fldnam);
			field = "\n  <tr>\n    <td>\n" + field_options.get(fldnam) + "\n</td>\n  </tr> \n";
			break;
		case "IPI":
			System.out.println(field_options + "  Present Finding is --->  " + fldnam);
			field = "\n  <tr>\n    <td>\n" + field_options.get(fldnam) + "\n</td>\n  </tr> \n";
			break;
		case "IPRS":
			field = "\n  <tr>\n    <td><input type ='reset' value ='" + lab_name + "' id ='" + fldnam + "' name ='"
					+ fldnam + "' /></td>\n  </tr> \n";
			break;
		case "IPD":
			field = "\n  <tr>\n    <td><label for='" + fldnam + "' id='lab_" + fldnam + "'>" + lab_name
					+ "</label></td>\n    <td><input type ='date' id ='" + fldnam + "' name ='" + fldnam
					+ "' /></td>\n  </tr> \n";
			break;
		default:
			field = "FDMSMT";
			break;
		}
		if (field.equals("FDMSMT")) {
			return "<!-- No fields matched for the field type [" + fldtyp + "] -->";
		} else {
			sb.append(field);
			return sb.toString();
		}
	}

	public static String pagegenerater(LinkedHashMap<String, String> elements) {
		if (elements.isEmpty() || elements.size() <= 0) {
			System.out.println("Pass the valid date to process");
			return "DATERR";
		}
		String html_top_syntax = "\n================================================================================[ Copy the Below Code and Use ]========================================================================================\n\n<!DOCTYPE html>\n<html lang='en'>\n  <head>\n  <meta charset='UTF-8'>\n  <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n  <title>Jconsole App</title>\n  \n\t<style>\n\t\tbody{\n\t\tbackground:"
				+ bgcolor + ";\n\t\tfont-size:20px;\n\t\tpadding:30px;\n\t\tcolor:" + txcolor
				+ ";\n\t\t}\n\t</style>\n\n<link rel='stylesheet' href='style.css'> <!-- Optional -->\n  <script src='script.js' lang='JavaScript' ></script> <!-- Optional --> \n</head>\n<body>\n<form action='jconsoleapp' method='POST'>\n<table>\n";
		String html_bottam_syntax = "\n\n</table>\n</form>\n</body>\n</html>\n";
		StringBuilder sb = new StringBuilder();
		StringBuilder fieldbuilder = new StringBuilder();
		Set<String> keys = elements.keySet();

		keys.forEach(key -> fieldbuilder.append(commandprocesser(elements.get(key), key)));

		sb.append(html_top_syntax);
		sb.append(fieldbuilder);
		sb.append(html_bottam_syntax);

		return sb.toString();
	}

	public static String optionsbuilder(String fld_type, String fld_name) {
		LinkedList<String> ls = new LinkedList<String>();
		System.out.println("Enter options with ',' saparater (exp :- option1,option2,option3) ");
		String b = sc.nextLine();
		b = b + ",";
		StringBuilder selectoptionsBuilder = new StringBuilder();
		if (b.isEmpty() || b.equals(" ") || b.equals(null)) {
			System.out.println("enter the options and try again");
		}
		int c = 0;
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == ',') {
				ls.add(b.substring(c, i));
				c = i + 1;
			}
		}
		c = 0;
		System.out.println(ls);
		if (fld_type.equalsIgnoreCase("IPSL")) {
			ls.forEach(lsval -> {
				inval = fieldspaceremover(lsval);
				selectoptionsBuilder.append("<option id= 'opt" + opt_num + inval + "' >  " + lsval + "  </option>\n");
				opt_num++;
			});
		} else if (fld_type.equalsIgnoreCase("IPRD")) {
			ls.forEach(lsval -> {
				inval = fieldspaceremover(lsval);
				selectoptionsBuilder.append("<input type='radio' id='opt" + opt_num + inval + " 'name='" + fld_name
						+ "' >  <label for ='" + inval + "'> " + lsval + "  </label>\n");
				opt_num++;
			});
		}
		ls.clear();
		opt_num = 0;
		return selectoptionsBuilder.toString();
	}

	public static String redirectionbuilder(String fld_type, String fld_name) {
		System.out.println(
				"Enter the file name with path (exp : - C:\\Users\\BI50516\\Pictures\\error1.png(for image) or E:/Ravi/Compiler/Live-HTML__CSS__JS-Editor.html (for anchor tag) ");
		String src_file = sc.nextLine();
		String field_str = null;
		if (src_file.isEmpty() || src_file.length() <= 0 || src_file.equalsIgnoreCase(" ") || src_file.equals(null)) {
			System.out.println("Please enter the valid source path ");
			redirectionbuilder(fld_type, fld_name);
		} else {
			inval = fieldspaceremover(fld_name);
			if (fld_type.equalsIgnoreCase("IPA")) {
				field_str = "       <a href='" + src_file + "' id='aid_" + inval + "' > " + fld_name + " </a>";
			} else if (fld_type.equalsIgnoreCase("IPI")) {
				field_str = "       <img id='img_" + inval + "' src='" + src_file + "' alt='" + inval
						+ "' style='height: 200px; width: 200px;' />\n		   <!-- If you want to change the image size change the height and width values (if you want the original remove the style attribute) -->\n";
			}
		}
		return field_str;
	}

	public static String fieldspaceremover(String fld_name) {
		char[] a = fld_name.toCharArray();
		String lab_name = null;
		for (char c : a) {
			if (c == ' ') {
				fieldnamebuilder.append("_");
			} else {
				fieldnamebuilder.append(c);
			}
		}
		lab_name = fieldnamebuilder.toString();
		fieldnamebuilder.delete(0, fieldnamebuilder.toString().length());
		return lab_name;

	}

	public static void theambuilder() {
		System.out.println("Enter your theam preference \n[D] Dark Theam \n[L] Light Theam");
		page_theam = sc.next();
		if (page_theam.equalsIgnoreCase("L")) {
			bgcolor = "aliceblue";
			txcolor = "black";
		} else if (page_theam.equalsIgnoreCase("D")) {
			bgcolor = "Black";
			txcolor = "white";
		}
	}
	
	public static void slowprint(String printval , int time)  {
		for (int i = 0; i < printval.length(); i++) {
			System.out.print(printval.charAt(i));
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				System.err.println("Thread Interrupted --->  [ "+e+" ]");
				System.exit(i);
			}
		}
	}

	public static String BuildStater() {
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		String result = null;
		StringBuilder fnamebuilder = new StringBuilder();
		while (true) {
			System.out.print("Enter the Field Code :  ");
			String fc = sc.nextLine();
			if (fc.equalsIgnoreCase("STA")) {
				result = "Thanks for using the Application ";
				break;
			} else if (fc.equalsIgnoreCase("GHP")) {
				theambuilder();
				result = pagegenerater(hm);
				if (result.equalsIgnoreCase("DATERR"))
					return "Please Pass a valid data for processing .";
				sc.close();
				return result;
			} else if (fc != null && !fc.isEmpty() && fc.length() > 0) {
				System.out.print("Enter the Field Name :  ");
				String fn = sc.nextLine();
				for (int i = 0; i < fn.length(); i++) {
					if (fn.charAt(i) == ' ') {
						fnamebuilder.append("_");
					} else {
						fnamebuilder.append(fn.charAt(i));
					}
				}
				fn = fnamebuilder.toString();
				fnamebuilder.delete(0, fnamebuilder.length());
				if (fn.isEmpty() || fc.isEmpty()) {
					return "Cant process empty values ";
				} else if (fn.equalsIgnoreCase(" ") || fn.equalsIgnoreCase(null)) {
					return "Cant process null values";
				} else {
					if (fc.equalsIgnoreCase("IPSL") || fc.equalsIgnoreCase("IPRD")) {
						String options = optionsbuilder(fc, fn);
						if (!options.isEmpty() && options.length() > 0) {
							field_options.put(fn, options);
						}
					} else if (fc.equalsIgnoreCase("IPA") || fc.equalsIgnoreCase("IPI")) {
						String fld_str = redirectionbuilder(fc, fn);
						if (!fld_str.isEmpty() && fld_str.length() > 0) {
							field_options.put(fn, fld_str);
						}
					}
					hm.put(fn, fc);
					fn = null;
					fc = null;
				}
			}
		}

		return result;
	}

	public static void BuilderWelcome(){
		String t1 = "Welcome to HTML PAGE BUILDER \n This is a Java Console Application that runs on commands to generate HTML pages (Pages with Table tags for better arrangement) \n Follow the codes in the below table enter the required field code to get a required field \n Dont enter spaces for field code and field names for better output \n ";
		slowprint(t1,15);
		
		String t2 = "\n+---------------------------------------------------------+              +---------------------------------------------------------+\n"
				+ "| Field Types                  Field Code                 |              | Field Types                  Field Code                 |\n"
				+ "|---------------------------------------------------------|              |---------------------------------------------------------|\n"
				+ "| Text                            IPT                     |              | Generate Html Page              GHP                     |\n"
				+ "| Number                          IPN                     |              | STOP the Application            STA                     |\n"
				+ "| Email                           IPE                     |              +---------------------------------------------------------+\n"
				+ "| File                            IPF                     |\n"
				+ "| Password                        IPP                     |\n"
				+ "| Checkbox                        IPC                     |\n"
				+ "| Date	                          IPD                     |\n"
				+ "| Button                          IPB                     |\n"
				+ "| Hidden                          IPH                     |\n"
				+ "| Range                           IPR                     |\n"
				+ "| Anchor                          IPA                     |\n"
				+ "| Image                           IPI                     |\n"
				+ "| Submit                          IPS                     |\n"
				+ "| Heading                         IPHD                    |\n"
				+ "| Tel                             IPTL                    |\n"
				+ "| Reset                           IPRS                    |\n"
				+ "| Color                           IPCL                    |\n"
				+ "| Select                          IPSL                    |\n"
				+ "| Time                            IPTM                    |\n"
				+ "| Radio                           IPRD                    |\n"
				+ "+---------------------------------------------------------+\n\n\n";
		
		slowprint(t2,5);
		String FINAL_HTML_PAGE = BuildStater();
		slowprint(FINAL_HTML_PAGE,2);

	}
    /**
     * Main method to run the HTML page builder application.
     *
     * @param args Command line arguments (not used).
     * @throws InterruptedException If the thread sleep is interrupted.
     */
	public static void main(String[] args) throws InterruptedException {
		BuilderWelcome();
	}

}
