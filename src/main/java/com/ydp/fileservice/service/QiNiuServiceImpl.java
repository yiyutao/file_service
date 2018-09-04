package com.ydp.fileservice.service;

import com.ydp.fileservice.domain.UploadConfig;

/**
 * @author: masterYI
 * @date: 2018/8/15
 * @time: 11:41
 * @description:七牛云上传
 */
public class QiNiuServiceImpl extends BaseUploadService {

    @Override
    public String upload(UploadConfig uploadConfig, String key, Object object) {
        if (object == null) {
            throw new IllegalArgumentException("上传资源为空");
        }
        //默认配置上传
        if (uploadConfig == null) {
            return qiniuUpload(key, object);
        }
        return qiniuUpload(uploadConfig.getAccessKey(), uploadConfig.getSecretKey(), uploadConfig.getBucket(), uploadConfig.getZone(), key, object);
    }


}
