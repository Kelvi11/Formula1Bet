# Formula1Bet
This is API written in java that allows the users:
* List of formula 1 events.
* Place a bet on those events.
* Simulate event outcome.

# Prerequisites

Java 21 should be installed in the OS in which this project will be run.  

Apache Maven 3.9.6 should be installed in the OS in which this project will be built.

# Build and run the project 

Navigate to Project directory ({directlyWereDownloaded}/Formula1Bet), open a terminal window and then run the following command:

```mvn spring-boot:run```

# Test the application

### List of formula 1 events:

Case 1 : List the events paginated to the first 20 and ordered by starting date descending.

``GET localhost:8080/api/events``

Case 2 : List the events filtered sessionType, year and/or countryCode, paginated by the values of offset and size, and ordered by starting date descending.

``GET localhost:8080/api/events?sessionType=Practice&year=2023&countryCode=ITA&offset=20&size=10``

### Place a bet on those events:

Case 1: Event with given id doesn't exist.

``
POST localhost:8080/api/bets
{
    "eventId": 922234,
    "driverNumber": 3,
    "amount": 15,
    "odds": 2
}
``

Case 2: User has insufficient funds.

``
POST localhost:8080/api/bets
{
    "eventId": 9222,
    "driverNumber": 3,
    "amount": 1000,
    "odds": 2
}
``

Case 3 : Bet is placed correctly.

``
POST localhost:8080/api/bets
{
    "eventId": 9222,
    "driverNumber": 3,
    "amount": 15,
    "odds": 2
}
``

### Simulate event outcome:

Case 1: Event with given id doesn't exist.

``
POST localhost:8080/api/events/outcome
{
    "eventId" : 922234343,
    "driverNumber": 3
}
``

Case 2: Driver with given number doesn't exist.

``
POST localhost:8080/api/events/outcome
{
    "eventId" : 9222,
    "driverNumber": 3
}
``

Case 3: Event outcome is propagated in the system

``
POST localhost:8080/api/events/outcome
{
    "eventId" : 9222,
    "driverNumber": 1
}
``
