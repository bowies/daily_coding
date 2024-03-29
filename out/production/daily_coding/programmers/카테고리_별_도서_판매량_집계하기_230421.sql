--Mysql
SELECT
    B.CATEGORY,
    SUM(SALES) AS TOTAL_SALES
FROM
    BOOK B,
    BOOK_SALES BS
WHERE
        B.BOOK_ID = BS.BOOK_ID
  AND
    BS.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
    B.CATEGORY
ORDER BY
    B.CATEGORY ASC

--Oracle
SELECT
    B.CATEGORY,
    SUM(SALES) AS TOTAL_SALES
FROM
    BOOK B
        INNER JOIN
    BOOK_SALES BS
    ON
            B.BOOK_ID = BS.BOOK_ID
WHERE
        TO_CHAR(BS.SALES_DATE, 'YYYYMM') = '202201'
GROUP BY
    B.CATEGORY
ORDER BY
    B.CATEGORY ASC