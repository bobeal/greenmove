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

* Add a read article to a profile

```
http POST http://localhost:8080/api/profile/0b9c9f33-4fb1-4dbd-91c8-869327f24386/article/article-ref
```

* Get a count of trees won by a profile

```
http http://localhost:8080/api/profile/0b9c9f33-4fb1-4dbd-91c8-869327f24386/treesWon
```

* Get all the articles

```
http http://localhost:8080/api/article
```

* Get all the articles on a given topic

```
http http://localhost:8080/api/article?topic=Alimentation
```
