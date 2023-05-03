--Mysql
SELECT
    F.FLAVOR
FROM
    FIRST_HALF F
        LEFT JOIN (
        SELECT
            FLAVOR,
            SUM(TOTAL_ORDER) AS TOTAL_ORDER
        FROM
            JULY
        GROUP BY
            FLAVOR
    ) J
                  ON F.FLAVOR = J.FLAVOR
ORDER BY
    (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC LIMIT 3;




--Oracle
SELECT
    F.FLAVOR
FROM(
        SELECT
            H.FLAVOR,
            SUM(H.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) AS TOTAL
        FROM FIRST_HALF H
                 INNER JOIN
             JULY J
             ON H.FLAVOR = J.FLAVOR
        GROUP BY
            H.FLAVOR
        ORDER BY
            TOTAL DESC
    ) F
WHERE
        ROWNUM <= 3