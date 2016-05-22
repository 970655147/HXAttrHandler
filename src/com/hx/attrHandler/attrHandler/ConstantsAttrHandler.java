/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import net.sf.json.JSONObject;

import com.hx.attrHandler.attrHandler.interf.AttrHandler;
import com.hx.attrHandler.util.Constants;

// ����res��AttrHandler
// ���䳣��
public class ConstantsAttrHandler extends AttrHandler {
	// ��������õ��ĳ���ֵ
	private String res;
	
	// ��ʼ��
	public ConstantsAttrHandler(String res) {
		this.res = res;
		if(Constants.escapeCharMap.containsKey(res.charAt(0)) && Constants.escapeCharMap.containsKey(res.charAt(res.length()-1)) ) {
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
		if(Constants.RECOGNIZE_RESULT_PROXY) {
			if(Constants.RESULT_PROXY.equals(res) ) {
				return result;
			}
		}
		
		return res;
	}

	@Override
	public String name() {
		return Constants.CONSTANTS;
	}

	@Override
	public String toString() {
		return new JSONObject().element("name", name() ).element("operands", res).toString();
	}
}