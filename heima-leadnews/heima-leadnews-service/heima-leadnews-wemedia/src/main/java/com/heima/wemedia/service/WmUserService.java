package com.heima.wemedia.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmLoginDto;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.model.wemedia.pojos.WmUser;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/27 16:44
 */

public interface WmUserService extends IService<WmUser> {

    public ResponseResult login(WmLoginDto wmLoginDto);


}
