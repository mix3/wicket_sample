package com.mycompany;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import com.mycompany.page.LinkPage;
import com.mycompany.page.TrainingPage;
import com.mycompany.page.UploadPage;
 
public class WicketApplication extends WebApplication{
    public WicketApplication(){}
    
    public Class getHomePage(){
        return UploadPage.class;
    }
	
    @Override
    protected void init() {
    	addComponentInstantiationListener(new GuiceComponentInjector(this));
    	
        mountBookmarkablePage("/TrainingPage", TrainingPage.class);
        mountBookmarkablePage("/LinkPage", LinkPage.class);
    }
}