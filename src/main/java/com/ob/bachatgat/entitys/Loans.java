package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loans")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long loanId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Long memberId;

    @Column(name = "loan_number")
    private String loanNumber;

    @Column(name = "loan_amount")
    private BigDecimal loanAmount;


    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "due_date")
    private LocalDate  dueDate;

    @Column(name = "total_interest")
    private BigDecimal totalInterest;

    @Column(name = "outstanding_principal")
    private BigDecimal outstandingPrincipal;

    @Column(name = "outstanding_interest")
    private BigDecimal outstandingInterest;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @Column(name = "approved_by")
    private Long approvedBy;// the id of member how approved that loan;

    @OneToMany(mappedBy = "loans",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LoanRepayments> loanRepayments=new ArrayList<>();

    public Loans() {
    }

    public Loans(Long loanId, Long memberId, String loanNumber, BigDecimal loanAmount, BigDecimal interestRate, LocalDate startDate, LocalDate dueDate, BigDecimal totalInterest, BigDecimal outstandingPrincipal, BigDecimal outstandingInterest, LocalDateTime approvedAt, Long approvedBy) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.totalInterest = totalInterest;
        this.outstandingPrincipal = outstandingPrincipal;
        this.outstandingInterest = outstandingInterest;
        this.approvedAt = approvedAt;
        this.approvedBy = approvedBy;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getOutstandingPrincipal() {
        return outstandingPrincipal;
    }

    public void setOutstandingPrincipal(BigDecimal outstandingPrincipal) {
        this.outstandingPrincipal = outstandingPrincipal;
    }

    public BigDecimal getOutstandingInterest() {
        return outstandingInterest;
    }

    public void setOutstandingInterest(BigDecimal outstandingInterest) {
        this.outstandingInterest = outstandingInterest;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }
}
