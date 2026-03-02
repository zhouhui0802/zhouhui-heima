package com.heima.model.wemedia.dtos;


import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/28 13:36
 */
@Data
public class WmNewsPageReqDto extends PageRequestDto {

    /**
     * 状态
     */
    private Short status;
    /**
     * 开始时间
     */
    private Date beginPubDate;
    /**
     * 结束时间
     */
    private Date endPubDate;
    /**
     * 所属频道ID
     */
    private Integer channelId;
    /**
     * 关键字
     */
    private String keyword;
}
