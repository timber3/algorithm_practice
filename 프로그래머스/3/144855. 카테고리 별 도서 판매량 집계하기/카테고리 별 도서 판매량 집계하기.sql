

select category, sum(sale) TOTAL_SALES
from BOOK a left join (
    select BOOK_ID, SUM(SALES) sale
    from BOOK_SALES
    where SALES_DATE like '2022-01%'
    group by BOOK_ID) b using (BOOK_ID)
group by category
order by category

;
