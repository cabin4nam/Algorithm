-- 코드를 입력하세요
/**
1. select : (가장 비싼) 식품의 분류(CATEGORY), 가격(PRICE), 이름 (PRODUCT_NAME)
2. 필터 : 식품류별로 group, 그룹 별 제일 비싼 식품
          식품 분류가 '과자', '국', '김치', '식용유' 인 경우
3. 정렬 : 식품 가격 순 내림차순
**/
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE PRICE IN (SELECT MAX(PRICE) FROM FOOD_PRODUCT GROUP BY CATEGORY) AND CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC;