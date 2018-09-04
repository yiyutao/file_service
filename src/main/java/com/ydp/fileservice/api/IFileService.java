package com.ydp.fileservice.api;

import com.ydp.fileservice.domain.UploadConfig;
import com.ydp.fileservice.types.UploadTargetEnum;

import java.io.File;
import java.io.InputStream;

/**
 * @author: masterYI
 * @date: 2018/8/9
 * @time: 17:03
 * @description:
 */
public interface IFileService {

    /**
     * 文件上传，不指定CDN运营商，上传到所有运营商。不指定上传配置，取默认值
     *
     * @param UploadConfig 上传配置
     * @param file         文件
     * @param key          上传资源名称
     */
    String[] upload(String key, File file);

    /**
     * 数据流上传，不指定CDN运营商，上传到所有运营商。不指定上传配置，取默认值
     *
     * @param UploadConfig 上传配置
     * @param inputStream  数据流
     * @param key          上传资源名称
     */
    String[] upload(String key, InputStream inputStream);

    /**
     * 文件上传，不指定CDN运营商，上传到所有运营商
     *
     * @param UploadConfig 上传配置
     * @param key          上传资源名称
     * @param file         文件
     */
    String[] upload(UploadConfig uploadParam, String key, File file);

    /**
     * 数据流上传，不指定CDN运营商，上传到所有运营商
     *
     * @param UploadConfig 上传配置
     * @param key          上传资源名称
     * @param inputStream  数据流
     */
    String[] upload(UploadConfig uploadParam, String key, InputStream inputStream);

    /**
     * 文件上传，不指定配置属性，取默认值
     *
     * @param targetEnum 上传CDN运营商，如七牛云，阿里云
     * @param key        上传资源名称
     * @param file       上传文件
     */
    String upload(UploadTargetEnum targetEnum, String key, File file);

    /**
     * 数据流上传，不指定配置属性，取默认值
     *
     * @param targetEnum 上传CDN运营商，如七牛云，阿里云
     * @param key        上传资源名称
     * @param file       上传文件
     */
    String upload(UploadTargetEnum targetEnum, String key, InputStream inputStream);

    /**
     * 文件上传
     *
     * @param targetEnum   上传CDN运营商，如七牛云，阿里云
     * @param UploadConfig 上传配置
     * @param key          上传资源名称
     * @param file         文件
     */
    String upload(UploadTargetEnum targetEnum, UploadConfig uploadParam, String key, File file);

    /**
     * 数据流上传
     *
     * @param targetEnum   上传CDN运营商，如七牛云，阿里云
     * @param UploadConfig 上传配置
     * @param key          上传资源名称
     * @param inputStream  数据流
     */
    String upload(UploadTargetEnum targetEnum, UploadConfig uploadParam, String key, InputStream inputStream);
}
