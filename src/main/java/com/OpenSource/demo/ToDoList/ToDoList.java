package com.OpenSource.demo.ToDoList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ToDoList {

    private Integer id;

    private String toDo;

    private Date date ;

    public ToDoList(String toDo, String indate)  {
        this.toDo = toDo;
        this.date =  parseDate(indate);

    }


    public ToDoList(Integer id, String toDo,String indate) {
        this.id = id;
        this.toDo = toDo;
        this.date = parseDate(indate);


    }



    private Date parseDate(String indate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return simpleDateFormat.parse(indate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter in correct format (dd-MM-yyyy).");
            return null; // Return null or handle it according to your needs
        }
    }



    public ToDoList() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoList toDoList = (ToDoList) o;
        return Objects.equals(toDo, toDoList.toDo) && Objects.equals(date, toDoList.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toDo, date);
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "toDo='" + toDo + '\'' +
                ", date=" + date +
                '}';
    }
}
