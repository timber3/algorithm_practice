select
    concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT)
from
    USED_GOODS_FILE  
where
    BOARD_ID in (
        select
            *
        from
            (select
                BOARD_ID
             from
                USED_GOODS_BOARD
             order by views desc limit 1
            ) as t
    )
order by FILE_ID desc