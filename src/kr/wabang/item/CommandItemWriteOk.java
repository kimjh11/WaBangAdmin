package kr.wabang.item;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.wabang.controller.CommandService;

public class CommandItemWriteOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �젅��二쇱냼
		String path = req.getServletContext().getRealPath("/item/itemImg");
		System.out.println("path="+path);
		//�뾽濡쒕뱶 �븯�뒗 �뙆�씪�쓽 �궗�씠利�
		int maxSize = 1024*1024*1024;
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		
		MultipartRequest mr = new MultipartRequest(req, path, maxSize,"UTF-8",pol);
		ItemVO vo = new ItemVO();
		vo.setCode(mr.getParameter("p_Code"));
		//�뿬湲곗뿉�꽌 移댄뀒怨좊━ �꽔湲�
		vo.setName(mr.getParameter("p_Title"));
		vo.setPrice(Integer.parseInt(mr.getParameter("p_Price")));
		vo.setDiscount(Integer.parseInt(mr.getParameter("sale")));
		vo.setCategory(mr.getParameter("cateTotal"));
		vo.setOption(mr.getParameter("optionTotal"));
		vo.setColor(mr.getParameter("colorTotal"));
		//�뙆�씪紐�
	
		Enumeration fileList = mr.getFileNames(); 
		String newFileName[] = new String[5]; 
		int idx = 0; 
		while(fileList.hasMoreElements()){
			String oldFile = (String)fileList.nextElement(); 
			newFileName[idx++]= mr.getFilesystemName(oldFile);
		} 
		vo.setNewFileName(newFileName);
		ItemDAO dao = new ItemDAO();
		int cnt = dao.itemWrtie(vo);
		
		if(cnt<0) {
			for(int i=0;i<newFileName.length;i++) {
				if(newFileName[i]!=null && !newFileName[i].equals("")) {
					File f = new File(path, newFileName[i]);
					f.delete();
				}
			}
		}
		req.setAttribute("cnt", cnt);
		
		System.out.println(vo.setVO());
		
		return "itemWriteOk.jsp";
	}

}

