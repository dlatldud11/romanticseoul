package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class Utility {
	// 업로드된 파일의 정보를 반환해주는 메소드입니다.
	public static File getUploadedFileInfo(MultipartFile multi, String realPath) {
		// multi : 업로드 하고자 하는 멀티 파트 객체
		// realPath : 실제로 이미지가 업로드 되는 위치
		
		String pattern = "yyyyMMddhhmmss" ; // 패턴) 년월일시분초
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(new Date()); // 현재 시각을 의미하는 문자열
		
		String somefile = multi.getOriginalFilename() ;
		System.out.println("somefile : " + somefile);
		
		int dot = somefile.indexOf(".") ; // 도트의 위치
		
		String filename = somefile.substring(0, dot) ; // 파일 이름
		String fileext = somefile.substring(dot) ; // 파일의 확장자
		String newfile = filename + now + fileext ; // 신규로 만들어질 파일 이름
		
		String myfile = realPath + File.separator + newfile ; 
		
		return new File(myfile) ;
	}

	// 예외 발생시, 예외 정보를 ModelAndView 객체에 저장하여 반환해주는 메소드입니다.
	public static ModelAndView getMav(String jsp, Exception ex, String classname) {
		// jsp : 예외 결과를 보여줄 jsp 파일
		// ex : 발생한 예외 객체
		// classname : 예외가 발생한 클래스 이름
		ModelAndView mav = new ModelAndView(jsp);
		
		mav.addObject("errlocation", classname + " 클래스") ;
		mav.addObject("errstring", ex.toString()) ;
		mav.addObject("errmessage", ex.getMessage()) ;
		
		return mav;
	}
}