package net.chimaek.day0715;

import lombok.AllArgsConstructor; // 생성자를 전부 받아오는
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private boolean admin;
    private boolean person;


}