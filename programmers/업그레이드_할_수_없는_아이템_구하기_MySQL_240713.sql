SELECT
    I.ITEM_ID,
    I.ITEM_NAME,
    I.RARITY
FROM
    ITEM_INFO I
LEFT JOIN
    ITEM_TREE IT ON I.ITEM_ID = IT.PARENT_ITEM_ID
WHERE
    IT.PARENT_ITEM_ID IS NULL
ORDER BY
    I.ITEM_ID DESC;
