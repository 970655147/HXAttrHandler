/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attrHandler.util.Constants;

// ��ȡ�������ַ����Ĵ�д��ʽ��Handler
// map(toUpperCase ), map(toUpperCase('abc') )
public class ToUpperCaseAttrHandler extends NoneOrOneStringArgsAttrHandler {
	// ��ʼ��
	public ToUpperCaseAttrHandler(String str) {
		super(str);
	}
	public ToUpperCaseAttrHandler() {
		this(Constants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return str.toUpperCase();
	}

	@Override
	public String name() {
		return Constants.TO_UPPERCASE;
	}
	
}