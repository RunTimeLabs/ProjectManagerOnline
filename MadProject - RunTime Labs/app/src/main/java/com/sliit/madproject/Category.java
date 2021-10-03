package com.sliit.madproject;

//model class
public class Category {
    private String ticketCategory;
    private String ticketPrice;
    private String ticketCount;

    public Category() {
    }

    public Category(String ticketCategory, String ticketPrice, String ticketCount) {
        this.ticketCategory = ticketCategory;
        this.ticketPrice = ticketPrice;
        this.ticketCount = ticketCount;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketCount() {return ticketCount;}

    public void setTicketCount(String ticketCount) {this.ticketCount = ticketCount;}
}
