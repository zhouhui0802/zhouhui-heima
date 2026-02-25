package com.heima.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dto.LoginDto;
import com.heima.model.user.pojos.ApUser;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/25 13:40
 */

public interface ApUserService extends IService<ApUser> {

    public ResponseResult login(LoginDto loginDto);
}
