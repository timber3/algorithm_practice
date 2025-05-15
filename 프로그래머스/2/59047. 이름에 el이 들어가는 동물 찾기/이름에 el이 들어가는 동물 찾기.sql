SELECT ANIMAL_ID, NAME

from ANIMAL_INS 

where (name regexp 'EL' or name regexp 'el') and ANIMAL_TYPE = 'Dog'

order by name