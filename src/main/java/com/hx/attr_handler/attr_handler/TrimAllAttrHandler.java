/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;
import com.hx.attr_handler.util.HXAttrHandlerTools;

// 去掉字符串的所有空格的handler
// map(trimAll)
public class TrimAllAttrHandler extends StringOneOrTwoIntAttrHandler {
	// 初始化
	public TrimAllAttrHandler(String str, int trimHead, int trimTail) {
		super(str, trimHead, trimTail);
	}
	public TrimAllAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}

	@Override
	protected String gotResult(String target, int from, int to, String result) {
		String trimed = HXAttrHandlerTools.trimAllSpaces(target);
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
		return HXAttrHandlerConstants.TRIM_ALL;
	}

}
