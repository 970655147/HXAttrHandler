/**
 * file name : GetStrInRangeHandler.java
 * created at : 11:49:20 PM May 20, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.TwoOrThreeStringTwoBooleanArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.util.AttrHandlerTools;

// getStrIn('hello', 'e', 'o')
public class GetStrInRangeHandler extends TwoOrThreeStringTwoBooleanArgsAttrHandler {

	// ≥ı ºªØ
	public GetStrInRangeHandler(String target, String start, String end, boolean includeStart, boolean includeEnd) {
		super(target, start, end, includeStart, includeEnd);
	}
	public GetStrInRangeHandler(String start, String end, boolean includeStart, boolean includeEnd) {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, start, end, includeStart, includeEnd);
	}
	public GetStrInRangeHandler(String target, String start, String end) {
		this(target, start, end, false, false);
	}
	public GetStrInRangeHandler(String start, String end) {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, start, end, false, false);
	}
	public GetStrInRangeHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED, false, false);
	}

	@Override
	protected String gotResult(String target, String start, String end, boolean includeStart, boolean includeEnd, String result) {
		return AttrHandlerTools.getStrInRange(target, start, end, includeStart, includeEnd);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.GET_STR_IN_RANGE;
	}

}
