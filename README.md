# Sample requests

* Create a profile

```
http --json POST http://localhost:8080/api/profile livesInUrbanArea=false isRetired=true hasChild=false livesInHouse=true preferredMeansOfTransport=CAR postalCode=07321
```

* Get a profile

```
http http://localhost:8080/api/profile/c0fc3a2a-aae7-4af0-bf4a-7aec40946635
```

* Get the list of topics

```
http http://localhost:8080/api/topic
```

* Add a topic to a profile

```
http POST http://localhost:8080/api/profile/c0fc3a2a-aae7-4af0-bf4a-7aec40946635/topic/bfaaa366-7d07-4a49-8d75-1998b6641bdb
```
