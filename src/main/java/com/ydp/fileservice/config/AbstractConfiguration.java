package com.ydp.fileservice.config;

/**
 * @author: masterYI
 * @date: 2018/8/20
 * @time: 11:48
 * @description:
 */
public abstract class AbstractConfiguration {

    /**
     * 密钥，标识用户，可传输
     */
    public static String accessKey;

    /**
     * 密钥，加密签名字符串，不可传输
     */
    public static String secretKey;

    /**
     * 空间名称
     */
    public static String bucket;

    /**
     * 区域地址，0：华东，1：华北，2：华南
     */
    public static int zone;

    /**
     * 外网端点，阿里云
     */
    public static String endpoint;
}
