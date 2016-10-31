package me.leofontes.dsotravel.Models;

/**
 * Created by Leo on 10/31/16.
 */

public class Schedule {
    private String[] days;
    private String[] open;
    private String[] close;

    public Schedule(String[] days, String[] open, String[] close) {
        this.days = days;
        this.open = open;
        this.close = close;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public String[] getOpen() {
        return open;
    }

    public void setOpen(String[] open) {
        this.open = open;
    }

    public String[] getClose() {
        return close;
    }

    public void setClose(String[] close) {
        this.close = close;
    }
}
