--Mysql
SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    (SELECT
         CATEGORY,
         ROW_NUMBER()
             OVER (PARTITION BY
                    CATEGORY
                ORDER BY
                    PRICE DESC) AS RANKING,
             PRODUCT_NAME,
         PRICE
     FROM
         FOOD_PRODUCT
     WHERE
             CATEGORY
             IN
             ('과자', '국', '김치','식용유')
     ORDER BY PRICE DESC) AS TEMP
WHERE RANKING = '1'
ORDER BY PRICE DESC

-- Oracle
SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    FOOD_PRODUCT
WHERE
        (CATEGORY, PRICE) IN ( SELECT CATEGORY, MAX(PRICE)
                               FROM FOOD_PRODUCT
                               WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
                               GROUP BY CATEGORY)
ORDER BY
    MAX_PRICE DESC;
