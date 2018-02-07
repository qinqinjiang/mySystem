package com.wode.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Servlet implementation class HelloFreeMaker
 */
@WebServlet("/HelloFreeMakerServet.do")
public class HelloFreeMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Configuration configuration = null; // freemaker配置对象实例
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloFreeMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	configuration = new Configuration();
    	//指定模板文件路径
    	configuration.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//创建数据模型
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "wode");
		map.put("name", "欢迎您");
		map.put("content","学习FreeMaker");
		
		//获取模板数据
		Template template = configuration.getTemplate("test.ftl");
		
		
		//设置字符集编码
		response.setContentType("text/html;charset="+template.getEncoding());
		
		//渲染模板文件输出
		Writer out = response.getWriter();
		try {
			//替换模板文件的差值（渲染）,后将页面返回给浏览器
			template.process(map, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
