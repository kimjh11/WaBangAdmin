package kr.wabang.item;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.wabang.controller.CommandService;

public class CommandItemEditOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 글 수정
		
		//이미지 파일  서버에 등록
		ItemVO vo = new ItemVO();
		vo.setPath(req.getServletContext().getRealPath("/item/itemImg"));
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req, vo.getPath(),Integer.MAX_VALUE,"UTF-8",pol);
		
		//다시 vo에 다 등록
		vo.setCode(mr.getParameter("p_Code"));
		vo.setName(mr.getParameter("p_Title"));
		vo.setPrice(Integer.parseInt(mr.getParameter("p_Price")));
		vo.setDiscount(Integer.parseInt(mr.getParameter("sale")));
		vo.setCategory(mr.getParameter("cateTotal"));
		vo.setOption(mr.getParameter("optionTotal"));
		vo.setColor(mr.getParameter("colorTotal"));
		vo.setDelThumb(mr.getParameter("delThumb"));
		vo.setDelDetail(mr.getParameter("delImage"));
		
		//업로드한 파일목록
		String newFilename[] = new String[5];
		
		//파일목록
		Enumeration fileList = mr.getFileNames();
		int i = 0;
		while(fileList.hasMoreElements()) {
			String file = (String)fileList.nextElement();
			newFilename[i++] = mr.getFilesystemName(file);
		}
		vo.setEditFileName(newFilename);
		
		ItemDAO dao = new ItemDAO();
		String path = req.getServletContext().getRealPath("/item/itemImg");
		int cnt = dao.editItem(vo, path);
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("code", vo.getCode());
		return "itemEditOk.jsp";
	}

}
