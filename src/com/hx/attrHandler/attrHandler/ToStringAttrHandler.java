/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// ��ȡ�������ַ����ĳ��ȵ�handler
// ������������
// map(toInt )	or map(toInt() )  or map(toInt('1') )
public class ToStringAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// ��ʼ��
	public ToStringAttrHandler(String str) {
		super(str);
	}
	public ToStringAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return str;
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.TO_STRING;
	}
	
}
