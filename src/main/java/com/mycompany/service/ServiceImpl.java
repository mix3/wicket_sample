package com.mycompany.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.java.ao.EntityManager;
import net.java.ao.Query;

import com.google.inject.Singleton;
import com.mycompany.WicketApplication;
import com.mycompany.entity.Article;
import com.mycompany.entity.Comment;
import com.mycompany.model.ArticleModel;
import com.mycompany.model.CommentModel;

@Singleton
public class ServiceImpl implements Service{
	private EntityManager em;
	
	public ServiceImpl() throws SQLException{
		Properties dbProperties = getDBProperties();
		String uri = dbProperties.getProperty("db.uri");
		String username = dbProperties.getProperty("db.username");
		String password = dbProperties.getProperty("db.password");
		
		em = new EntityManager(new H2DatabaseProvider(uri, username, password));
//		em = new EntityManager(new H2DatabaseProvider("jdbc:h2:blog_db", "sa", ""));
		Logger.getLogger("net.java.ao").setLevel(Level.FINE);
		
		em.migrate(Article.class, Comment.class);
	}
	
	private Properties getDBProperties() {
		Properties back = new Properties();
		InputStream is = WicketApplication.class.getResourceAsStream("/db.properties");
		if (is == null) {
			throw new RuntimeException("Unable to locate db.properties");
		}
		try {
			back.load(is);
			is.close();
		} catch (IOException e) {
			throw new RuntimeException("Unable to load db.properties");
		}
		return back;
	}
	
	public void createArticle(ArticleModel am) throws SQLException {
//		em.create(Article.class, new DBParam[]{
//			new DBParam("title", am.getTitle()),
//			new DBParam("contents", am.getContents())
//		});
		Article a = em.create(Article.class);
		a.setTitle(am.getTitle());
		a.setContents(am.getContents());
		a.save();
	}

	public void createComment(CommentModel cm) throws SQLException {
//		em.create(Comment.class, new DBParam[]{
//			new DBParam("name", cm.getName()),
//			new DBParam("contents", cm.getContents()),
//			new DBParam("articleid", cm.getArticleModel().getId())
//		});
		Comment c = em.create(Comment.class);
		c.setName(cm.getName());
		c.setContents(cm.getContents());
		c.setArticle(em.get(Article.class, cm.getArticleID()));
		c.save();
	}
	
	public List<ArticleModel> getArticleList() throws SQLException {
		List<ArticleModel> aml = new ArrayList<ArticleModel>();
		for(Article a : em.find(Article.class, Query.select().order("id desc"))){
			aml.add(new ArticleModel(a));
		}
		return aml;
	}
}
