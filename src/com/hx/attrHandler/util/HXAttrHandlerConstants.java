/**
 * file name : Constants.java
 * created at : 8:06:27 PM Jul 24, 2015
 * created by 970655147
 */

package com.hx.attrHandler.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hx.attrHandler.attrHandler.DoNothingAttrHandler;
import com.hx.attrHandler.attrHandler.StandardHandlerParser.Types;
import com.hx.attrHandler.attrHandler.operation.MapOperationAttrHandler;
import com.hx.attrHandler.attrHandler.operation.interf.OperationAttrHandler;

// 常量
public final class HXAttrHandlerConstants {
	
	// disable constructor
	private HXAttrHandlerConstants() {
		HXAttrHandlerTools.assert0("can't instantiate !");
	}
	
	public static final String HANDLER = "handler";
	
	// Constants
	public static final Character SLASH = '\\';
	public static final Character INV_SLASH = '/';
	public static final Character QUESTION = '?';
	public static final Character DOT = '.';
	public static final Character COMMA = ',';
	public static final Character COLON = ':';	
	public static final Character SPACE = ' ';
	public static final Character TAB = '\t';
	public static final Character CR = '\r';
	public static final Character LF = '\n';
	public static final Character QUOTE = '\"';
	public static final Character SINGLE_QUOTE = '\'';
	public static final String EMPTY_STR = "";
	public static final String DEFAULT_VALUE = "defaultValue";

	// Constants related on 'attrHandler'				// add at 2016.03.22
	public static final String HANDLER_PREFIX = "map";
	public static final String RESULT_PROXY = "$this";
	public static final boolean RECOGNIZE_RESULT_PROXY = true;
	public static final String ANONY_OPERAND_NAME = "anonymousOperand";
	public static final String EMPTY_OPERAND_NAME = "emptyOperand";
	public static final int COMPOSITE_HANDLER_DEFAULT_CAP = 2;
	public static final int CONCATE_HANDLER_DEFAULT_CAP = 2;
	public static final int CUTTING_DOOR_HANDLER_DEFAULT_CAP = 2;
	public static final int CALC_HANDLER_DEFAULT_CAP = 2;
	public static final int MULTI_ARG_HANDLER_DEFAULT_CAP = 2;
	public static final int OPERAND_DEFAULT_CAP = 2;
	// some 'sugar' symbol
		// 'abc' + 'def', 2 > 3, true && true, 3>5 ? truePart : falsePart
	public static final String STRING_CONCATE = "+";
	public static final String STRING_NOT = "!";
	public static final String GT = ">";
	public static final String LT = "<";
	public static final String EQ = "=";
	public static final String AND = "&";
	public static final String OR = "|";
	public static final String COND_EXP_COND = "?";
	public static final String COND_EXP_BRANCH = ":";
	
	public static final String PARAM_SEP = ",";
	public static final String SUB_HANDLER_CALL = ".";
//	public static final String QUOTE = "'";
	public static final String QUOTED_STRING = "quotedString";
	public static final String TRUE = Boolean.TRUE.toString();
	public static final String FALSE = Boolean.FALSE.toString();
	public static final String HANDLER_UNDEFINED = "-1";
	public static final int TARGET_UNDEFINED = Integer.parseInt(HANDLER_UNDEFINED);
	
	// each 'functionName'
	public static final String CONCATE = "concate";
	public static final String REPLACE = "replace";
	public static final String REPLACE_WITH_ORIGINAL = "replaceO";
	public static final String TRIM = "trim";
	public static final String TRIM_ALL = "trimAll";
	public static final String TRIM_AS_ONE = "trimAsOne";
	public static final String SUB_STRING = "subString";
	public static final String TO_UPPERCASE = "toUpperCase";
	public static final String TO_LOWERCASE = "toLowerCase";
	public static final String CONSTANTS = "constants";
	public static final String DO_NOTHING = "doNothing";
	public static final String GET_STR_IN_RANGE = "getStrIn";
	
	public static final String INDEX_OF = "indexOf";
	public static final String LAST_INDEX_OF = "lastIndexOf";
	public static final String LENGTH = "length";
	
	public static final String EQUALS = "equals";
	public static final String MATCHES = "matches";
	public static final String CONTAINS = "contains";
	public static final String NOT = "not";
	
	public static final String COMPOSITE = "composite";
	
	public static final String GREATER_THAN = "gt";
	public static final String GREATER_EQUALS_THAN = "get";
	public static final String LESS_THAN = "lt";
	public static final String LESS_EQUALS_THAN = "let";
	public static final String _EQUALS = "eq";
	public static final String NOT_EQUALS = "neq";
	
	public static final String CUTTING_OUT_AND = "and";
	public static final String CUTTING_OUT_OR = "or";
	
	public static final String COND_EXP = "condExp";
	
	public static final String ADD = "add";
	public static final String SUB = "sub";
	public static final String MUL = "mul";
	public static final String DIV = "div";
	public static final String MOD = "mod";
	
	public static final String TO_INT = "toInt";
	public static final String TO_BOOLEAN = "toBool";
	public static final String TO_STRING = "toString";

	// Constants related on 'operation'
	public static final String OPERATION_COMPOSITE = "operationComposite";
	public static final String MAP_OPERATION = "map";
	public static final String FILTER_OPERATION = "filter";
	public static final String ASSERT_OPERATION = "assert";
	
	// 校验不通过即时返回的消息, 
	// default 'OperationHandler'[map(doNothing) ]
	public static final String immediateOperationMsg;
	public static final OperationAttrHandler defaultOperationAttrHandler = new MapOperationAttrHandler(new DoNothingAttrHandler(), Types.String);
	
	// <handlerType -> operation> {'handler' : [map, filter, assert] }
	// the 'Operation' that need immediateReturn
	// the seprator that used while 'WordsSeprate'
	// the symbolPair that need to be escape while 'WordsSeprate', like 'log(abc);', should not be seprate
	// the symbolPair represents every 'bracketPair'['(' & ')', '{' & '}', '[' & ']' ]
	public static final Map<String, List<String>> handlerTypeToHandleOperations = new HashMap<>();
	public static final Set<String> immediateOperation = new HashSet<>();
	public static final Set<String> handlerParserSeps = new HashSet<>();
	public static final Map<String, String> escapeMap = new HashMap<>();
	public static final Map<Character, Character> escapeCharMap = new HashMap<>();
	public static final Map<String, String> bracketPair = new HashMap<>();
	static {
		handlerTypeToHandleOperations.put(HANDLER, Arrays.asList(MAP_OPERATION, FILTER_OPERATION, ASSERT_OPERATION) );
		
		immediateOperation.add(FILTER_OPERATION);
		immediateOperation.add(ASSERT_OPERATION);
		
		immediateOperationMsg = immediateOperation.toString();
		
		handlerParserSeps.add("(");
		handlerParserSeps.add(")");
		handlerParserSeps.add(",");
		handlerParserSeps.add(".");
		handlerParserSeps.add("'");
		
		handlerParserSeps.add("+");
		handlerParserSeps.add("!");
		handlerParserSeps.add(">");
		handlerParserSeps.add("<");
		handlerParserSeps.add("=");
		handlerParserSeps.add("&");
		handlerParserSeps.add("|");
		handlerParserSeps.add("?");
		handlerParserSeps.add(":");
		
		escapeMap.put("\"", "\"");
		escapeMap.put("'", "'");
		escapeCharMap.put('\'', '\'');
		escapeCharMap.put('"', '"');
		
		bracketPair.put("(", ")");
		bracketPair.put("{", "}");
	}
	
	// 视为空的字符串
	static Set<String> emptyStrCondition = new HashSet<>();
	static {
		emptyStrCondition.add(EMPTY_STR);
	}
	static boolean isEmpty0(String str) {
		return (str == null) || emptyStrCondition.contains(str.trim());
	}
	
}
