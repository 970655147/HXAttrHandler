/**
 * file name : TwoIntArgsAttrHandler.java
 * created at : 10:51:01 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter.interf;


import com.hx.json.JSONArray;
import com.hx.json.JSONObject;

import com.hx.attr_handler.attr_handler.adapter.interf.interf.TwoStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;


// 零个或者一个字符串参数的AttrHander参数的AttrHandler
public abstract class OneOrTwoStringArgsAttrHandler extends TwoStringArgsAttrHandler {
	// 传入的用户指定的参数
	protected String arg01;
	protected String arg02;
	
	// 初始化
	public OneOrTwoStringArgsAttrHandler(String arg01, String arg02) {
		setArgs(arg01, arg02);
	}
	
	// 配置参数
	@Override
	public void setArgs(String arg01, String arg02) {
		this.arg01 = arg01;
		this.arg02 = arg02;
	}
	// 重写handle0, 处理逻辑[将核心逻辑留在了gotResult中]
	public String handle0(String result) {
		if(AttrHandlerConstants.HANDLER_UNDEFINED.equals(arg02) ) {
			arg02 = arg01;
			arg01 = result;
		}
		
		return gotResult(arg01, arg02, result);
	}
	
	// 核心业务
	protected abstract String gotResult(String arg01, String arg02, String result);
	
	@Override
	public String toString() {
		return new JSONObject().element("name", name() ).element("operands", new JSONArray().element(arg01.toString()).element(arg02.toString()) ).toString();
	}
}
