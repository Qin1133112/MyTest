//package uploadFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
///**
// * Servlet implementation class UploadFileServlet
// */
//@WebServlet("/UploadFileServlet")
//public class UploadFileServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public UploadFileServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String webRootPath = getServletContext().getRealPath("/");
//        System.out.println("webRootPath:" + webRootPath);
//        
//        File file = new File(webRootPath+"upload");
//		
////		File file = new File("D:/upload");// 上传文件保存位置
//		File tempfile = new File("D:/tempload");// 上传缓存临时文件夹
//		if (!file.exists()) {
//			file.mkdir();
//		}
//		if (!tempfile.exists()) {
//			tempfile.mkdir();
//		}
//		// 判断是否上传文件表单,也就是form中是否有enctype="multipart/form-data"项;必须post提交,get提交对内容长度有限制
//		if (ServletFileUpload.isMultipartContent(request)) {
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			factory.setSizeThreshold(1024 * 512);// 设置缓冲区大小
//			factory.setRepository(tempfile);// 设置临时文件夹
//			ServletFileUpload fileUpload = new ServletFileUpload(factory);
//			fileUpload.setFileSizeMax(10000 * 1024 * 1024);// 设置最大文件大小
//
//			try {
//				List<FileItem> items = fileUpload.parseRequest(request);// 获取所有表单
//				for (FileItem item : items) {
//					// 判断当前的表单控件是否是一个普通控件
//					if (!item.isFormField()) {
//						// 是一个文件控件时
//						String name = item.getName();
//						System.out.println("上传文件名:" + name);
//						System.out.println("文件大小:" + item.getSize());
//
//						String extName = name.substring(name.lastIndexOf("."));
//						String newName = new SimpleDateFormat("yyyyMMDDHHmmssms").format(new Date());
//
//						System.out.println("扩展名" + extName);
//						item.write(new File(webRootPath+"upload/" + newName + extName));
//					} else {
//						// 是普通控件时
//						String desc = item.getString("UTF-8");
//						System.out.println("文件描述" + desc);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			throw new RuntimeException("请设置form表单的enctype属性");
//		}
//		response.sendRedirect("secc.jsp?code=001");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
