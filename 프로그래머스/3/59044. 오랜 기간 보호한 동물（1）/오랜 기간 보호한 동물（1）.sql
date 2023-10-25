-- 코드를 입력하세요
SELECT AI.NAME, AI.DATETIME

from ANIMAL_INS as AI left join ANIMAL_OUTS as AO 
on AI.ANIMAL_ID = AO.ANIMAL_ID
where AO.ANIMAL_ID is null
order by AI.DATETIME limit 3;