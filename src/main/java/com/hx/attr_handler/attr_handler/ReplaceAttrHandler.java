/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.TwoOrThreeStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// ���������ַ����滻ΪĿ���ַ���
// map(replace(src, tar) )
public class ReplaceAttrHandler extends TwoOrThreeStringArgsAttrHandler {
	// ��ʼ��
	public ReplaceAttrHandler(String target, String regex, String replacement) {
		super(target, regex, replacement);
	}
	public ReplaceAttrHandler(String regex, String replacement) {
		super(HXAttrHandlerConstants.HANDLER_UNDEFINED, regex, replacement);
	}
	public ReplaceAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.REPLACE;
	}
	
	@Override
	protected String gotResult(String target, String pattern, String replacement, String result) {
		return target.replaceAll(pattern, replacement);
	}
	
}
