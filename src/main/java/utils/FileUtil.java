package utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String rename(String fileName) {
		String nameFile = "";
		if (!fileName.isEmpty()) {
			String[] arrImg = fileName.split("\\.");
			String duoiFileImg = arrImg[arrImg.length - 1];
			
			for (int i = 0; i < (arrImg.length - 1); i++) {
				if (i == 0) {
					nameFile = arrImg[i];
				} else {
					nameFile += "-" + arrImg[i];
				}
			}
			nameFile = nameFile + "-" + System.nanoTime() + "." + duoiFileImg;
		}
		return nameFile;
	}

	public static String getName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	public static String upload(MultipartFile multipartFile, HttpServletRequest request)
			throws IllegalStateException, IOException {
		/*
		 * String webPath = request.getServletContext().getRealPath(""); String dirPath
		 * = webPath + DIR_UPLOAD; if (new File(dirPath).exists()) { new
		 * File(dirPath).mkdir(); } String fileName =
		 * multipartFile.getOriginalFilename(); System.out.println(fileName); String
		 * pathFile = dirPath + File.separator + fileName; multipartFile.transferTo(new
		 * File(pathFile)); System.out.println(pathFile); return fileName;
		 */
		
		String nameFile = rename(multipartFile.getOriginalFilename());
		System.out.println(nameFile);
		String pathFile ="";
		if(!"".equals(nameFile)){
			String dirFile = request.getServletContext().getRealPath("upload");
			System.out.println(dirFile);
			File fileDir = new File(dirFile);
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			try {
				multipartFile.transferTo(new File(fileDir+File.separator+nameFile));
				System.out.println("Upload file thành công!");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		return nameFile;
	}

}
