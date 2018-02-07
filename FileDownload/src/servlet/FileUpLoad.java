package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传demo
 * @author jiangqinqin
 *
 */
@WebServlet("/fileUpload")
public class FileUpLoad extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取上传文件的保存目录(具体路径)
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tempFile = new File(tempPath);
		//如果目录不存在创建
		if(!tempFile.exists()){
			tempFile.mkdir();
		}
		//使用Apache文件上传组件处理文件文件上传
		try {
			//创建DiskFileItemFactory工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			//设置工厂的缓冲区的大小（100KB）默认10KB，当上传文件大小超过缓冲区大小生成临时文件，放到临时目录
			diskFileItemFactory.setSizeThreshold(1024*10);  
			//设置临时文件保存目录
			diskFileItemFactory.setRepository(tempFile);
			//创建文件上传解析器
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			//设置上传文件名乱码问题
			servletFileUpload.setHeaderEncoding("UTF-8");
			//设置每个上传文件的最大值（1MB）
			servletFileUpload.setFileSizeMax(1024*1024);
			//设置总的上传文件的最大值（10MB）
			servletFileUpload.setSizeMax(10*1024*1024);
			//解析上传文件，一个FileItem对应一个表单输入项
			List<FileItem> list = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				//如果是普通输入项的数据
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					//获取输入数据，防止乱码
					String value = fileItem.getString("UTF-8");
					System.out.println(name+" "+value);
				}else {  //如果是上传文件
					//获取文件名
					String filename = fileItem.getName();
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					//这里只获取文件名，有些浏览器提交的文件名可能是具体路径，所以需要截取
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//得到上传文件扩展名（可以用来判断上传的是否是合法的文件）
					String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
					System.out.println("fileExtName："+fileExtName);
					//获取上传文件的输入流
					InputStream fileInputStream = fileItem.getInputStream();
					//得到文件保存名称
					String saveFileName = makeFileName(filename);
					//得到保存文件的目录
					String realSavePath = makePath(saveFileName, path);
					//创建输出流
					FileOutputStream fileOutputStream = new FileOutputStream(realSavePath+"\\"+saveFileName);
					//创建缓冲区
					byte[] buffer = new byte[1024];
					//判断输入流数据是否读完的标志
					int len = 0;
					//将输入流数据读入缓冲区
					while ((len = fileInputStream.read(buffer))>0) {
						//将缓冲区数据写入指定目录
						fileOutputStream.write(buffer, 0, len);
					}
					System.out.println("文件上传成功");
					if (fileInputStream != null) {
						fileInputStream.close();
					}
					if (fileOutputStream != null) {
						fileOutputStream.close();
					}
					//删除上传时产生的临时文件
					fileItem.delete();
				}
			}
		} catch(FileUploadBase.FileSizeLimitExceededException e){
			System.out.println("单个上传文件大小超过最大值");
			e.printStackTrace();
		}
		catch (FileUploadBase.SizeLimitExceededException e) {
			System.out.println("总上传文件大小超过最大值");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @param fileName 文件原始名称
	 * @return uuid+"_"+文件的原始名称
	 * jiangqinqin
	 */
	private String makeFileName(String fileName){
		//防止文件覆盖，生成唯一文件名
		return UUID.randomUUID().toString()+"_"+fileName;
	}
	
	/**
	 * 为防止一个目录下生成太多文件，使用hash算法打乱存储目录
	 * @param filename 文件名
	 * @param savePath 保存路径
	 * @return 新的存储目录
	 * jiangqinqin
	 */
	private String makePath(String filename,String savePath){
		//得到文件名的hash值,也就是filename字符串在内存的地址
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;  //0-15
		int dir2 = (hashcode&0xf0)>>4;
		String dir = savePath + "\\"+dir1+"\\"+dir2;
		//File既可以代表文件也可以代表目录
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
	
}
