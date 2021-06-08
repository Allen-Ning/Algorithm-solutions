# Write your MySQL query statement below
select Scores.Score, count(UniqScores.Score) AS RANK
from Scores
join (select distinct Score from Scores) as UniqScores
on Scores.Score <= UniqScores.Score
group by Scores.id
order by Scores.Score desc
