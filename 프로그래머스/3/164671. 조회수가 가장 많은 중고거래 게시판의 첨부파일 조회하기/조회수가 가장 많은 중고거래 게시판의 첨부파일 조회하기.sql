# select concat('/home/grep/src/', a.BOARD_ID , '/' , a.FILE_ID , a.FILE_NAME , a.FILE_EXT)
# from USED_GOODS_FILE a, (
#     select Max(VIEWS)
#     from USED_GOODS_BOARD
# ) b
# where a.BOARD_ID = b.BOARD_ID
# order by a.FILE_ID

select concat('/home/grep/src/', a.BOARD_ID , '/' , FILE_ID , FILE_NAME , FILE_EXT)
from
    (select BOARD_ID
     from USED_GOODS_BOARD  
     where VIEWS = (
         select Max(VIEWS)
         from USED_GOODS_BOARD 
     )
    ) a, USED_GOODS_FILE  as b
where a.BOARD_ID = b.BOARD_ID
order by FILE_ID desc