/**
 * file name : MapOperationAttrHandler.java
 * created at : 12:28:38 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.operation;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.attr_handler.operation.interf.OperationAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;
import com.hx.attr_handler.attr_handler.StandardHandlerParser;

// filterHandler
// ע�� �� �뽫���ԭ������
public class FilterOperationAttrHandler extends OperationAttrHandler {
	// ��ϵĺ���ҵ���handler
	private AttrHandler handler;
	
	// ��ʼ��
	public FilterOperationAttrHandler(AttrHandler handler, StandardHandlerParser.Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(HXAttrHandlerConstants.FILTER_OPERATION);
		operationReturn(operationReturn);
	}

	// ע�� �� ���ܸı���
	@Override
	protected String handle0(String result) {
		boolean bool = Boolean.parseBoolean(handler.handle(result) );
		beFiltered(bool);
		if(beFiltered() ) {
			returnMsg("beFiltered while handle : '" + result + "', filterHandler : " + handler.toString() );
			return "beFiltered";
		}
		return result;
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.FILTER_OPERATION;
	}

}
