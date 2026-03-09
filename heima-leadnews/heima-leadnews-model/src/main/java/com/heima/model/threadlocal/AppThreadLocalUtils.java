package com.heima.model.threadlocal;


import com.heima.model.user.pojos.ApUser;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/9 9:52
 */
public class AppThreadLocalUtils {

    private final  static ThreadLocal<ApUser> userThreadLocal = new ThreadLocal<>();
    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(ApUser user){
        userThreadLocal.set(user);
    }
    /**
     * 获取线程中的用户
     * @return
     */
    public static ApUser getUser( ){
        return userThreadLocal.get();
    }
    /**
     * 清空线程中的用户信息
     */
    public static void clear(){
        userThreadLocal.remove();
    }
}
