select 
    ORDER_ID,
    PRODUCT_ID,
    date_format(OUT_DATE, '%Y-%m-%d'),
    case
        when datediff(OUT_DATE, '2022-05-01') <= 0 then '출고완료'
        when datediff(OUT_DATE, '2022-05-01') > 0 then '출고대기'
        else '출고미정'
    end as 출고여부
from
    FOOD_ORDER