# **DATABASE MODELING 101**

Fay, D. (n.d.). Data Modeling | Know Your Problem Space. Prisma’s Data Guide. Retrieved January 25, 2023, from https://www.prisma.io/dataguide/datamodeling/know-your-problem-space

### **Goal of data modeling problem**
- *"Defining useful entities and identifying whether and how they relate to one another in a web or graph of connections*"

## **Identifying the entities**
- "What categories do we really care about?"
- Relational databases are complicated, not complex like neural networks, economies, languages, life itself, etc.
    - simply made of many individual parts
        - each of them has their own role

## **Important connections**
- When dropping tables, we should use `cascade` because it manages all the dependencies related to other tables (foreign keys)

## **Level of detail**
*"Some information too is useful, but already has its own internal structure which is less than convenient to transform into entities and relationships."* 

<ins>**Hierarchies, hypertext documents, bills of materials, even transient "working copies" of entity-relationship subgraphs elsewhere in the database; these or the information they contain can be represented relationally, but unless there are important relationships crossing the boundary between external and internal structure, it's likely not worth the effort of breaking them open.**</ins>  

*If this kind of information is your primary concern, specialized databases may be appropriate, like (for hierarchical documents) CouchDB or MongoDB. If they're exceptions to an otherwise relational model, data types such as JSON and XML can help avoid splitting your model across two or more databases. Not only is each additional data store more work to maintain and coordinate, referential integrity, the guarantee that information a relationship is predicated upon won't up and vanish, only holds inside a single database.*"