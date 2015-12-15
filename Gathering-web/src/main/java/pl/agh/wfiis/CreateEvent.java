package pl.agh.wfiis;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "createEvent")
@Dependent
public class CreateEvent {

    private String title;
    private String description;
    private Date eventData;
    private String place;
    private String pictureLink;
    private int maxAmountOfParticipants;
    private double price;
    private String currency;
    // Kategorie
    private int minimalAge;
    private int maximalAge;
    // organizerId

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

    public Date getEventData() {
        return eventData;
    }

    public void setEventData(Date eventData) {
        this.eventData = eventData;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public int getMaxAmountOfParticipants() {
        return maxAmountOfParticipants;
    }

    public void setMaxAmountOfParticipants(int maxAmountOfParticipants) {
        this.maxAmountOfParticipants = maxAmountOfParticipants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getMaximalAge() {
        return maximalAge;
    }

    public void setMaximalAge(int maximalAge) {
        this.maximalAge = maximalAge;
    }
    
    public CreateEvent() {
    }
    
    public void registerNewEventInDatabase() {
        
    }
    
}
