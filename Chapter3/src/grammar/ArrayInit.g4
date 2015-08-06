/* Grammars always start with a grammar header. This grammar is
*  called ArrayInit and must match the filename: ArrayInit.g4
*/
grammar ArrayInit;

/** A rule called init that matches comma-separated values between {} */
init : '{' value (',' value)* '}' ;

/** A vlue is either a nested arry or a simple integer */
value : init
	  | INT
	  ;

INT : [0-9]+ ;
WS  : [ \t\r\n]+ -> skip ;
