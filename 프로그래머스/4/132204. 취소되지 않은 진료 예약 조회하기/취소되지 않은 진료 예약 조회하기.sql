# !진료예약번호, !환자이름, !환자번호, !진료과코드, 의사이름, !진료예약일시


select APNT_NO, PT_NAME, PT_NO, o1.MCDP_CD, DR_NAME, APNT_YMD
from (
    select apnt_no, mddr_id, b.pt_no, b.pt_name, MCDP_CD, apnt_ymd
    from appointment a join patient b on (a.pt_no = b.pt_no)
    where APNT_CNCL_YN = 'N' && APNT_YMD like '2022-04-13%'
) o1 join doctor o2 on (o1.MDDR_ID = o2.DR_ID)
order by apnt_ymd
