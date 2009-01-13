package com.mycompany.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class TrainingPage extends WebPage{
	public TrainingPage(){
		add(new Label("message1", "Label Test 1"));
		add(new Label("message2", "Label Test 2"));
	}
}
