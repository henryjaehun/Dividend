package com.dayone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class ScrapedResult {

    private Company company;

    private List<Dividend> dividendEntities;

    public ScrapedResult() { this.dividendEntities = new ArrayList<>(); }

    public List<Dividend> getDividends() {
        // 이부분 완성해야함 강의에 없는 내용
        return dividendEntities;
    }
}
