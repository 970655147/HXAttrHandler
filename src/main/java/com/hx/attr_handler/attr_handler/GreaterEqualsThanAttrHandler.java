/**
 * file name : GreaterThanAttrHandler.java
 * created at : 5:19:32 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.util.AttrHandlerTools;

//判断给定的字符串是否和expect匹配的handler
//gt(2), gt(2, 1), 2 > 1
public class GreaterEqualsThanAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// 初始化
	public GreaterEqualsThanAttrHandler(String arg01, String arg02) {
		super(arg01, arg02);
	}
	public GreaterEqualsThanAttrHandler(String arg01) {
		this(arg01, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public GreaterEqualsThanAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String arg01, String arg02, String result) {
		AttrHandlerTools.assert0(arg01 != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		AttrHandlerTools.assert0(arg02 != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		int intArg01 = 0, intArg02 = 0;
		boolean valid = true;
		try {
			intArg01 = Integer.parseInt(arg01);
			intArg02 = Integer.parseInt(arg02);
		} catch(Exception e) {
			valid = false;
		}
		if(valid) {
			return String.valueOf(intArg01 >= intArg02);
		}
		
		return String.valueOf(arg01.compareTo(arg02) >= 0 );
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.GREATER_EQUALS_THAN;
	}
}
