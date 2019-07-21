DELETE FROM receipt_records;
DELETE FROM reimbursement;
DELETE FROM employee;

INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('John','Smith','qwerty','smith@temp.com',0,'Boston',1234567891);
INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('Kyle','Sinhart','qwerty','sinhart@temp.com',1,'New York City',1234567891);
INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('Sarah','Weem','qwerty','sarah@temp.com',0,'Verona',1234567891);
INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('Lindsay','Jones','qwerty','lindsay@temp.com',0,'Montclair',1234567891);
INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('Barb','Dunkel','qwerty','barb@temp.com',0,'Reston',1234567891);
INSERT INTO employee (fname,lname,pass,emp_email,is_admin,hometown,phone) 
VALUES ('Jess','Vasam','qwerty','jess@temp.com',0,'Austin',1234567891);

INSERT INTO reimbursement (emp_id,re_status,amount,date_of,re_description,manager_id) 
VALUES (1,0,432,DATE'2019-05-26','Purchase of cake and champagne for Caitlins birthday Party',2);
INSERT INTO reimbursement (emp_id,re_status,amount,date_of,re_description) 
VALUES (3,0,200,DATE'2019-06-22','Random purchase of office supplies');
INSERT INTO reimbursement (emp_id,re_status,amount,date_of,re_description) 
VALUES (5,0,200,DATE'2019-06-25','Random second purchase of office supplies');

INSERT INTO receipt_records (re_id,amount,v_name) 
VALUES (1,200,'Fine Wine and Spirits');
INSERT INTO receipt_records (re_id,amount,v_name) 
VALUES (1,232,'Cool Cakes and Bakes');
INSERT INTO receipt_records (re_id,amount,v_name) 
VALUES (2,200,'Office Company Inc.');
INSERT INTO receipt_records (re_id,amount,v_name) 
VALUES (3,200,'Office Company Inc.');

commit;



