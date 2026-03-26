# Write your MySQL query statement below
SELECT e.name
FROM Employee as e
Inner join Employee as m 
ON e.id = m.managerId
group by m.managerId
having count(m.managerId)>=5
-- SELECT e.name
-- FROM Employee AS e 
-- INNER JOIN Employee AS m ON e.id=m.managerId 
-- GROUP BY m.managerId 
-- HAVING COUNT(m.managerId) >= 5
