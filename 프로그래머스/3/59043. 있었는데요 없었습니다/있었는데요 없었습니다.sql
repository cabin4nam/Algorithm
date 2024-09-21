-- 코드를 입력하세요
/**
1. select : ANIMAL_ID, NAME
2. from : animal_ins 의 date_time 확인, animal_outs의 date_time 확인
3. where : 입양일(ins.datetime) < 보호시작일(out.datetime)
4. order : 보호시작일 오름차순
**/
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins JOIN ANIMAL_OUTS outs USING (ANIMAL_ID)
WHERE outs.DATETIME < ins.DATETIME
ORDER BY ins.DATETIME;
