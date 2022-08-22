
create table member(
                       num int not null auto_increment,
                       id varchar(20) primary key,
                       pass varchar(20) not null,
                       name varchar(30) not null,
                       age int not null,
                       email varchar(30) not null,
                       phone varchar(30) not null,
                       usergrant int,
                       unique key(num)
);

create table contents(

                         contentnum int primary key,
                         id varchar(20) not null,
                         title varchar(20) not null,
                         content varchar(20) not null,
                         contentdate datetime not null,
                         contentempathy int not null,
                         foreign key (id) references member(id) on delete cascade on update cascade
);

create table comments(

                         commentnum int primary key,
                         contentnum int not null,
                         id varchar(20) not null,
                         comments varchar(20) not null,
                         commentsdate datetime not null,
                         contentempathy int not null,
                         foreign key (id) references member(id) on delete cascade on update cascade,
                         foreign key (contentnum) references contents(contentnum) on delete cascade on update cascade
);
