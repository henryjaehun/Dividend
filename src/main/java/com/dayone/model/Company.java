package com.dayone.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // 디자인패턴중 빌더패턴을 해당 클래서에서 사용할수 있게 해줌
public class Company {

    private String ticker;
    private String name;
}
