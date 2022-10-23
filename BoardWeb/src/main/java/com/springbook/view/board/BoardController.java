package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	// 검색 조건 목록 설정
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap() {
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			return conditionMap;
		}
	
	
	// 글등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");

		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글번호 : " + vo.getSeq());
		System.out.println("제목: " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("ㄴㅐ용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");

		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세조회
/*	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); //Model 정보 저장
		return "getBoard.jsp";
	}
*/
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo)); //Model 정보 저장
		return "getBoard.jsp"; // View 정보 저장
	}
	
	

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		//Null check
		if(vo.getSearchCondition() ==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() ==null) vo.setSearchKeyword("");
		
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp"; // View 이름 리턴
	}

}
