--Mysql
SELECT
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') as OUT_DATE,
    CASE
        WHEN
                DATE_FORMAT(OUT_DATE, '%m-%d') <= '05-01'
            THEN '출고완료'
        WHEN
                DATE_FORMAT(OUT_DATE, '%m-%d') > '05-01'
            THEN '출고대기'
        ELSE
            '출고미정'
        END
                                      AS 출고여부
FROM
    FOOD_ORDER
ORDER BY
    ORDER_ID ASC;

--Oracle
SELECT
    ORDER_ID,
    PRODUCT_ID,
    TO_CHAR(OUT_DATE, 'YYYY-MM-DD') AS OUT_DATE,
    CASE
        WHEN
                TO_NUMBER(TO_CHAR(OUT_DATE,'YYYYMMDD')) <= '20220501'
            THEN '출고완료'
        WHEN
                TO_NUMBER(TO_CHAR(OUT_DATE,'YYYYMMDD')) > '20220501'
            THEN '출고대기'
        ELSE
            '출고미정'
        END AS "출고여부"
FROM
    FOOD_ORDER
ORDER BY
    ORDER_ID ASC;