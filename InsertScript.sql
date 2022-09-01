INSERT INTO public.transaction_type
(trans_type)
values	('withdraw'),
		('deposit'),
		('transfer');
INSERT INTO public.user_type
(user_type)
VALUES('customer'),
('employee'),
('admin');

INSERT INTO public.users
(username, "password", full_name, phone, adress, email,user_type_id)
VALUES('cust1', 'passc1', 'customer1', 'c11111111', 'adress C1', 'emailc1@email.com',1),
	('cust2', 'passc2', 'customer2', 'c2222222', 'adress C2', 'emailc2@email.com',1),
	('cust3', 'passc3', 'customer3', 'c33333333', 'adress C3', 'emailc3email.com',1),
	('cust4', 'passc4', 'customer4', 'c4444444', 'adress C4', 'emailc4@email.com',1),
	('empl1', 'passe1', 'emplpyee1', 'e11111111', 'adress E1', 'emaile1@email.com',2),
	('empl2', 'passe2', 'emplpyee2', 'e2222222', 'adress E2', 'emaile2@email.com',2),
	('empl3', 'passe3', 'emplpyee3', 'e3333333', 'adress E3', 'emaile3@email.com',3)
;

INSERT INTO public.users
(username, "password", full_name, phone, adress, email,user_type_id)
VALUES('admin', 'admin', 'Administrator', 'a11111111', 'adress A1', 'admin@email.com',3);

ALTER TABLE accounts 
ALTER COLUMN account_type TYPE varchar(50);

ALTER TABLE accounts 
ALTER COLUMN acc_number TYPE varchar(50);

ALTER TABLE transactions 
ALTER COLUMN transact_date TYPE varchar(50);

INSERT INTO public.employees
(employee_role, user_id)
VALUES('empl1', 5 ),
('empl2', 6 ),
('admin', 7 )
;
INSERT INTO public.customers
(user_id, employee_id)
VALUES(1, 1),
(2, 1),
(3, 3),
(4, 2);

INSERT INTO public.accounts
(account_type, balance, created_on, is_active, acc_number)
VALUES('cheking', 1500, '8/19/2022', false, 'acc111111'),
('cheking', 15600, '8/20/2022', false, 'acc222222'),
('saving', 5300, '8/21/2022', false, 'acc3333333'),
('cheking', 2700, '8/22/2022', false, 'acc4444444'),
('saving', 60800, '8/26/2022', false, 'acc5555555');

INSERT INTO public.transactions
(transact_date, transact_ammount, transact_type, account_id)
VALUES('8/10/2022', 80, 1, 1),
('8/10/2022', 800, 2, 3),
('8/10/2022', 150, 1, 1),
('8/10/2022', 240, 2, 1),
('8/10/2022', 110, 1, 1);

INSERT INTO public.users_acc_bridg
(user_id, account_id)
VALUES(1, 2),
(1, 1),
(2, 2),
(3, 2),
(3, 3),
(3, 3),
(4, 2),
(5, 4);


UPDATE public.users
SET email='email1@email,com'
WHERE user_id=1;


INSERT INTO public.accounts
(account_type, balance, created_on, is_active, acc_number, last_login)
VALUES('ckeking', 450, '8/24/2022', false, 'A1234', '2017-03-31 9:30:20');

INSERT INTO public.transactions
(transact_date, transact_ammount, transact_type, account_id)
VALUES('8/24/2022', 60, 'deposit', 1);


ALTER TABLE accounts  
ADD employee_id int;

ALTER TABLE customers  
ADD username varchar(50);

ALTER TABLE customers  
ADD password varchar(50);

ALTER TABLE customers  
ADD email varchar(50);


DROP TABLE accounts , customers, employees, users_acc_bridg , transactions, transaction_type, users  ;

DROP TABLE users, employees , customers  ;

