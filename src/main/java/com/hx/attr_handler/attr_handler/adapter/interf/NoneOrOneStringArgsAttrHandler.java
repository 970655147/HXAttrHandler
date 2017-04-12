/**
 * file name : TwoIntArgsAttrHandler.java
 * created at : 10:51:01 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter.interf;

import com.hx.attr_handler.attr_handler.adapter.interf.interf.OneStringArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;
import net.sf.json.JSONObject;


// �������һ���ַ���������AttrHander������AttrHandler
public abstract class NoneOrOneStringArgsAttrHandler extends OneStringArgsAttrHandler {
	// ������û�ָ���Ĳ���
	protected String arg;
	
	// ��ʼ��
	public NoneOrOneStringArgsAttrHandler(String str) {
		setArgs(str);
	}
	
	// ���ò���
	public void setArgs(String arg) {
		this.arg = arg;
	}
	// ��дhandle0, �����߼�[�������߼�������gotResult��]
	public String handle0(String result) {
		if(HXAttrHandlerConstants.HANDLER_UNDEFINED.equals(arg) ) {
			arg = result;
		}
		
		return gotResult(arg, result);
	}
	
	// ����ҵ��
	protected abstract String gotResult(String arg, String result);
	
	@Override
	public String toString() {
		return new JSONObject()
				.element("name", name() ).element("operands", arg.toString() )
				.toString();
	}
}
