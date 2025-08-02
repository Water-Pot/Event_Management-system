package event.lib;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public abstract class Event implements Serializable {
    private String eventTitle;
    private String eventId;
    private String eventManager;
    private String customerContact;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    private int totalBill;
    private String paymentStatus;
    private LocalDate eventDate;
    private int durationInDays;
    private ArrayList<Task> tasks;
    private int numOfParticipants, unitPrice;
    public Event(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
                 int numOfParticipants) {
        super();
        this.eventTitle = eventTitle;
        this.eventId = String.format("%04d", new Random().nextInt(10000));
        this.customerContact = customerContact;
        this.eventDate = eventDate;
        this.durationInDays = durationInDays;
        this.numOfParticipants = numOfParticipants;
        tasks = new ArrayList<>();
        paymentStatus="Unpaid";
    }

    public Event(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants, int unitPrice) {
        super();
        this.eventTitle = eventTitle;
        this.eventId = String.format("%04d", new Random().nextInt(10000));
        this.eventDate = eventDate;
        this.durationInDays = durationInDays;
        this.numOfParticipants = numOfParticipants;
        this.unitPrice = unitPrice;
        tasks = new ArrayList<>();
        paymentStatus="Unpaid";
    }

    protected void addPrefixCodeToId(String prefix) {
        this.eventId = prefix + this.eventId;
    }

    public abstract double getBill() throws Exception;

    public void addTask(String title, String description) {
//		String id = getEventId() + "-"+String.format("%03d", new Random().nextInt(1000));
        Task t = new Task(title, description);
        tasks.add(t);
    }

    public boolean startTask(String title) {
        Task t = findTask(title);
        if (t == null) return false;
        t.startTask();
        return true;
    }

    public boolean completeTask(String title) {
        Task t = findTask(title);
        if (t == null) return false;
        if(t.getStatus()!="In Progress")return false;
        t.completeTask();
        return true;
    }

    public Task findTask(String title) {
        for (Task t: tasks) {
            if (t.getTitle().equalsIgnoreCase(title))
                return t;
        }

        return null;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventManager() {
        return eventManager;
    }

    public void setEventManager(String eventManager) {
        this.eventManager = eventManager;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.eventDate = LocalDate.parse(eventDate, formatter);
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getEventId() {
        return eventId;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"\nEventId=" + eventId + "\nEventTitle=" + eventTitle +"\neventManager=" + eventManager
                + "\ncustomerContact=" + customerContact + "\neventDate=" + eventDate + "\ndurationInDays="
                + durationInDays + "\ntasks=" + tasks.toString() + "\nnumOfParticipants=" + numOfParticipants + "\nunitPrice="
                + unitPrice;
    }



}