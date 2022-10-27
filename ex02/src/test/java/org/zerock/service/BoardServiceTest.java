package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	
	@Test
	public void testResister() {		
		BoardVO board = new BoardVO();
		board.setTitle("작성작성작성작성");
		board.setContent("testResister 로 작성된 내용");
		board.setWriter("newbie");
		
		service.register(board);		
		log.info("생성된 게시물의 번호 : " + board.getBno());		
	}
	
	
	@Test
	public void testGetList() {		
		service.getList().forEach(board -> log.info(board));		
	}
	
	
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	

	@Test
	public void testDelete() {
		log.info("remove result: " + service.remove(2L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(1L);
		if(board == null) {
			return;
		}
		board.setTitle("제목 수정할래!!!!");
		log.info("modify result : " + service.modify(board));
		
	}
	
	
	
	
	
	
	
	
	
	

}
