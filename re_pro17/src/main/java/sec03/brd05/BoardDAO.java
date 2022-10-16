package sec03.brd05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mariadb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT articleNO, title, content, id, writeDate from t_board ORDER BY articleNO desc";
			System.out.println(query);
			System.out.println("가지고왔어");
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int articleNO = rs.getInt("articleNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				/* article.setLevel(level); */
				article.setArticleNO(articleNO);
				/* article.setParentNO(parentNO); */
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}
	
	
	public ArticleVO selectArticle(int articleNO){
		
		ArticleVO article=new ArticleVO();
		try{
		conn = dataFactory.getConnection();
		String query ="select articleNO,title,content, imageFileName,id,writeDate"
			                     +" from t_board" 
			                     +" where articleNO=?";
		System.out.println(query);
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, articleNO);
		ResultSet rs =pstmt.executeQuery();
		rs.next();
		int _articleNO =rs.getInt("articleNO");

		String title = rs.getString("title");
		String content =rs.getString("content");
	    String imageFileName = rs.getString("imageFileName"); 
		String id = rs.getString("id");
		Date writeDate = rs.getDate("writeDate");

		article.setArticleNO(_articleNO);

		article.setTitle(title);
		article.setContent(content);
		article.setImageFileName(imageFileName);
		article.setId(id);
		article.setWriteDate(writeDate);
		rs.close();
		pstmt.close();
		conn.close();
		}catch(Exception e){
		e.printStackTrace();	
		}
		return article;
		}
	

	private int getNewArticleNO() {
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT  max(articleNO) from t_board";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1); //가장 큰번호에 1을 더함
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewArticle(ArticleVO article) {
		int articleNO = getNewArticleNO();
		try {
			conn = dataFactory.getConnection();
			
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			String query = "INSERT INTO t_board (articleNO, title, content, imageFileName, id)"
					+ " VALUES (?, ? ,?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, imageFileName);
			pstmt.setString(5, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleNO;
	}
	
	public void updateArticle(ArticleVO article) {
		int articleNO = article.getArticleNO();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			conn = dataFactory.getConnection();
			String query = "update t_board  set title=?,content=?";
			if (imageFileName != null && imageFileName.length() != 0) {
				query += ",imageFileName=?";
			}
			query += " where articleNO=?";
			
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if (imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


