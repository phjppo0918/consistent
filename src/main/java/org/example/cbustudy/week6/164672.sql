SELECT b.board_id, b.writer_id, b.title, b.price,
       case
           when (b.status = "DONE") then "거래완료"
           when (b.status = "SALE") then "판매중"
           when (b.status = "RESERVED") then "예약중"
           end as "status"

from used_goods_board b
where b.created_date = "2022-10-05"
order by board_id desc