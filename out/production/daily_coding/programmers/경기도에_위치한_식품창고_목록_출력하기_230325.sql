--MySQL
SELECT
    WAREHOUSE_ID,
    WAREHOUSE_NAME,
    ADDRESS,
    IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) AS FREEZER_YN
FROM
    FOOD_WAREHOUSE
WHERE
        ADDRESS LIKE '경기도%'

--Oracle
SELECT
    WAREHOUSE_ID,
    WAREHOUSE_NAME,
    ADDRESS,
    NVL(FREEZER_YN, 'N') AS FREEZER_YN
FROM
    FOOD_WAREHOUSE
WHERE
        ADDRESS LIKE '%경기도%'
ORDER BY
    WAREHOUSE_ID


