package com.kxr.service;

/**
 * @Author: kongxr
 * @Date: 2023-03-27 15:15
 * @Description:
 */
public class PushService {

    public static boolean pushMessage(String content) {
        System.out.println("触发 PushService，进行实际推送， 推送内容:" + content);
        return true;
    }
}
