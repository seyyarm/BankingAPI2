CREATE TABLE accounts (
	account_id serial PRIMARY KEY,
	account_type VARCHAR ( 50 ) NOT NULL,
	balance integer NOT NULL,
	created_on varchar(50) NOT NULL,
	is_active boolean NOT NULL,
	acc_number VARCHAR ( 255 ) NOT NULL
);

CREATE TABLE transaction_type (
	trans_type_id serial PRIMARY KEY,
	trans_type varchar(50) not null
);

CREATE TABLE transactions (
	transact_id serial PRIMARY KEY,
	transact_date varchar(50),
	transact_ammount integer not null,
	transact_type int not null,
	account_id int,
	CONSTRAINT fk_accounts
      FOREIGN KEY(account_id) 
	  REFERENCES accounts(account_id),
	
	CONSTRAINT fk_transaction_type
      FOREIGN KEY(transact_type) 
	  REFERENCES transaction_type(trans_type_id)
);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	username varchar(50) not null,
	password varchar(50) not null,
	full_name varchar(150) not null,
	phone varchar(50),
	adress varchar(150),
	email varchar(50),
	user_type_id int,
		 CONSTRAINT fk_user_type
      FOREIGN KEY(user_type_id) 
	  REFERENCES user_type(user_type_id)
	
);

create  table user_type(
	user_type_id serial PRIMARY KEY,
	user_type varchar(50)
);

CREATE TABLE users_acc_bridg (
	user_id int,
	account_id int,
	CONSTRAINT fk_accounts
      FOREIGN KEY(account_id) 
	  REFERENCES accounts(account_id),
	  
	  CONSTRAINT fk_users
      FOREIGN KEY(user_id) 
	  REFERENCES users(user_id)
);


