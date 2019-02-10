package com.train;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        int number = 0;
        int singlePrice = 1000;
        int roundPrice = (int) (2000 * 0.9);
        do{
            System.out.print("歡迎使用此訂票系統，請輸入欲購買的張數:\t");
            Scanner scanner = new Scanner(System.in);
            try {
                number = scanner.nextInt();
                int numberRound = 0;
                System.out.print("是否有來回票 ? 是(Y), 否(N):\t");
                String command = scanner.next();
                if (command.contains("y") || command.contains("Y")) {
                    System.out.print("請輸入來回票張數:\t");
                    numberRound = scanner.nextInt();
                    while (numberRound > number) {
                        System.out.print("來回票張數不可超過總票數，請重新輸入:\t");
                        numberRound = scanner.nextInt();
                    }
                }
                Ticket ticket = new Ticket(number, numberRound);
                int total = ticket.getTotalPrice(singlePrice, roundPrice);
                System.out.println("以下為您的訂票資訊，請確認:");
                ticket.showMessage(total);

            }catch (Exception e){
                System.out.println("輸入錯誤，輸入僅接受數值");
            }
        }while (number == 0);
    }
}
