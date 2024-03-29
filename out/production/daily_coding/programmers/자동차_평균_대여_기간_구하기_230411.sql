--Mysql
SELECT
    CAR_ID,
    ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION #소수 두번째에서 할라면 1 (2는 세번째)
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY
    CAR_ID
HAVING
        AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7 #끝나는 날짜, 시작 날짜 +1 해야 7일 이상으로 비교 가능
ORDER BY
    AVERAGE_DURATION DESC, CAR_ID DESC

--Oracle
SELECT
    CAR_ID,
    ROUND(AVG(END_DATE - START_DATE +1), 1) AS AVERAGE_DURATION
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY
    CAR_ID
HAVING
        ROUND(AVG(END_DATE - START_DATE + 1), 1) >= 7
ORDER BY
    AVERAGE_DURATION DESC, CAR_ID DESC

--Oracle은 DateDiff 대신 그냥 '-' 하면 됨