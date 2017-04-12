/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter;

import com.hx.attr_handler.attr_handler.ConstantsAttrHandler;
import com.hx.attr_handler.attr_handler.adapter.interf.interf.TwoStringArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import net.sf.json.JSONObject;

// ���������ַ���������AttrHandler��Handler������
// ��Ϊ�������ڲ�ʹ��
public class TwoStringResultHandlerArgsAttrHandler extends AttrHandler {
	// �������ݵ�handler, ��ȡ������handler
	private TwoStringArgsAttrHandler handler;
	private AttrHandler arg01;
	private AttrHandler arg02;
	
	// ��ʼ��
	public TwoStringResultHandlerArgsAttrHandler(TwoStringArgsAttrHandler handler, AttrHandler arg01, AttrHandler arg02) {
		this.handler = handler;
		this.arg01 = arg01;
		this.arg02 = arg02;
	}
	public TwoStringResultHandlerArgsAttrHandler(TwoStringArgsAttrHandler handler,  String arg01, String arg02) {
		this(handler, new ConstantsAttrHandler(arg01), new ConstantsAttrHandler(arg02) );
	}
	
	@Override
	public String handle0(String result) {
		handler.setArgs(arg01.handle(result), arg02.handle(result) );
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
