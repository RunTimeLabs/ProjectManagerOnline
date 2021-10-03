package com.sliit.madproject;

public class Pre_Event {

    String date,event,details,plan,remark,title;

    public Pre_Event(){

    }

    public Pre_Event(String date,String event,String details,String remark,String plan,String title){

        this.date=date;
        this.event=event;
        this.details=details;
        this.remark=remark;
        this.plan=plan;
        this.title=title;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
