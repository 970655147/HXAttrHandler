/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.TwoOrThreeStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 将给定的字符串替换为目标字符串
// map(replace(src, tar) )
public class ReplaceAttrHandler extends TwoOrThreeStringArgsAttrHandler {
	// 初始化
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
