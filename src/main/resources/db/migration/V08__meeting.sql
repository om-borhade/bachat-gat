CREATE TABLE meeting (
                          id BIGSERIAL PRIMARY KEY,

                          meeting_date DATE,

                          meeting_time TIME,

                          location VARCHAR(255),

                          agenda TEXT,

                          minutes TEXT,

                          created_by BIGINT,
                          updated_at timestamp not null ,
                          deleted_at  timestamp not null ,
                          created_at  timestamp not null ,
                          is_active  CHAR(1) ,
                          status   CHAR(1),

                          CONSTRAINT fk_meetings_created_by
                              FOREIGN KEY (created_by)
                                  REFERENCES members(id)
);