package com.mycompany.service;

import java.sql.SQLException;
import java.util.List;

import com.google.inject.ImplementedBy;
import com.mycompany.model.ArticleModel;
import com.mycompany.model.CommentModel;

@ImplementedBy(ServiceImpl.class)
public interface Service{
	// read
	public List<ArticleModel> getArticleList() throws SQLException;
	
	// create
	public void createArticle(ArticleModel am) throws SQLException;
	public void createComment(CommentModel cm) throws SQLException;
}
