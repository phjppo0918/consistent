SELECT gb.title, gb.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, "%Y-%m-%d")
FROM used_goods_reply r
         join used_goods_board gb on gb.board_id = r.board_id
where  gb.created_date >= "2022-10-01" &&  gb.created_date <= "2022-10-31"
order by r.created_date, gb.title