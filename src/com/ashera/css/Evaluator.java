/* Evaluator.java */
/* Generated By:JavaCC: Do not edit this line. Evaluator.java */
package com.ashera.css;
import com.ashera.css.CssTree.Attribute;
import com.ashera.parser.css.CssResult;
public class Evaluator implements EvaluatorConstants {
    public static void main(String[] args) throws Exception {
        CssTree cssTree = new CssTree();
        new Evaluator(new java.io.StringReader("@font-face {url: a22; font-weight: normal; } @font-face {url: 222; font-weight: normal; }")).S(cssTree);
        cssTree.getCss("div", "test test1", "test2", new CssResult() {
                        @Override
                        public void put(String key, Attribute value) {
                                System.out.println("key1" + key + value.value);
                        }
                });
    }

  final public void S(CssTree v) throws ParseException {String value;
    label_1:
    while (true) {
      switch (jj_nt.kind) {
      case MEDIA:
      case CSS_VAR:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch (jj_nt.kind) {
      case MEDIA:{
        jj_consume_token(MEDIA);
String gaurdValues = "";
        String gaurdKeys = "";
        label_2:
        while (true) {
          switch (jj_nt.kind) {
          case 17:{
            ;
            break;
            }
          default:
            jj_la1[1] = jj_gen;
            break label_2;
          }
          jj_consume_token(17);
          jj_consume_token(CSS_VAR);
gaurdKeys = gaurdKeys + "," + token.image;
          jj_consume_token(COLON);
          jj_consume_token(CSS_VAR);
gaurdValues = gaurdValues + "," + token.image;
          jj_consume_token(18);
          switch (jj_nt.kind) {
          case AND_TOKEN:{
            jj_consume_token(AND_TOKEN);
            break;
            }
          default:
            jj_la1[2] = jj_gen;
            ;
          }
        }
        jj_consume_token(OPEN_BRACKET);
        label_3:
        while (true) {
          switch (jj_nt.kind) {
          case CSS_VAR:{
            ;
            break;
            }
          default:
            jj_la1[3] = jj_gen;
            break label_3;
          }
          connection(v, gaurdKeys, gaurdValues);
        }
        jj_consume_token(CLOSE_BRACKET);
        break;
        }
      case CSS_VAR:{
        connection(v, "default", "default");
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  }

  final public void connection(CssTree v, String gaurdKeys, String gaurdValues) throws ParseException {
    jj_consume_token(CSS_VAR);
String attributeName = token.image;
    jj_consume_token(OPEN_BRACKET);
    label_4:
    while (true) {
      switch (jj_nt.kind) {
      case CSS_VAR:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      jj_consume_token(CSS_VAR);
String key = token.image;
      jj_consume_token(COLON);
      switch (jj_nt.kind) {
      case CSS_VAR_WHITE_SPACE:{
        jj_consume_token(CSS_VAR_WHITE_SPACE);
        break;
        }
      case CSS_VAR:{
        jj_consume_token(CSS_VAR);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
v.setAttribute(gaurdKeys, gaurdValues, attributeName, key, token.image);
      jj_consume_token(SEMI_COLON);
    }
    jj_consume_token(CLOSE_BRACKET);
v.end();
  }

  /** Generated Token Manager. */
  public EvaluatorTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x820,0x20000,0x40,0x800,0x820,0x800,0x10800,};
   }

  /** Constructor with InputStream. */
  public Evaluator(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Evaluator(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EvaluatorTokenManager(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Evaluator(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new EvaluatorTokenManager(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Evaluator(EvaluatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(EvaluatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    token.next = jj_nt = token_source.getNextToken();
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken = token;
    if ((token = jj_nt).next != null) jj_nt = jj_nt.next;
    else jj_nt = jj_nt.next = token_source.getNextToken();
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    jj_nt = token;
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if ((token = jj_nt).next != null) jj_nt = jj_nt.next;
    else jj_nt = jj_nt.next = token_source.getNextToken();
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[19];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
