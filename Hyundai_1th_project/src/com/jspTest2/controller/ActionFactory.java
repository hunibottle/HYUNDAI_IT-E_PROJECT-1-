package com.jspTest2.controller;
import com.jspTest2.controller.action.*;

public class ActionFactory {
  private static ActionFactory instance = new ActionFactory();
  private ActionFactory() {
    super();  }
  public static ActionFactory getInstance() {
    return instance;
  }
  public Action getAction(String command) {
    Action action = null;
    System.out.println("ActionFactory  :" + command);

    if (command.equals("index")) {
      action = new IndexAction();
    } 
    else if(command.equals("product")){
        action = new ProductAction();
      } 
    else if(command.equals("productbycatagory")) {
    	action = new ProductCategoryAction();
    }
    else if(command.equals("productbyindex")) {
    	action = new ProductIndexAction();
    }
    else if(command.equals("newsList")){
    	action = new NewsListAction();
    }else if(command.equals("product_detail")) {
    	action = new ProductDetailAction();
    }else if (command.equals("logout")) {
    	action = new LogoutAction();
    }
    return action;
  }
}//end class