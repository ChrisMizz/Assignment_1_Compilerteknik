// Generated from C:/Users/Ejer/OneDrive/DTU/3.Semester/compilerteknik/Assignment1\simpleCalc.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simpleCalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ID=5, FLOAT=6, ALPHA=7, NUM=8, WHITESPACE=9, 
		COMMENT=10, COMMENT2=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ID", "FLOAT", "ALPHA", "NUM", "WHITESPACE", 
			"COMMENT", "COMMENT2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ID", "FLOAT", "ALPHA", "NUM", "WHITESPACE", 
			"COMMENT", "COMMENT2"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public simpleCalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simpleCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\\\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6%\n\6\f\6\16"+
		"\6(\13\6\3\7\6\7+\n\7\r\7\16\7,\3\7\3\7\6\7\61\n\7\r\7\16\7\62\5\7\65"+
		"\n\7\3\b\3\b\3\t\3\t\3\n\6\n<\n\n\r\n\16\n=\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\7\13F\n\13\f\13\16\13I\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\fS\n"+
		"\f\f\f\16\fV\13\f\3\f\3\f\3\f\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\3\2\b\13\2C\\aac|\u00a7\u00a8\u00ba\u00ba\u00c5"+
		"\u00c5\u02de\u02de\u2022\u2022\u2028\u2028\3\2\62;\5\2\13\f\17\17\"\""+
		"\3\2\f\f\3\2,,\3\2\61\61\2d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37"+
		"\3\2\2\2\13!\3\2\2\2\r*\3\2\2\2\17\66\3\2\2\2\218\3\2\2\2\23;\3\2\2\2"+
		"\25A\3\2\2\2\27L\3\2\2\2\31\32\7-\2\2\32\4\3\2\2\2\33\34\7,\2\2\34\6\3"+
		"\2\2\2\35\36\7*\2\2\36\b\3\2\2\2\37 \7+\2\2 \n\3\2\2\2!&\5\17\b\2\"%\5"+
		"\17\b\2#%\5\21\t\2$\"\3\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2"+
		"\'\f\3\2\2\2(&\3\2\2\2)+\5\21\t\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2"+
		"\2\2-\64\3\2\2\2.\60\7\60\2\2/\61\5\21\t\2\60/\3\2\2\2\61\62\3\2\2\2\62"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64.\3\2\2\2\64\65\3\2\2\2\65\16"+
		"\3\2\2\2\66\67\t\2\2\2\67\20\3\2\2\289\t\3\2\29\22\3\2\2\2:<\t\4\2\2;"+
		":\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\b\n\2\2@\24\3\2\2"+
		"\2AB\7\61\2\2BC\7\61\2\2CG\3\2\2\2DF\n\5\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\b\13\2\2K\26\3\2\2\2LM\7\61\2\2M"+
		"N\7,\2\2NT\3\2\2\2OS\n\6\2\2PQ\7,\2\2QS\n\7\2\2RO\3\2\2\2RP\3\2\2\2SV"+
		"\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7,\2\2XY\7\61\2\2Y"+
		"Z\3\2\2\2Z[\b\f\2\2[\30\3\2\2\2\f\2$&,\62\64=GRT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}