package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.post.Category;
import lombok.Builder;

public class CategoryNameDto {
    private String categoryName;

    @Builder
    public CategoryNameDto(Category category) {
        this.categoryName = category.getCategoryName();
    }

}
