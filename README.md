# Working with Objects through RedisTemplate

Most users are likely to use **RedisTemplate** and its corresponding package, `org.springframework.data.redis.core` <br/>
The template is, in fact, the central class of the Redis module, due to its rich feature set <br/>
The template offers a high-level abstraction for Redis interactions <br/>
<br/>
While **RedisConnection** offers low-level methods that accept and return binary values (byte arrays) <br/>
<br/>
Moreover, the template provides operations views that offer rich, generified interfaces for working against a certain type as described in the following table:

| INTERFACES         | DESCRIPTION                    |
|--------------------|--------------------------------|
|ValueOperations     | String (or value) operations   |
|ListOperations      | List operations                |
|HashOperations      | Hash operations                |
|SetOperations       | Set operations                 |
|ZSetOperations      | SortedSet operations           |
|BoundKeyOperations  | Key bound operations                |
|BoundValueOperations| String key bound operations         |
|BoundListOperations | List key bound operations           |
|BoundHashOperations | Hash key bound operations           |
|BoundSetOperations  | Set key bound operations            |
|BoundZSetOperations | SortedSet key bound operations      |



