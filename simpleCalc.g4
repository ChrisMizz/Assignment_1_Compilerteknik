grammar simpleCalc;

simpleCalcLanguage  : (cm+=commands)* (wl+=while_loop)* (is+=if_statements)* e=expr EOF
                    ;

commands            : x=ID EQUALS e=expr SEMICOLON
                    ;

function            : com=commands                                                          #AsFirst
                    | ex=expr                                                               #ExpFirst
                    ;

functionlist        : (com+=function)*
                    ;


while_loop          : WHILE PAR1 (cond=conditions) PAR2 ex=functionlist                     #While
                    ;

if_statements       : IF PAR1 (cond=conditions) PAR2 ex=functionlist (ELSE eSecond=functionlist)*   #Ifelsestate
                    ;

conditions          : eFirst=expr '>' eSecond=expr                                                   # Less
                    | eFirst=expr '<' eSecond=expr                                                   # Bigger
                    | eFirst=expr '<=' eSecond=expr                                                  # BiggerOrEqual
                    | eFirst=expr '>=' eSecond=expr                                                  # LessOrEqual
                    | eFirst=expr '==' eSecond=expr                                                  # Equals
                    | eFirst=expr '!=' eSecond=expr                                                  # NotEqual
                    | eFirst=expr '<=' eSecond=expr                                                  # BiggerOrEqual
                    | '!' PAR1 cond=conditions PAR2                                         # Not
                    | eFirst=conditions '&&' eSecond=conditions                                      # And
                    | eFirst=conditions '||' eSecond=conditions                                      # Or
                    ;

expr	            : x=ID		                                                            # Variable
                    | c=FLOAT     	                                                        # Constant
                    | eFirst=expr op=OPTWO eSecond=expr                                         # Multiplication
                    | eFirst=expr op=OPONE eSecond=expr                                              # Addition
                    | PAR1 e=expr PAR2                                                      # Parenthesis
                    | op=OPONE f=FLOAT                                                      # SignedConstant
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
