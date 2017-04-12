/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import net.sf.json.JSONObject;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 返回res的AttrHandler
// 适配常量
public class ConstantsAttrHandler extends AttrHandler {
	// 处理结果得到的常量值
	private String res;
	
	// 初始化
	public ConstantsAttrHandler(String res) {
		this.res = res;
		if(HXAttrHandlerConstants.escapeCharMap.containsKey(res.charAt(0)) && HXAttrHandlerConstants.escapeCharMap.containsKey(res.charAt(res.length()-1)) ) {
			this.res = this.res.substring(1, this.res.length()-1 );
		}
	}
	public ConstantsAttrHandler(int i) {
		this(String.valueOf(i) );
	}
	public ConstantsAttrHandler(boolean bool) {
		this(String.valueOf(bool) );
	}

	@Override
	public String handle0(String result) {
		if(HXAttrHandlerConstants.RECOGNIZE_RESULT_PROXY) {
			if(HXAttrHandlerConstants.RESULT_PROXY.equals(res) ) {
				return result;
			}
		}
		
		return res;
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.CONSTANTS;
	}

	@Override
	public String toString() {
		return new JSONObject().element("name", name() ).element("operands", res).toString();
	}
}
