/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// 判断给定的字符串是否和expect匹配的handler
// trim, length等等也具有此用法
// 1. 将$this和'abc'进行比较   2. 将传入的两个字符串进行比较
// map(equals('abc') ), map(equals('abc', 'df') )
public class NotEqualsAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// 初始化
	public NotEqualsAttrHandler(String val, String expect) {
		super(val, expect);
	}
	public NotEqualsAttrHandler(String expect) {
		this(expect, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public NotEqualsAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String str, String expect, String result) {
		if(expect == null) {
			if(str == null) {
				return AttrHandlerConstants.FALSE;
			} else {
				return AttrHandlerConstants.TRUE;
			}
		}
		return String.valueOf(! expect.equals(str) );
	}

	@Override
	public String name() {
		return AttrHandlerConstants.NOT_EQUALS;
	}
}
