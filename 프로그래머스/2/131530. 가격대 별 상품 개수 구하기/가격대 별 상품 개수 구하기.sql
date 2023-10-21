-- 코드를 입력하세요
SELECT floor(PRICE/10000)*10000 as val, COUNT(*)
from PRODUCT
group by floor(PRICE/10000)*10000
order by val;