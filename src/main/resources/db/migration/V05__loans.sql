CREATE TABLE loans (
                       id BIGSERIAL PRIMARY KEY,

                       member_id BIGINT NOT NULL,

                       loan_number VARCHAR(100) NOT NULL UNIQUE,

                       loan_amount DECIMAL(15,2),

                       interest_rate DECIMAL(5,2),

                       start_date DATE,

                       due_date DATE,

                       total_interest DECIMAL(15,2),

                       outstanding_principal DECIMAL(15,2),

                       outstanding_interest DECIMAL(15,2),

                       approved_at TIMESTAMP,

                       approved_by BIGINT,

                       updated_at timestamp not null ,
                       deleted_at  timestamp not null ,
                       created_at  timestamp not null ,
                       is_active  CHAR(1) ,
                       status   CHAR(1),

                       CONSTRAINT fk_loans_member
                           FOREIGN KEY (member_id)
                               REFERENCES members(id),

                       CONSTRAINT fk_loans_approved_by
                           FOREIGN KEY (approved_by)
                               REFERENCES members(id)
);