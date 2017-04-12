/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 什么都不做的AttrHandler
// map(doNothing)
public class DoNothingAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// 初始化
	public DoNothingAttrHandler(String str) {
		super(str);
	}
	public DoNothingAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return result;
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.DO_NOTHING;
	}
	
}
