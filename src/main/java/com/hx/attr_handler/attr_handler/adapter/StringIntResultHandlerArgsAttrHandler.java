/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter;

import com.hx.attr_handler.attr_handler.ConstantsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.json.JSONObject;

import com.hx.attr_handler.attr_handler.adapter.interf.interf.StringIntArgsAttrHandler;

// 构造(String, Int)参数的AttrHandler的Handler适配器
// map(trim)
public class StringIntResultHandlerArgsAttrHandler extends AttrHandler {
	// 处理数据的handler, 获取参数的handler
	private StringIntArgsAttrHandler handler;
	private AttrHandler arg01;
	private AttrHandler arg02;
	
	// 初始化
	public StringIntResultHandlerArgsAttrHandler(StringIntArgsAttrHandler handler, AttrHandler arg01, AttrHandler arg02) {
		this.handler = handler;
		this.arg01 = arg01;
		this.arg02 = arg02;
	}
	public StringIntResultHandlerArgsAttrHandler(StringIntArgsAttrHandler handler, String arg01, int arg02) {
		this(handler, new ConstantsAttrHandler(String.valueOf(arg01)), new ConstantsAttrHandler(String.valueOf(arg02)) );
	}

	@Override
	public String handle0(String result) {
		handler.setArgs(arg01.handle(result), Integer.parseInt(arg02.handle(result)) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("arg01", arg01.toString() ).element("arg02", arg02.toString() )
				.toString();
	}
}
