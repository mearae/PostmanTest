-- 모든 제약 조건 비활성화
SET REFERENTIAL_INTEGRITY FALSE;
truncate table user_tb;
SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO user_tb (`id`,`email`,`password`,`userName`, `roles`) VALUES ('1', 'admin@green.com', '{bcrypt}$2a$10$nc3qKc9axO3dNb8IsbNjEe9wpMGOZWgbH19VC77.nkQo0QChFMEka', '홍길동', 'ROLE_ADMIN');
INSERT INTO user_tb (`id`,`email`,`password`,`userName`, `roles`) VALUES ('2', 'example123@gmail.com', '{bcrypt}$2a$10$nc3qKc9axO3dNb8IsbNjEe9wpMGOZWgbH19VC77.nkQo0QChFMEka', '배준혁', 'ROLE_USER');