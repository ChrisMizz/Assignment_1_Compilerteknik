grammar simpleCalc;

start   : (as+=assign)* (e=expr)* (wl += loop)* EOF ;

assign : x=ID '=' e=expr ';' ;

assignments : a=assign  # Assignment
	| e=expr # Expression
	;

sequence : (a+=assignments )+ ;

loop : 'while' '(' c=cond ')' e=sequence # While
;

cond: e1=expr '<' e2=expr  # Bigger
    | e1=expr '<=' e2=expr # BiggerOrEqual
    | e1=expr '>' e2=expr  # Less
    | e1=expr '>=' e2=expr # LessOrEqual
    | e1=expr '==' e2=expr # Equals
    | e1=expr '!=' e2=expr # NotEqual
    | e1=expr '<=' e2=expr # BiggerOrEqual
    | c1=cond '||' c2=cond # Or
    | c1=cond '&&' c2=cond # And
    |'!' '(' c1=cond ')'   # Not
    ;

expr : x=ID    	              # Variable
     | c=FLOAT	              # Constant
     | e1=expr op=OPE e2=expr # Multiplication
     | e1=expr op=OP e2=expr  # Addition
     | '(' e=expr ')'	      # Parenthesis
     | op=OP f=FLOAT          # SignedConstant
;

// Lexer:
OP : '-'|'+' ;
OPE : '*'|'/' ;

ID    : ALPHA (ALPHA|NUM)* ;
FLOAT : NUM+ ('.' NUM+)? ;

ALPHA : [a-zA-Z_ÆØÅæøå] ;
NUM   : [0-9] ;

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//'~[\n]*  -> skip;
COMMENT2   : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
