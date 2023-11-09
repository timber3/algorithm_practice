select ANIMAL_ID, ANIMAL_TYPE, NAME
from ANIMAL_OUTS a join 
    (select ANIMAL_ID
    from ANIMAL_INS 
    where SEX_UPON_INTAKE like '%Intact%') b using(ANIMAL_ID)
where a.SEX_UPON_OUTCOME like '%Spayed%' or
    a.SEX_UPON_OUTCOME like '%Neutered%'