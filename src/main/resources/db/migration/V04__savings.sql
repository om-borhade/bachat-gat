CREATE TABLE savings (
                         id BIGSERIAL PRIMARY KEY,
                         member_id BIGINT NOT NULL,
                         amount DECIMAL(15,2) NOT NULL,
                         saving_month DATE NOT NULL,
                         payment_date DATE NOT NULL,
                         payment_reference VARCHAR(255),
                         updated_at timestamp not null ,
                         deleted_at  timestamp not null ,
                         created_at  timestamp not null ,
                         is_active  CHAR(1) ,
                         status   CHAR(1),

                         CONSTRAINT fk_savings_member
                             FOREIGN KEY (member_id)
                                 REFERENCES members(id)
);