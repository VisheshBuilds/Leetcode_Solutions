# Write your MySQL query statement below
SELECT e.name
FROM Employee as e
JOIN Employee as em
ON e.id=em.managerId
GROUP BY e.id
HAVING COUNT(em.managerId) >=5