package com.heima.model.wemedia.dtos;


import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/28 10:49
 */
@Data
public class WmMaterialDto extends PageRequestDto {

    /**
     * 1 收藏
     * 0 未收藏
     */
    private Short isCollection;
}
