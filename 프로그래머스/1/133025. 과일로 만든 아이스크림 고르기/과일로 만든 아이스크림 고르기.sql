-- 코드를 입력하세요
SELECT t1.FLAVOR FROM FIRST_HALF t1 JOIN ICECREAM_INFO t2 ON t1.FLAVOR = t2.FLAVOR
WHERE TOTAL_ORDER > 3000 AND t2.INGREDIENT_TYPE = 'fruit_based';