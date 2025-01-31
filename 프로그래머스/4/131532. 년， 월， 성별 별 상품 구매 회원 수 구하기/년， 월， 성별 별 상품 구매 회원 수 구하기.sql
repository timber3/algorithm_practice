SELECT
    YEAR(sales_date),
    MONTH(sales_date),
    gender,
    count(distinct ui.user_id)
from
    user_info ui join online_sale os on (ui.user_id = os.user_id)
where
    ui.gender is not null 
group by
    YEAR(sales_date), MONTH(sales_date), gender   
order by
    YEAR(sales_date), MONTH(sales_date), gender