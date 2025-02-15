CREATE SEQUENCE department_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE department (
    id int8 NOT NULL DEFAULT nextval('department_sequence'),
    "name" varchar(255) NOT NULL,
    CONSTRAINT department_pkey PRIMARY KEY (id)
);