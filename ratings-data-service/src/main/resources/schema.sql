create table rating(
	movieid bigint not null,
	rating bigint
);

alter table rating add constraint constraint_1 primary key(movieid);

