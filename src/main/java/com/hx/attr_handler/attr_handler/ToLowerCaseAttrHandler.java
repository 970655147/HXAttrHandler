/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 获取给定的字符串的小写形式的Handler
// map(toLowerCase ), map(toLowerCase('abc') )
public class ToLowerCaseAttrHandler extends NoneOrOneStringArgsAttrHandler {
	// 初始化
	public ToLowerCaseAttrHandler(String str) {
		super(str);
	}
	public ToLowerCaseAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return str.toLowerCase();
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.TO_LOWERCASE;
	}
	
}
