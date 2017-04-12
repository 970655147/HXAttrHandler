/**
 * file name : TwoStringIntResultHandlerArgsAttrHandler.java
 * created at : 2:14:47 AM May 21, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter;

import com.hx.attr_handler.attr_handler.ConstantsAttrHandler;
import com.hx.attr_handler.attr_handler.adapter.interf.interf.TwoStringIntArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import net.sf.json.JSONObject;

//构造两个字符串参数 + 一个int参数的AttrHandler的Handler适配器
//作为适配器内部使用
public class TwoStringIntResultHandlerArgsAttrHandler extends AttrHandler {
	// 处理数据的handler, 获取参数的handler
	private TwoStringIntArgsAttrHandler handler;
	private AttrHandler target;
	private AttrHandler idxStr;
	private AttrHandler from;
	
	// 初始化
	public TwoStringIntResultHandlerArgsAttrHandler(TwoStringIntArgsAttrHandler handler, AttrHandler target, AttrHandler idxStr, AttrHandler from) {
		this.handler = handler;
		this.target = target;
		this.idxStr = idxStr;
		this.from = from;
	}
	public TwoStringIntResultHandlerArgsAttrHandler(TwoStringIntArgsAttrHandler handler, String target, String arg01, int arg02) {
		this(handler, new ConstantsAttrHandler(target), new ConstantsAttrHandler(arg01), new ConstantsAttrHandler(String.valueOf(arg02)) );
	}
	
	@Override
	public String handle0(String result) {
		handler.setArgs(target.handle(result), idxStr.handle(result), Integer.parseInt(from.handle(result)) );
		return handler.handle(result);
	}

	@Override
	public String name() {
		return handler.name();
	}
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("handler", handler.toString() ).element("target", target.toString() ).element("idxStr", idxStr.toString() )
				.element("from", from)
				.toString();
	}
	
}
