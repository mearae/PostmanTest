-- 모든 제약 조건 비활성화
SET REFERENTIAL_INTEGRITY FALSE;
truncate table user_tb;
SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO user_tb (`id`,`email`,`password`,`name`,`roles`) VALUES ('1', 'example123@gmail.com', '{bcrypt}$2a$10$IkVCSNVb.j.63fF19eISZe1mSvMUxs6KRg/ltThRhLexgJzk1CZMO', '배준혁', 'ROLE_ADMIN');
INSERT INTO user_tb (`id`,`email`,`password`,`name`,`roles`) VALUES ('2', 'user123@gmail.com', '{bcrypt}$2a$10$IkVCSNVb.j.63fF19eISZe1mSvMUxs6KRg/ltThRhLexgJzk1CZMO', '배준혁', 'ROLE_USER');