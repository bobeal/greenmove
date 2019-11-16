# Sample requests

* Create a profile

```
http --json POST http://localhost:8080/api/profile livesInUrbanArea=false isRetired=true hasChild=false livesInHouse=true preferredMeansOfTransport=CAR postalCode=07321
```

* Get a profile

```
http http://localhost:8080/api/profile/c0fc3a2a-aae7-4af0-bf4a-7aec40946635
```
