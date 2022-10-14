package sec03.brd02;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	
	public List<ArticleVO> listArticles_test() {
		System.out.println("listArticles까지는 왔다");
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	

	public List<ArticleVO> listArticles() {
		System.out.println("listArticles까지는 왔다");
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public void addArticle(ArticleVO article){
		boardDAO.insertNewArticle(article);		
	}
}
