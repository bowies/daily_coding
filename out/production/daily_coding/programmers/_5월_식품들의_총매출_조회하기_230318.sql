--MYSQL
SELECT
    O.PRODUCT_ID AS PRODUCT_ID,
    P.PRODUCT_NAME AS PRODUCT_NAME,
    (PRICE*SUM(AMOUNT)) AS TOTAL_SALES
FROM
    FOOD_ORDER O
        JOIN
    FOOD_PRODUCT P
    ON
            O.PRODUCT_ID = P.PRODUCT_ID
WHERE
    YEAR(PRODUCE_DATE) = 2022
  AND
    MONTH(PRODUCE_DATE) = 5
GROUP BY
    PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC, PRODUCT_ID;

--ORACLE
SELECT
    P.PRODUCT_ID AS PRODUCT_ID,
    P.PRODUCT_NAME AS PRODUCT_NAME,
    (P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM
    FOOD_PRODUCT P
        JOIN (
        SELECT
            PRODUCT_ID, SUM(AMOUNT) AS AMOUNT
        FROM
            FOOD_ORDER
        WHERE
                TO_CHAR(PRODUCE_DATE, 'YYYYMM') = '202205'
        GROUP BY
            PRODUCT_ID
    ) O
             ON
                     P.PRODUCT_ID = O.PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC, PRODUCT_ID;

