package com.heima.wemedia.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmNewsMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/28 15:01
 */
@Mapper
public interface WmNewsMaterialMapper extends BaseMapper<WmNewsMaterial> {
    void saveRelations(@Param("materialIds") List<Integer> materialIds,
                       @Param("newsId") Integer newsId,
                       @Param("type")Short type);
}
