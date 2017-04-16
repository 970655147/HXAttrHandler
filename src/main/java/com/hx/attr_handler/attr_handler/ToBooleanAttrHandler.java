/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// ��ȡ�������ַ����ĳ��ȵ�handler
// map(toBool )	or map(toBool() )  or map(toBool('false') )
public class ToBooleanAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// ��ʼ��
	public ToBooleanAttrHandler(String str) {
		super(str);
	}
	public ToBooleanAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return String.valueOf(Boolean.parseBoolean(str) );
	}

	@Override
	public String name() {
		return AttrHandlerConstants.TO_BOOLEAN;
	}
	
}
