CREATE TABLE employee (
    emp_id NUMBER(9) PRIMARY KEY,
    fname VARCHAR2(100) NOT NULL,
    lname VARCHAR2(100) NOT NULL,
    pass VARCHAR2(100) NOT NULL,
    emp_email VARCHAR2(100) NOT NULL UNIQUE,
    is_admin NUMBER(1) NOT NULL
)

CREATE TABLE reimbursement (
    transact_id NUMBER(9) PRIMARY KEY,
    emp_id NUMBER(9) CONSTRAINT fk_emp_id REFERENCES employee(emp_id),
    re_status NUMBER(1) DEFAULT 0,
    amount NUMBER(9) NOT NULL,
    date_of DATE,
    re_description VARCHAR2(1000)
)

CREATE TABLE receipt_records (
    rec_id NUMBER(9) PRIMARY KEY,
    transact_id NUMBER(9) CONSTRAINT fk_transact_id REFERENCES reimbursement(transact_id),
    amount NUMBER(6),
    v_name VARCHAR2(100),
    photo BLOB
    /* photo column*/
)

CREATE SEQUENCE emp_seq
    START WITH 1
    INCREMENT BY 1
;

CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    IF :new.emp_id IS NULL
    THEN
        SELECT emp_seq.nextval INTO :new.emp_id FROM dual;
    END IF;
END;

CREATE SEQUENCE transact_seq
    START WITH 1
    INCREMENT BY 1
;

CREATE OR REPLACE TRIGGER transact_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    IF :new.transact_id IS NULL
    THEN
        SELECT transact_seq.nextval INTO :new.transact_id FROM dual;
    END IF;
END;

CREATE SEQUENCE rec_seq
    START WITH 1
    INCREMENT BY 1
;

CREATE OR REPLACE TRIGGER rec_seq_trigger
BEFORE INSERT ON receipt_records
FOR EACH ROW
BEGIN
    IF :new.rec_id IS NULL
    THEN
        SELECT rec_seq.nextval INTO :new.rec_id FROM dual;
    END IF;
END;

ALTER TABLE reimbursement
ADD manager_id NUMBER(9) CONSTRAINT fk_manager_id references employee(emp_id); 

ALTER TABLE reimbursement
MODIFY re_description VARCHAR2(4000);

commit;