package event.lib;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class TourPackage extends Event implements Serializable {
    ArrayList<String> placesToVisit = new ArrayList<>();


    ArrayList<String> customerContacts = new ArrayList<>();
    private int numOfRegisteredParticipants;



    public TourPackage(String eventTitle, LocalDate eventDate,
                       int durationInDays, int numOfParticipants, int perPersonPrice) {
        super(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);

        addPrefixCodeToId("TP-");
    }

    public ArrayList<String> getCustomerContacts() {
        return customerContacts;
    }

    public int getNumOfRegisteredParticipants() {
        return numOfRegisteredParticipants;
    }

    @Override
    public double getBill() throws Exception {
        return getNumOfRegisteredParticipants()*getUnitPrice();
    }

    public boolean registerForTour(int participants, String contactNo) {
        if (numOfRegisteredParticipants + participants <= getNumOfParticipants()) {
            numOfRegisteredParticipants += participants;
            customerContacts.add(contactNo);
            return true;
        }

        return false;
    }

    public ArrayList<String> getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(ArrayList<String> placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public void addPlacesToVisit(String placeToVisit) {
        this.placesToVisit.add(placeToVisit);
    }

}