select o1.member_name, o2.REVIEW_TEXT, date_format(o2.REVIEW_DATE, "%Y-%m-%d")
from MEMBER_PROFILE o1 join (
    select a.member_id, a.REVIEW_TEXT, a.REVIEW_DATE
    from REST_REVIEW a join (
        select member_id, count(*)
        from rest_review
        group by member_id
        order by count(*) desc
        limit 1
    ) b on (a.member_id = b.member_id)
) o2 on (o1.member_id = o2.member_id)
order by 3, 2

