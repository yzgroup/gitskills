/**
 * 
 */
package com.cdintelligent.znzx.common.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * 文件操作类
 * 
 * @author SF2516
 */
public final class FileUtils
{
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class);

    /**
     * 关闭资源
     * 
     * @param resource 资源
     */
    public static void closeResource(Closeable resource)
    {
        try
        {
            if (null != resource)
            {
                resource.close();
            }
        }
        catch (IOException e)
        {
            LOGGER.error("close resource failed", e);
        }
    }

    /**
     * 清空资源
     * 
     * @param fls 资源
     */
    public static void flushResource(Flushable fls)
    {
        try
        {
            if (null != fls)
            {
                fls.flush();
            }
        }
        catch (IOException e)
        {
            LOGGER.error("flushable resource failed", e);
        }
    }

    /**
     * 关闭数据流
     * 
     * @param stream 流
     * @param fls 流
     */
    public static void closeStream(Closeable stream, Flushable fls)
    {
        flushResource(fls);
        closeResource(stream);
    }

    /**
     * 压缩文件
     * 
     * @param srcfile File[] 需要压缩的文件列表
     * @param zipfile File 压缩后的文件
     */
    public static void zipFiles(List<File> srcfile, File zipfile) throws IOException
    {
        byte[] buf = new byte[1024];
        // Create the ZIP file
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
        // Compress the files
        for (int i = 0; i < srcfile.size(); i++)
        {
            File file = srcfile.get(i);
            FileInputStream in = new FileInputStream(file);
            // Add ZIP entry to output stream.
            out.putNextEntry(new ZipEntry(file.getName()));
            // Transfer bytes from the file to the ZIP file
            int len;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            // Complete the entry
            out.closeEntry();
            in.close();
        }
        // Complete the ZIP file
        out.close();

    }


    /**
     * <p>Description: 递归删除文件夹</p>
     * <p>Copyright: Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime: 2017.11.06</p>
     *
     * @param file file
     * @author ngl
     * @version 1.0
     */
    public static void deleteFile(File file)
    {
        // 判断文件是否存在
        if (file.exists())
        {
            // 判断是否是文件
            if (file.isFile())
            {
                file.delete();// 删除文件
            }
            else if (file.isDirectory())// 否则如果它是一个目录
            {
                File[] files = file.listFiles();// 声明目录下所有的文件 files[];
                // 遍历目录下所有的文件
                for (int i = 0; i < files.length; i++)
                {
                    deleteFile(files[i]);// 把每个文件用这个方法进行迭代
                }
                file.delete();// 删除文件夹
            }
        }
        else
        {
            LOGGER.info("所删除的文件不存在");
        }
    }
}
