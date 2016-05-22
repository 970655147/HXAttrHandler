/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.NoneOrOneStringArgsAttrHandler;
import com.hx.attrHandler.util.Constants;

// ʲô��������AttrHandler
// map(doNothing)
public class DoNothingAttrHandler extends NoneOrOneStringArgsAttrHandler {
	
	// ��ʼ��
	public DoNothingAttrHandler(String str) {
		super(str);
	}
	public DoNothingAttrHandler() {
		this(Constants.HANDLER_UNDEFINED);
	}

	@Override
	protected String gotResult(String str, String result) {
		return result;
	}

	@Override
	public String name() {
		return Constants.DO_NOTHING;
	}
	
}