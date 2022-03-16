package com.jspTest2.controller;

import com.jspTest2.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory  :" + command);

		if (command.equals("index")) {
			action = new IndexAction();
		} else if (command.equals("product")) {
			action = new AllBoardAction();
		} else if (command.equals("sneakers")) {
			action = new SneakersBoardAction();
		} else if (command.equals("clothes")) {
			action = new ClothesBoardAction();
		} else if (command.equals("newsList")) {
			action = new NewsListAction();
		} else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("cart_insert")) {
			action = new CartInsertAction();
		} else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		} else if (command.equals("cart_list")) {
			action = new CartListAction();
		} else if (command.equals("order_list")) {
			action = new OrderListAction();
		} else if (command.equals("delete")) {
			action = new UserDeleteAction();
		} else if (command.equals("update")) {

			action = new UserUpdateAction();
		} else if (command.equals("confirmpwd")) {

			action = new ConfirmPwdAction();
		} else if (command.equals("order")) {
			action = new OrderInsertAction();
		}
		else if(command.equals("cart_list_order")) {
			action = new CartListOrderInsertAction();
		}
		else if(command.equals("resell_list")) {
			action = new ResellListAction();
		}
		else if(command.equals("regist_resell")) {
			action = new RegistResellProductAction();
		}
		return action;
	}
}// end class