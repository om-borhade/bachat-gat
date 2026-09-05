package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Members extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long memberId;

    @Column(name = "member_code")
    private String memberCode;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "phone_number")
    private BigDecimal PhoneNumber;

    @Column(name = "address")
    private String Address;

    @Column(name = "joining_date")
    private LocalDate joiningDate;



    public Members() {
    }

    public Members(Long memberId, String memberCode, String memberName, BigDecimal phoneNumber, String address, LocalDate joiningDate) {
        this.memberId = memberId;
        this.memberCode = memberCode;
        this.memberName = memberName;
        PhoneNumber = phoneNumber;
        Address = address;
        this.joiningDate = joiningDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public BigDecimal getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }


}
