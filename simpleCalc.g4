grammar simpleCalc;

start   : e=expr EOF ;

expr	: e1=expr MD e2=expr # Multiplication
	    | e1=expr PM e2=expr # Addition
	    | c=FLOAT     	     # Constant
	    | x=ID		         # Variable
	    | '(' e=expr ')'     # Parenthesis
	    | pm=PM f=FLOAT      #SignedConstant
	    ;

PM : '+' | '-';
MD : '*' | '/';

ID    : ALPHA (ALPHA|NUM)* ;
FLOAT : NUM+ ('.' NUM+)? ;

ALPHA : [a-zA-Z_ÆØÅæøå] ;
NUM   : [0-9] ;

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//'~[\n]*  -> skip;
COMMENT2   : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
