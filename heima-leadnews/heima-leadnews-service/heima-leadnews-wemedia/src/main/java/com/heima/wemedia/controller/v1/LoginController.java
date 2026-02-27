package com.heima.wemedia.controller.v1;


import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmLoginDto;
import com.heima.model.wemedia.pojos.WmUser;
import com.heima.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/27 16:51
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private WmUserService  wmUserService;

    @PostMapping("/in")
    public ResponseResult login(@RequestBody WmLoginDto wmLoginDto) {
        return wmUserService.login(wmLoginDto);
    }
}
