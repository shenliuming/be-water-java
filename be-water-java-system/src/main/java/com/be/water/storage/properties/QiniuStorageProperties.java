package com.be.water.storage.properties;

import lombok.Data;

/**
 * 七牛云存储配置项
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@Data
public class QiniuStorageProperties {
    private String accessKey;
    private String secretKey;
    private String bucketName;
}