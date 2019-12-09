package com.petewurster;
/**
 * Create a program that prompts the user to enter the amount of a purchase.
 *
 * Your program will then display:
 *
 * The state sales tax amount (6.2%)
 * The county sales tax amount (3%)
 * The total sales tax (The sum of the state and county sales taxes)
 * The total of the sale (The sum of the purchase price and total sales tax)
 *
 * Do not worry about rounding the decimal places.
 *
 * SAMPLE INPUT/OUTPUT:
 *
 * Please enter the purchase amount: 120
 *
 * The state sales tax is $7.44
 * The county sales tax is $3.60
 * The total sales tax is $11.04
 *
 * The total sale is $131.04
 */

import java.util.Scanner;

public class Sales {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        final Double stTax = 0.062;
        final Double cTax = 0.03;

        System.out.println("Enter any non-digit character or 0 when complete...");
        System.out.print("How much did the first item cost? ");

        Double num;
        Double sum = 0.0;

        do{
            num = ( (String)kbd.nextLine() ).matches("[0-9]+[.]?[0-9]*|[0-9]*[.]?[0-9]+" ) ?
                    Double.parseDouble( (String)kbd.match().group() ) : 0;
            sum += num;
            System.out.print( (num != 0) ? "\tand the next item? " : "");
        } while (num != 0.0);

        System.out.printf(
                "%nSubtotal: $%.2f %n" +
                        "State tax (%.1f%%): $%.2f %n" +
                        "County tax (%.1f%%): $%.2f %n" +
                        "Total taxes: $%.2f %n" +
                        "%nTotal sale: $%.2f",
                sum,
                (stTax * 100), (sum * stTax),
                (cTax * 100), (sum * cTax),
                (stTax + cTax) * sum,
                sum + ((stTax + cTax) * sum)
        );
    }

}
