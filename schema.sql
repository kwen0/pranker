create table IF NOT EXISTS pod
(
   id integer auto_increment not null,
   episode_title varchar(255) not null,
   name varchar(255) not null,
   avg_rating double(255) not null,
   primary key(id)
);

create table IF NOT EXISTS ratings
(
   id integer auto_increment not null,
   user_id integer not null,
   pod_id integer not null
   rating integer not null,
   comment varchar(255) not null,
   primary key(id),
   foreign key(user_id),
   foreign key(pod_id),

);

create table IF NOT EXISTS pranker
(
   id integer auto_increment not null,
   name varchar(255) not null,
   phone_num integer not null,
   email varchar(255) not null,
   password varchar(255) not null,
   primary key(id)
);