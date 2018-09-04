package com.ydp.fileservice.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: masterYI
 * @date: 2018/8/15
 * @time: 16:49
 * @description:上传参数
 */
@Data
public class UploadConfig implements Serializable {

    private static final long serialVersionUID = 6214108808165661801L;
    /**
     * 密钥，标识用户，可传输
     */
    private String accessKey;

    /**
     * 密钥，加密签名字符串，不可传输
     */
    private String secretKey;

    /**
     * 空间名称
     */
    private String bucket;

    /**
     * 区域地址，0：华东，1：华北，2：华南
     */
    private int zone;

    /**
     * 外网端点，阿里云
     */
    private String endpoint;


    public UploadConfig() {
    }

    public UploadConfig(String accessKey, String secretKey, String bucket, int zone) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
        this.zone = zone;
    }

    public UploadConfig(String accessKey, String secretKey, String endpoint) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.endpoint = endpoint;
    }
}
