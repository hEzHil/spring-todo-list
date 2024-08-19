package com.OpenSource.demo.ToDoList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record ToDoRegistration(
        String toDo,
        String date
) {
//    public ToDoRegistration (   String toDo,Date date){
//
//            this.toDo = toDo;
//            this.date =  parseDate(indate);
//
//
//    }
//    private Date parseDate(String indate) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            return simpleDateFormat.parse(indate);
//        } catch (ParseException e) {
//            System.out.println("Invalid date format. Please enter in correct format (dd-MM-yyyy).");
//            return null; // Return null or handle it according to your needs
//        }
//    }
}
