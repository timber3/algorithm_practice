select 
    (case
        when PRICE < 10000 then 0
        else truncate(price, -4)
     end) as price_group, count(*)
from
    product
group by
    price_group
order by
    1