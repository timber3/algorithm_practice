SELECT car_id, car_type, ROUND(daily_fee * 30 * (100 - COALESCE(discount_rate, 0)) / 100) AS fee
FROM CAR_RENTAL_COMPANY_CAR a1
JOIN (
    SELECT car_type, discount_rate
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE DURATION_TYPE = '30일 이상' AND car_type IN ('세단', 'SUV')
) b1 USING (car_type)
WHERE ROUND(daily_fee * 30 * (100 - COALESCE(discount_rate, 0)) / 100) BETWEEN 500000 AND 1999999
AND NOT EXISTS (
    SELECT 1
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    WHERE a1.car_id = h.car_id
    AND NOT (h.end_date < '2022-11-01' OR h.start_date > '2022-12-01')
)
ORDER BY fee DESC, car_type, car_id DESC;