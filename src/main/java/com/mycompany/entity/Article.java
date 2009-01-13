package com.mycompany.entity;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

public interface Article extends Entity{
	public String getTitle();
	public void setTitle(String title);
	public String getContents();
	public void setContents(String contents);
	
	@OneToMany
	public Comment[] getComments();
}
