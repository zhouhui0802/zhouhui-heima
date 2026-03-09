package com.heima.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.pojos.ApArticleConfig;

import java.util.Map;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/5 11:29
 */

public interface ApArticleConfigService extends IService<ApArticleConfig> {

    /**
     * 修改文章配置
     * @param map
     */
    public void updateByMap(Map map);
}
