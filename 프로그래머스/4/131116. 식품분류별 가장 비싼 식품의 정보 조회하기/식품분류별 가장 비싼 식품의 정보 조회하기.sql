select distinct a.CATEGORY, MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT a
join (
    select CATEGORY, MAX(PRICE) as MAX_PRICE
    from FOOD_PRODUCT 
    group by CATEGORY
) b on a.PRICE = b.MAX_PRICE
where a.CATEGORY in ('과자', '국', '김치', '식용유')
order by MAX_PRICE desc;