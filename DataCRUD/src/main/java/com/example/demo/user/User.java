package com.example.demo.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// ** 기본 생성자 생성 + 생성자 접근 수준 설정

@Entity // User라는 이름의 테이블을 생성할 예정
// ** 제약사항
// 1-1. @Entity가 있는 클래스는 기본생성자를 가지고 있어야 한다.
// 1-2. 'public' 또는 'protected'의 접근 수준을 가져야 한다.
// 2. @Entity가 있느 클래스는 상속을 받거나, 다른 Entity를 상속받을 수 있다.
// 3. Entity 클래스의 필드는 관계형 매핑을 위해서 다른 어노테이션을 추가할 수 있다.
// 3-2. @Column, @Id, @OneToMany, @ManyToOne 등등 ...

@Table(name = "user_tb") // 회사마다 약속된 이름이 다름
// ** table 이름을 "user"로 설정한다. 

public class User {

    @Id // ** 해당 필드를 PK로 설정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ** PK 자동 설정
    private int id;

    // ** length = 100 : DB에서의 길이를 100로 설정
    // ** nullable = false : 이 컬럼을 null로 설정할 수 없다.
    // ** unique = true : 이 컬럼의 값을 유일한 값으로 설정한다. (중복 불가)
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    // ** length = 45 : DB에서의 길이를 45로 설정
    // ** nullable = false : 이 컬럼을 null로 설정할 수 없다.
    @Column(length = 45, nullable = false)
    private String username;

    @Column(length = 30)
    @Convert(converter = StringArrayConverter.class)
    // DB에서 가져올 때 List로, DB에 저장할 때 Entity로
    private List<String> roles = new ArrayList<>();
    // ** 사용자 권한을 저장한다.
    // ** ROLE_ADMIN
    // ** ROLE_MANAGER
    // ** ROLE_USER 등등...


    // ** 빌더 패턴을 쉽게 구현할 수 있도록 해준다.
    // ** 주로 인자가 많거나, 인자를 선택적으로 지정해야 하는 경우 사용된다.
    @Builder
    public User(int id, String email, String password, String username, List<String> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public void output(){
        System.out.println(id);
        System.out.println(email);
        System.out.println(password);
        System.out.println(username);
        System.out.println(roles);
    }
}
