package com.ITP.IFKFbackend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Events {

    @Id
    @GeneratedValue
    private Long eventId;
    private String eventName;
    private String eventType;
    private Date eventDate;
    private LocalTime eventTime;
    private String organizer;
    private String eventDesc;
    private boolean isFinished;
    private String bgImgName;

    public Events() {
        super();
    }

    public Events(Long eventId, String eventName, String eventType, Date eventDate, LocalTime eventTime, String organizer,
                  String eventDesc, boolean isFinished, String bgImgName) {
        super();
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.organizer = organizer;
        this.eventDesc = eventDesc;
        this.isFinished = isFinished;
        this.bgImgName = bgImgName;
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;

    }

    public void setEventTime(LocalTime eventTime) {
        //DateFormat formatter = new SimpleDateFormat("HH:mm");
        //Date newTime = (Date)formatter.parse(eventTime);
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getBgImgName() {
        return bgImgName;
    }

    public void setBgImgName(String bgImgName) {
        this.bgImgName = bgImgName;
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

//    @Override
//    public String toString() {
//        return "Events{" +
//                "eventId=" + eventId +
//                ", eventName='" + eventName + '\'' +
//                ", eventType='" + eventType + '\'' +
//                ", eventDate=" + eventDate +
//                ", eventTime=" + eventTime +
//                ", organizer='" + organizer + '\'' +
//                ", eventDesc='" + eventDesc + '\'' +
//                ", isFinished=" + isFinished +
//                ", bgImgName='" + bgImgName + '\'' +
//                '}';
//    }
}
