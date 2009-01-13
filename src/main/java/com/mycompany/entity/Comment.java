package com.mycompany.entity;

import net.java.ao.Entity;

public interface Comment extends Entity{
	public String getName();
	public void setName(String name);
	public String getContents();
	public void setContents(String contents);
	
	public Article getArticle();
	public void setArticle(Article article);
}
