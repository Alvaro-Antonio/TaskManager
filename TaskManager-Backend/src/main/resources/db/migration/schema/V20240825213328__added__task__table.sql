CREATE SEQUENCE task_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE public.task (
                             id int8 NOT NULL DEFAULT nextval('task_sequence'),
                             deadline timestamp NOT NULL,
                             description varchar(300) NULL,
                             duration timestamp NULL,
                             finalized bool NOT NULL,
                             title varchar(120) NOT NULL,
                             department_id int8 NOT NULL,
                             person_allocated_id int8 NULL,
                             CONSTRAINT task_pkey PRIMARY KEY (id)
);

ALTER TABLE task ADD CONSTRAINT person_allocated_FK FOREIGN KEY (person_allocated_id) REFERENCES person(id);
ALTER TABLE task ADD CONSTRAINT departmente_FK FOREIGN KEY (department_id) REFERENCES department(id);