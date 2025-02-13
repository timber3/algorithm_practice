
select flavor
from (
    select
        flavor, sum(total_order) as s
    from
        july 
    group by
        flavor
    union all
    select
        flavor, sum(total_order) as s
    from
        FIRST_HALF
    group by
        flavor
) c
group by
    flavor
order by sum(s) desc
limit 3
    
