-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF as FH JOIN ICECREAM_INFO as II
ON FH.FLAVOR = II.FLAVOR
group by INGREDIENT_TYPE
order by TOTAL_ORDER;

