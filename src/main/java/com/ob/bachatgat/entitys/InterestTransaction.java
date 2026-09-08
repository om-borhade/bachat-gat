package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "interest_transactions")
public class InterestTransaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long interestTxtId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    private Loans loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Members member;

    @Column(name = "interest_amount")
    private BigDecimal interestAmount;

    @Column(name = "calculated_date")
    private LocalDate calculatedDate;

    @Column(name = "paid_amount")
    private BigDecimal paidAmount;

    @Column(name = "pending_amount")
    private BigDecimal pendingAmount;

    public InterestTransaction() {
    }

    public InterestTransaction(Long interestTxtId, Loans loan, Members member, BigDecimal interestAmount, LocalDate calculatedDate, BigDecimal paidAmount, BigDecimal pendingAmount) {
        this.interestTxtId = interestTxtId;
        this.loan = loan;
        this.member = member;
        this.interestAmount = interestAmount;
        this.calculatedDate = calculatedDate;
        this.paidAmount = paidAmount;
        this.pendingAmount = pendingAmount;
    }

    public Long getInterestTxtId() {
        return interestTxtId;
    }

    public void setInterestTxtId(Long interestTxtId) {
        this.interestTxtId = interestTxtId;
    }

    public Loans getLoan() {
        return loan;
    }

    public void setLoan(Loans loan) {
        this.loan = loan;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public LocalDate getCalculatedDate() {
        return calculatedDate;
    }

    public void setCalculatedDate(LocalDate calculatedDate) {
        this.calculatedDate = calculatedDate;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        this.pendingAmount = pendingAmount;
    }
}
