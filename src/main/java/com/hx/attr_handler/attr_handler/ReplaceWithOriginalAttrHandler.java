/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.TwoOrThreeStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.log.util.Tools;

// 将给定的字符串替换为目标字符串
// map(replaceO(src, tar) )
public class ReplaceWithOriginalAttrHandler extends TwoOrThreeStringArgsAttrHandler {
	// 初始化
	public ReplaceWithOriginalAttrHandler(String target, String regex, String replacement) {
		super(target, regex, replacement);
	}
	public ReplaceWithOriginalAttrHandler(String regex, String replacement) {
		super(AttrHandlerConstants.HANDLER_UNDEFINED, regex, replacement);
	}
	public ReplaceWithOriginalAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.REPLACE_WITH_ORIGINAL;
	}
	
	@Override
	protected String gotResult(String target, String pattern, String replacement, String result) {
		return Tools.replaceO(target, pattern, replacement);
	}

}
