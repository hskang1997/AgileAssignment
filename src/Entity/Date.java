/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Hskang
 */
public class Date {

    private int date;
    private int month;
    private int year;
    private String monthStr;

    public Date() {
    }

    public Date(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.setMonthStr(month);
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        setMonthStr(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonthStr() {
        return monthStr;
    }

    public void setMonthStr(int month) {
        switch (month) {
            case 1:
                monthStr = "January";
                break;

            case 2:
                monthStr = "February";
                break;

            case 3:
                monthStr = "March";
                break;

            case 4:
                monthStr = "April";
                break;

            case 5:
                monthStr = "May";
                break;

            case 6:
                monthStr = "June";
                break;

            case 7:
                monthStr = "July";
                break;

            case 8:
                monthStr = "August";
                break;

            case 9:
                monthStr = "September";
                break;

            case 10:
                monthStr = "October";
                break;

            case 11:
                monthStr = "November";
                break;

            case 12:
                monthStr = "December";
                break;
        }
    }
    
    
    public String toString() {
        return date + " " + monthStr + " " + year;
    }

}
