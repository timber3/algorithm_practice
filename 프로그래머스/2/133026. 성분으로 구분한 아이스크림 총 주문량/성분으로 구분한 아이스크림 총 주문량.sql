select INGREDIENT_TYPE, sum(TOTAL_ORDER) TOTAL_ORDER
from FIRST_HALF a join ICECREAM_INFO b on (a.flavor = b.flavor)
group by INGREDIENT_TYPE
order by TOTAL_ORDER