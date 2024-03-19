--ANSI SQL
SELECT
    WAREHOUSE_ID,
    WAREHOUSE_NAME,
    ADDRESS,
    COALESCE(FREEZER_YN, 'N') AS FREEZER_YN
FROM
    FOOD_WAREHOUSE
WHERE
    ADDRESS LIKE '%경기도%'
ORDER BY
    WAREHOUSE_ID;

--ANSI SQL로 변환하면 DB 이식성이 좋아지고, COALESCE 함수 쓰면 간결하게 사용 할 수 있다.
--그러나 최적화를 못 하거나 지원을 못 하는 경우가 생길 수도 있긴 해서 조율이 필요하다.
--코어레스 함수는 여러 개 인자값을 받아서, NULL이 아닌 첫 번째 값을 반환 할 수 있게 하는 함수인데,
--여기서 위 쿼리가 COALESCE 함수를 사용하여 "FREEZER_YN"이 NULL인 경우에는 'N'으로 대체하여 반환하게 해 주는 식으로 사용하면 된다.
--그러니까 IS NULL 이나 NVL 대치를 해서 쓰면 ANSI SQL 표준인 것이다...

--gpt한테 물어보면 지원 안 하는 경우는 아래와 같다.
--  1. MySQL: 5.0 이상의 버전부터 COALESCE 함수가 지원됩니다.
--  2. PostgreSQL: 7.3 이상의 버전부터 COALESCE 함수가 지원됩니다.
--  3. Oracle: Oracle 9i 이상의 버전부터 COALESCE 함수가 지원됩니다.
--  4. SQL Server: SQL Server 2005 이상의 버전부터 COALESCE 함수가 지원됩니다.
-- 어쨌든 거의 지원 한 다고 볼 수 있겠으나, 아닌 경우에는 그 DB 특화형으로 치환해서 사용하면 된다.


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


