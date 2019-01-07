package com.TicketThreadDemo;

/**
 * 多线程Demo
 * 火车票
 */
public class TicketDemo01 implements Runnable {

    private static int TicketCount = 100;

    @Override
    public void run() {
        while (TicketCount > 0){
            getTicket();
        }
    }

    private void getTicket(){
        int count = 0;
        if(TicketCount > 0){
            count = --TicketCount;
            System.out.println("火车票==>" + Thread.currentThread().getName() + "口,售出"+count + " 票" );

        }
    }

    public static void main(String[] args) {

        TicketDemo01 ticketDemo01 = new TicketDemo01();
        Thread thread01 = new Thread(ticketDemo01);
        thread01.setName("T1");
        thread01.start();

        Thread thread02 = new Thread(ticketDemo01);
        thread02.setName("T2");
        thread02.start();

        Thread thread03 = new Thread(ticketDemo01);
        thread03.setName("T3");
        thread03.start();

        Thread thread04 = new Thread(ticketDemo01);
        thread04.setName("T4");
        thread04.start();

    }
}


class TicketEntity{

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TicketEntity() {
        super();
    }
}
