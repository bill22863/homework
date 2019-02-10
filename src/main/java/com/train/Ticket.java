package com.train;

public class Ticket {
    int TicketNumber;
    int RoundTripNumber;

    public Ticket(int ticketNumber, int roundTripNumber) {
        TicketNumber = ticketNumber;
        RoundTripNumber = roundTripNumber;
    }

    public int getTotalPrice(int normalPrice, int roundPrice){
        //單程票數量
        int normalNumber = TicketNumber - RoundTripNumber;
        int price = normalNumber * normalPrice + RoundTripNumber * roundPrice;
        return price;
    }

    public void showMessage(int total){
        System.out.println("訂票訊息:");
        System.out.print("總票數:\t" + TicketNumber + "張\n");
        System.out.print("來回票:\t" + RoundTripNumber + "張\n");
        System.out.print("總金額:\t" + total + "元");
    }
}
