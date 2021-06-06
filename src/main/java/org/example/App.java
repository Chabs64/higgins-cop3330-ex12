package org.example;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Chad Higgins
 */

/*
Computing simple interest is a great way to quickly figure out whether an investment has value.
It’s also a good way to get comfortable with explicitly coding the order of operations in your programs.

Create a program that computes simple interest.
Prompt for the principal amount, the rate as a percentage, and the time, and display the amount accrued (principal + interest).

The formula for simple interest is A = P(1 + rt), where P is the principal amount,
r is the annual rate of interest, t is the number of years the amount is invested,
and A is the amount at the end of the investment.

Example Output
Enter the principal: 1500
Enter the rate of interest: 4.3
Enter the number of years: 4
After 4 years at 4.3%, the investment will be worth $1758.

Constraints
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the principal: ");
        BigDecimal rPrincipal = BigDecimal.valueOf(in.nextDouble());

        System.out.println("Enter the rate of interest: ");
        BigDecimal rInterest = BigDecimal.valueOf(in.nextDouble());

        System.out.println("Enter the number of years: ");
        BigDecimal rYears = BigDecimal.valueOf(in.nextInt());

        //A = P(1 + rt)

        BigDecimal percentInterest = rInterest.multiply(BigDecimal.valueOf(0.01));

        //I hate this... working with money
        BigDecimal Result = rPrincipal.multiply(BigDecimal.valueOf(1).add(rYears.multiply(percentInterest))).setScale(0, RoundingMode.HALF_UP);

        System.out.println("After "+rYears+" years at "+rInterest+", the investment will be worth $"+Result+".");
    }
}
