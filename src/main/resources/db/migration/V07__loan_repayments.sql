CREATE TABLE loan_repayments (
                                 repayment_id BIGSERIAL PRIMARY KEY,

                                 loan_id BIGINT NOT NULL,

                                 member_id BIGINT NOT NULL,

                                 payment_date DATE,

                                 principal_amount DECIMAL(15,2),

                                 interest_amount DECIMAL(15,2),

                                 total_amount DECIMAL(15,2),

                                 payment_reference VARCHAR(255),
                                 updated_at timestamp not null ,
                                 deleted_at  timestamp not null ,
                                 created_at  timestamp not null ,
                                 is_active  CHAR(1) ,
                                 status   CHAR(1),

                                 CONSTRAINT fk_loan_repayments_loan
                                     FOREIGN KEY (loan_id)
                                         REFERENCES loans(id),

                                 CONSTRAINT fk_loan_repayments_member
                                     FOREIGN KEY (member_id)
                                         REFERENCES members(id)
);