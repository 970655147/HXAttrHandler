/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// 去掉字符串前后空格的handler
// map(trim), map(trim('abc'), map(trim('abc', 1) )
public class TrimAttrHandler extends StringOneOrTwoIntAttrHandler {
	
	// 初始化
	public TrimAttrHandler(String str, int trimHead, int trimTail) {
		super(str, trimHead, trimTail);
	}
	public TrimAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String target, int from, int to, String result) {
		String trimed = target.trim();
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
		return HXAttrHandlerConstants.TRIM;
	}
	
}
