/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.interf.OneBooleanArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// ��������[boo]ת��Ϊ[!boo]��handler
// map(not('abc') )
public class NotAttrHandler extends OneBooleanArgsAttrHandler {
	// �������õ��ĳ���ֵ
	private boolean boo;
	
	// ��ʼ��
	public NotAttrHandler(boolean  boo) {
		this.boo =  boo;
	}
	public NotAttrHandler() {
		this(false);
	}
	
	@Override
	public String handle0(String result) {
		if(boo) {
			return HXAttrHandlerConstants.FALSE;
		} else {
			return HXAttrHandlerConstants.TRUE;
		}
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.NOT;
	}

	@Override
	public void setArgs(boolean arg) {
		this.boo = arg;
	}
	
}
