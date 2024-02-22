SELECT DISTINCT
    cp1.CART_ID
FROM
    CART_PRODUCTS cp1
JOIN
    CART_PRODUCTS cp2 ON cp1.CART_ID = cp2.CART_ID
WHERE
    cp2.NAME = 'Milk'
    AND cp1.NAME = 'Yogurt'
ORDER BY
    cp1.CART_ID;


-- Oracle 도 DISTINCT 사용 가능하므로 INTERSECT 대신 DISTINCT로 짜고,
-- CARD_ID를 공유하는 경우에 한정해서 테이블의 인스턴스를 조인하는 방식으로 수정한다.
-- 저렇게 짜면 기존 Both 용 보다 읽기 용이한 쿼리인 것
-- 서브쿼리를 쓰면 최적화가 좀 어려울 수 있으므로 조인을 쓰는 방식이 낫다.