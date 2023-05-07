--Mysql
SELECT
    HISTORY_ID,
    ROUND((DAILY_FEE * (100 - IFNULL(DISCOUNT_RATE, 0)) /100) * PERIOD) AS FEE
FROM
    (
        SELECT
            CAR.CAR_ID,
            CAR.CAR_TYPE,
            DAILY_FEE,
            HISTORY_ID,
            TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1 AS PERIOD,
            CASE
                WHEN
                            TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1 >= 90 THEN '90일 이상'
                WHEN
                            TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1 >= 30 THEN '30일 이상'
                WHEN
                            TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1 >= 7 THEN '7일 이상'
                ELSE
                    '7일 미만'
                END AS DURATION_TYPE
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HISTORY
                INNER JOIN
            CAR_RENTAL_COMPANY_CAR AS CAR
            ON
                    CAR.CAR_ID = HISTORY.CAR_ID
    ) AS PERIOD_TABLE
        LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN
    ON
                PERIOD_TABLE.CAR_TYPE = PLAN.CAR_TYPE
            AND
                PERIOD_TABLE.DURATION_TYPE = PLAN.DURATION_TYPE
WHERE
        PERIOD_TABLE.CAR_TYPE = '트럭'
ORDER BY
    FEE DESC,
    HISTORY_ID DESC;

--Oracle
WITH HISTORY_TABLE AS (
    SELECT
        CR.HISTORY_ID AS HISTORY_ID,
        C.CAR_ID AS CAR_ID,
        C.CAR_TYPE AS CAR_TYPE,
        C.DAILY_FEE AS DAILY_FEE,
        CR.DURATION AS DURATION,
        CASE
            WHEN
                    CR.DURATION < 7 THEN ''
            ELSE
                CASE
                    WHEN
                            CR.DURATION < 30 THEN '7일 이상'
                    ELSE
                        CASE
                            WHEN CR.DURATION < 90 THEN '30일 이상'
                            ELSE '90일 이상'
                            END
                    END
            END
                      AS DURATION_TYPE
    FROM
        CAR_RENTAL_COMPANY_CAR C,
        (
            SELECT
                HISTORY_ID,
                CAR_ID,
                END_DATE - START_DATE + 1 AS DURATION
            FROM
                CAR_RENTAL_COMPANY_RENTAL_HISTORY) CR
    WHERE
            1 = 1
      AND
            C.CAR_ID = CR.CAR_ID
      AND
            C.CAR_TYPE = '트럭'
)



SELECT
    H.HISTORY_ID,
    H.DAILY_FEE * H.DURATION * (100 - NVL(CR.DISCOUNT_RATE, 0)) / 100 AS FEE
FROM
    HISTORY_TABLE H
        LEFT OUTER JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN CR
    ON
                H.CAR_TYPE = CR.CAR_TYPE
            AND
                H.DURATION_TYPE = CR.DURATION_TYPE
ORDER BY
            H.DAILY_FEE * H.DURATION * (100 - NVL(CR.DISCOUNT_RATE, 0)) / 100 DESC,
            H.HISTORY_ID DESC;