/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.OneOrTwoStringArgsAttrHandler;
import com.hx.attrHandler.util.Constants;
import com.hx.attrHandler.util.Tools;

// �жϸ�����result���Ƿ����contains
// ������equals
// 1. map(contains('abc') )		2. map(contains('abc', 'a') )
public class ContainsAttrHandler extends OneOrTwoStringArgsAttrHandler {
	
	// ��ʼ��
	public ContainsAttrHandler(String str, String contains) {
		super(str, contains);
	}
	public ContainsAttrHandler(String contains) {
		this(contains, Constants.HANDLER_UNDEFINED);
	}
	public ContainsAttrHandler() {
		this(Constants.HANDLER_UNDEFINED, Constants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String contains, String result) {
		Tools.assert0(contains != null, "error while calc the 'matches(String)', pattern be initialized illegal ! ");
		return String.valueOf(str.contains(contains) );
	}
	
	@Override
	public String name() {
		return Constants.CONTAINS;
	}
}