/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import java.util.regex.Pattern;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.util.AttrHandlerTools;

// �жϸ������ַ����Ƿ��expectƥ���handler
// ������equals
// map(matches(pat) ), map(matches(str, pat) )
public class MatchesAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// ��ʼ��
	public MatchesAttrHandler(String str, String pattern) {
		super(str, pattern);
	}
	public MatchesAttrHandler(String pattern) {
		this(pattern, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public MatchesAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String pattern, String result) {
		AttrHandlerTools.assert0(pattern != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		return String.valueOf(Pattern.compile(pattern).matcher(str).matches() );
	}

	@Override
	public String name() {
		return AttrHandlerConstants.MATCHES;
	}
}
