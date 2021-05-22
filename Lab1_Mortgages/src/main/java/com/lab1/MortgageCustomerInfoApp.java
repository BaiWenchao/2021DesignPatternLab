package com.lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class MortgageCustomerInfoApp {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input the start date(yyyy-MM-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Please input the end date(yyyy-MM-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Please input the date today(yyyy-MM-dd): ");
            LocalDate now = LocalDate.parse(scanner.nextLine());
            System.out.println("Please input the name of the strategy(Linear or Amoritized)");

            String s = scanner.nextLine();
            if (s.equals("Linear")){
                Mortgage m =new Mortgage(500000,500000,startDate,endDate,42);
                // s = 1 -> Linear
                Payment payment = m.getRequiredPayment(now, 1);
                System.out.println("Your Redemption: ");
                System.out.println(payment.getRedemption());
                System.out.println("Your interest: ");
                System.out.println(payment.getInterest());
            }else if (s.equals("Amoritized")){
                Mortgage m =new Mortgage(500000,500000,startDate,endDate,42);
                // s = 2 -> Amoritized
                Payment payment = m.getRequiredPayment(now, 2);
                System.out.println("Your Redemption: ");
                System.out.println(payment.getRedemption());
                System.out.println("Your interest: ");
                System.out.println(payment.getInterest());
            }else{
                System.out.println("Please input the name of the strategy(Linear or Amoritized)");
            }
            System.out.println("exit?(y or n)");
            if (scanner.nextLine().equals("y")){
                System.out.println("Bye!");
                return;
            }
        }

//        LocalDate startDate = LocalDate.parse("2021-04-01");
//        LocalDate now = LocalDate.parse("2023-08-01");
//        LocalDate endDate = LocalDate.parse("2024-08-01");

    }
}
