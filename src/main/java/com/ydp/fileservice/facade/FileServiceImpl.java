package com.ydp.fileservice.facade;

import com.ydp.fileservice.api.IFileService;
import com.ydp.fileservice.domain.UploadConfig;
import com.ydp.fileservice.service.BaseUploadService;
import com.ydp.fileservice.types.UploadTargetEnum;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: masterYI
 * @date: 2018/8/15
 * @time: 11:34
 * @description: 上传文件实现类，上传到云的文件不会做重名校验，请在客户端做好资源名称的唯一性生成
 */
public class FileServiceImpl implements IFileService {


    @Override
    public String[] upload(String key, File file) {
        UploadTargetEnum[] values = UploadTargetEnum.values();
        List<String> urls = new ArrayList<>();
        for (UploadTargetEnum targetEnum : values) {
            String url = upload(targetEnum, key, file);
            urls.add(url);
        }
        return urls.toArray(new String[values.length]);
    }

    @Override
    public String[] upload(String key, InputStream inputStream) {
        UploadTargetEnum[] values = UploadTargetEnum.values();
        List<String> urls = new ArrayList<>();
        for (UploadTargetEnum targetEnum : values) {
            String url = upload(targetEnum, key, inputStream);
            urls.add(url);
        }
        return urls.toArray(new String[values.length]);
    }

    @Override
    public String[] upload(UploadConfig uploadConfig, String key, File file) {
        UploadTargetEnum[] values = UploadTargetEnum.values();
        List<String> urls = new ArrayList<>();
        for (UploadTargetEnum targetEnum : values) {
            String url = upload(targetEnum, uploadConfig, key, file);
            urls.add(url);
        }
        return urls.toArray(new String[values.length]);
    }

    @Override
    public String[] upload(UploadConfig uploadConfig, String key, InputStream inputStream) {
        UploadTargetEnum[] values = UploadTargetEnum.values();
        List<String> urls = new ArrayList<>();
        for (UploadTargetEnum targetEnum : values) {
            String url = upload(targetEnum, uploadConfig, key, inputStream);
            urls.add(url);
        }
        return urls.toArray(new String[values.length]);
    }

    @Override
    public String upload(UploadTargetEnum targetEnum, String key, File file) {
        BaseUploadService uploadService = targetEnum.getUploadService();
        return uploadService.upload(null, key, file);
    }

    @Override
    public String upload(UploadTargetEnum targetEnum, String key, InputStream inputStream) {
        BaseUploadService uploadService = targetEnum.getUploadService();
        return uploadService.upload(null, key, inputStream);
    }

    @Override
    public String upload(UploadTargetEnum targetEnum, UploadConfig uploadConfig, String key, File file) {
        BaseUploadService uploadService = targetEnum.getUploadService();
        return uploadService.upload(uploadConfig, key, file);
    }

    @Override
    public String upload(UploadTargetEnum targetEnum, UploadConfig uploadConfig, String key, InputStream inputStream) {
        BaseUploadService uploadService = targetEnum.getUploadService();
        return uploadService.upload(uploadConfig, key, inputStream);
    }

}
