package com.heima.wemedia.controller.v1;


import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.WmNewsDto;
import com.heima.model.wemedia.dtos.WmNewsPageReqDto;
import com.heima.model.wemedia.pojos.WmNews;
import com.heima.wemedia.service.WmNewsAutoScanService;
import com.heima.wemedia.service.WmNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/28 13:37
 */
@RestController
@RequestMapping("/api/v1/news")
public class WmNewsController {

    @Autowired
    private WmNewsService wmNewsService;

    @Autowired
    private WmNewsAutoScanService wmNewsAutoScanService;

    @PostMapping("/list")
    public ResponseResult findAll(@RequestBody WmNewsPageReqDto wmNewsPageReqDto) {
        return wmNewsService.findAll(wmNewsPageReqDto);
    }

    @PostMapping("/submit")
    public ResponseResult submitNews(@RequestBody WmNewsDto wmNewsDto){

        wmNewsService.submitNews(wmNewsDto);

        // 审核文章
        wmNewsAutoScanService.autoScanWmNews(wmNewsDto.getId());
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
