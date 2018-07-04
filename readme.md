# Compile Project

```
mvn install
```

a jar file is generated in target folder as microservice-taux.jar

# Project Execution

Run the jar file using the command
```
java -jar microservice-taux.jar
```
## Create an exchange rate
```
POST http://localhost:8001/taux-change/rates/
```
```
{
    "src": "xxx",
    "dst": "xxx",
    "montant": xxx,
    "date": "yyyy-MM-dd"
}
```

## Read an exchange rate
```
GET http://localhost:8001/taux-change/rates/{id}
```
OR
```
GET http://localhost:8001/taux-change/src/{devise}/dst/{devise}/date/yyyy-MM-dd
```
## Update an exchange rate
```
PUT http://localhost:8001/taux-change/rates/{id}
```
```
{
    "id": {id},
    "src": "xxx",
    "dst": "xxx",
    "taux": xxx,
    "date": "yyyy-MM-dd"
}
```
## Delete an exchange rate
```
DELETE http://localhost:8001/taux-change/rates/{id}
```
