-- 코드를 입력하세요
# SELECT TITLE, gb.BOARD_ID, REPLY_ID, gr.WRITER_ID, gr.CONTENTS, date_format(gr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
# from USED_GOODS_BOARD as gb
# join USED_GOODS_REPLY as gr
# on gb.BOARD_ID = gr.BOARD_ID
# where gr.CREATED_DATE like '2022-10-%'
# order by gr.CREATED_DATE , TITLE;

select TITLE, gb.BOARD_ID, REPLY_ID, gr.WRITER_ID, gr.CONTENTS, date_format(gr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as gb, USED_GOODS_REPLY as gr
where gb.BOARD_ID = gr.BOARD_ID and gb.CREATED_DATE like '2022-10-%'
order by gr.CREATED_DATE, TITLE;