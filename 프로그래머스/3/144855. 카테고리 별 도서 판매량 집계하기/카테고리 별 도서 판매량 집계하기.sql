# select category, sum(sale) TOTAL_SALES
# from BOOK a left join (
#     select BOOK_ID, SUM(SALES) sale
#     from BOOK_SALES
#     where SALES_DATE like '2022-01%'
#     group by BOOK_ID) b using (BOOK_ID)
# group by category
# order by category;


select CATEGORY, sum(SALES)
from BOOK a join BOOK_SALES b on a.BOOK_ID = b.BOOK_ID
where SALES_DATE like '2022-01%'
group by CATEGORY
order by CATEGORY