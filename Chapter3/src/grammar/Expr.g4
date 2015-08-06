grammar Expr;
import CommonLexerRules;

prog: stat+ ;

stat: expr NEWLINE                  # printExpr
    | ID '=' expr NEWLINE           # assign
    | NEWLINE                       # blank
    | 'clear'                       # clear
    ;

expr: expr op=('*'|'/') expr           # MultDiv
    | expr op=('+'|'-') expr           # AddSub
    | INT                           # int
    | ID                            # id
    | '(' expr ')'                  # parens
    ;

MUL : '*' ; // assigns the token name to the '*' used above
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;


