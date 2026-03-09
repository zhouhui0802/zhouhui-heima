package com.heima.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 联想词表
 * </p>
 *
 * @author itheima
 */
@Data
@Document("ap_associate_words")
/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/9 15:21
 */
public class ApAssociateWords implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 联想词
     */
    private String associateWords;

    /**
     * 创建时间
     */
    private Date createdTime;
}
