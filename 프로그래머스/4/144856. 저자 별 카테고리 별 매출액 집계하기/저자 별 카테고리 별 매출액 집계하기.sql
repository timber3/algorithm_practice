select a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES * PRICE) as TOTAL_SALES
from BOOK a
join BOOK_SALES b on a.BOOK_ID = b.BOOK_ID
join AUTHOR c on a.AUTHOR_ID = c.AUTHOR_ID
where sales_date like '2022-01%'
group by AUTHOR_ID, CATEGORY
order by AUTHOR_ID, CATEGORY desc