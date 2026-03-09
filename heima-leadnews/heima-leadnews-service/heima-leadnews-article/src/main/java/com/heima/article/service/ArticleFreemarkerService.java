package com.heima.article.service;


import com.heima.model.article.pojos.ApArticle;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/2 14:10
 */

public interface ArticleFreemarkerService {

    /**
     * 生成静态文件上传到minIO中
     * @param apArticle
     * @param content
     */
    public void buildArticleToMinIO(ApArticle apArticle, String content);
}
