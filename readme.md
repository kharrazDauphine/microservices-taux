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
## Create a transaction
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

## Read a transaction
```
GET http://localhost:8001/taux-change/rates/{id}
```
OR
```
GET http://localhost:8001/taux-change/src/{devise}/dst/{devise}/date/yyyy-MM-dd
```
## Update a transaction
```
PUT http://localhost:8001/taux-change/rates/{id}
```
{
    "id": {id},
    "src": "xxx",
    "dst": "xxx",
    "taux": xxx,
    "date": "yyyy-MM-dd"
}
```
## Delete a transaction
```
DELETE http://localhost:8001/taux-change/rates/{id}
```
