CREATE SEQUENCE person_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE public.person (
    id int8 NOT NULL DEFAULT nextval('person_sequence'),
     "name" varchar(150) NOT NULL,
     id_department int8 NOT NULL,
     CONSTRAINT person_pkey PRIMARY KEY (id)
);
ALTER TABLE person ADD CONSTRAINT department_id_FK FOREIGN KEY (id_department) REFERENCES department(id);