# select HOUR, COUNT
# from ANIMAL_OUTS 
# where 

select HOUR(DATETIME), COUNT(*)
from (
select * from ANIMAL_OUTS 
where HOUR(DATETIME) between 9 and 19
    ) t
    group by HOUR(DATETIME)
    order by HOUR(DATETIME)