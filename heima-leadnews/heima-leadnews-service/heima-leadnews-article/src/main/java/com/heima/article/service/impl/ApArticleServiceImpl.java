package com.heima.article.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleConfigMapper;
import com.heima.article.mapper.ApArticleContentMapper;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.article.pojos.ApArticleConfig;
import com.heima.model.article.pojos.ApArticleContent;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @description TODO
* @author zhouhui
* @date 2026/2/26 8:58
* @version 1.0
*/
@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService {
    /**
     * 根据参数加载文章列表
     *
     * @param loadtype       1为加载更多  2为加载最新
     * @param articleHomeDto
     * @return
     */
    //页面最大加载的数字
    private final static short MAX_PAGE_SIZE= 50;

    @Autowired
    private ApArticleMapper apArticleMapper;

    @Override
    public ResponseResult load(Short loadtype, ArticleHomeDto articleHomeDto) {

        //校验参数
        Integer size = articleHomeDto.getSize();
        if(size==null||size==0){
            size=10;
        }
        size = Math.min(size,MAX_PAGE_SIZE);
        articleHomeDto.setSize(size);

        //类型参数校验
        if(!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_MODE)&&!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){

            loadtype=ArticleConstants.LOADTYPE_LOAD_MODE;
        }

        //文章频道校验
        if(StringUtils.isEmpty(articleHomeDto.getTag())){
            articleHomeDto.setTag(ArticleConstants.DEFAULT_TAG);
        }

        //时间校验
        if(articleHomeDto.getMaxBehotTime()==null){
            articleHomeDto.setMaxBehotTime(new Date());
        }

        if(articleHomeDto.getMinBehotTime()==null){
            articleHomeDto.setMinBehotTime(new Date());
        }

        //查询数据
        List<ApArticle> apArticles = apArticleMapper.loadArticleList(articleHomeDto,loadtype);
        System.out.println("apArticles.size(): "+apArticles.size());
        //结果封装
        ResponseResult responseResult = ResponseResult.okResult(apArticles);
        return responseResult;
    }

    @Autowired
    private ApArticleConfigMapper apArticleConfigMapper;

    @Autowired
    private ApArticleContentMapper apArticleContentMapper;

    /**
     * 保存app端相关文章
     *
     * @param articleDto@return
     */
    @Override
    public ResponseResult saveArticle(ArticleDto articleDto) {

/*        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        //1.检查参数
        if(articleDto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        ApArticle apArticle = new ApArticle();
        BeanUtils.copyProperties(articleDto,apArticle);

        //2.判断是否存在id
        if(articleDto.getId() == null){
            //2.1 不存在id  保存  文章  文章配置  文章内容

            //保存文章
            save(apArticle);

            //保存配置
            ApArticleConfig apArticleConfig = new ApArticleConfig(apArticle.getId());
            apArticleConfigMapper.insert(apArticleConfig);

            //保存 文章内容
            ApArticleContent apArticleContent = new ApArticleContent();
            apArticleContent.setArticleId(apArticle.getId());
            apArticleContent.setContent(articleDto.getContent());
            apArticleContentMapper.insert(apArticleContent);

        }else {
            //2.2 存在id   修改  文章  文章内容

            //修改  文章
            updateById(apArticle);

            //修改文章内容
            ApArticleContent apArticleContent = apArticleContentMapper.selectOne(Wrappers.<ApArticleContent>lambdaQuery().eq(ApArticleContent::getArticleId, articleDto.getId()));
            apArticleContent.setContent(articleDto.getContent());
            apArticleContentMapper.updateById(apArticleContent);
        }


        //3.结果返回  文章的id
        return ResponseResult.okResult(apArticle.getId());
    }
}
