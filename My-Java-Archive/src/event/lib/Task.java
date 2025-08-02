package event.lib;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
    private String title, description, status;
    private LocalDate startDate, endDate;

    public Task(String title, String description) {
        super();
        this.title = title;
//		this.id = id;
        this.description = description;
        this.status = "New";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStarDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.startDate = LocalDate.parse(startDate, formatter);
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void startTask() {
        setStatus("In Progress");
        setStartDate(LocalDate.now());
    }

    public void completeTask() {
        setStatus("Complete");
        setEndDate(LocalDate.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //formatter.
        if(startDate==null){

            return "[ Title: "+title + ",status: " + status + ", start date: TBA " + ", end date: TBA ]";
        }
        else if(endDate==null){
            String sD = startDate.format(formatter);
            return "[ Title: "+title + ",status: " + status + ", start date: " + sD + ", end date: TBA ]";
        }
        String sD = startDate.format(formatter);
        String eD = endDate.format(formatter);
        return "[ Title: "+title + "\n,status: " + status + "\n, start date: " + sD + "\n, end date: "
                + eD+" ]";
    }



}