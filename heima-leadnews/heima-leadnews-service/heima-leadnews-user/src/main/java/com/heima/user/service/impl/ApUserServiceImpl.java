package com.heima.user.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dto.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/25 13:42
 */
@Service
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {
    @Override
    public ResponseResult login(LoginDto loginDto) {

        //正常的手机登录
        if(!StringUtils.isBlank(loginDto.getPhone())&&!StringUtils.isBlank(loginDto.getPassword())){
            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, loginDto.getPhone()));
            if(apUser==null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"原始数据不存在");
            }

            //对比密码
            String salt=apUser.getSalt();
            String pswd =loginDto.getPassword();
            pswd = DigestUtils.md5DigestAsHex((pswd+salt).getBytes());

            if(!pswd.equals(apUser.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            //返回数据 jwt
            Map<String, Object> map = new HashMap<>();
            map.put("token",AppJwtUtil.getToken(apUser.getId().longValue()));
            apUser.setSalt("");
            apUser.setPassword("");
            map.put("user",apUser);
            return ResponseResult.okResult(map);

        }else{
            //游客浏览
            Map<String ,Object> map =new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }
    }
}
