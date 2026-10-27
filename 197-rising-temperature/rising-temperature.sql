# Write your MySQL query statement below

SELECT wd.id
FROM Weather as w
JOIN Weather as wd
ON wd.recordDate=DATE_ADD(w.recordDate, INTERVAL 1 DAY )
WHERE wd.temperature>w.temperature