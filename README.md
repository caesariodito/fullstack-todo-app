# Fullstack To Do App
A fullstack application for to do list using Spring Boot as the BE and Kotlin XML as the FE.

The Frontend which is mobile app is located on the [fe-todo](fe-todo/) directory.

The Backend which is the springboot web app is located on the [be-todo](be-todo/) directory.

## Acknowledgement

This is my personal ranting and thoughts (you can skip it).
[Acknowledgement](/Acknowledgement.md)

## Roadmap

Personal track record and documentation when I develop this app.
[Roadmap](Roadmap.md)

## Deployments

Springboot: Deployed on AWS EC2 Instance (t2.micro) free tier

URL API documentation: http://18.205.245.195:8080/docs

## Prerequisites

- database (sql family); in my case I use mariadb | for the springboot web app
- jdk17 (development of both)
- androidsdk 24 (to develop the android app)
- docker and docker-compose (containerization)

## How to run

The built app is available on the [/build](build/) directory. There are .apk and jar for the android app and springboot web app respectively. You can just run it with `java -jar` command or install the .apk.

To build the app from source:
- springboot web app: you can use the maven cli `./mvnw spring-boot:run` to run or compile the app and run via docker-compose.yaml `docker compose up` (also make sure to edit the .yaml file to match your desired configs) or jar (make sure to edit the [server.properties](be-todo/src/main/resources/application.properties) file) via `java -jar <jarfile>.jar`.
- android kotlin xml: you can open the project with Android Studio and run the app there using your desired device. I believe it is easier that way instead of running it via cli and setting up everything.

## Problems

I encountered problem mostly on the development of Frontend part, which is Kotlin XML. Well actually I encountered so many problems with these two app (FE and BE) due to my lack of understanding of the tools. But gratefully, I managed to create a working app, though I may not be considered good because of the outdated code and not-so best practice implementation that I did through the app.

Also, this is the first time that I got the chance to delve pretty deep into the MVVM architecture and the Springboot project structure. It was pretty 'alien' for me since I never touched those tools like years. For my journey in android development, I just have a basic knowledge of the development ecosystem tools (android studio with xml views) and most of the code that I wrote there was using jetpack compose.

Personally, the problem with the springboot development is on the lack of community and the official documentation to look up to. Most of the available code on the internet is outdated (even I believe that this code that I write is outdated). To integrate springboot with third-party dependencies is sometimes pretty stressing. Again... due to lack of documentation that I found (maybe it's just me, skill issue fr).

## Future Development and Improvements

- Offline feature using Room local database
- Best practice data and view binding for the Main view of the android app
- Refactor the android xml app and springboot web app
- More UI/UX friendly