-- 코드를 입력하세요
SELECT a.AUTHOR_ID , a.AUTHOR_NAME , b.CATEGORY , sum(bs.SALES * b.PRICE)
FROM BOOK_SALES as bs
join BOOK as b on bs.BOOK_ID = b.BOOK_ID
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
where bs.SALES_DATE like '2022-01%'
group by a.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc