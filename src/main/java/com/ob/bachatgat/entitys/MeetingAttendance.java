package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "meeting_attendance")
public class MeetingAttendance extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long MeetingAttendanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", referencedColumnName = "id")
    private Meeting meetingsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member",referencedColumnName = "id")
    private Members member;

    @Column(name = "attendance_status", length = 50, nullable = false)
    private String attendanceStatus;

    @Column(name = "remarks", length = 255)
    private String remarks;

    public MeetingAttendance() {
    }

    public MeetingAttendance(Long meetingAttendanceId, Meeting meetingsId, Members member, String attendanceStatus, String remarks) {
        MeetingAttendanceId = meetingAttendanceId;
        this.meetingsId = meetingsId;
        this.member = member;
        this.attendanceStatus = attendanceStatus;
        this.remarks = remarks;
    }

    public Long getMeetingAttendanceId() {
        return MeetingAttendanceId;
    }

    public void setMeetingAttendanceId(Long meetingAttendanceId) {
        MeetingAttendanceId = meetingAttendanceId;
    }

    public Meeting getMeetingsId() {
        return meetingsId;
    }

    public void setMeetingsId(Meeting meetingsId) {
        this.meetingsId = meetingsId;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
