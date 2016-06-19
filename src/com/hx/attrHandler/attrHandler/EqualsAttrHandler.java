/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

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
		this(expect, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	public EqualsAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	
	@Override
	protected String gotResult(String str, String expect, String result) {
		if(expect == null) {
			if(str == null) {
				return HXAttrHandlerConstants.TRUE;
			} else {
				return HXAttrHandlerConstants.FALSE;
			}
		}
		return String.valueOf(expect.equals(str) );
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.EQUALS;
	}
}
