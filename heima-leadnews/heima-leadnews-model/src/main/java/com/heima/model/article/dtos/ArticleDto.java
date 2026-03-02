package com.heima.model.article.dtos;


import com.heima.model.article.pojos.ApArticle;
import lombok.Data;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/28 16:34
 */
@Data
public class ArticleDto extends ApArticle {

    /**
     * 文章内容
     */
    private String content;
}
