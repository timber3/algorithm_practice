
select ANIMAL_ID, Name
from (
select a.ANIMAL_ID, a.Name, TIMESTAMPDIFF(SECOND, a.DATETIME, b.DATETIME) as res
from ANIMAL_INS a join ANIMAL_OUTS b using(ANIMAL_ID)
order by res desc
limit 2) t
