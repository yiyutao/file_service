package com.ydp.fileservice.service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.ydp.fileservice.config.AbstractConfiguration;
import com.ydp.fileservice.config.PropertiesConfiguration;
import com.ydp.fileservice.config.YamlConfiguration;
import com.ydp.fileservice.domain.UploadConfig;

import java.io.File;
import java.io.InputStream;

/**
 * @author: masterYI
 * @date: 2018/8/15
 * @time: 16:44
 * @description:
 */
public abstract class BaseUploadService {

    //加载配置文件
    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String name = "fileservice";
        new PropertiesConfiguration(classLoader, name);
        //new YamlConfiguration(classLoader, name);

    }

    /**
     * 上传
     *
     * @param uploadConfig 上传配置
     * @param key          上传资源名称
     * @param object       文件或数据流
     * @return 上传资源访问路径
     */
    public abstract String upload(UploadConfig uploadConfig, String key, Object object);


    /**
     * 默认配置上传
     *
     * @param key    上传资源名称
     * @param object 文件或数据流
     * @return 上传资源访问路径
     */
    String qiniuUpload(String key, Object object) {
        return qiniuUpload(AbstractConfiguration.accessKey, AbstractConfiguration.secretKey, AbstractConfiguration.bucket
                , AbstractConfiguration.zone, key, object);
    }

    /**
     * 默认配置数据流上传
     *
     * @param name        上传流的名称
     * @param inputStream 数据流
     */
    String qiniuUpload(String accessKey, String secretKey, String bucket, int zone, String key, Object object) {
        Configuration cfg = new Configuration(getZone(zone));
        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        String url = "";
        Response response = null;
        try {
            if (object instanceof File) {
                response = uploadManager.put((File) object, key, upToken);
            }
            if (object instanceof InputStream) {
                response = uploadManager.put((InputStream) object, key, upToken, null, null);
            }
            if (response != null) {
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                url = putRet.key;
            }

        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
        return url;
    }


    private static Zone getZone(int zone) {
        switch (zone) {
            case 1:
                return Zone.zone1();
            case 2:
                return Zone.zone2();
            default:
                return Zone.zone0();
        }
    }

}
