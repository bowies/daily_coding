--Oracle
SELECT
    HISTORY_ID,
    CAR_ID,
    TO_CHAR(START_DATE, 'YYYY-MM-DD') AS START_DATE,
    TO_CHAR(END_DATE, 'YYYY-MM-DD') AS END_DATE,
    CASE
        WHEN
                        END_DATE - START_DATE + 1 >= 30
            THEN
            '장기 대여'
        ELSE
            '단기 대여'
        END
                                      AS RENT_TYPE
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
        TO_CHAR(START_DATE, 'YYYYMM') = '202209'
ORDER BY
    HISTORY_ID DESC;


--MySQL
SELECT
    HISTORY_ID,
    CAR_ID,
    DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
    DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
    CASE
        WHEN
                    DATEDIFF(END_DATE,START_DATE) + 1 >= 30
            THEN "장기 대여"
        ELSE "단기 대여"
        END AS RENT_TYPE
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    START_DATE
        BETWEEN '2022-09-01' AND '2022-09-30'
ORDER BY
    HISTORY_ID DESC