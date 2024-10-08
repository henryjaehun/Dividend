package com.dayone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder // 디자인패턴중 빌더패턴을 해당 클래서에서 사용할수 있게 해줌
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private String ticker;
    private String name;
}
