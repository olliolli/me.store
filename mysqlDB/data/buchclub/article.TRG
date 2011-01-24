TYPE=TRIGGERS
triggers='create  trigger trig_article_insert before insert on `article` for each row set new.createddate = NOW()'
sql_modes=0
definers='root@localhost'
