package com.beeworkshop.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributesListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("添加的属性名：" + event.getName());
		System.out.println("添加的属性值：" + event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("删除的属性名：" + event.getName());
		System.out.println("删除的属性值：" + event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("改变的属性名：" + event.getName());
		System.out.println("改变的属性值：" + event.getValue());
	}

}
