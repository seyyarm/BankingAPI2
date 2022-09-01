select * from users;
select * from user_type;
select * from transaction_type tt ;
select * from accounts;
select * from transactions;
SELECT * FROM public.users_acc_bridg;

select * from accounts where is_active = true;
select * from accounts where is_active = false;



select accounts.account_id,users.user_id ,users.full_name , account_type, balance, created_on, is_active
from accounts, users, users_acc_bridg uab
where users.user_id = uab.user_id ;

delete from transaction_type where trans_type_id=1;

DELETE FROM public.transactions
WHERE transact_id=1;

DELETE FROM public.accounts
WHERE account_id=1;

ALTER TABLE  employees 
RENAME COLUMN employee_name TO name;

ALTER TABLE public.users drop COLUMN email;


