package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, TimeEntry timeEntry) {
        this.id = id;
        this.projectId = timeEntry.getProjectId();
        this.userId = timeEntry.getUserId();
        this.date = timeEntry.getDate();
        this.hours = timeEntry.getHours();
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public TimeEntry update(TimeEntry timeEntry) {
        this.setProjectId(timeEntry.getProjectId());
        this.setUserId(timeEntry.getUserId());
        this.setDate(timeEntry.getDate());
        this.setHours(timeEntry.getHours());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TimeEntry) {
            TimeEntry timeEntry = (TimeEntry) o;
            return  this.getId() == timeEntry.getId() &&
                    this.getProjectId() == timeEntry.getProjectId() &&
                    this.getUserId() == timeEntry.getUserId() &&
                    this.getDate().equals(timeEntry.getDate()) &&
                    this.getHours() == timeEntry.getHours();
        }
        return false;
    }
}
