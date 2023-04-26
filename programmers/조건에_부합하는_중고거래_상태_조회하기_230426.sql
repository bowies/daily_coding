--Mysql
SELECT 
    BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    CASE 
        WHEN 
            STATUS = 'SALE' THEN '판매중'
        WHEN 
            STATUS = 'RESERVED' THEN '예약중' 
        WHEN 
            STATUS = 'DONE' THEN '거래완료' 
    END
        STATUS
FROM 
    USED_GOODS_BOARD
WHERE
    BOARD_ID 
        IN(
            SELECT
                BOARD_ID
            FROM
                USED_GOODS_BOARD
            WHERE
                CREATED_DATE = '2022-10-05'
        )
ORDER BY
    BOARD_ID DESC;

--Oracle
SELECT 
    BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    CASE 
        WHEN 
            STATUS = 'SALE' THEN '판매중'
        WHEN 
            STATUS = 'RESERVED' THEN '예약중' 
        WHEN 
            STATUS = 'DONE' THEN '거래완료' 
    END
       AS STATUS
FROM 
    USED_GOODS_BOARD
WHERE
    TO_CHAR(CREATED_DATE, 'YYYYMMDD') = '20221005'
ORDER BY
    BOARD_ID DESC;