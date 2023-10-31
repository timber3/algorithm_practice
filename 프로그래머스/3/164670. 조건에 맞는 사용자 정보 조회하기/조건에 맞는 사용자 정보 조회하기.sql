-- 코드를 입력하세요

SELECT gu.USER_ID, gu.NICKNAME, concat(gu.CITY, " ", gu.STREET_ADDRESS1, " ", gu.STREET_ADDRESS2),
CONCAT(SUBSTR(gu.TLNO, 1, 3), "-", SUBSTR(gu.TLNO, 4, 4) , "-", SUBSTR(gu.TLNO, 8,4))

FROM (
    SELECT WRITER_ID as wi, COUNT(WRITER_ID) as cw
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    ) as t join USED_GOODS_USER as gu on t.wi = gu.USER_ID

WHERE t.cw >= 3

ORDER BY USER_ID desc