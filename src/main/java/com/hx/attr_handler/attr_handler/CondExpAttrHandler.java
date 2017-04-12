/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hx.attr_handler.util.HXAttrHandlerConstants;

// ��������ʽ��handler
// 1. condExp(true, truePart, falsePart )		2. true ? truePart : falsePart
public class CondExpAttrHandler extends AttrHandler {
	// �����Լ�truePart, falsePart
	private AttrHandler condAttr;
	private AttrHandler truePart;
	private AttrHandler falsePart;
	
	// ��ʼ��
	public CondExpAttrHandler(AttrHandler condAttr, AttrHandler truePart, AttrHandler falsePart) {
		this.condAttr = condAttr;
		this.truePart = truePart;
		this.falsePart = falsePart;
	}
	public CondExpAttrHandler(AttrHandler condAttr, AttrHandler truePart, String falsePart) {
		this(condAttr, truePart, new ConstantsAttrHandler(falsePart) );
	}
	public CondExpAttrHandler(AttrHandler condAttr, String truePart, AttrHandler falsePart) {
		this(condAttr, new ConstantsAttrHandler(truePart), falsePart );
	}
	public CondExpAttrHandler(AttrHandler condAttr, String truePart, String falsePart) {
		this(condAttr, new ConstantsAttrHandler(truePart), new ConstantsAttrHandler(falsePart) );
	}
	public CondExpAttrHandler(String condAttr, String truePart, String falsePart) {
		this(new ConstantsAttrHandler(condAttr), truePart, falsePart);
	}
	public CondExpAttrHandler() {
		this(new ConstantsAttrHandler("false"), HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}
	
	@Override
	protected String handle0(String result) {
		boolean cond = Boolean.parseBoolean(condAttr.handle(result) );
		if(cond ) {
			return truePart.handle(result);
		} else {
			return falsePart.handle(result);
		}
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.COND_EXP;
	}
	
	@Override
	public String toString() {
		return new JSONObject().element("name", name() ).element("operands", new JSONArray().element(condAttr).element(truePart).element(falsePart) ).toString();
	}
}