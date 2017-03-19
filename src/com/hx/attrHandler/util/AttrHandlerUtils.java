/**
 * file name : HandlerParserUtil.java
 * created at : 11:10:38 AM May 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.util;

import com.hx.attrHandler.attrHandler.StandardHandlerParser;
import com.hx.attrHandler.attrHandler.StandardHandlerParser.Types;
import com.hx.attrHandler.attrHandler.interf.HandlerParser;
import com.hx.attrHandler.attrHandler.operation.CompositeOperationAttrHandler;
import com.hx.attrHandler.attrHandler.operation.interf.OperationAttrHandler;
import com.hx.log.util.Tools;

public final class AttrHandlerUtils {
	
	// disable constructor
	private AttrHandlerUtils() {
		Tools.assert0("can't instantiate !");
	}
	
	// ------------ handlerParser相关 ------- 2016.03.23 -------------
	// 处理handlerParse相关的业务
	public static final HandlerParser handlerParser = new StandardHandlerParser();
	
	// 将给定的字符串解析为AttrHandler
	public static OperationAttrHandler handlerParse(String handlerStr, String handlerType, Types lastOperationReturn) {
		HXAttrHandlerTools.assert0(handlerStr != null, "'handlerStr' can't be null ");
		HXAttrHandlerTools.assert0(handlerType != null, "'handlerType' can't be null ");
		return handlerParser.handlerParse(handlerStr, handlerType, lastOperationReturn);
	}
	public static OperationAttrHandler handlerParse(String handlerStr, String handlerType) {
		return handlerParse(handlerStr, handlerType, null);
	}
	
	// 合并两个Handler
	public static OperationAttrHandler combineHandler(OperationAttrHandler mainHandler, OperationAttrHandler attachHander) {
		HXAttrHandlerTools.assert0(mainHandler != null, "'mainHandler' can't be null ");
		HXAttrHandlerTools.assert0(attachHander != null, "'attachHander' can't be null ");
		
		HXAttrHandlerTools.assert0(! mainHandler.operationReturn().isFinal, "the first handler's returnType is final, can't concate 'AttrHandler' anymore ! please check it ! ");
		CompositeOperationAttrHandler<OperationAttrHandler> attrHandler = new CompositeOperationAttrHandler<>();
		attrHandler.addHandler(mainHandler);
		attrHandler.addHandler(attachHander);
		return attrHandler;
	}
//	// 合并两个返回值为逻辑值的Handler, isAnd表示使用"&&"连接 还是"||"连接
//	public static AttrHandler combineCuttingOutHandler(OperationAttrHandler mainHandler, OperationAttrHandler attachHander, boolean isAnd) {
//		Tools.assert0(Types.Boolean == mainHandler.operationReturn(), "combineCuttingOutHandler need '(Boolean, Boolean)' as parameter ! please check it ! ");
//		Tools.assert0(Types.Boolean == attachHander.operationReturn(), "combineCuttingOutHandler need '(Boolean, Boolean)' as parameter ! please check it ! ");
//		if(isAnd) {
//			return new CuttingOutAndAttrHandler<AttrHandler>(Arrays.asList(mainHandler, attachHander) );
//		} else {
//			return new CuttingOutOrAttrHandler<AttrHandler>(Arrays.asList(mainHandler, attachHander) );
//		}
//	}
	// 获取给定的attrHander中最后一个有效的AttrHandler[非Composite]
//	public static AttrHandler lastWorkedHandler(AttrHandler attrHandler) {
//		if(attrHandler instanceof CompositeAttrHandler) {
//			CompositeAttrHandler compositeHandler = ((CompositeAttrHandler) attrHandler);
//			return lastWorkedHandler(compositeHandler.handler(compositeHandler.handlers().size() ) );
//		}
//		
//		return attrHandler;
//	}
//	public static OperationAttrHandler lastWorkedHandler(OperationAttrHandler attrHandler) {
//		if(attrHandler instanceof CompositeOperationAttrHandler) {
//			CompositeOperationAttrHandler<?> compositeHandler = ((CompositeOperationAttrHandler<?>) attrHandler);
//			return lastWorkedHandler(compositeHandler.handler(compositeHandler.handlers().size() ) );
//		}
//		
//		return attrHandler;
//	}
//	public static AttrHandler removeIfLastWorkedHandlerIsFilter(OperationAttrHandler attrHandler) {
//		if(attrHandler instanceof CompositeOperationAttrHandler) {
//			CompositeOperationAttrHandler<OperationAttrHandler> compositeHandler = ((CompositeOperationAttrHandler<OperationAttrHandler>) attrHandler);
//			OperationAttrHandler lastAttrHandler = compositeHandler.handler(compositeHandler.handlers().size() - 1);
//			if(lastAttrHandler instanceof CompositeOperationAttrHandler) {
//				return removeIfLastWorkedHandlerIsFilter(lastAttrHandler);
//			}
//			if(Constants.FILTER_OPERATION.equals(lastAttrHandler.operationType()) ) {
//				return compositeHandler.removeHandler(compositeHandler.handlers().size() - 1);
//			}
//		}
//		
//		return null;
//	}
	
}
