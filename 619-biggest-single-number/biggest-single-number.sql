# Write your MySQL query statement below
SELECT (
  SELECT 
  num
  FROM MyNumbers
  Group by num
  having COUNT(num)=1
  order by num desc
  limit 1
) as num