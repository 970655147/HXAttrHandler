/**
 * file name : StringTwoIntResultHandlerArgsAttrHandler.java
 * created at : 3:21:28 AM May 21, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.adapter;

import net.sf.json.JSONObject;

import com.hx.attrHandler.attrHandler.ConstantsAttrHandler;
import com.hx.attrHandler.attrHandler.adapter.interf.interf.StringTwoIntAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;

public class StringTwoIntResultHandlerArgsAttrHandler extends AttrHandler {
	// �������ݵ�handler, ��ȡ������handler
	private StringTwoIntAttrHandler handler;
	private AttrHandler target;
	private AttrHandler from;
	private AttrHandler to;
	
	// ��ʼ��
	public StringTwoIntResultHandlerArgsAttrHandler(StringTwoIntAttrHandler handler, AttrHandler target, AttrHandler from, AttrHandler to) {
		this.handler = handler;
		this.target = target;
		this.from = from;
		this.to = to;
	}
	public StringTwoIntResultHandlerArgsAttrHandler(StringTwoIntAttrHandler handler, String target, int from, int to) {
		this(handler, new ConstantsAttrHandler(target), new ConstantsAttrHandler(from), new ConstantsAttrHandler(to) );
	}

	@Override
	public String handle0(String result) {
		handler.setArgs(target.handle(result), Integer.parseInt(from.handle(result)), Integer.parseInt(to.handle(result)) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("target", target.toString() ).element("from", from.toString() )
				.element("to", to.toString() )
				.toString();
	}
}
