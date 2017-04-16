/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.StringOneOrTwoIntAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// ��ȡ�ַ�����handler
// map(subString(1, 3) )
public class SubStringAttrHandler extends StringOneOrTwoIntAttrHandler {
	// ��ʼ��
	public SubStringAttrHandler(String target, int from, int to) {
		super(target, from, to);
	}
	public SubStringAttrHandler(String target, int from) {
		super(target, from, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	public SubStringAttrHandler(int from, int to) {
		super(AttrHandlerConstants.HANDLER_UNDEFINED, from, to);
	}
	public SubStringAttrHandler(int from) {
		super(AttrHandlerConstants.HANDLER_UNDEFINED, from, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	public SubStringAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.TARGET_UNDEFINED, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.SUB_STRING;
	}
	
	@Override
	protected String gotResult(String target, int from, int to, String result) {
		if(to == AttrHandlerConstants.TARGET_UNDEFINED) {
			to = target.length();
		}
		return target.substring(from, to);
	}
	
}
