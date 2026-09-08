package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "loan_repayments")
public class LoanRepayments extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repayment_id")
    private Long repaymentId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "loan_id",referencedColumnName = "id")
    private Loans loanId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Members memberId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "principal_amount")
    private BigDecimal principalAmount;

    @Column(name = "interest_amount")
    private BigDecimal interestAmount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "payment_reference")
    private String paymentReference;

    public LoanRepayments() {
    }

    public LoanRepayments(Long repaymentId, Loans loanId, Members memberId, LocalDate paymentDate, BigDecimal principalAmount, BigDecimal interestAmount, BigDecimal totalAmount, String paymentReference) {
        this.repaymentId = repaymentId;
        this.loanId = loanId;
        this.memberId = memberId;
        this.paymentDate = paymentDate;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
        this.totalAmount = totalAmount;
        this.paymentReference = paymentReference;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Loans getLoanId() {
        return loanId;
    }

    public void setLoanId(Loans loanId) {
        this.loanId = loanId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }
}
