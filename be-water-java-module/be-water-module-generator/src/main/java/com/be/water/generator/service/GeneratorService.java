package com.be.water.generator.service;

import com.be.water.generator.vo.PreviewVO;

import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成
 *

 */
public interface GeneratorService {

    void downloadCode(Long tableId, ZipOutputStream zip);

    void generatorCode(Long tableId);

    List<PreviewVO> preview(Long tableId);
}
