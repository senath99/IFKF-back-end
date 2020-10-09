package com.ITP.IFKFbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Events {

    @Id
    @GeneratedValue
    private Long eventId;
    private String eventName;
    private String eventType;
    private String eventDate;
    private LocalTime eventTime;
    private String organizer;
    private String eventDesc;
    private String bgImgName;
    private String eventLocation;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isFinished;

    public Events() {
        super();
    }

    public Events(Long eventId, String eventName, String eventType, String eventDate, LocalTime eventTime, String organizer, String eventDesc, String bgImgName, String eventLocation, boolean isFinished) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.organizer = organizer;
        this.eventDesc = eventDesc;
        this.bgImgName = bgImgName;
        this.eventLocation = eventLocation;
        this.isFinished = isFinished;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getBgImgName() {
        return bgImgName;
    }

    public void setBgImgName(String bgImgName) {
        this.bgImgName = bgImgName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Events other = (Events) obj;
        if (eventId != other.eventId)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (eventId ^ (eventId >>> 32));
        return result;
    }

}
