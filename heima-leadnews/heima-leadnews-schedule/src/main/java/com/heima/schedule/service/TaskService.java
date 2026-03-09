package com.heima.schedule.service;


/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/3 9:19
 */

import com.heima.common.constants.ScheduleConstants;
import com.heima.model.schedule.dtos.Task;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * 对外访问接口
 */
public interface TaskService {

    /**
     * 添加任务
     * @param task   任务对象
     * @return       任务id
     */
    public long addTask(Task task) ;

    /**
     * 取消任务
     * @param taskId        任务id
     * @return              取消结果
     */
    public boolean cancelTask(long taskId);

    /**
     * 按照类型和优先级来拉取任务
     * @param type
     * @param priority
     * @return
     */
    public Task poll(int type,int priority);

    public void refresh();

}
