# TrafficSignalProblem
A very small Spring Boot Application with the below business problem:

A logic that controls the traffic signals for a four-way intersection. 
Initially, consider traffic flowing in straight lines only, no turns and with below rules:

1. Cars arrive in each direction on both roads (Snell and Weaver) at the rate of 1 car per second. That is, 4 cars approach the intersection each second.
 
2. Only one road (Snell or Weaver) can have a "green" light at one time.
 
3. It is acceptable for both roads to have the "red" light at the same time. Of course, traffic backs up on both roads if this happens.
 
4. Start by turning on the traffic on Snell Rd "green" in both directions for 3 seconds; then turn it "red" for one second; then turn Weaver "green" for 3 seconds; and then red for one second.
 
5. When the light turns from red to green at any intersection, it takes the first car 2 seconds to start moving and cross the intersection. Subsequent cars take 1 second each.
 
6. At the instant the light turns from "green" to "red", a car may not start moving to cross the intersection; whether that car just arrived at the intersection or was waiting at that intersection.
 
7. The output should be the number of cars that are waiting at the intersection in each direction at each second, for the first 20 seconds. Do not make the program wait 20 seconds to produce the output: this is only a simulation, so print the output when it's ready.

## Getting Started
Download the project. If you open this project in any IDE, start the app as an spring boot application. 
The application will run on the default port 8080
It exposes a basic endpoint which will initiate the traffic control will return a HTTP Status of 200.

If this application needs to be run as the package then perform a mvn command from the project folder

```
mvn clean install
```

and then to run as a packaged application run the below command

```
java -jar target/TrafficSignalProblem-0.0.1-SNAPSHOT.jar
```

Use any Rest client to hit the endpoint
```
http://<hostname>:8080/
```

Or using curl command
```
curl http://<hostname>:8080/
```

**The output can be seen on the console.**

## Configuration

In application.properties, there are two properties which can be set.

Initially these are values set:

```
traffic.red.light.frequency=4
traffic.operatrion.frequency=20
```

## Junits and Coverage

Junits are written as per the spring boot application and for now the coverage is just above 90%.

## Author

Sameer Hashmi
