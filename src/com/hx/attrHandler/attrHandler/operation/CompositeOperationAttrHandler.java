/**
 * file name : CompositeOperationAttrHandler.java
 * created at : 12:06:21 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.operation;

import java.util.List;

import com.hx.attrHandler.attrHandler.StandardHandlerParser.Types;
import com.hx.attrHandler.attrHandler.operation.interf.MultiArgsOperationAttrHandler;
import com.hx.attrHandler.attrHandler.operation.interf.OperationAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// 复合OperationAttrHandler的AttrHandler
public class CompositeOperationAttrHandler<T extends OperationAttrHandler> extends MultiArgsOperationAttrHandler<T> {
	// 初始化
	public CompositeOperationAttrHandler(List<T> handlerChain) {
		super(handlerChain);
		operationType(HXAttrHandlerConstants.OPERATION_COMPOSITE);
	}
	public CompositeOperationAttrHandler(int initCap) {
		super(initCap);
		operationType(HXAttrHandlerConstants.OPERATION_COMPOSITE);
	}
	public CompositeOperationAttrHandler() {
		this(HXAttrHandlerConstants.COMPOSITE_HANDLER_DEFAULT_CAP);
	}
	
	// 获取最后一个OperationAttrHandler
	public Types lastReturnType() {
		if((handlers == null) || (handlers.size() == 0) ) {
			return Types.String;
		}
		
		return handlers.get(handlers.size()-1).operationReturn();
	}
	
	@Override
	public String handle0(String result) {
		String res = result;
		for(OperationAttrHandler handler : handlers) {
			res = handler.handle(res);
			if(handler.immediateReturn() ) {
				updateImmediateReturnFlag(handler);
				returnMsg(handler.returnMsg() );
				return returnMsg;
			}
		}
		
		return res;
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.OPERATION_COMPOSITE;
	}
}
