package com.example.demo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// ** 기본 생성자 생성 + 생성자 접근 수준 설정

@Entity // User라는 이름의 테이블을 생성할 예정
// ** 제약사항
// 1-1. @Entity가 있는 클래스는 기본생성자를 가지고 있어야 한다.
// 1-2. 'public' 또는 'protected'의 접근 수준을 가져야 한다.
// 2. @Entity가 있느 클래스는 상속을 받거나, 다른 Entity를 상속받을 수 있다.
// 3. Entity 클래스의 필드는 관계형 매핑을 위해서 다른 어노테이션을 추가할 수 있다.
// 3-2. @Colume, @Id, @OneToMany, @ManyToOne 등등 ...

@Table(name = "user") // 회사마다 약속된 이름이 다름
// ** table 이름을 "user"로 설정한다. 

public class User {

    @Id
    private int id;

    private String name;
}
