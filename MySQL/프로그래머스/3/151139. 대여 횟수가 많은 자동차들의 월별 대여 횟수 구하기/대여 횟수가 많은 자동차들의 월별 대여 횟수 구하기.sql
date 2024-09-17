-- 코드를 입력하세요
-- SELECT MONTH(start_date) as MONTH ,car_id as RECORES from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
    -- start_date between DATE("2022-08-01") and DATE("2022-10-31") 
   -- group by MONTH(start_date) order by MONTH(start_date) asc,car_id desc;
    

select MONTH(start_date) as month,car_id,count(car_id) as records from CAR_RENTAL_COMPANY_RENTAL_HISTORY where car_id in(
    
        select car_id as RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY where 
            start_date between DATE("2022-08-01") and DATE("2022-11-01")

        group by car_id 

        having count(car_id) >=5
    )
    and START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
    group by month, car_id 
    having count(car_id) >0
    order by month asc, car_id desc
    