# 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
# 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.

select a.ANIMAL_ID, a.NAME
from ANIMAL_INS a join ANIMAL_OUTS b on (a.ANIMAL_ID = b.ANIMAL_ID)
order by datediff(a.DATETIME, b.DATETIME)
limit 2