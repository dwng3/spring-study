package com.example.spring_study.dto;

import lombok.Data;

import java.util.List;

@Data
public class CursorPaginationResponse<T> {

    private List<T> data;

    private String nextPage;

    public CursorPaginationResponse(List<T> data, String nextPage) {
        this.data = data;
        this.nextPage = nextPage;
    }

}
