create or replace procedure p_login_check(p_username in varchar2,p_password in varchar2,p_count out number)
as
v_count number(10);

begin
select count(*) into v_count from users where username=p_username AND password=p_password;
p_count:=v_count;
dbms_output.put_line('count: '||' '||v_count);  
end;
/

declare
v_count number(10);
begin
p_login_check('ramesh','1234',v_count);
dbms_output.put_line('Login Status: '||v_count);
end;
/