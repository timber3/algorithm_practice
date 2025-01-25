
select YEAR(a.DIFFERENTIATION_DATE) YEAR, b.mx - a.SIZE_OF_COLONY YEAR_DEV, a.id ID
from ECOLI_DATA a join (
    select max(SIZE_OF_COLONY) mx, YEAR(DIFFERENTIATION_DATE) as year_dev
    from ECOLI_DATA
    group by YEAR(DIFFERENTIATION_DATE)
) b on (YEAR(a.DIFFERENTIATION_DATE) = b.year_dev)
order by YEAR, YEAR_DEV
    

