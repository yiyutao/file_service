package com.ydp.fileservice.config;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * @author: masterYI
 * @date: 2018/8/20
 * @time: 11:54
 * @description:
 */
public class YamlConfiguration extends AbstractConfiguration {

    public YamlConfiguration(ClassLoader classLoader, String name) {
        try {
            name = name + ".yml";
            URL url = classLoader.getResource(name);
            if (url == null) {
                return;
            }
            Yaml yaml = new Yaml();

            Map map = yaml.loadAs(url.openStream(), Map.class);
            accessKey = map.get("accessKey") == null ? null : map.get("accessKey").toString();
            secretKey = map.get("secretKey") == null ? null : map.get("secretKey").toString();
            bucket = map.get("bucket") == null ? null : map.get("bucket").toString();
            endpoint = map.get("endpoint") == null ? null : map.get("endpoint").toString();
            zone = map.get("zone") == null ? 0 : Integer.valueOf(map.get("zone").toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
