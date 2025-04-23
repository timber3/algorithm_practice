-- 사용자 ID, 닉네임, 전체주소, 전화번호

select writer_id, nickname, concat(CITY,' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2),
concat(substring(tlno, 1, 3), '-' , substring(tlno, 4, 4) , '-' , substring(tlno, 8,4))
from USED_GOODS_BOARD a join USED_GOODS_USER b on (a.WRITER_ID = b.user_id)
group by writer_id
having count(*) >= 3
order by 1 desc