package com.ingsha.captcha.util;

/**
 * @ClassName FontsUtil
 * @Description TODO
 * @Author Martin Yi
 * @Date 2024/4/2 14:02
 * @Version 1.0
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class FontsUtil {

    /**
     * 手动复制字体文件到临时目录. 调用传文件的构造方法创建字体
     *
     * @param fontName 字体文件名称
     * @return
     */
    public static Font getFont(String fontName, int style, float size) {
        Font font = null;

        String path = System.getProperty("java.io.tmpdir");

        File tempFontFile = new File(path + fontName);
        if (!tempFontFile.exists()) {
            //临时文件不存在
            copyTempFontFile(fontName, tempFontFile);
        }
        if (tempFontFile.exists()) {
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, tempFontFile).deriveFont(style, size);
                ;
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
                tempFontFile.delete();
            }
        }
        return font;
    }

    /**
     * 复制字体文件到临时文件目录
     *
     * @param fontName
     * @param tempFontFile
     */
    private static synchronized void copyTempFontFile(String fontName, File tempFontFile) {
        try (InputStream is = FontsUtil.class.getResourceAsStream("/" + fontName)) {
            FileUtil.copyToFile(is, tempFontFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
