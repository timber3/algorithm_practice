-- 코드를 입력하세요
# select ri.FOOD_TYPE, ri.REST_ID, ri.REST_NAME, ri.FAVORITES
# from 
#     (select FOOD_TYPE, max(FAVORITES) as mf
#     from REST_INFO 
#     group by FOOD_TYPE
#     ) t join REST_INFO ri on t.mf = ri.FAVORITES
# order by FOOD_TYPE desc

select a.FOOD_TYPE, a.REST_ID, a.REST_NAME, b.m
from REST_INFO a
    join (
        select FOOD_TYPE, MAX(FAVORITES) as m
        from REST_INFO
        group by FOOD_TYPE
    ) b on a.FOOD_TYPE = b.FOOD_TYPE and b.m = a.FAVORITES
order by a.FOOD_TYPE desc