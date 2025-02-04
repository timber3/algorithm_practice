# select count(*) FISH_COUNT, max(LENGTH) MAX_LENGTH, fish_type FISH_TYPE
# from fish_info
# group by FISH_TYPE
# having avg(length) >= 33
# order by fish_type


# select fish_type, avg(length) avg_len
# from fish_info
# group by fish_type
# having avg_len >= 33
# order by 1

SELECT 
    COUNT(*) AS FISH_COUNT,  -- 물고기 수
    MAX(length) AS MAX_LENGTH,  -- 최대 길이
    fish_type AS FISH_TYPE  -- 물고기 종류
FROM 
    fish_info
GROUP BY 
    fish_type  -- 물고기 종류별로 그룹화
HAVING 
    AVG(length) >= 33  -- 평균 길이가 33 이상인 그룹만 선택
ORDER BY 
    fish_type;  -- 물고기 종류로 정렬