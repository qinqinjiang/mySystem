package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;
/**
 * 文件下载demo
 * @author jiangqinqin
 *
 */
@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		//乱码处理
		filename = new String(filename.getBytes("iso8859-1"),"UTF-8");
		//文件上传根目录
		String fileSaveRootPath = this.getServletContext().getRealPath("WEB-INF\\upload");
		//文件所在目录
		String fileSavePath = fileSavePath(filename, fileSaveRootPath);
		File file = new File(fileSavePath+"\\"+filename);
		if (!file.exists()) {
			System.out.println("资源不存在");
			return;
		}
		String realname = filename.substring(filename.indexOf("_")+1);
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		//读取要下载的文件
		FileInputStream fileInputStream = new FileInputStream(file);
		//获取输出流
		OutputStream outputStream = response.getOutputStream();
		//创建缓存
		byte[] buffer = new byte[1024];
		int len = 0;
		//将输入流的内容读到缓冲区
		while ((len = fileInputStream.read(buffer))>0) {
			//输出缓冲区的内容到浏览器
			outputStream.write(buffer,0,len);
		}
		System.out.println("文件下载成功");
		if (fileInputStream != null) {
			fileInputStream.close();
		}
		if (outputStream != null) {
			outputStream.close();
		}
		
	}
	
	/**
	 * 根据文件名和根目录找出文件位置
	 * @param filename 文件名
	 * @param fileSaveRootPath 根目录
	 * @return
	 * jiangqinqin
	 */
	public String fileSavePath(String filename,String fileSaveRootPath){
		int hash = filename.hashCode();
		int dir1 = hash&0xf;
		int dir2 = (hash&0xf0)>>4;
		String dir = fileSaveRootPath+"\\"+dir1+"\\"+dir2;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
	
	
	
}
