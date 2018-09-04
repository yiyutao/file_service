package com.ydp.fileservice.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @author: masterYI
 * @date: 2018/8/20
 * @time: 11:09
 * @description: 解析properties配置文件
 */
public class PropertiesConfiguration extends AbstractConfiguration {

    public PropertiesConfiguration(ClassLoader classLoader, String name) {
        try {
            name = name + ".properties";
            URL url = classLoader.getResource(name);
            Properties properties = new Properties();
            if (url == null) {
                return;
            }
            properties.load(url.openStream());

            accessKey = properties.getProperty("accessKey");
            secretKey = properties.getProperty("secretKey");
            bucket = properties.getProperty("bucket");
            endpoint = properties.getProperty("endpoint");
            String zoneStr = properties.getProperty("zone");
            zone = zoneStr == null || "".equals(zoneStr) ? 0 : Integer.valueOf(zoneStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
