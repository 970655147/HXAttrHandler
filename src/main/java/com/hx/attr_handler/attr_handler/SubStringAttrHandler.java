/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 截取字符串的handler
// map(subString(1, 3) )
public class SubStringAttrHandler extends StringOneOrTwoIntAttrHandler {
	// 初始化
	public SubStringAttrHandler(String target, int from, int to) {
		super(target, from, to);
	}
	public SubStringAttrHandler(String target, int from) {
		super(target, from, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public SubStringAttrHandler(int from, int to) {
		super(HXAttrHandlerConstants.HANDLER_UNDEFINED, from, to);
	}
	public SubStringAttrHandler(int from) {
		super(HXAttrHandlerConstants.HANDLER_UNDEFINED, from, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public SubStringAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.SUB_STRING;
	}
	
	@Override
	protected String gotResult(String target, int from, int to, String result) {
		if(to == HXAttrHandlerConstants.TARGET_UNDEFINED) {
			to = target.length();
		}
		return target.substring(from, to);
	}
	
}
