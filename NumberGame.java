package com.test.game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
  static int tc = 1;
  static boolean timeout = false;
  static String msg1 = "Please enter the number between ";
  protected static boolean runner = false;
  protected static int numval = 0;

  protected static boolean desider(int inum, int numval) {

    if (inum == 000) {
      System.out.println("Game Stoped Fourse fully . ");
      return false;
    } else if (inum == numval) {
      System.out.println("Congratulations Your guess is corrct  \n\nYour Rank is ------》  " + tc);
      return false;
    } else if (inum != numval) {
      System.out.println("Wrong Try again \n");
      tc++;
      return true;
    } else {
      System.out.println("Enter the correct input and try again");
      tc++;
      return true;
    }
  }

  public static void main(String[] args) {
    boolean a = true;
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();

    System.out.println(
        "Select level you want to play \n\n\t EASY           ---《 E  》 --- \n\t Hard           ---《 H  》 --- \n\t VERY HARD      ---《 VH 》 --- \n\t INFINITY HARD  ---《 IH 》 --- \n\t STOP           ---《 S  》 --- ");
    boolean levval = true;

    while (levval == true) {
      String level = sc.next();
      if (level.equals("E")) {
        numval = rn.nextInt(10);
        System.out.println(msg1 + " 1 to 10");
        runner = true;
        break;
      } else if (level.equals("H")) {
        numval = rn.nextInt(50);
        System.out.println(msg1 + " 1 to 50");
        runner = true;
        break;
      } else if (level.equals("VH")) {
        numval = rn.nextInt(100);
        System.out.println(msg1 + " 1 to 100");
        runner = true;
        break;
      } else if (level.equals("IH")) {
        numval = rn.nextInt(10000000);
        System.out.println(msg1 + " 1 to 10000000");
        runner = true;
        break;
      } else if (level.equals("ST")) {
        break;
      } else {
        System.out.println("Please enter the Correct level of code \nPlease try again ");
      }
    }

    System.out.println("The random number is ----》" + numval);

    while (runner == true) {

      int inum = sc.nextInt();
      if (inum >= 0) {
        if (!desider(inum, numval)) {
          break;
        }
      } else {
        System.out.println("Enter the correct input");
      }
    }
  }
}

