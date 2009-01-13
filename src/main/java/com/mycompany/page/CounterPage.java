package com.mycompany.page;
 
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
 
public class CounterPage extends WebPage{
    private static int count = 0;
    
    public CounterPage(){
        add(new Label("counter", new Model(count)));
        add(new Link("link"){
            @Override
            public void onClick() {
                count++;
                setResponsePage(CounterPage.class);
            }
        });
    }
}