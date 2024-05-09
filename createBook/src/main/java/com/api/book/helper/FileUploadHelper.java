package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	"C:\\Users\\Abhay Suthar\\Desktop\\Eclipse-workspace\\createBook\\src\\main\\resources\\static\\image";

	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipathFile) {
		boolean f = false;

		try {
//		InputStream inputStream = file.getInputStream();
//		byte data[] = new byte[inputStream.available()];
//		inputStream.read(data);
//		
//		// write
//		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//		fos.write(data);
//		
//		fos.flush();
//		fos.close();

			Files.copy(multipathFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipathFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
