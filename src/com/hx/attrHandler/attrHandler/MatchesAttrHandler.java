/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import java.util.regex.Pattern;

import com.hx.attrHandler.attrHandler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;
import com.hx.attrHandler.util.HXAttrHandlerTools;

// 判断给定的字符串是否和expect匹配的handler
// 类似于equals
// map(matches(pat) ), map(matches(str, pat) )
public class MatchesAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// 初始化
	public MatchesAttrHandler(String str, String pattern) {
		super(str, pattern);
	}
	public MatchesAttrHandler(String pattern) {
		this(pattern, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public MatchesAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String pattern, String result) {
		HXAttrHandlerTools.assert0(pattern != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		return String.valueOf(Pattern.compile(pattern).matcher(str).matches() );
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.MATCHES;
	}
}
