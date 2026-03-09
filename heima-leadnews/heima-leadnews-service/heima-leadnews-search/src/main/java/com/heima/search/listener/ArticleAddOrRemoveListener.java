package com.heima.search.listener;


import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.search.service.ArticleSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/9 9:56
 */
@Component
@Slf4j
public class ArticleAddOrRemoveListener {

    @Autowired
    ArticleSearchService articleSearchService;

    @Autowired
    ArticleFeign articleFeign;

    @RabbitListener(queues = NewsUpOrDownConstants.NEWS_UP_FOR_ES_QUEUE)
    public void listenNewsUpMsg(String articleId){
        log.info("接收到文章上架消息， 消息内容: {}",articleId);
        // 根据articleId查询文章信息，将文章信息 添加到es索引库中
        // 远程查询article信息
        ResponseResult<SearchArticleVO> result = articleFeign.findArticle(Long.valueOf(articleId));
        if (!result.checkCode()) {
            CustException.cust(AppHttpCodeEnum.DATA_NOT_EXIST,"未查询到对应的文章数据");
            log.error("未查询到对应的文章信息,文章id:{}",articleId);
        }
        articleSearchService.saveArticle(result.getData());
    }

    @RabbitListener(queues = NewsUpOrDownConstants.NEWS_DOWN_FOR_ES_QUEUE)
    public void listenNewsDownMsg(String articleId){
        log.info("接收到文章下架消息， 消息内容: {}",articleId);
        // 根据 articleId 删除es索引库中对应的文章信息
        articleSearchService.deleteArticle(articleId);
    }
}
