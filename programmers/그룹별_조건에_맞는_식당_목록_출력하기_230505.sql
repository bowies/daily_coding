--Mysql
SELECT
    M.MEMBER_NAME,
    R.REVIEW_TEXT,
    DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    MEMBER_PROFILE M
        JOIN
    REST_REVIEW R
    ON
            M.MEMBER_ID = R.MEMBER_ID
WHERE
        M.MEMBER_ID
        IN (
            SELECT
                MEMBER_ID
            FROM
                REST_REVIEW
            GROUP BY
                MEMBER_ID
            HAVING
                    COUNT(MEMBER_ID)
                    =
                    (
                        SELECT
                            COUNT(REVIEW_TEXT) AS 'NUM'
                        FROM
                            REST_REVIEW
                        GROUP BY
                            MEMBER_ID
                        ORDER BY
                            NUM DESC
    LIMIT
    1))
ORDER BY
    R.REVIEW_DATE,
    R.REVIEW_TEXT

--Oracle
SELECT
    M.MEMBER_NAME,
    R.REVIEW_TEXT,
    TO_CHAR(R.REVIEW_DATE, 'yyyy-mm-dd') REVIEW_DATE
FROM
    MEMBER_PROFILE M
        LEFT JOIN
    REST_REVIEW R
    ON
            M.MEMBER_ID = R.MEMBER_ID
WHERE
        R.MEMBER_ID
        IN (
            SELECT
                MEMBER_ID
            FROM
                REST_REVIEW
            GROUP BY
                MEMBER_ID
            HAVING
                    COUNT(*) = (
                    SELECT
                        MAX(count(*))
                    FROM
                        REST_REVIEW
                    GROUP BY
                        MEMBER_ID
                )
        )
ORDER BY
    R.REVIEW_DATE