# select CATEGORY, s
# from BOOK a join 
#     ()
# order by CATEGORY

select CATEGORY, sum(s)
from BOOK a join 
    (select BOOK_ID, SUM(SALES) as s
    from BOOK_SALES 
     where SALES_DATE like '2022-01%'
    group by BOOK_ID) b using (BOOK_ID)
group by CATEGORY
order by CATEGORY