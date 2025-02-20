# with result as (
    
# )

# select *
# from result
# order by datetime


select a.name name, a.datetime datetime
    from ANIMAL_INS a left join ANIMAL_OUTS b on (a.ANIMAL_ID = b.ANIMAL_ID)
    where b.datetime is null
    order by a.datetime
    limit 3
