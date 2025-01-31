select
    animal_type, count(*)
from
    animal_ins
group by
    animal_type
having
    animal_type = 'Cat' or animal_type = 'Dog'
order by
    1