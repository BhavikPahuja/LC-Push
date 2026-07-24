# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
LEFT JOIN Department d
ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(e1.salary)
    FROM Employee e1
    WHERE e.departmentId = e1.departmentId
);