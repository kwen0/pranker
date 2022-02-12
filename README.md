# Pranker.io
The podcast ranker app

Original Project Planning Doc - https://docs.google.com/document/d/1u40Qy18w2PqTp1tpnbtiwtpPL9nLrlPCT3PMPkQnv64/edit#heading=h.is9a6rq47s8o


### Technologies
- Client
    - React
- Server 
    - [Spring Boot](https://spring.io/projects/spring-boot): Spring based framework for developing stand-alone java apps
        - look at pom.xml to view all packages needed to build Pranker
    - Postgres
        - look at package.json to view everything needed to build frontend

### Setup Application
1. Clone repo `git clone git@github.com:chumomega/pranker.git`
2. Open your IDE of choice (i use intellij)
3. Use maven to install dependencies (from pom.xml)
    - see [this picture](./maven-install-dependencies.png) for more details
4. Build application
5. create pranker db!
5. Right click on [PrankerApplication.java](./src/main/java/com/v2/pranker/PrankerApplication.java) file in ide and click `Run Application`
6. Go to your browser and open `http://localhost:8990`
8. Please correct if you see any mistakes

##### DB Setup
- `brew install postgres`
- `brew services start postgresql` to start postgres
- `psql postgres`
- `create user main_pranker;`
- `create role app with superuser;`
- `GRANT app to main_pranker;`
- `create database pranker;`
- `\q` `psql -U main_pranker -d pranker`
- to view tables: `select * from information_schema.tables;`
- create tables:
```
SELECT 
   table_name, 
   column_name, 
   data_type 
FROM 
   information_schema.columns
WHERE 
   table_name = 'pod';
```
```
create table IF NOT EXISTS pod
 (
    id integer not null,
    episode_title varchar(255) not null,
    name varchar(255) not null,
    avg_rating numeric not null,
    primary key(id)
 );
```
```
create table IF NOT EXISTS pranker
 (
    id integer not null,
    name varchar(255) not null,
    phone_num bigint not null,
    email varchar(255) not null,
    password varchar(255) not null,
    primary key(id)
 );
```
```
create table IF NOT EXISTS ratings
 (
    id integer not null,
    user_id integer not null,
    pod_id integer not null,
    rating numeric not null,
    comment varchar(255) not null,
    primary key(id),
    foreign key(user_id) references pranker(id),
    foreign key(pod_id) references pod(id)
 );
```
- enter dummy data: 
```
insert into pod
values(1,'#1005', 'JRE Podcast', 4.2);
insert into pod
values(2,'#1006', 'JRE Podcast', 3.9);
insert into pod
values(3,'#1007', 'JRE Podcast', 4.7);

insert into pranker
values(999, 'Chum Chum Oko', 6166166161, 'fakenews@gmail.com', 'password101');
insert into pranker
values(998, 'Bobby Bitch', 9199199191, 'fakenews2@gmail.com', 'password101');

insert into ratings
values(1, 999, 1, 5, 'horse dewormer and vitamin c');
insert into ratings
values(2, 998, 1, 3, 'some bullshit');

insert into ratings
values(3, 999, 2, 5, 'cool!');
insert into ratings
values(4, 998, 2, 3, 'average at best');

insert into ratings
values(5, 999, 3, 4, 'fauci and rhonda patrick');
insert into ratings
values(6, 998, 3, 4, 'fake doctors and fake news! deplatform this guy');
```
##### Troubleshooting
- If you cannot connect to the server, download [PGAdmin](https://www.pgadmin.org/download/)
- Click on connect server and make sure it looks like the below: 
<img width="556" alt="pgadmin" src="https://user-images.githubusercontent.com/87447527/153696472-7eda4e74-b873-448e-adfa-115fa1a1e3be.png">


### Ways you could contribute
- add user auth screen
- add form for users to add new podcast
- add modal to present podcast in a user friendly way
- add button to allow users to add a new rating
- add form for users to add rating
- ...



