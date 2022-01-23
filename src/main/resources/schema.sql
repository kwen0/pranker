drop table if exists pod;
create table IF NOT EXISTS pod
(
   id integer not null,
   episode_title varchar(255) not null,
   name varchar(255) not null,
   avg_rating double(255) not null,
   primary key(id)
);

drop table if exists pranker;
create table IF NOT EXISTS pranker
(
   id integer not null,
   name varchar(255) not null,
   phone_num bigint not null,
   email varchar(255) not null,
   password varchar(255) not null,
   primary key(id)
);

drop table if exists ratings;
create table IF NOT EXISTS ratings
(
   id integer not null,
   user_id integer not null,
   pod_id integer not null,
   rating integer not null,
   comment varchar(255) not null,
   primary key(id),
   foreign key(user_id) references pranker(id),
   foreign key(pod_id) references pod(id)
);