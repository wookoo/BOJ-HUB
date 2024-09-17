-- 코드를 입력하세요

select b.category, sum(bs.SALES) as TOTAL_SALES from book b, BOOK_SALES bs where 
    b.book_id = bs.book_id AND
    YEAR(bs.SALES_DATE) = '2022' AND
    MONTH(bs.SALES_DATE) = '1' group by category order by category;

-- SELECT book_id, SALES_DATE, sum(SALES) from BOOK_SALES 
 --       where YEAR(SALES_DATE) = '2022' and MONTH(SALES_DATE)= "1" group by book_id;