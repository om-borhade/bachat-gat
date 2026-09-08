CREATE TABLE meeting_attendance (
                                    id BIGSERIAL PRIMARY KEY,

                                    meeting_id BIGINT NOT NULL,

                                    member_id BIGINT NOT NULL,

                                    attendance_status VARCHAR(50) NOT NULL,

                                    remarks VARCHAR(255),
                                    updated_at timestamp not null ,
                                    deleted_at  timestamp not null ,
                                    created_at  timestamp not null ,
                                    is_active  CHAR(1) ,
                                    status   CHAR(1),

                                    CONSTRAINT fk_meeting_attendance_meeting
                                        FOREIGN KEY (meeting_id)
                                            REFERENCES meeting(id),

                                    CONSTRAINT fk_meeting_attendance_member
                                        FOREIGN KEY (member_id)
                                            REFERENCES members(id)
);