-- 코드를 입력하세요
SELECT FH.FLAVOR
from FIRST_HALF as FH Join ICECREAM_INFO as II on FH.FLAVOR = II.FLAVOR
where TOTAL_ORDER > 3000 and INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER desc