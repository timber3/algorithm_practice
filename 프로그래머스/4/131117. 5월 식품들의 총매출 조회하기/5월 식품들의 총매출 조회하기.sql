# select PRODUCT_ID, PRODUCT_NAME, (AMOUNT * PRICE) TOTAL_SALES
# from FOOD_PRODUCT a join 
#     (select *
#      from FOOD_ORDER
     
# where PRODUCE_DATE like '2022-05%'
# group by PRODUCT_ID
# order by TOTAL_SALES desc , PRODUCT_ID

select PRODUCT_ID, PRODUCT_NAME, (PRICE * s) as TOTAL_SALES
from FOOD_PRODUCT a join (
    select PRODUCT_ID, SUM(AMOUNT) as s, PRODUCE_DATE
    from FOOD_ORDER
    where PRODUCE_DATE like '2022-05%'
    group by PRODUCT_ID
    ) b
    using (PRODUCT_ID)
order by TOTAL_SALES desc, PRODUCT_ID
