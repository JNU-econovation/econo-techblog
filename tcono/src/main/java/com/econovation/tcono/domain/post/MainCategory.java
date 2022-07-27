package com.econovation.tcono.domain.post;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MainCategory {
    TOTAL(0),TECH(1), CULTURE(2), TROUBLE_SHOOTING(3);

    private int mainCategoryNumber;

    private static final String NOT_FOUND_MAINCATEGORY_MESSAGE="해당 카테고리의 게시물이 없습니다";

    MainCategory(int mainCategoryNumber) {
        this.mainCategoryNumber = mainCategoryNumber;
    }

    public static MainCategory getMainCategory(int mainCategoryNumber) { //카테고리 넘버를 받아서 존재하는 대분류인지 판단
        return Arrays.stream(MainCategory.values())
                .filter(x -> x.mainCategoryNumber==mainCategoryNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MAINCATEGORY_MESSAGE));
    }
}