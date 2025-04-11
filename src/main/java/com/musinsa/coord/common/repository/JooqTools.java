package com.musinsa.coord.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JooqTools {

    public static <T> Page<T> buildPage(List<T> result, Pageable pageable, long totalElements) {
        if(result.isEmpty())
            return Page.empty(pageable);
        return new PageImpl<>(result, pageable, totalElements);
    }

}