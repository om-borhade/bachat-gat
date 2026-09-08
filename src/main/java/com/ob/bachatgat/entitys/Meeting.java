package com.ob.bachatgat.entitys;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long meetingId;

    @Column(name = "meeting_date")
    private LocalDate meetingDate;

    @Column(name = "meeting_time")
    private LocalTime meetingTime;

    @Column(name = "location")
    private String location;

    @Column(name = "agenda")
    private String agenda;

    @Column(name = "minutes")
    private String minutes;

   @Column(name = "createdBy")//id of member how conduct meeting;
    private Long createdBy;

   @OneToMany(mappedBy = "meetingsId" ,cascade = CascadeType.ALL,orphanRemoval = true)
   private List<MeetingAttendance> meetingAttendances =new ArrayList<>();

    public Meeting() {
    }

    public Meeting(Long meetingId, LocalDate meetingDate, LocalTime meetingTime, String location, String agenda, String minutes, Long createdBy) {
        this.meetingId = meetingId;
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
        this.location = location;
        this.agenda = agenda;
        this.minutes = minutes;
        this.createdBy = createdBy;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public LocalTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(LocalTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
