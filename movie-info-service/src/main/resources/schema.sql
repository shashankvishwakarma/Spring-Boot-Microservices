create table movie(
	id bigint not null,
	title varchar(255),
	overview varchar(255)
);

alter table movie add constraint constraint_1 primary key(id);

