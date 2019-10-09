import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.util.*;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException{

	// we expect exactly one argument: the name of the input file
	if (args.length!=1) {
	    System.err.println("\n");
	    System.err.println("Simple calculator\n");
	    System.err.println("=================\n\n");
	    System.err.println("Please give as input argument a filename\n");
	    System.exit(-1);
	}
	String filename=args[0];

	// open the input file
	CharStream input = CharStreams.fromFileName(filename);
	    //new ANTLRFileStream (filename); // depricated
	
	// create a lexer/scanner
	simpleCalcLexer lex = new simpleCalcLexer(input);
	
	// get the stream of tokens from the scanner
	CommonTokenStream tokens = new CommonTokenStream(lex);
	
	// create a parser
	simpleCalcParser parser = new simpleCalcParser(tokens);
	
	// and parse anything from the grammar for "start"
	ParseTree parseTree = parser.start();

	// Construct an interpreter and run it on the parse tree
	Interpreter interpreter = new Interpreter();
	AST result=interpreter.visit(parseTree);
	
	System.out.println("The result is: "+result.eval(new Environment()));
    }
}

abstract class AST{
    abstract public Double eval(Environment env);
};

class Start extends AST {
    public List<Assign> as;
    public Expr e;
    Start(List<Assign> as, Expr e){ this.as=as; this.e=e;}
    public Double eval(Environment env){
	for (Assign a:as)
	    a.eval(env);
	return e.eval(env);
    };
}

class Assign extends AST{
    public String variable;
    public Expr e;
    Assign(String variable, Expr e){ this.variable=variable; this.e=e; }
    public Double eval(Environment env){
	env.setVariable(variable,e.eval(env));
	return null;
    }
}

abstract class Expr extends AST{
}

class Multiplication extends Expr{
    public Expr e1;
    public Expr e2;
    Multiplication(Expr e1, Expr e2){ this.e1=e1; this.e2=e2;}
    public Double eval(Environment env){
	return e1.eval(env) * e2.eval(env);
    }
}

class Addition extends Expr{
    public Expr e1;
    public Expr e2;
    Addition(Expr e1, Expr e2){ this.e1=e1; this.e2=e2;}
    public Double eval(Environment env){
	return e1.eval(env) + e2.eval(env);
    }
}

class Subtraction extends Expr{
    public Expr e1;
    public Expr e2;
    Subtraction(Expr e1, Expr e2){ this.e1=e1; this.e2=e2;}
    public Double eval(Environment env){
	return e1.eval(env) - e2.eval(env);
    }
}

class Constant extends Expr{
    public Double v;
    Constant(Double v){ this.v=v;}
    public Double eval(Environment env){
	return v;
    }

}

class Variable extends Expr{
    public String v;
    Variable(String v){ this.v=v;}
    public Double eval(Environment env){
	return env.getVariable(v);
    }    
}

// We write an interpreter that implements interface
// "simpleCalcVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<AST> implements simpleCalcVisitor<AST> {

    public AST visitStart(simpleCalcParser.StartContext ctx){
	List<Assign> as=new ArrayList<Assign>();
	
	for (simpleCalcParser.AssignContext a:ctx.as)
	    as.add((Assign) visit(a));

	return new Start(as,(Expr) visit(ctx.e));
    };

    public AST visitParenthesis(simpleCalcParser.ParenthesisContext ctx){
	return visit(ctx.e);
    };
    
    public AST visitVariable(simpleCalcParser.VariableContext ctx){
	String varname=ctx.x.getText();
	return new Variable(varname);
    };
    
    public AST visitAddition(simpleCalcParser.AdditionContext ctx){
	Expr e1=(Expr)visit(ctx.e1);
	Expr e2=(Expr)visit(ctx.e2);
	
	if (ctx.op.getText().equals("+"))
	    return new Addition(e1,e2);
	else
	    return new Subtraction(e1,e2);
    };

    public AST visitMultiplication(simpleCalcParser.MultiplicationContext ctx){
	Expr e1=(Expr)visit(ctx.e1);
	Expr e2=(Expr)visit(ctx.e2);
	
	return new Multiplication(e1,e2);
    };

    public AST visitConstant(simpleCalcParser.ConstantContext ctx){
	return new Constant(Double.parseDouble(ctx.c.getText())); 
    };

    public AST visitSignedConstant(simpleCalcParser.SignedConstantContext ctx){
	return new Constant(Double.parseDouble(ctx.getText()));
    };
    
    public AST visitAssign(simpleCalcParser.AssignContext ctx){
	
	// New implementation: evaluate the expression and store it in the environment for the given
	// variable name
	String varname=ctx.x.getText();
	Expr e=(Expr)visit(ctx.e);

	return new Assign(varname,e);
    };

}
