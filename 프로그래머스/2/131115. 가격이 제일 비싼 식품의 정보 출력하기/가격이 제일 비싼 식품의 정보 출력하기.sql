select *
from FOOD_PRODUCT 
where price in
(
    select max(price)
    from FOOD_PRODUCT
)
              