-- 코드를 입력하세요
select PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
from (
    SELECT Max(PRICE) as pp
    from FOOD_PRODUCT
    ) as t, FOOD_PRODUCT 
where PRICE = t.pp