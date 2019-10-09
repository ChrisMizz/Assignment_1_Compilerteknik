grammar simpleCalc;

start   : (as+=assign)* (e=expr)* (wl += loop)* (ie+=ifstatement)* EOF ;
// Her har vi gjort så man skal slutte hver indtastning i input filen med ";"
assign : x=ID '=' e=expr ';' ;

assignments : a=assign  # Assignment
	        | e1=expr # Expression
	        ;
// Her har vi indsat et "+" da man SKAL indtaste minimum 1 assignment for at få det til at virke
sequence : (a+=assignments )+ ;
// Dette if statement kan foregå på 2 måder. Den første er hvor der ingen "else" statement er, og den anden er med en "else" statement
ifstatement : IF '('(d=cond)')' THEN e1=sequence # Ifstate
            | IF '(' (d=cond) ')' THEN e1=sequence ELSE e2=sequence # IfElseState
            ;
// Loopet vil bare tage imod en cond, og en eller flere assignments
loop : WHILE '(' d=cond ')' e=sequence # While
;

cond: e1=expr '<' e2=expr  # Bigger
    | e1=expr '<=' e2=expr # BiggerOrEqual
    | e1=expr '>' e2=expr  # Less
    | e1=expr '>=' e2=expr # LessOrEqual
    | e1=expr '==' e2=expr # Equals
    | e1=expr '!=' e2=expr # NotEqual
    | e1=expr '<=' e2=expr # BiggerOrEqual
    |'!' '(' d1=cond ')'   # Not
    | e1=cond '&&' e2=cond # And
    | e1=cond '||' e2=cond # Or
    ;

expr : d=FLOAT x=ID           # NumMultiAlpha
     |x=ID    	              # Variable
     | c=FLOAT	              # Constant
     | e1=expr op=OPE e2=expr # Multiplication
     | e1=expr op=OP e2=expr  # Addition
     | '(' e=expr ')'	      # Parenthesis
     | op=OP f=FLOAT          # SignedConstant
;

// Lexer:
OP : '-'|'+' ;
OPE : '*'|'/' ;
WHILE : 'while' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;

ID    : ALPHA (ALPHA|NUM)* ;
FLOAT : NUM+ ('.' NUM+)? ;

ALPHA : [a-zA-Z_ÆØÅæøå] ;
NUM   : [0-9] ;

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//'~[\n]*  -> skip;
COMMENT2   : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
