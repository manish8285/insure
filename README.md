# insure
Insurance Management Plateform

Insure is a rest application that provide a plateform to manage insurance. This application is the complete solution for the insurance management. 
You can manage the following things

### Client Module
You can add new client, store and update information about client such as name,contact address etc.You can view all available clients that are stored inside the database; You can also get the all details of the particular client. Delete operations are also possible. 

### Policy Module
You can create new policy, get the list of all available policies or details of any particular policy. You can further update of delete the any particular policy.

### Claim Module
Claim management is very easy with the help of this application. You can see all the available claims,or can get details of particular claim.You can not only create the new claim but you can also update and delete the claim.

# How To Run This Application
## Method 1
1) Clone or download this repository
2) Create A Mysql database named insure
3) Database must have a user named 'admin' and password 'password'
3) Go to target directory and open the terminal or command prompt in case of windows
4) Run the jar file named 'insure-0.0.1-SNAPSHOT.jar' 
5) You can run the jar file by the command java -jar insure-0.0.1-SNAPSHOT.jar
6) Access the application on default port 8787 example http://localhost:8787/api/clients/

## Method 2
1) Clone or download this repository
2) Import the project in eclipse STS
3) If you wan make changes in the configuration file present in resources directory or setup database as per configuration
4) Run the project
5) Access the project at mentioned port like http://localhost:8787/api/clients/



## Technical specification
This is a SpringBoot project a rest application that follows MVC pattern and uses MySql database . The sturcture of the project is as follows
##### 1
This application contains properties.yml file in the resources folder that is configuration file for databases and port number
##### 2
entities package inside main package contains all the entity classes for this application such as client,claim and insurancePolicy.
##### 3
repositries package inside main package contains all the jpa repositries for the entities
##### 4
services package inside main package contains list of all the business logics 
##### 5 
imples package inside services contains all the implementations of the business logics.
##### 6
controllers package inside main package contains all the end points
##### 7
exceptions package inside main package contains all the exception classes


# Note
1) I have yoused MySql database instead of in memory database
2) Apis are not secured but most of my other projects are secured using JWT based authentication
3) Records are fetched in the form of list of objects that is not suitable for large amount of data. I mostly use pageable for such situation

