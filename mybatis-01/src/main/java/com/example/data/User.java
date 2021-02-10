package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by GuaiWenWo on 2021/2/7 17:12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private  String pwd;
}
