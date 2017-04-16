/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// �жϸ������ַ����Ƿ��expectƥ���handler
// trim, length�ȵ�Ҳ���д��÷�
// 1. ��$this��'abc'���бȽ�   2. ������������ַ������бȽ�
// map(equals('abc') ), map(equals('abc', 'df') )
public class EqualsAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// ��ʼ��
	public EqualsAttrHandler(String val, String expect) {
		super(val, expect);
	}
	public EqualsAttrHandler(String expect) {
		this(expect, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public EqualsAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String str, String expect, String result) {
		if(expect == null) {
			if(str == null) {
				return AttrHandlerConstants.TRUE;
			} else {
				return AttrHandlerConstants.FALSE;
			}
		}
		return String.valueOf(expect.equals(str) );
	}

	@Override
	public String name() {
		return AttrHandlerConstants.EQUALS;
	}
}
