package com.ob.bachatgat.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_repayments")
public class LoanRepayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repayment_id")
    private Long repaymentId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "loan_id",referencedColumnName = "id")
    private Long loanId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Long memberId;


}
