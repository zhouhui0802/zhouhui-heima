package com.heima.model.common.ano;


import java.lang.annotation.*;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/9 9:22
 */
// 标记此注解的字段 为id字段
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EsId {
}
