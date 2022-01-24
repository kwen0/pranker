# Pranker.io
The podcast ranker app

Original Project Planning Doc - https://docs.google.com/document/d/1u40Qy18w2PqTp1tpnbtiwtpPL9nLrlPCT3PMPkQnv64/edit#heading=h.is9a6rq47s8o


### Technologies
- Client
    - TBD...
- Server 
    - [Spring Boot](https://spring.io/projects/spring-boot): Spring based framework for developing stand-alone java apps
        - [H2](https://www.h2database.com/html/main.html): open source java database, usually embedded in java apps
        - view the pom.xml file for more info on what dependencies we use in this spring app
    - 

### How to run locally
1. Clone repo `git clone git@github.com:chumomega/pranker.git`
2. Open your IDE of choice (i use intellij)
3. Use maven to install dependencies (from pom.xml)
    - see [this picture](./maven-install-dependencies.png) for more details
4. Build application
5. Right click on [PrankerApplication.java](./src/main/java/com/v2/pranker/PrankerApplication.java) file in ide and click `Run Application`
6. Go to your browser and open `http://localhost:8990`
7. From here you can query the different endpoint we have like http://localhost:8990/h2-console or w.e else
8. Please correct if you see any mistakes :)


### Ways you could contribute
- Work on the front end views
- fix bug with auto increment for pod integers when they're available in db(probably need another wrapper)
- add some more endpoints that we need
- integrate postgres db on aws
- add security and user authentication



