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
		T__0=1, T__1=2, T__2=3, OP1=4, OP2=5, ID=6, FLOAT=7, ALPHA=8, NUM=9, WHITESPACE=10, 
		COMMENT=11, COMMENT2=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "OP1", "OP2", "ID", "FLOAT", "ALPHA", "NUM", 
			"WHITESPACE", "COMMENT", "COMMENT2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "OP1", "OP2", "ID", "FLOAT", "ALPHA", "NUM", 
			"WHITESPACE", "COMMENT", "COMMENT2"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\7\7)\n\7\f\7\16\7,\13\7\3\b\6\b/\n\b\r\b\16\b\60\3\b\3\b\6\b\65\n\b"+
		"\r\b\16\b\66\5\b9\n\b\3\t\3\t\3\n\3\n\3\13\6\13@\n\13\r\13\16\13A\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\7\fJ\n\f\f\f\16\fM\13\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\rW\n\r\f\r\16\rZ\13\r\3\r\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\n\4\2--//\4\2,,\61"+
		"\61\13\2C\\aac|\u00a7\u00a8\u00ba\u00ba\u00c5\u00c5\u02de\u02de\u2022"+
		"\u2022\u2028\u2028\3\2\62;\5\2\13\f\17\17\"\"\3\2\f\f\3\2,,\3\2\61\61"+
		"\2h\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#"+
		"\3\2\2\2\r%\3\2\2\2\17.\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25?\3\2\2\2\27"+
		"E\3\2\2\2\31P\3\2\2\2\33\34\7?\2\2\34\4\3\2\2\2\35\36\7*\2\2\36\6\3\2"+
		"\2\2\37 \7+\2\2 \b\3\2\2\2!\"\t\2\2\2\"\n\3\2\2\2#$\t\3\2\2$\f\3\2\2\2"+
		"%*\5\21\t\2&)\5\21\t\2\')\5\23\n\2(&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3"+
		"\2\2\2*+\3\2\2\2+\16\3\2\2\2,*\3\2\2\2-/\5\23\n\2.-\3\2\2\2/\60\3\2\2"+
		"\2\60.\3\2\2\2\60\61\3\2\2\2\618\3\2\2\2\62\64\7\60\2\2\63\65\5\23\n\2"+
		"\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28"+
		"\62\3\2\2\289\3\2\2\29\20\3\2\2\2:;\t\4\2\2;\22\3\2\2\2<=\t\5\2\2=\24"+
		"\3\2\2\2>@\t\6\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2C"+
		"D\b\13\2\2D\26\3\2\2\2EF\7\61\2\2FG\7\61\2\2GK\3\2\2\2HJ\n\7\2\2IH\3\2"+
		"\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\f\2\2O\30\3"+
		"\2\2\2PQ\7\61\2\2QR\7,\2\2RX\3\2\2\2SW\n\b\2\2TU\7,\2\2UW\n\t\2\2VS\3"+
		"\2\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\"+
		"\7,\2\2\\]\7\61\2\2]^\3\2\2\2^_\b\r\2\2_\32\3\2\2\2\f\2(*\60\668AKVX\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}