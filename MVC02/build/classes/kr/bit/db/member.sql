-- member(회원) teble
create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(20) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null,
	unique key(id)
)

-- SQL(CRUD), JDBC

-- 검색
select * from member;
select * from member where num=1;
-- insert(저장)
insert into member(id, pass, name, age, email, phone)
values ('admin','admin','관리자',30,'bit@naver.com','010-1111-1111');

-- update(수정)
update member set age=31, phone='010-1111-0000' where id='admin';

-- delete(삭제)
delete from member where id='admin';

drop table member;