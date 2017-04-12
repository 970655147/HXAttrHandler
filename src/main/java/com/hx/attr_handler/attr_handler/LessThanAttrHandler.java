/**
 * file name : GreaterThanAttrHandler.java
 * created at : 5:19:32 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;
import com.hx.attr_handler.util.HXAttrHandlerTools;

//判断给定的字符串是否和expect匹配的handler
//gt(2), gt(2, 1), 2 > 1
public class LessThanAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// 初始化
	public LessThanAttrHandler(String arg01, String arg02) {
		super(arg01, arg02);
	}
	public LessThanAttrHandler(String arg01) {
		this(arg01, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public LessThanAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String arg01, String arg02, String result) {
		HXAttrHandlerTools.assert0(arg01 != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		HXAttrHandlerTools.assert0(arg02 != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		int intArg01 = 0, intArg02 = 0;
		boolean valid = true;
		try {
			intArg01 = Integer.parseInt(arg01);
			intArg02 = Integer.parseInt(arg02);
		} catch(Exception e) {
			valid = false;
		}
		if(valid) {
			return String.valueOf(intArg01 < intArg02);
		}
		
		return String.valueOf(arg01.compareTo(arg02) < 0 );
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.LESS_THAN;
	}
}
