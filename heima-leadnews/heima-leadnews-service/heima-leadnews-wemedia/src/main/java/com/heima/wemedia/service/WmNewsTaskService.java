package com.heima.wemedia.service;


import java.util.Date;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/4 14:25
 */
public interface WmNewsTaskService {

    /**
     * 添加任务到延迟队列中
     * @param id  文章的id
     * @param publishTime  发布的时间  可以做为任务的执行时间
     */
    public void addNewsToTask(Integer id, Date publishTime);

    /**
     * 消费延迟队列数据
     */
    public void scanNewsByTask();
}
