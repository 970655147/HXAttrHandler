/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// ��ȡ�������ַ�����Сд��ʽ��Handler
// map(toLowerCase ), map(toLowerCase('abc') )
public class ToLowerCaseAttrHandler extends NoneOrOneStringArgsAttrHandler {
	// ��ʼ��
	public ToLowerCaseAttrHandler(String str) {
		super(str);
	}
	public ToLowerCaseAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return str.toLowerCase();
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.TO_LOWERCASE;
	}
	
}
