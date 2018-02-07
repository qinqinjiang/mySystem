package servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileList
 */
@WebServlet("/fileList")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = this.getServletContext().getRealPath("WEB-INF\\upload");
		Map<String, String> map = new HashMap<String, String>();
		//遍历获取upload下所有可下载文件的文件名
		listfile(new File(filePath),map);
		request.setAttribute("fileNameMap", map);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);
	}
	
	/**
	 * 将所有可下载文件遍历
	 * @param file 文件或目录
	 * @param map 存储文件名
	 * jiangqinqin
	 */
	private void listfile(File file,Map<String, String> map){
		if (file.isDirectory()) {
			File files[] = file.listFiles();
			for (File file2 : files) {
				listfile(file2, map);
			}
		}else {
			//截取真实文件名（截掉uuid_）
			String realName = file.getName().substring(file.getName().indexOf("_")+1);
			map.put(file.getName(), realName);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
