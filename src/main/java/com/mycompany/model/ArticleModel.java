package com.mycompany.model;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.entity.Article;
import com.mycompany.entity.Comment;
 
@SuppressWarnings("serial")
public class ArticleModel implements Serializable{
	private int id;
    private String title;
    private String contents;
    private List<CommentModel> commentList;
    
    public ArticleModel(){
        this.commentList = new ArrayList<CommentModel>();
    }
    public ArticleModel(String title, String contents){
        this();
        this.title = title;
        this.contents = contents;
    }
    public ArticleModel(String title, String contents, List<CommentModel> commentList){
        this(title, contents);
        this.commentList = commentList;
    }
    public ArticleModel(Article a){
        this();
        this.id = a.getID();
    	this.title = a.getTitle();
    	this.contents = a.getContents();
    	for(Comment c : a.getComments()){
    		this.commentList.add(new CommentModel(c));
    	}
    }
    
    // setter/getter
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContents() {
        return contents;
    }
	public void setContents(String contents) {
        this.contents = contents;
    }
    public List<CommentModel> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<CommentModel> commentList) {
        this.commentList = commentList;
    }
    public void addComment(CommentModel comment){
        this.commentList.add(comment);
    }
}