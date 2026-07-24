# Write your MySQL query statement below
SELECT e1.name AS Employee
FROM Employee e1
WHERE managerId IS NOT NULL
AND e1.salary > (
    SELECT e2.salary
    FROM Employee e2
    WHERE e1.managerId = e2.id
)