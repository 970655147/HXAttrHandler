/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import java.util.List;

import com.hx.attr_handler.attr_handler.adapter.MultiArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// ���������ַ����滻ΪĿ���ַ���
// map(replace(src, tar) )
public class MultiplyAttrHandler extends MultiArgsAttrHandler<AttrHandler> {
	
	// ��ʼ��
	public MultiplyAttrHandler(List<AttrHandler> handlerChain) {
		super(handlerChain);
	}
	public MultiplyAttrHandler(int initCap) {
		super(initCap);
	}
	public MultiplyAttrHandler() {
		super(AttrHandlerConstants.CALC_HANDLER_DEFAULT_CAP);
	}

	@Override
	public String handle0(String result) {
		int res = 1;
		for(AttrHandler handler : handlers) {
			res *= Integer.parseInt(handler.handle(result) );
		}
		
		return String.valueOf(res);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.MUL;
	}
}
