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
public class HXAttrHandlerConstants {
	
	public static final String HANDLER = "handler";
	
	// Constants
	public final static Character SLASH = '\\';
	public final static Character INV_SLASH = '/';
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
	public final static String HANDLER_PREFIX = "map";
	public final static String RESULT_PROXY = "$this";
	public final static boolean RECOGNIZE_RESULT_PROXY = true;
	public final static String ANONY_OPERAND_NAME = "anonymousOperand";
	public final static String EMPTY_OPERAND_NAME = "emptyOperand";
	public final static int COMPOSITE_HANDLER_DEFAULT_CAP = 2;
	public final static int CONCATE_HANDLER_DEFAULT_CAP = 2;
	public final static int CUTTING_DOOR_HANDLER_DEFAULT_CAP = 2;
	public final static int CALC_HANDLER_DEFAULT_CAP = 2;
	public final static int MULTI_ARG_HANDLER_DEFAULT_CAP = 2;
	public final static int OPERAND_DEFAULT_CAP = 2;
	// some 'sugar' symbol
		// 'abc' + 'def', 2 > 3, true && true, 3>5 ? truePart : falsePart
	public final static String STRING_CONCATE = "+";
	public final static String STRING_NOT = "!";
	public final static String GT = ">";
	public final static String LT = "<";
	public final static String EQ = "=";
	public final static String AND = "&";
	public final static String OR = "|";
	public final static String COND_EXP_COND = "?";
	public final static String COND_EXP_BRANCH = ":";
	
	public final static String PARAM_SEP = ",";
	public final static String SUB_HANDLER_CALL = ".";
//	public final static String QUOTE = "'";
	public final static String QUOTED_STRING = "quotedString";
	public final static String TRUE = Boolean.TRUE.toString();
	public final static String FALSE = Boolean.FALSE.toString();
	public final static String HANDLER_UNDEFINED = "-1";
	public final static int TARGET_UNDEFINED = Integer.parseInt(HANDLER_UNDEFINED);
	
	// each 'functionName'
	public final static String CONCATE = "concate";
	public final static String REPLACE = "replace";
	public final static String TRIM = "trim";
	public final static String TRIM_ALL = "trimAll";
	public final static String TRIM_AS_ONE = "trimAsOne";
	public final static String SUB_STRING = "subString";
	public final static String TO_UPPERCASE = "toUpperCase";
	public final static String TO_LOWERCASE = "toLowerCase";
	public final static String CONSTANTS = "constants";
	public final static String DO_NOTHING = "doNothing";
	public final static String GET_STR_IN_RANGE = "getStrIn";
	
	public final static String INDEX_OF = "indexOf";
	public final static String LAST_INDEX_OF = "lastIndexOf";
	public final static String LENGTH = "length";
	
	public final static String EQUALS = "equals";
	public final static String MATCHES = "matches";
	public final static String CONTAINS = "contains";
	public final static String NOT = "not";
	
	public final static String COMPOSITE = "composite";
	
	public final static String GREATER_THAN = "gt";
	public final static String GREATER_EQUALS_THAN = "get";
	public final static String LESS_THAN = "lt";
	public final static String LESS_EQUALS_THAN = "let";
	public final static String _EQUALS = "eq";
	public final static String NOT_EQUALS = "neq";
	
	public final static String CUTTING_OUT_AND = "and";
	public final static String CUTTING_OUT_OR = "or";
	
	public final static String COND_EXP = "condExp";
	
	public final static String ADD = "add";
	public final static String SUB = "sub";
	public final static String MUL = "mul";
	public final static String DIV = "div";
	public final static String MOD = "mod";
	
	public final static String TO_INT = "toInt";
	public final static String TO_BOOLEAN = "toBool";
	public final static String TO_STRING = "toString";

	// Constants related on 'operation'
	public final static String OPERATION_COMPOSITE = "operationComposite";
	public final static String MAP_OPERATION = "map";
	public final static String FILTER_OPERATION = "filter";
	public final static String ASSERT_OPERATION = "assert";
	
	// 校验不通过即时返回的消息, 
	// default 'OperationHandler'[map(doNothing) ]
	public final static String immediateOperationMsg;
	public final static OperationAttrHandler defaultOperationAttrHandler = new MapOperationAttrHandler(new DoNothingAttrHandler(), Types.String);
	
	// <handlerType -> operation> {'handler' : [map, filter, assert] }
	// the 'Operation' that need immediateReturn
	// the seprator that used while 'WordsSeprate'
	// the symbolPair that need to be escape while 'WordsSeprate', like 'log(abc);', should not be seprate
	// the symbolPair represents every 'bracketPair'['(' & ')', '{' & '}', '[' & ']' ]
	public final static Map<String, List<String>> handlerTypeToHandleOperations = new HashMap<>();
	public final static Set<String> immediateOperation = new HashSet<>();
	public final static Set<String> handlerParserSeps = new HashSet<>();
	public final static Map<String, String> escapeMap = new HashMap<>();
	public final static Map<Character, Character> escapeCharMap = new HashMap<>();
	public final static Map<String, String> bracketPair = new HashMap<>();
	static {
		handlerTypeToHandleOperations.put(HANDLER, Arrays.asList(MAP_OPERATION, FILTER_OPERATION, ASSERT_OPERATION) );
		
		immediateOperation.add(FILTER_OPERATION);
		immediateOperation.add(ASSERT_OPERATION);
		
		immediateOperationMsg = immediateOperation.toString();
		
		handlerParserSeps.add("(");
		handlerParserSeps.add(")");
		handlerParserSeps.add("+");
		handlerParserSeps.add(",");
		handlerParserSeps.add(".");
		handlerParserSeps.add("'");
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
