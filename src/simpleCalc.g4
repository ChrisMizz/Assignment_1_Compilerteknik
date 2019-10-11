grammar simpleCalc;

simpleCalcLanguage  : (cm+=commands)* (wl+=while_loop)* (is+=if_statements)* e=expr EOF
                    ;

commands            : x=ID EQUALS e=expr SEMICOLON
                    ;

function            : com=commands                                                                  #ComFunction
                    | ex=expr                                                                       #ExFunction
                    ;

functionlist        : (com+=function)*
                    ;


while_loop          : WHILE PAR1 (cond=conditions) PAR2 ex=functionlist                              #While
                    ;

if_statements       : IF PAR1 (cond=conditions) PAR2 ex=functionlist (ELSE eSecond=functionlist)*    #Ifelsestate
                    ;

conditions          : eFirst=expr '<' eSecond=expr                                                   # Greater
                    | eFirst=expr '>' eSecond=expr                                                   # Lesser
                    | eFirst=expr '<=' eSecond=expr                                                  # GreaterEqual
                    | eFirst=expr '>=' eSecond=expr                                                  # LesserEqual
                    | eFirst=expr '==' eSecond=expr                                                  # Equal
                    | eFirst=expr '!=' eSecond=expr                                                  # NotEqual
                    | '!' PAR1 cond=conditions PAR2                                                  # Not
                    | eFirst=conditions '&&' eSecond=conditions                                      # And
                    | eFirst=conditions '||' eSecond=conditions                                      # Or
                    ;

expr	            : x=ID		                                                                     # Variable
                    | c=FLOAT     	                                                                 # Constant
                    | eFirst=expr op=OPTWO eSecond=expr                                              # MultiDivi
                    | eFirst=expr op=OPONE eSecond=expr                                              # AddiSub
                    | PAR1 e=expr PAR2                                                               # Parenthesis
                    | op=OPONE f=FLOAT                                                               # SignedConstant
                    ;

WHILE               : 'while'   ;
IF                  : 'if'      ;
ELSEIF              : 'else if' ;
ELSE                : 'else'    ;
EQUALS              : '='       ;
PAR1                : '('       ;
PAR2                : ')'       ;
SEMICOLON           : ';'       ;    
OPONE               : '+' | '-' ;
OPTWO               : '*' | '/' ;

ID                  : ALPHA (ALPHA|NUM)* ;
FLOAT               : NUM+ ('.' NUM+)? ;

ALPHA               : [a-zA-Z_ÆØÅæøå] ;
NUM                 : [0-9] ;

WHITESPACE          : [ \n\t\r]+ -> skip;
COMMENT             : '//'~[\n]*  -> skip;
COMMENT2            : '/*' (~[*] | '*'~[/]  )*   '*/'  -> skip;
