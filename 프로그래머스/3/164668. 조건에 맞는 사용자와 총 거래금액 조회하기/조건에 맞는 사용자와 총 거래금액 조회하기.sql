-- 코드를 입력하세요
# SELECT GU.USER_ID, GU.NICKNAME, sum(GB.PRICE) as TOTAL_SALES
# FROM USED_GOODS_USER as GU JOIN USED_GOODS_BOARD as GB on GU.USER_ID = GB.WRITER_ID
# WHERE GB.STATUS = 'DONE' and sum(GB.PRICE) > 700000
# GROUP BY GB.WRITER_ID
# ORDER BY TOTAL_SALES;

Select A.WRITER_ID as USER_ID, A.NICKNAME , A.TOTAL_SALES
From (
Select GB.WRITER_ID, GU.NICKNAME, SUM(GB.PRICE) as TOTAL_SALES, GB.STATUS
FROM USED_GOODS_USER as GU JOIN USED_GOODS_BOARD as GB on GU.USER_ID = GB.WRITER_ID
where GB.STATUS = 'DONE'
group by GU.USER_ID
    ) A
where A.TOTAL_SALES >= 700000
ORDER BY A.TOTAL_SALES 

