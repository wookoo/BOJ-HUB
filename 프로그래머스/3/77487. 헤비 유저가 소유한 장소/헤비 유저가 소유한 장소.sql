-- 코드를 입력하세요
SELECT * from places where HOST_ID in (select HOST_ID from places group by HOST_ID having count(*) >= 2);