--Oracle
SELECT
    *
FROM
    PLACES H
WHERE
    EXISTS (
            SELECT
                *
            FROM
                PLACES P
            WHERE
                    P.HOST_ID = H.HOST_ID
            GROUP BY
                HOST_ID
            HAVING
                    COUNT(ID) >= 2
        )
ORDER BY
    ID ASC;

--Mysql
SELECT
    *
FROM
    PLACES H
WHERE
    EXISTS (
            SELECT
                *
            FROM
                PLACES P
            WHERE
                    P.HOST_ID = H.HOST_ID
            GROUP BY
                HOST_ID
            HAVING
                    COUNT(ID) >= 2
        )
ORDER BY
    ID ASC;