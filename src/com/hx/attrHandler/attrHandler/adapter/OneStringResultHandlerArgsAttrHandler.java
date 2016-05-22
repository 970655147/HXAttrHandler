/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.adapter;

import net.sf.json.JSONObject;

import com.hx.attrHandler.attrHandler.ConstantsAttrHandler;
import com.hx.attrHandler.attrHandler.adapter.interf.interf.OneStringArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;

// 构造一个字符串参数的AttrHandler的Handler适配器
// map(trim)
public class OneStringResultHandlerArgsAttrHandler extends AttrHandler {
	// 处理数据的handler, 获取参数的handler
	private OneStringArgsAttrHandler handler;
	private AttrHandler arg;
	
	// 初始化
	public OneStringResultHandlerArgsAttrHandler(OneStringArgsAttrHandler handler, AttrHandler arg) {
		this.handler = handler;
		this.arg = arg;
	}
	public OneStringResultHandlerArgsAttrHandler(OneStringArgsAttrHandler handler, String arg) {
		this(handler, new ConstantsAttrHandler(arg) );
	}
	
	@Override
	public String handle0(String result) {
		handler.setArgs(arg.handle(result) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("arg", arg.toString() )
				.toString();
	}
}
