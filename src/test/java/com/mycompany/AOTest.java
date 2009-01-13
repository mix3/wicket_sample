package com.mycompany;

import java.sql.SQLException;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.model.ArticleModel;
import com.mycompany.model.CommentModel;
import com.mycompany.service.Service;

public class AOTest {
	private static Service service;
	
	public static void main(String[] args){
		Injector injector = Guice.createInjector();
		service = injector.getInstance(Service.class);
		try {
			test();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	private static void test() throws SQLException{
		List<ArticleModel> aml = service.getArticleList();
		for(ArticleModel am : aml){
			System.out.println(am.getId());
			System.out.println(am.getTitle());
			System.out.println(am.getContents());
			for(CommentModel cm : am.getCommentList()){
				System.out.println("\t"+cm.getName());
				System.out.println("\t"+cm.getContents());
			}
		}
	}
}
