CREATE TABLE interest_transactions (
                                       id BIGSERIAL PRIMARY KEY,

                                       loan_id BIGINT NOT NULL,

                                       member_id BIGINT NOT NULL,

                                       interest_amount DECIMAL(15,2),

                                       calculated_date DATE,

                                       paid_amount DECIMAL(15,2),

                                       pending_amount DECIMAL(15,2),

                                       updated_at timestamp not null ,
                                       deleted_at  timestamp not null ,
                                       created_at  timestamp not null ,
                                       is_active  CHAR(1) ,
                                       status   CHAR(1),

                                       CONSTRAINT fk_interest_transaction_loan
                                           FOREIGN KEY (loan_id)
                                               REFERENCES loans(id),

                                       CONSTRAINT fk_interest_transaction_member
                                           FOREIGN KEY (member_id)
                                               REFERENCES members(id)
);