/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// �жϸ������ַ����Ƿ��expectƥ���handler
// trim, length�ȵ�Ҳ���д��÷�
// 1. ��$this��'abc'���бȽ�   2. ������������ַ������бȽ�
// map(equals('abc') ), map(equals('abc', 'df') )
public class NotEqualsAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// ��ʼ��
	public NotEqualsAttrHandler(String val, String expect) {
		super(val, expect);
	}
	public NotEqualsAttrHandler(String expect) {
		this(expect, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public NotEqualsAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String str, String expect, String result) {
		if(expect == null) {
			if(str == null) {
				return HXAttrHandlerConstants.FALSE;
			} else {
				return HXAttrHandlerConstants.TRUE;
			}
		}
		return String.valueOf(! expect.equals(str) );
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.NOT_EQUALS;
	}
}
