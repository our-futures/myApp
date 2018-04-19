package com.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author Administrator
 *上传图片工具类
 */
public final class UploadImage {
	
	private static String makeFileName(String filename){ 
		         //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		         return UUID.randomUUID().toString() + "_" + filename;
		     }
		
	
	 public static  void upImage(HttpServletRequest request, HttpServletResponse response){
		 //获取上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		 String savePath = request.getSession().getServletContext().getRealPath("/images/upload");
		 File file = new File(savePath);
		 if(!file.exists() && !file.isDirectory()){
			 System.out.println(savePath+"目录不存在，需要创建");
			 file.mkdir();
		 }
		 try{
			 //创建一个DiskFileItemFactory工厂
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 //创建一个文件上传解析器
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 //解决中文名称乱码问题
			 upload.setHeaderEncoding("UTF-8");
			 //3、判断提交上来的数据是否是上传表单的数据
              if(!ServletFileUpload.isMultipartContent(request)){
                  //按照传统方式获取数据
              }
              //使用servletFileUpload解析上传的form表单，返回一个List<FileItem>的集合每FileItem对应一个元素
              List<FileItem>  list = upload.parseRequest(request);
              for(FileItem item : list){
                   //如果fileitem中封装的是普通输入项的数据
                   if(item.isFormField()){
                       String name = item.getFieldName();
                       //解决普通输入项的数据的中文乱码问题
                       String value = item.getString("UTF-8");
                       System.out.println(name + "=" + value);
                   }else{//如果fileitem中封装的是上传文件
                       //得到上传的文件名称，
                       String filename = item.getName();
                       System.out.println(filename);
                      if(filename==null || filename.trim().equals("")){
                           continue;
                       }
                      //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                      //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                       filename = filename.substring(filename.lastIndexOf("\\")+1);
                     //得到文件保存的名称
                       String saveFilename = makeFileName(filename);
                       //获取item中的上传文件的输入流
                       InputStream in = item.getInputStream();
                       //创建一个文件输出流
                      FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFilename);
                       //创建一个缓冲区
                       byte buffer[] = new byte[1024];
                       //判断输入流中的数据是否已经读完的标识
                       int len = 0;
                       //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                       while((len=in.read(buffer))>0){
                           //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                           out.write(buffer, 0, len);
                       }
                       //关闭输入流
                       in.close();
                       //关闭输出流
                       out.close();
                       //删除处理文件上传时生成的临时文件
                       item.delete();
                   }
               }
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("上传失败");
			 e.printStackTrace();
		}
	 }
}
