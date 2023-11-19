SELECT u.user_id, u.nickname,
       concat(u.city, " ", u.street_address1, " ", u.street_address2),
       concat(SUBSTRING(u.tlno, 1,3),"-", SUBSTRING(u.tlno, 4, 4), "-", SUBSTRING(u.tlno,8,4))
FROM USED_GOODS_USER u
         jOIN USED_GOODS_BOARD b on b.writer_id = u.user_id
group by u.user_id
having count(u.user_id) >= 3
order by u.user_id desc