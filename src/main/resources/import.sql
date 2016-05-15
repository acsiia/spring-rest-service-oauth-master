

insert into users(id, name, login, password, enable, email) values (1,'Roy','roy','spring', 'true', 'mail.ru');
insert into users(id, name, login, password, enable, email) values (2,'Craig','craig','spring', 'true', 'mail.ru');
insert into users(id, name, login, password, enable, email) values (3,'Greg','greg','spring', 'true', 'mail.ru');
 
insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');
insert into role(id, name) values (3,'ROLE_GUEST'); 

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);

insert into country(country_id, country_en, country_ru) values (1,'Russia', 'RussiaRu');
insert into country(country_id, country_en, country_ru) values (2,'Belarus', 'BelarusRu');

insert into profile(id, firstname, surname, secondname, city, sex, user_id, country_id, birthday) values (1,'Roy','Jonatan','Smit','NY','mail',1,1,'2004-05-16');
insert into profile(id, firstname, surname, secondname, city, sex, user_id, country_id, birthday) values (2,'Craig','Peterson','Kraul','Berlin','mail',2,2,'2000-05-11');
insert into profile(id, firstname, surname, secondname, city, sex, user_id, country_id, birthday) values (3,'Greg','Smit','Paul','Moskov','mail.ru',3,2,'1994-05-16');

insert into post(post_id, dislikes, img, likes, post_content, post_time, user_id) values (1,5,NULL ,10,'post 1',null,1);
insert into post(post_id, dislikes, img, likes, post_content, post_time, user_id) values (2,5,NULL ,10,'post 2',null,2);
insert into post(post_id, dislikes, img, likes, post_content, post_time, user_id) values (3,5,NULL ,10,'post 3',null,2);

INSERT  INTO comment(id, comment, post_id, sender) VALUES (1, 'comment 1', 2, 3)
INSERT  INTO comment(id, comment, post_id, sender) VALUES (2, 'comment 2', 2, 2)
INSERT  INTO comment(id, comment, post_id, sender) VALUES (3, 'comment 3', 1, 1)







