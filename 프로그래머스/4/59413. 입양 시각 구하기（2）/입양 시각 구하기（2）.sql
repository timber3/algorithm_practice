with recursive hours as (
    select 0 as hour
    union all
    select hour + 1 from hours where hour < 23
)

select
    a.hour, count(animal_id)
from
    hours a left join animal_outs b on (a.hour = hour(b.datetime))
group by
    a.hour
order by
    1
