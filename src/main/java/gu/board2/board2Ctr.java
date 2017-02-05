package gu.board2;

import gu.common.PageVO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class board2Ctr {

    @Autowired
    private board2Svc boardSvc;
    
    // 리스트
    @RequestMapping(value = "/board2List")
   	public String boardList(PageVO pageVO, ModelMap modelMap) throws Exception {
    	
    	pageVO.pageCalculate( boardSvc.selectBoardCount() ); // startRow, endRow

    	List<?> listview   = boardSvc.selectBoardList(pageVO);
    	
    	modelMap.addAttribute("listview", listview);
    	modelMap.addAttribute("pageVO", pageVO);

        return "board2/boardList";
    }
    
    // 글 쓰기 
//    @RequestMapping(value = "/board2Form")
//   	public String boardForm() throws Exception {
//        return "board2/boardForm";
//    }
    
    @RequestMapping(value = "/board2Save")
   	public String boardSave(@ModelAttribute boardVO boardInfo) throws Exception {
    	if (boardInfo.getBrdno()== null || "".equals(boardInfo.getBrdno())){
            boardSvc.insertBoard(boardInfo);    //brdno is null(insert)
    	}else{
    		boardSvc.updateBoard(boardInfo);    //brdno is not null(update)
    	}
    	
        return "redirect:/board2List";
    }

    // 글 수정
    @RequestMapping(value = "/board2Update")
   	public String boardUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardVO boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board2/boardUpdate";
    }
    
    @RequestMapping(value = "/board2UpdateSave")
   	public String board2UpdateSave(@ModelAttribute boardVO boardInfo) throws Exception {
    	
    	boardSvc.updateBoard(boardInfo);
    	
        return "redirect:/board2List";
    }    

    // 글 읽기
    @RequestMapping(value = "/board2Read")
   	public String boardRead(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardSvc.updateCount(brdno);
    	boardVO boardInfo = boardSvc.selectBoardOne(brdno);
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board2/boardRead";
    }
    
    // 글 삭제
    @RequestMapping(value = "/board2Delete")
   	public String boardDelete(HttpServletRequest request) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardSvc.deleteBoardOne(brdno);
        
        return "redirect:/board2List";
    }
    
    // 글 수정(update와 합침)
    @RequestMapping(value = "/board2Form")
   	public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	if(brdno != null){
    		boardVO boardInfo = boardSvc.selectBoardOne(brdno);
    		modelMap.addAttribute("boardInfo", boardInfo);
    	}
    	
        return "board2/boardForm";
    }

}
