select
    a.user_id, a.nickname, b.total_sales
from 
    USED_GOODS_USER a join (
        select
            writer_id, sum(price) total_sales
        from
            USED_GOODS_BOARD 
        where
            status regexp ('DONE')
        group by
            writer_id
        ) b on (a.user_id = b.writer_id)
where
    b.total_sales >= 700000
order by
    b.total_sales
