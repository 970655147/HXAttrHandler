/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// ��ȡ�������ַ����ĳ��ȵ�handler
// ������������
// map(toInt )	or map(toInt() )  or map(toInt('1') )
public class ToIntAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// ��ʼ��
	public ToIntAttrHandler(String str) {
		super(str);
	}
	public ToIntAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return String.valueOf(Integer.parseInt(str) );
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.TO_INT;
	}
	
}
