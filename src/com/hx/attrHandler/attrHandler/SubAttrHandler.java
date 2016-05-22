/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import java.util.List;

import com.hx.attrHandler.attrHandler.adapter.MultiArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;
import com.hx.attrHandler.util.Constants;

// ���������ַ����滻ΪĿ���ַ���
// map(replace(src, tar) )
public class SubAttrHandler extends MultiArgsAttrHandler<AttrHandler> {
	
	// ��ʼ��
	public SubAttrHandler(List<AttrHandler> handlerChain) {
		super(handlerChain);
	}
	public SubAttrHandler(int initCap) {
		super(initCap);
	}
	public SubAttrHandler() {
		super(Constants.CALC_HANDLER_DEFAULT_CAP);
	}

	@Override
	public String handle0(String result) {
		int res = Integer.parseInt(handlers.get(0).handle(result) );
		for(int i=1; i<handlers.size(); i++) {
			res -= Integer.parseInt(handlers.get(i).handle(result) );
		}
		
		return String.valueOf(res);
	}

	@Override
	public String name() {
		return Constants.SUB;
	}
}
