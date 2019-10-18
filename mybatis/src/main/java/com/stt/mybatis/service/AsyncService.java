package com.stt.mybatis.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 异步任务批量处理
 *
 * @Auther: 梦学谷
 */
@Service
public class AsyncService {
    //批量新增操作
    @Async
    public void batchAdd() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("批量保存数据中....");
    }
}
