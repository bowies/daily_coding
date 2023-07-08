--Oracle

SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
        NAME = 'Milk'
INTERSECT
SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
        NAME = 'Yogurt'
ORDER BY
    CART_ID;


--Mysql


SELECT
    DISTINCT C.CART_ID
FROM
    CART_PRODUCTS C, CART_PRODUCTS T
WHERE
        C.CART_ID = T.CART_ID
  AND
    (C.NAME ='Milk'
        AND T.NAME ='Yogurt')
ORDER BY
    C.CART_ID;


-- Both

SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
        CART_ID
        IN (
            SELECT
                CART_ID
            FROM
                CART_PRODUCTS
            WHERE
                    NAME = 'Milk')
  AND NAME = 'Yogurt'
ORDER BY
    CART_ID;