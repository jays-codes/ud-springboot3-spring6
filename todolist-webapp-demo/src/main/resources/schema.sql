create table todo(
	id integer not null,
	username varchar(45) not null,
	description varchar(75) not null,
	targetDate date not null,
	done boolean not null,
	primary key (id)	
);