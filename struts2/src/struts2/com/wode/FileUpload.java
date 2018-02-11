package struts2.com.wode;

import java.io.File;
import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传
 * @author 蒋芹芹
 *
 * 2018年2月8日
 */
public class FileUpload extends ActionSupport{
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	@Override
	public String execute() throws Exception {
		destPath = "D:/upload";
		try {
			System.out.println("Src File name:"+myFile);
			System.out.println("Dest File name:"+myFileFileName);
			
			File destFile = new File(destPath, myFileFileName);
			FileUtils.copyFile(myFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
}
