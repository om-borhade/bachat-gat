package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private BigDecimal phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @OneToMany(mappedBy = "members" ,cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Savings> savings=new ArrayList<>();



    public Members() {
    }

    public Members(Long memberId, String memberCode, String memberName, BigDecimal phoneNumber, String address, LocalDate joiningDate, List<Savings> savings) {
        this.memberId = memberId;
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.joiningDate = joiningDate;
        this.savings = savings;
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
        return phoneNumber;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<Savings> getSavings() {
        return savings;
    }

    public void setSavings(List<Savings> savings) {
        this.savings = savings;
    }
}
