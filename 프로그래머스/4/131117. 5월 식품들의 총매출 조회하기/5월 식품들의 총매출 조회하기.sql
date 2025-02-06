select
    a.PRODUCT_ID, a.PRODUCT_NAME, sum(b.AMOUNT * a.PRICE)
from
    FOOD_PRODUCT a join FOOD_ORDER b on (a.product_id = b.product_id)
where
    PRODUCE_DATE like '2022-05%'
group by
    a.PRODUCT_ID, a.PRODUCT_NAME
order by
    3 desc, 1