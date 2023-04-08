-- MySQL

SELECT
    DISTINCT U.USER_ID,
             U.NICKNAME,
             CONCAT_WS(" ", U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2) AS 전체주소,
             CONCAT_WS("-", SUBSTRING(TLNO, 1, 3), SUBSTRING(TLNO, 4, 4), SUBSTRING(TLNO, 8, 4)) AS 전화번호
FROM
    USED_GOODS_USER AS U
        JOIN
    USED_GOODS_BOARD AS B
    ON B.WRITER_ID = U.USER_ID
WHERE
        U.USER_ID
        IN
        (
            SELECT
                WRITER_ID
            FROM
                USED_GOODS_BOARD
            GROUP BY
                WRITER_ID
            HAVING
                    COUNT(*) >= 3
        )
ORDER BY
    U.USER_ID DESC;

--Oracle


SELECT
    U.USER_ID,
    U.NICKNAME,
    U.CITY ||' '|| U.STREET_ADDRESS1 ||' '|| U.STREET_ADDRESS2 AS "전체주소",
    SUBSTR(U.TLNO,0,3) ||'-'|| SUBSTR(U.TLNO,4,4) ||'-'|| SUBSTR(U.TLNO,8) AS "전화번호"
FROM
    USED_GOODS_USER U
        INNER JOIN
    (
        SELECT
            WRITER_ID,
            COUNT(*) AS CNT
        FROM
            USED_GOODS_BOARD
        GROUP BY
            WRITER_ID
        HAVING
                COUNT(*) >= 3
    ) B
    ON U.USER_ID = B.WRITER_ID
ORDER BY
    U.USER_ID DESC





----------------------------------------------

--Oracle

SELECT
    U.USER_ID,
    U.NICKNAME,
    (U.CITY || ' ' || U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2) AS 전체주소,
    CASE
        WHEN
                LENGTH(U.TLNO) = 11
            THEN
                SUBSTR(U.TLNO,0,3) || '-' || SUBSTR(U.TLNO,4,4) || '-' || SUBSTR(U.TLNO,8,4)
        END
                                                                     AS 전화번호
FROM
    USED_GOODS_USER U
WHERE
        USER_ID
        IN
        (
            SELECT
                US.USER_ID
            FROM
                USED_GOODS_BOARD BO
                    INNER JOIN
                USED_GOODS_USER US
                ON
                        BO.WRITER_ID = US.USER_ID
            GROUP BY
                US.USER_ID
            HAVING
                    COUNT(*) >=3
        )
ORDER BY
    U.USER_ID DESC;

