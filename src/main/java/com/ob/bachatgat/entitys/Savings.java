package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Savings extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long saving_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Long memberId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "saving_month")
    private LocalDateTime savingMonth;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_reference")
    private String paymentReference;


    public Savings() {
    }

    public Savings(Long saving_id, Long memberId, BigDecimal amount, LocalDateTime savingMonth, LocalDateTime paymentDate, String paymentReference) {
        this.saving_id = saving_id;
        this.memberId = memberId;
        this.amount = amount;
        this.savingMonth = savingMonth;
        this.paymentDate = paymentDate;
        this.paymentReference = paymentReference;
    }

    public Long getSaving_id() {
        return saving_id;
    }

    public void setSaving_id(Long saving_id) {
        this.saving_id = saving_id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getSavingMonth() {
        return savingMonth;
    }

    public void setSavingMonth(LocalDateTime savingMonth) {
        this.savingMonth = savingMonth;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }
}
