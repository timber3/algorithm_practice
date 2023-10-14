-- 코드를 입력하세요
SELECT ao.ANIMAL_ID ANIMAL_ID, ao.NAME NAME
from ANIMAL_OUTS as ao left join ANIMAL_INS as ai
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.ANIMAL_ID is null;