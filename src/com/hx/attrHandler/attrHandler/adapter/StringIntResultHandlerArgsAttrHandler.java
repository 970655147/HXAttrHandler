/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.adapter;



import net.sf.json.JSONObject;

import com.hx.attrHandler.attrHandler.ConstantsAttrHandler;
import com.hx.attrHandler.attrHandler.adapter.interf.interf.StringIntArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;

// ����(String, Int)������AttrHandler��Handler������
// map(trim)
public class StringIntResultHandlerArgsAttrHandler extends AttrHandler {
	// �������ݵ�handler, ��ȡ������handler
	private StringIntArgsAttrHandler handler;
	private AttrHandler arg01;
	private AttrHandler arg02;
	
	// ��ʼ��
	public StringIntResultHandlerArgsAttrHandler(StringIntArgsAttrHandler handler, AttrHandler arg01, AttrHandler arg02) {
		this.handler = handler;
		this.arg01 = arg01;
		this.arg02 = arg02;
	}
	public StringIntResultHandlerArgsAttrHandler(StringIntArgsAttrHandler handler, String arg01, int arg02) {
		this(handler, new ConstantsAttrHandler(String.valueOf(arg01)), new ConstantsAttrHandler(String.valueOf(arg02)) );
	}

	@Override
	public String handle0(String result) {
		handler.setArgs(arg01.handle(result), Integer.parseInt(arg02.handle(result)) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("arg01", arg01.toString() ).element("arg02", arg02.toString() )
				.toString();
	}
}