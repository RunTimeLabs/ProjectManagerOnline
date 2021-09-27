package com.example.ProjectManagerOnline;

//model class
public class Category {
    private String ticketCategory;
    private String ticketPrice;

    public Category() {
    }

    public Category(String ticketCategory, String ticketPrice) {
        this.ticketCategory = ticketCategory;
        this.ticketPrice = ticketPrice;
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
}
