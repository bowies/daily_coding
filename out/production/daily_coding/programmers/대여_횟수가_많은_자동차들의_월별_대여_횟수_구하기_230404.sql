--MySQL
SELECT
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(HISTORY_ID) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    CAR_ID
    IN(
    SELECT
    CAR_ID
    FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
    MONTH(START_DATE) BETWEEN 8 AND 10
    GROUP BY
    CAR_ID
    HAVING
    COUNT(*) >= 5
    )
  AND MONTH(START_DATE) BETWEEN 8 AND 10
GROUP BY
    MONTH, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC;

--Oracle
WITH GETCARID AS ( -- 8~10월의 최소 1개 이상인 자동차 아이디만 가져오는 것
    SELECT
        CAR_ID,
        COUNT(*) AS GET_CAR_ID
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
        EXTRACT(MONTH FROM START_DATE) IN(8,9,10)
    GROUP BY
        CAR_ID
    ORDER BY
        CAR_ID DESC
)

SELECT
    EXTRACT(MONTH FROM START_DATE) AS MONTH,
    C.CAR_ID,
    COUNT(*) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY C
    INNER JOIN GETCARID G
    ON
    C.CAR_ID = G.CAR_ID
WHERE
    G.GET_CAR_ID >= 5
    AND
    EXTRACT(MONTH FROM START_DATE) IN (8,9,10)
GROUP BY
    EXTRACT(MONTH FROM START_DATE),
    C.CAR_ID
ORDER BY
    MONTH ASC, CAR_ID DESC