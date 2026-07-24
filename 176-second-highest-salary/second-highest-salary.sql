# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary
FROM Employee e1
WHERE salary != (
    SELECT MAX(salary)
    FROM Employee e2
);