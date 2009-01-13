package com.mycompany.page;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
 
public class SwitchPage extends WebPage{
    private static String label = "off";
    
    public SwitchPage(){
        add(new Label("switch", new Model(label)));
        add(new Link("link"){
            @Override
            public void onClick() {
            	if(label.equals("off")){
            		label = "on";
            	}else{
            		label = "off";
            	}
                setResponsePage(SwitchPage.class);
            }
        });
    }
}