/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// ��ȡ�������ַ����ĳ��ȵ�handler
// map(length )	or map(length() )
public class LengthAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// ��ʼ��
	public LengthAttrHandler(String str) {
		super(str);
	}
	public LengthAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return String.valueOf(str.length() );
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.LENGTH;
	}
	
}
