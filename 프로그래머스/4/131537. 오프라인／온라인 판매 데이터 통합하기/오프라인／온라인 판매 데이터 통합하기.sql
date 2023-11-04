select *
from 
    (select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as date, PRODUCT_ID, USER_ID, SALES_AMOUNT
    from ONLINE_SALE
    where month(SALES_DATE) = 3

    union all

    select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as date, PRODUCT_ID, NULL as 'USER_ID', SALES_AMOUNT
    from OFFLINE_SALE
    where month(SALES_DATE) = 3) r
order by r.date, r.PRODUCT_ID, r.USER_ID



