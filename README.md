# Database Specialisation
Welcome to my JCore specialisation. In this repository you can find the progress I've made on the various goals I've 
set.

## Database types
1. Relational
2. Non-relational
   * Document stores
   * Key-value stores
   * Graph database
   * Wide-colum stores

### Relational databases
Relational databases are ideal for storage of structured data. Data is stored as row records in tables and can be 
related to one another. This database type is also capable of processing data in a transactional manner (ACID), 
meaning that a transaction always guarantees a consistent database. However, this database type has issues of its own in 
the current big data era, as it struggles to process data in quantities generated by for example social media.

### Non-relational databases
Non-relational databases on the other hand, process data in an unstructured manner. These databases are roughly divided 
in four categories; document stores, key-value stores, graph databases and wide-column stores. Databases in these
different categories each model the data in a unique way. The unstructured models allow these databases to scale 
horizontally instead of vertically, unlike relational databases.

#### Document stores
This database type models data in a rich text format, namely JSON, BSON or XML. Each document is considered a standalone 
entity and contains an aggregate of information. This type of database is especially efficient at retrieving data, but 
is not capable of handling relationships between documents.

#### Key-value stores
This database type models data as key-value pairs. Each key is unique and is associated with a value. This type of
database is especially efficient at retrieving data, but is not capable of handling relationships between key-value 
pairs.

#### Time series databases
This database type models data as time-value pairs. Each value is associated with a timestamp, meaning that this
database type is optimized for measuring change over time. This database is ideal for storage of events, measurements,
clicks, trades and the like. 

#### Graph databases
This database type models data as graphs. Social media is a great example, as one user can be connected to other users, 
which each have their own befriended users. This type of database is especially effective at representing relationships, 
while the structure of the data is not known beforehand.

#### Wide-column stores
This database type models data as rows and columns, however wide-column stores are ideal for storing rows that have
different values in different columns. For example, it is very efficient at handling empty columns, in contrast to 
relational databases.

## Database choices
1. Relational 
   1. PostgresSQL 
   2. MariaDB 
   3. Oracle

2. Non-relational
   1. MongoDB
   2. Elasticsearch
   3. Redis
   4. Neo4j
   5. Cassandra
   6. InfluxDB

## Decision tree
```mermaid
graph TD
    Start --> Intro{Question A}
    Intro --> |Yes| SQL[Branch 1]
    Intro --> |No| NoSQL[Branch 2]
    
    SQL --> C1{Question B}
    C1 --> |Yes| D1[Leaf 1]
    C1 --> |No| D2[Leaf 2]
   
    click D1 href "#References"
   
    NoSQL --> C2{Question C}
    C2 --> |Yes| D3[Leaf 1]
    C2 --> |No| D4[Leaf 2]
```

## References
### Links
- [Mermaid editor](https://mermaid.live)

### Sources
- [Types of SQL databases](https://www.altexsoft.com/blog/business/comparing-database-management-systems-mysql-postgresql-mssql-server-mongodb-elasticsearch-and-others/)
- [Types of NoSQL databases](https://www.mongodb.com/scale/types-of-nosql-databases)
- [Time series databases](https://www.influxdata.com/time-series-database/)
- [SQL vs NoSQL](https://www.keboola.com/blog/relational-vs-non-relational-database-when-to-use-one-instead-of-the-other)
