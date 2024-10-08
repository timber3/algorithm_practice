# select FLAVOR
# from FIRST_HALF 
# where TOTAL_ORDER > 3000 and FLAVOR in (
#     select FLAVOR
#     from ICECREAM_INFO 
#     where INGREDIENT_TYPE = 'fruit_based'
# )
# order by TOTAL_ORDER desc;

select FLAVOR
from FIRST_HALF a left join ICECREAM_INFO b using (FLAVOR)
where a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER DESC;