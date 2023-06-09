/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.util.AttrHandlerTools;

// 将字符串的多个空格合并为一个的handler
// map(trimAsOne), map(trimAsOne('abc') )
public class TrimAsOneAttrHandler extends StringOneOrTwoIntAttrHandler {
	
	// 初始化
	public TrimAsOneAttrHandler(String str, int trimHead, int trimTail) {
		super(str, trimHead, trimTail);
	}
	public TrimAsOneAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.TARGET_UNDEFINED, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String target, int from, int to, String result) {
		String trimed = AttrHandlerTools.trimSpacesAsOne(target);
		if(from == AttrHandlerConstants.TARGET_UNDEFINED) {
			from = 0;
		}
		if(to == AttrHandlerConstants.TARGET_UNDEFINED) {
			to = trimed.length();
		} else {
			to = trimed.length() - to;
		}
		return trimed.substring(from, to);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.TRIM_AS_ONE;
	}
	
}
