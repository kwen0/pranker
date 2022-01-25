# Pranker.io
The podcast ranker app

Original Project Planning Doc - https://docs.google.com/document/d/1u40Qy18w2PqTp1tpnbtiwtpPL9nLrlPCT3PMPkQnv64/edit#heading=h.is9a6rq47s8o


### Technologies
- Client
    - TBD...
- Server 
    - [Spring Boot](https://spring.io/projects/spring-boot): Spring based framework for developing stand-alone java apps
        - Postgres: open source java database, usually embedded in java apps
        - view the pom.xml file for more info on what dependencies we use in this spring app
    - 

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
- psql postgres
- 

### Ways you could contribute
- Work on the front end views
- add some more endpoints that we need
- integrate postgres db on aws
- add security and user authentication



