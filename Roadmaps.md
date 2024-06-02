# fullstack-todo-app
A fullstack application for to do list using Spring Boot as the BE and Kotlin XML as the FE

BACKEND
1. init
2. create database (be-todo-bca) with mysql
3. create 4 package (
    controllers
    services
    repositories
    models
)
4. crud api implemented (unmodified)
5. modify the model, service, etc to match the requested payload
6. add seeder
7. MINUS:
   1. Flyway or Liquibase V
   2. error handling V
   3. code quality (formatting and linters) skipped
   4. UNIT TEST


FRONTEND (MOBILE)
1. init
2. add dependencies
3. explore mvvm, how to fetch from api, example project on todo list app
4. creating (via gpt and other project reference) using data binding, mvvm, retrofit (api fetching), lifecycle livedata
5. debugging and testing to connect using local server (windows)
6. success fetching all data from server
7. MINUS:
   1. other CRUD operations
8. other crud operations implemented
9. PROBLEM: when pressing delete button, it requests to the server, but the UI doesn't reload
10. Add create endpoint function
11. SOLVED THE DELETE PROBLEM
12. MINUS:
    1.  creating user-friendly UI 
    2.  get single todo API not used (View task detail)
    3.  response of delete is not correct yet (BACKEND) V
    4.  Error handling 
    5.  Code Quality 

SUPER MINUS:
1. containerized V
2. deployment V

IMPULSIVE THOUGHTS:
1. DOCKER COMPOSE!?!!? V

WORKING ON MINUS
1. response delete is correct V
2. id not found handler V
3. flyway implemented V
4. rename task to todo V
5. containerization with docker compose V 
6. deploy the backend on AWS V


AWS SSH:
1. apt update & upgrade
2. install docker, docker-compose, git (https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository) (https://docs.docker.com/compose/install/linux/)
3. clone my repo
4. move the jar in build directory to the target directory (below docker-compose.yml)
5. docker compose up -d
6. access the public ip with port 8080/docs
7. finished

WORKING ON MINUS AGAIN:
1. get single todo api
2. creating user-friendly UI 
3. Error handling and linters