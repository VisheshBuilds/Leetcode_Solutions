-- Write your PostgreSQL query statement below
SELECT wd.id
FROM Weather as w
JOIN Weather as wd
ON w.recordDate+1=wd.recordDate
WHERE wd.temperature>w.temperature