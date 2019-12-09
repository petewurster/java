package com.petewurster;

import java.util.Scanner;

/**
 * Create a program that prints the user's zodiac sign, based on their birth day and month.
 *
 * Prompt the user to enter the month number of their birth.
 *
 * Prompt the user to enter the day number of their birth.
 *
 * Print the user's zodiac sign.
 * Aries       : 3/21-4/20
 * Taurus      : 4/21-5/21
 * Gemini      : 5/22-6/21
 * Cancer      : 6/22-7/22
 * Leo         : 7/23-8/22
 * Virgo       : 8/23-9/23
 * Libra       : 9/24-10/23
 * Scorpio     : 10/24-11/22
 * Sagittarius : 11/23-12/21
 * Capricorn   : 12/22-1/20
 * Aquarius    : 1/21-2/19
 * Pisces      : 2/20-3/20
 *
 * EXAMPLE INPUT/OUTPUT:
 * Enter the month number of your birth: 8
 * Enter the day number of your birth: 5
 * Your zodiac sign is Leo.
 */
public class Zodiac {
    public static Scanner kbd = new Scanner(System.in);

//    regex input filtering disallows MOST bad values
//    the rest of the code is written to ignore the ones that
//    get through [ex. 02/37 is treated just like 02/29]
    public static String getData() {
        String input = "";
        while(!input.matches("[0-1][0-9]/[0-3][0-9]")) {
            System.out.println("Enter your birthday in mm/dd format.");
            input = kbd.nextLine().matches("[0-1][0-9]/[0-3][0-9]" ) ? kbd.match().group().trim() : "";
        }
        return input;
    }

    public static int[] convertData(String input) {
        return new int[] {
                Integer.parseInt(input.split("/")[0]),
                Integer.parseInt(input.split("/")[1])
        };
    }

    public static String getSign(int[] date) {
        String[] signs = {"Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer",
                "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn"};

        //this started as a crazy nested ternary but was extracted into a
        //switch because it was just too unreadable
        switch(date[0]) {
            case 1:
                return date[1] < 21 ? signs[11] : signs[0];
            case 2:
                return date[1] < 20 ? signs[0] : signs[1];
            case 3:
                return date[1] < 21 ? signs[1] : signs[2];
            case 4:
                return date[1] < 21 ? signs[2] : signs[3];
            case 5:
                return date[1] < 22 ? signs[3] : signs[4];
            case 6:
                return date[1] < 22 ? signs[4] : signs[5];
            case 7:
                return date[1] < 23 ? signs[5] : signs[6];
            case 8:
                return date[1] < 23 ? signs[6] : signs[7];
            case 9:
                return date[1] < 24 ? signs[7] : signs[8];
            case 10:
                return date[1] < 24 ? signs[8] : signs[9];
            case 11:
                return date[1] < 23 ? signs[9] : signs[10];
        }
        return date[1] < 22 ? signs[10] : signs[11];
    }

//lately I've been indenting my nested functions for better readability
    public static void main(String[] args) {
        System.out.println("Your sign is " +
                getSign(
                        convertData(
                                getData()
                        )
                ) + "."
        );

    }

}
