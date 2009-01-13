package com.mycompany.model;
 
import java.io.Serializable;

import com.mycompany.entity.Comment;
 
@SuppressWarnings("serial")
public class CommentModel implements Serializable{
    private String name;
    private String contents;
    private int articleID;
    
    public CommentModel(){}
    public CommentModel(String name, String contents){
        this.name = name;
        this.contents = contents;
    }
    public CommentModel(Comment c){
    	this.name = c.getName();
    	this.contents = c.getContents();
    }
    
    // setter/getter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
}