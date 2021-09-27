package com.example.ProjectManagerOnline;

//model class
public class Category {
    private String ticketCategory;

    public Category() {
    }

    public Category(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }
}
