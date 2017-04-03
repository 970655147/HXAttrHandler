/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;
import com.hx.attrHandler.util.HXAttrHandlerTools;

// 将字符串的多个空格合并为一个的handler
// map(trimAsOne), map(trimAsOne('abc') )
public class TrimAsOneAttrHandler extends StringOneOrTwoIntAttrHandler {
	
	// 初始化
	public TrimAsOneAttrHandler(String str, int trimHead, int trimTail) {
		super(str, trimHead, trimTail);
	}
	public TrimAsOneAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String target, int from, int to, String result) {
		String trimed = HXAttrHandlerTools.trimSpacesAsOne(target);
		if(from == HXAttrHandlerConstants.TARGET_UNDEFINED) {
			from = 0;
		}
		if(to == HXAttrHandlerConstants.TARGET_UNDEFINED) {
			to = trimed.length();
		} else {
			to = trimed.length() - to;
		}
		return trimed.substring(from, to);
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.TRIM_AS_ONE;
	}
	
}
