package com.ydp.fileservice.types;

import com.ydp.fileservice.service.BaseUploadService;
import com.ydp.fileservice.service.AliyunServiceImpl;
import com.ydp.fileservice.service.QiNiuServiceImpl;

/**
 * @author: masterYI
 * @date: 2018/8/15
 * @time: 11:11
 * @description: 上传目标空间，如七牛云、阿里云
 */
public enum UploadTargetEnum {

    /**
     * 七牛云
     */
    QINIU(new QiNiuServiceImpl()),

    /**
     * 阿里云
     */
    ALIYUN(new AliyunServiceImpl());

    private BaseUploadService uploadService;

    UploadTargetEnum(BaseUploadService uploadService) {
        this.uploadService = uploadService;
    }

    public BaseUploadService getUploadService() {
        return uploadService;
    }
}
