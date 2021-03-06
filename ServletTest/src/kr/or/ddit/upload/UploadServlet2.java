package kr.or.ddit.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 자카르타 프로젝트의 fileupload 모듈을 이용한 파일업로드 예제
 */
public class UploadServlet2 extends HttpServlet {
	
	private static final String UPLOAD_DIR = "upload_files";
	
	// 메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	
	// 파일 1개당 최대 크기
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 40;
	
	// 요청 파일 최대 크기
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 50;
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(req)) {// multipart/form-data 인지 아닌지 확인작업이 필요하다
			// 인코딩 타입이 multipart/form-data 인 경우...
			
			
			// 폼필드 데이터 저장용...
			Map<String, String> formMap = 
					new HashMap<String, String>();
			
			DiskFileItemFactory factory = 
					new DiskFileItemFactory();
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			factory.setRepository(
					new File("d/:D_Other/"));
					//System.getProperty("java.io.tmpdir"))); 임시저장경로
			
			ServletFileUpload upload = 
					new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);
			
			
			// 웹애플리케이션 루트 디렉토리 기준 업로드 경로 설정하기
			String uploadPath = getServletContext().getRealPath("") //웹애플리케이션 경로의 실제 파일시스템의 경로를 알아내는 메서드이다. 
					+ File.separator + UPLOAD_DIR;
			
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir(); //파일생성까지 완료
			}
			
			
			List<FileItem> formItems;
			
			
			try {
				formItems = upload.parseRequest(req);
			
				if(formItems != null && formItems.size() > 0) {
					for(FileItem item : formItems) {
						if(!item.isFormField()) {// 파일인 경우...
							// 전체경로를 제외한 파일명만 추출하기
							String fileName = 
									new File(item.getName()).getName(); //파일이름을 뺴오는 메서드
							
							String filePath =  //빼온 파일이름으로 다시 경로를 설정해준다
								uploadPath + File.separator + fileName;
							
							File storeFile = new File(filePath);
							
							item.write(storeFile); //write()메서드가 원하는 객체는 파일객체임으로 파일객체를 만들어 넣어줬다
							
							req.setAttribute("message","업로드 완료됨. => 파일명 : " + fileName);
							
						}else { // 폼 데이터인 경우...
							// 폼필드의 값이 한글인 경우에는 해당 문자열을 적절히 변환을
							// 해주어야 한다.
							// 방법1. value = new String(fileItem.getString()
							//            .getBytes("8859-1"), "UTF-8");
							// 방법2. value = fileItem.getString("UTF-8");
							
							formMap.put(item.getFieldName(),  //성공한 데이터 값 저장(잘됐나 확인하기위해 작업 사실 업로드하는데는 필요없다.)
									item.getString("UTF-8"));
						}
					}
				}
				
				
			} catch (Exception e) {
				req.setAttribute("message", "예외발생: " + e.getMessage()); 
				e.printStackTrace();
			}
			for(Entry<String, String> entry : formMap.entrySet()) {
				System.out.println("파라미터명 : " + entry.getKey());
				System.out.println("파라미터값 : " + entry.getValue());
			}
			resp.setContentType("text/html");
			resp.getWriter().print("업로드 완료됨.!!!");
		}
	}
}
