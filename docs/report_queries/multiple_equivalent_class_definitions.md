# Multiple Equivalent Class Definitions

**Problem:** A class has more than one equivalent class definition. This should be avoided, as equivalent class definitions can interact adversely.

**Solution:** Combine the equivalent class statements.

```sparql
PREFIX owl: <http://www.w3.org/2002/07/owl#>

SELECT DISTINCT ?entity ?property ?value WHERE {
 VALUES ?property { owl:equivalentClass }
 ?entity ?property [ owl:intersectionOf ?value ] .
 ?entity ?property [ owl:intersectionOf ?value2 ] .
 FILTER (?value != ?value2)
 FILTER (!isBlank(?entity))
}
ORDER BY ?entity
```