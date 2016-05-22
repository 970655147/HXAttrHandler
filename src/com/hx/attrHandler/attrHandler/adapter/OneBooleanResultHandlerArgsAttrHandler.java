/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.adapter;

import net.sf.json.JSONObject;

import com.hx.attrHandler.attrHandler.ConstantsAttrHandler;
import com.hx.attrHandler.attrHandler.adapter.interf.interf.OneBooleanArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;

// ����һ��boolean������AttrHandler��Handler������
// map(trim)
public class OneBooleanResultHandlerArgsAttrHandler extends AttrHandler {
	// �������ݵ�handler, ��ȡ������handler
	private OneBooleanArgsAttrHandler handler;
	private AttrHandler arg;
	
	// ��ʼ��
	public OneBooleanResultHandlerArgsAttrHandler(OneBooleanArgsAttrHandler handler, AttrHandler arg) {
		this.handler = handler;
		this.arg = arg;
	}
	public OneBooleanResultHandlerArgsAttrHandler(OneBooleanArgsAttrHandler handler, boolean arg) {
		this(handler, new ConstantsAttrHandler(String.valueOf(arg)) );
	}
	
	@Override
	public String handle0(String result) {
		handler.setArgs(Boolean.parseBoolean(arg.handle(result)) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("arg", arg.toString() )
				.toString();
	}
	
}