--Mysql
SELECT 
    A.AUTHOR_ID, #저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력
    AUTHOR_NAME, 
    CATEGORY, 
    SUM((SALES * PRICE)) AS TOTAL_SALES #저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여
FROM 
    BOOK_SALES S
    JOIN 
        BOOK B 
        ON S.BOOK_ID = B.BOOK_ID
    JOIN 
        AUTHOR A 
        ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE 
    YEAR(S.SALES_DATE) = 2022 
    AND 
    MONTH(S.SALES_DATE) = 1 #2022년 1월의 도서 판매 데이터를 기준
GROUP BY 
    CATEGORY,
    AUTHOR_ID
ORDER BY 
    A.AUTHOR_ID,
    CATEGORY DESC # 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬

--Oracle
SELECT 
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY,
    SUM(S.SALES * B.PRICE) AS TOTAL_SALES
FROM
    AUTHOR A
    INNER JOIN 
        BOOK B 
        ON A.AUTHOR_ID = B.AUTHOR_ID
    INNER JOIN 
        BOOK_SALES S 
        ON B.BOOK_ID = S.BOOK_ID
WHERE
    TO_CHAR(S.SALES_DATE, 'YYYYMM') = '202201'
GROUP BY 
    A.AUTHOR_ID,
    A.AUTHOR_NAME, 
    B.CATEGORY
ORDER BY 
    A.AUTHOR_ID, 
    B.CATEGORY DESC