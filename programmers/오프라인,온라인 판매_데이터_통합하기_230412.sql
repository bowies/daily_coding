--Mysql
#Mysql은 Alias 안 써주면 정답 처리 안 됨
SELECT
    DATE_FORMAT(O.SALES_DATE , '%Y-%m-%d') AS SALES_DATE,
    O.PRODUCT_ID,
    O.USER_ID,
    O.SALES_AMOUNT
FROM
    (
        SELECT
            SALES_DATE,
            PRODUCT_ID,
            USER_ID,
            SALES_AMOUNT
        FROM
            ONLINE_SALE
        UNION ALL #UNION 해도 됨, UNION ALL은 중복 허용
        SELECT
            SALES_DATE,
            PRODUCT_ID,
            null AS USER_ID,
            SALES_AMOUNT
        FROM
            OFFLINE_SALE) AS O
WHERE
    YEAR(O.SALES_DATE) = 2022
  AND
    MONTH(O.SALES_DATE) = 3
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC

--Oracle
SELECT
    TO_CHAR(SALES_DATE , 'YYYY-MM-DD') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM
    (
        SELECT
            SALES_DATE,
            PRODUCT_ID,
            USER_ID,
            SALES_AMOUNT
        FROM
            ONLINE_SALE
        UNION --합쳐주기
        SELECT
            SALES_DATE,
            PRODUCT_ID,
            null USER_ID,
            SALES_AMOUNT
        FROM
            OFFLINE_SALE)
WHERE
        TO_CHAR(SALES_DATE , 'YYYY-MM') ='2022-03'
ORDER BY
    SALES_DATE ASC, --판매일
    PRODUCT_ID ASC, --상품아이디
    USER_ID ASC --유저아이디