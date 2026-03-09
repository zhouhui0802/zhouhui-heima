package com.heima.search.service;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.search.dtos.HistorySearchDto;
import com.heima.model.search.dtos.UserSearchDto;

import java.io.IOException;

public interface ApUserSearchService {

    /**
     * 保存用户搜索历史记录
     * @param
     */
    public void insert( String keyword,Integer userId);

    ResponseResult findUserSearch();

    /**
     删除搜索历史
     @return
     */
    ResponseResult delUserSearch(HistorySearchDto historySearchDto);

}