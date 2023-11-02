
select USER_ID, PRODUCT_ID
from (
    select USER_ID, PRODUCT_ID, count(*) as cnt
    from ONLINE_SALE 
    group by USER_ID, PRODUCT_ID) t
where t.cnt >= 2
order by USER_ID, PRODUCT_ID desc
      
      
