/* The following code was generated by JFlex 1.7.0 */

import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;

/**
* Analizador léxico - Grupo 4
* 	Brero, Juan - 168557
*  	Ponti, Mateo - 175627
*  	Saracho, Franco Mateo - 182783
*  	Herrneder, Matias - 174264
*  	Romero Monteagudo, Valentín Joel - 190306
*/


public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\13\1\15\2\13\1\14\22\0\1\12\1\26\1\10\3\0"+
    "\1\24\1\7\1\70\1\71\1\17\1\22\1\75\1\23\1\6\1\16"+
    "\1\3\1\5\10\2\1\20\1\74\1\27\1\21\1\30\2\0\1\52"+
    "\1\1\1\50\1\46\1\47\1\1\1\62\1\1\1\56\2\1\1\51"+
    "\1\63\1\60\1\57\1\61\1\1\1\53\1\54\1\55\6\1\1\66"+
    "\1\0\1\67\1\0\1\11\1\0\1\42\1\4\1\64\1\43\1\35"+
    "\1\36\1\76\1\32\1\33\2\1\1\34\1\1\1\45\1\65\2\1"+
    "\1\40\1\37\1\41\1\44\1\1\1\31\3\1\1\72\1\25\1\73"+
    "\7\0\1\13\32\0\1\13\u15df\0\1\13\u097f\0\13\13\35\0\2\13"+
    "\5\0\1\13\57\0\1\13\u0fa0\0\1\13\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\ud00f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\3\1\2\4\1\5\1\6"+
    "\2\1\1\7\1\10\2\1\1\11\1\12\1\13\12\2"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\2\1\24\2\0\1\25\1\0\1\26\1\0\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\2\2"+
    "\1\37\12\2\1\40\1\0\1\41\2\2\1\42\14\2"+
    "\1\43\3\2\1\44\4\2\1\45\1\2\1\46\1\47"+
    "\1\0\1\50\7\2\1\0\1\51\1\52\5\2\1\53"+
    "\5\2\1\0\2\2\1\0\1\2\1\0\2\2\1\0"+
    "\1\2\1\0\2\2\1\0\1\2\4\0\1\2\4\0"+
    "\1\2\4\0\1\54\4\0\1\55\2\0\1\56\4\0"+
    "\1\57\1\60";

  private static int [] zzUnpackAction() {
    int [] result = new int[166];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\77\0\176\0\275\0\374\0\u013b\0\u017a\0\u01b9"+
    "\0\77\0\u01f8\0\u0237\0\77\0\u0276\0\u02b5\0\77\0\77"+
    "\0\u02f4\0\u0333\0\77\0\u0372\0\u03b1\0\u03f0\0\u042f\0\u046e"+
    "\0\u04ad\0\u04ec\0\u052b\0\u056a\0\u05a9\0\u05e8\0\u0627\0\77"+
    "\0\77\0\77\0\77\0\77\0\77\0\77\0\77\0\u0666"+
    "\0\u013b\0\u06a5\0\u06e4\0\77\0\u01b9\0\77\0\u0723\0\u0762"+
    "\0\77\0\77\0\77\0\77\0\77\0\77\0\77\0\u07a1"+
    "\0\u07e0\0\176\0\u081f\0\u085e\0\u089d\0\u08dc\0\u091b\0\u095a"+
    "\0\u0999\0\u09d8\0\u0a17\0\u0a56\0\u06a5\0\u0a95\0\77\0\u0ad4"+
    "\0\u0b13\0\176\0\u0b52\0\u0b91\0\u0bd0\0\u0c0f\0\u0c4e\0\u0c8d"+
    "\0\u0ccc\0\u0d0b\0\u0d4a\0\u0d89\0\u0dc8\0\u0e07\0\u0e46\0\u0e85"+
    "\0\u0ec4\0\u0f03\0\176\0\u0f42\0\u0f81\0\u0fc0\0\u0fff\0\176"+
    "\0\u103e\0\176\0\176\0\u107d\0\176\0\u10bc\0\u10fb\0\u113a"+
    "\0\u1179\0\u11b8\0\u11f7\0\u1236\0\u1275\0\176\0\176\0\u12b4"+
    "\0\u12f3\0\u1332\0\u1371\0\u13b0\0\77\0\u13ef\0\u142e\0\u146d"+
    "\0\u14ac\0\u14eb\0\u152a\0\u1569\0\u15a8\0\u15e7\0\u1626\0\u1665"+
    "\0\u16a4\0\u16e3\0\u1722\0\u1761\0\u17a0\0\u17df\0\u181e\0\u185d"+
    "\0\u189c\0\u18db\0\u191a\0\u1959\0\u1998\0\u19d7\0\u1a16\0\u1a55"+
    "\0\u1a94\0\u1ad3\0\u1b12\0\u1b51\0\u1b90\0\u1bcf\0\u1c0e\0\176"+
    "\0\u1c4d\0\u1c8c\0\u1ccb\0\u1d0a\0\77\0\u1d49\0\u1d88\0\77"+
    "\0\u1dc7\0\u1e06\0\u1e45\0\u1e84\0\77\0\77";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[166];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\3\1\4\1\6\1\7"+
    "\1\10\1\2\2\11\1\12\1\11\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\3\1\27\1\3\1\30\1\31\1\32\1\33"+
    "\5\3\1\34\1\35\11\3\1\36\2\3\1\37\1\3"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\3\100\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\35\3\10\0\1\3\2\0\2\4\1\0\1\4"+
    "\1\51\72\0\2\4\1\52\1\4\1\51\72\0\2\51"+
    "\1\0\1\51\72\0\5\53\1\0\1\54\21\0\35\53"+
    "\10\0\1\53\1\0\5\55\2\0\1\56\20\0\35\55"+
    "\10\0\1\55\15\0\1\11\100\0\1\57\77\0\1\60"+
    "\1\61\76\0\1\62\101\0\1\63\77\0\1\64\72\0"+
    "\1\65\6\0\1\66\67\0\1\67\56\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\1\3\1\70\5\3"+
    "\1\71\25\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\5\3\1\72\6\3\1\73"+
    "\20\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\3\3\1\74\31\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\3\3\1\75\31\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\10\3\1\76\24\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\4\3\1\77\30\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\16\3"+
    "\1\100\16\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\27\3\1\101\5\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\22\3\1\102\12\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\1\3\1\103"+
    "\32\3\1\104\10\0\1\3\1\0\5\50\23\0\35\50"+
    "\10\0\1\50\3\0\1\105\1\0\1\105\100\0\1\54"+
    "\70\0\5\57\4\0\4\57\1\0\1\106\11\0\35\57"+
    "\10\0\1\57\21\0\1\107\56\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\2\3\1\110\32\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\2\3\1\111\32\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\10\3\1\112"+
    "\24\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\6\3\1\113\26\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\34\3\1\114\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\7\3\1\115\25\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\10\3\1\116\1\117\23\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\17\3"+
    "\1\120\15\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\15\3\1\121\17\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\26\3\1\122\6\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\11\3\1\123"+
    "\23\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\13\3\1\124\21\3\10\0\1\3"+
    "\16\0\1\11\61\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\3\3\1\125\31\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\10\3"+
    "\1\126\24\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\4\3\1\127\30\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\11\3\1\130\23\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\2\3\1\131"+
    "\32\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\13\3\1\132\21\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\12\3\1\133\22\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\20\3\1\134\14\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\15\3\1\135\12\3\1\136\4\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\31\3\1\137\3\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\7\3\1\140"+
    "\25\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\14\3\1\141\20\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\4\3\1\142\30\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\4\3\1\143\30\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\1\144\16\0\35\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\10\3\1\145"+
    "\24\3\10\0\1\3\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\14\3\1\146\20\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\7\3\1\147\25\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\21\3\1\150\13\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\16\3\1\151\16\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\22\3"+
    "\1\152\12\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\22\3\1\153\12\3\10\0"+
    "\1\3\1\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\10\3\1\154\24\3\10\0\1\3\33\0\1\155"+
    "\44\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\35\3\10\0\1\156\1\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\14\3\1\157\20\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\22\3\1\160\12\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\17\3\1\161\15\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\26\3\1\162\6\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\21\3"+
    "\1\163\13\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\15\3\1\164\17\3\10\0"+
    "\1\3\36\0\1\165\41\0\1\3\2\50\1\3\1\50"+
    "\3\0\1\50\17\0\16\3\1\166\16\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\20\3\1\167\14\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\31\3\1\170\3\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\32\3\1\171\2\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\2\3"+
    "\1\172\32\3\10\0\1\3\1\0\1\3\2\50\1\3"+
    "\1\50\1\173\2\0\1\50\17\0\35\3\10\0\1\3"+
    "\1\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\21\3\1\174\13\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\22\3\1\175\12\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\1\176"+
    "\2\0\1\50\17\0\35\3\10\0\1\3\1\0\1\3"+
    "\2\50\1\3\1\50\3\0\1\50\17\0\6\3\1\177"+
    "\26\3\10\0\1\3\54\0\1\200\23\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\22\3\1\201\12\3"+
    "\10\0\1\3\1\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\21\3\1\202\13\3\10\0\1\3\54\0"+
    "\1\203\23\0\1\3\2\50\1\3\1\50\3\0\1\50"+
    "\17\0\10\3\1\204\24\3\10\0\1\3\47\0\1\205"+
    "\30\0\1\3\2\50\1\3\1\50\3\0\1\50\17\0"+
    "\16\3\1\206\16\3\10\0\1\3\1\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\32\3\1\207\2\3"+
    "\10\0\1\3\47\0\1\210\30\0\1\3\2\50\1\3"+
    "\1\50\3\0\1\50\17\0\2\3\1\211\32\3\10\0"+
    "\1\3\50\0\1\212\27\0\1\3\2\50\1\3\1\50"+
    "\1\213\2\0\1\50\17\0\35\3\10\0\1\3\1\0"+
    "\1\3\2\50\1\3\1\50\1\214\2\0\1\50\17\0"+
    "\35\3\10\0\1\3\50\0\1\215\27\0\1\3\2\50"+
    "\1\3\1\50\3\0\1\50\17\0\14\3\1\216\20\3"+
    "\10\0\1\3\55\0\1\217\75\0\1\220\76\0\1\221"+
    "\77\0\1\222\22\0\1\3\2\50\1\3\1\50\3\0"+
    "\1\50\17\0\33\3\1\223\1\3\10\0\1\3\56\0"+
    "\1\224\67\0\1\225\76\0\1\226\105\0\1\227\21\0"+
    "\1\3\2\50\1\3\1\50\3\0\1\50\17\0\10\3"+
    "\1\230\24\3\10\0\1\3\57\0\1\231\67\0\1\232"+
    "\76\0\1\233\105\0\1\234\77\0\1\235\73\0\1\236"+
    "\76\0\1\237\101\0\1\240\74\0\1\241\76\0\1\242"+
    "\77\0\1\243\76\0\1\244\77\0\1\245\76\0\1\246"+
    "\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7875];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\6\1\1\11\2\1\1\11\2\1\2\11"+
    "\2\1\1\11\14\1\10\11\2\1\2\0\1\11\1\0"+
    "\1\11\1\0\1\1\7\11\16\1\1\0\1\11\34\1"+
    "\1\0\10\1\1\0\7\1\1\11\5\1\1\0\2\1"+
    "\1\0\1\1\1\0\2\1\1\0\1\1\1\0\2\1"+
    "\1\0\1\1\4\0\1\1\4\0\1\1\4\0\1\1"+
    "\4\0\1\11\2\0\1\11\4\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[166];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  // Buffer para almacenar los tokens
  private ArrayList<String> tokens = new ArrayList<>();
  private ArrayList<Lexema> lexemas = new ArrayList<>();

  public ArrayList<String> getTokens(){
    return tokens;
  }

  public ArrayList<Lexema> getLexemas(){
    return lexemas;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 226) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { tokens.add("Illegal character <" + yytext() + "> \t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
            System.err.println("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);
            } 
            // fall through
          case 49: break;
          case 2: 
            { tokens.add("ID\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "ID"));
            } 
            // fall through
          case 50: break;
          case 3: 
            { tokens.add("CTE_INT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_INT", true));
            } 
            // fall through
          case 51: break;
          case 4: 
            { /* No se realiza accion por lo tanto se ignoran*/
            } 
            // fall through
          case 52: break;
          case 5: 
            { tokens.add("OP_DIV\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DIV"));
            } 
            // fall through
          case 53: break;
          case 6: 
            { tokens.add("OP_PROD\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_PROD"));
            } 
            // fall through
          case 54: break;
          case 7: 
            { tokens.add("OP_SUMA\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_SUMA"));
            } 
            // fall through
          case 55: break;
          case 8: 
            { tokens.add("OP_RESTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_RESTA"));
            } 
            // fall through
          case 56: break;
          case 9: 
            { tokens.add("OP_NOT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_NOT"));
            } 
            // fall through
          case 57: break;
          case 10: 
            { tokens.add("COND_MENOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENOR"));
            } 
            // fall through
          case 58: break;
          case 11: 
            { tokens.add("COND_MAYOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYOR"));
            } 
            // fall through
          case 59: break;
          case 12: 
            { tokens.add("ABRIR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_LISTA"));
            } 
            // fall through
          case 60: break;
          case 13: 
            { tokens.add("CERRAR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_LISTA"));
            } 
            // fall through
          case 61: break;
          case 14: 
            { tokens.add("ABRIR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_COND"));
            } 
            // fall through
          case 62: break;
          case 15: 
            { tokens.add("CERRAR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_COND"));
            } 
            // fall through
          case 63: break;
          case 16: 
            { tokens.add("ABRIR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_BLOQUE"));
            } 
            // fall through
          case 64: break;
          case 17: 
            { tokens.add("CERRAR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_BLOQUE"));
            } 
            // fall through
          case 65: break;
          case 18: 
            { tokens.add("TOK_EOI\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_EOI"));
            } 
            // fall through
          case 66: break;
          case 19: 
            { tokens.add("TOK_SEP\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_SEP"));
            } 
            // fall through
          case 67: break;
          case 20: 
            { tokens.add("CTE_REAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_REAL", true));
            } 
            // fall through
          case 68: break;
          case 21: 
            { tokens.add("CTE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_CHAR", true));
            } 
            // fall through
          case 69: break;
          case 22: 
            { tokens.add("CTE_STRING\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_STRING", true));
            } 
            // fall through
          case 70: break;
          case 23: 
            { tokens.add("TOK_DOSP\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_DOSP"));
            } 
            // fall through
          case 71: break;
          case 24: 
            { tokens.add("OP_DECLA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DECLA"));
            } 
            // fall through
          case 72: break;
          case 25: 
            { tokens.add("COND_IGUAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_IGUAL"));
            } 
            // fall through
          case 73: break;
          case 26: 
            { tokens.add("OP_AND\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_AND"));
            } 
            // fall through
          case 74: break;
          case 27: 
            { tokens.add("OP_OR\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_OR"));
            } 
            // fall through
          case 75: break;
          case 28: 
            { tokens.add("COND_MENORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENORI"));
            } 
            // fall through
          case 76: break;
          case 29: 
            { tokens.add("COND_DIST\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_DIST"));
            } 
            // fall through
          case 77: break;
          case 30: 
            { tokens.add("COND_MAYORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYORI"));
            } 
            // fall through
          case 78: break;
          case 31: 
            { tokens.add("DECL_IF\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_IF"));
            } 
            // fall through
          case 79: break;
          case 32: 
            { tokens.add("CTE_BIN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_BIN", true));
            } 
            // fall through
          case 80: break;
          case 33: 
            { tokens.add("OP_ASIGN\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_ASIGN"));
            } 
            // fall through
          case 81: break;
          case 34: 
            { tokens.add("TYPE_INT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_INT"));
            } 
            // fall through
          case 82: break;
          case 35: 
            { tokens.add("DECL_ELSE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELSE"));
            } 
            // fall through
          case 83: break;
          case 36: 
            { tokens.add("INPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "INPUT"));
            } 
            // fall through
          case 84: break;
          case 37: 
            { tokens.add("TYPE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_CHAR"));
            } 
            // fall through
          case 85: break;
          case 38: 
            { tokens.add("CL_WHILE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CL_WHILE"));
            } 
            // fall through
          case 86: break;
          case 39: 
            { tokens.add("OUTPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "OUTPUT"));
            } 
            // fall through
          case 87: break;
          case 40: 
            { tokens.add("TYPE_FLOAT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_FLOAT"));
            } 
            // fall through
          case 88: break;
          case 41: 
            { tokens.add("TYPE_STR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_STR"));
            } 
            // fall through
          case 89: break;
          case 42: 
            { tokens.add("RETURN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "RETURN"));
            } 
            // fall through
          case 90: break;
          case 43: 
            { tokens.add("DECL_ELIF\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELIF"));
            } 
            // fall through
          case 91: break;
          case 44: 
            { tokens.add("FUNC_COUNTDISTINCT\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "FUNC_COUNTDISTINCT"));
            } 
            // fall through
          case 92: break;
          case 45: 
            { tokens.add("ABRIR_DECLA\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_DECLA"));
            } 
            // fall through
          case 93: break;
          case 46: 
            { tokens.add("ABRIR_PROG\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_PROG"));
            } 
            // fall through
          case 94: break;
          case 47: 
            { tokens.add("CERRAR_DECLA\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_DECLA"));
            } 
            // fall through
          case 95: break;
          case 48: 
            { tokens.add("CERRAR_PROG\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_PROG"));
            } 
            // fall through
          case 96: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
