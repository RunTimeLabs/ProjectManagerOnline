package com.sliit.madproject;

public class Post_Event {

    String date,event,list,remark,task,todolist;

    public Post_Event(){

    }

    public Post_Event(String date,String event,String list,String remark,String task,String todolist){

        this.date=date;
        this.event=event;
        this.list=list;
        this.remark=remark;
        this.task=task;
        this.todolist=todolist;

    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todo) {
        this.todolist = todo;
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

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
