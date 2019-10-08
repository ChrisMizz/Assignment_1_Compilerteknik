grammar simpleCalc;

start   : (as+=assign)* e=expr EOF ;

assign : x=ID '=' e=expr  ;

expr	: e1=expr OP2 e2=expr # Multiplication
	    | e1=expr OP1 e2=expr # Addition
	    | c=FLOAT     	      # Constant
	    | x=ID		          # Variable
	    | '(' e=expr ')'      # Parenthesis
	    | op=OP1 f=FLOAT      #SignedConstant
;

OP1 : '+' | '-';
OP2 : '*' | '/';

ID    : ALPHA (ALPHA|NUM)* ;
FLOAT : NUM+ ('.' NUM+)? ;

ALPHA : [a-zA-Z_ÆØÅæøå] ;
NUM   : [0-9] ;

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//'~[\n]*  -> skip;
COMMENT2   : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
