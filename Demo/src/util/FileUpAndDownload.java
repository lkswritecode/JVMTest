package util;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileUpAndDownload
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/4/22 10:29
 * @Version 1.0
 **/
public class FileUpAndDownload {
    /**
     * 上传
     * @param file 文件
     * @param FileName 文件名称
     * @param request HttpServletRequest
     * @throws IOException
     * @throws InterruptedException
     */
    public void upload(File file, String FileName, HttpServletRequest request) throws IOException, InterruptedException {
        //获取后缀名
        String sufName = "."+FilenameUtils.getExtension(FileName);
        //文件保存路径
        String url = request.getSession().getServletContext().getRealPath("")+"file/"+System.currentTimeMillis()+sufName;
        if(file!=null){
            //文件输入流
            FileInputStream inputStream = new FileInputStream(file);
            //文件输出流
            FileOutputStream outputStream = new FileOutputStream(url);
            //获取输入通道
            FileChannel inChan = inputStream.getChannel();
            //获取输出通道
            FileChannel outChan = outputStream.getChannel();
            //缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //文件大小
            long upFileSize=file.length();
            //上传进度
            double persent=0;
            int len = 0;//表示成功读取的字节数的个数搜索

            while ((len=inChan.read(buf)) != -1){
                //重设缓冲区
                buf.flip();
                //输出缓冲区
                outChan.write(buf);
                //清空缓冲区
                buf.clear();
                //计算文件进度
                persent+=len/(double)upFileSize*100D;
                Thread.sleep(10);
            }
            outChan.close();
            inChan.close();
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }

    /**
     * 下载
     * @param response HttpServletResponse
     * @param fileUrl  文件路径
     * @param fileName 文件名
     * @throws IOException
     */
    public void download( HttpServletResponse response, String fileUrl,String fileName) throws IOException {
             //将文件加入内存
            File file = new File(fileUrl);
            //文件输入流
            FileInputStream fileInputStream = new FileInputStream(file);;
             //文件管道
            FileChannel fileChannel = fileInputStream.getChannel();
             //servlet输出流
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            //字节buff
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            //读取字节
            while (fileChannel.read(byteBuffer)>0){}
            byte[] data = byteBuffer.array();
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //刷新响应
            response.reset();
            //设置响应头
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            //添加响应头长度
            response.addHeader("Content-Length", "" + data.length);
            //设置响应类型
            response.setContentType("application/octet-stream;charset=UTF-8");
            //输出文件
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
            response.flushBuffer();
            fileChannel.close();
            fileInputStream.close();
    }
}
