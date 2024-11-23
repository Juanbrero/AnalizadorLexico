import java_cup.runtime.*;
import java.util.ArrayList;
import exceptions.ErrorCompilacion;
import representaciones.Lexema;

/**
* Analizador léxico - Grupo 4
* 	Brero, Juan - 168557
*  	Ponti, Mateo - 175627
*  	Saracho, Franco Mateo - 182783
*  	Herrneder, Matias - 174264
*  	Romero Monteagudo, Valentín Joel - 190306
*/

%%
%public
%class Lexico
%cup
%full
%line
%column
%char

/* Alfabetos */

    ALFABETICO  = [a-zA-Z]
    NUMERICO    = [0-9]
    ALFANUM     = ({ALFABETICO}|{NUMERICO})
    ESPECIAL    = [|!#$%&/\()=?¿¡.,:;+=-@*]
    ESPACIO     = [ \s\r\n\r\n\t]

/* Constantes */

    CTE_BIN     = "0b"(0|1)+
    CTE_INT     = {NUMERICO}+
    CTE_REAL    = ({NUMERICO}*("."){NUMERICO}+)|({NUMERICO}+("."){NUMERICO}*)
    CTE_STRING  = ("\"")({ALFANUM}|{ESPECIAL}|{ESPACIO})*("\"")

/* Miscelaneos */

    ID          = {ALFABETICO}+("_"|{ALFANUM}*){ALFANUM}*
    COMENTARIOS = ("//*")({ALFANUM}|{ESPACIO}|{ESPECIAL})*("*//")

%{
    private ArrayList<Lexema> lexemas = new ArrayList<>();

    private Symbol symbol (int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol (int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    public ArrayList<Lexema> getLexemas(){
        return lexemas;
    }
%}

%%

<YYINITIAL> {

/* Operadores */

    ":="    { lexemas.add(new Lexema(yytext(), "OP_DECLA", yyline, yycolumn)); return new Symbol(sym.OP_DECLA, yychar, yyline, yytext()); }


    "::="   { lexemas.add(new Lexema(yytext(), "OP_ASIGN", yyline, yycolumn)); return new Symbol(sym.OP_ASIGN, yychar, yyline, yytext()); }


    "+"     { lexemas.add(new Lexema(yytext(), "OP_SUMA", yyline, yycolumn)); return new Symbol(sym.OP_SUMA, yychar, yyline, yytext());}


    "-"     { lexemas.add(new Lexema(yytext(), "OP_RESTA", yyline, yycolumn)); return new Symbol(sym.OP_RESTA, yychar, yyline, yytext());}


    "*"     { lexemas.add(new Lexema(yytext(), "OP_PROD", yyline, yycolumn)); return new Symbol(sym.OP_PROD, yychar, yyline, yytext());}


    "/"     { lexemas.add(new Lexema(yytext(), "OP_DIV", yyline, yycolumn)); return new Symbol(sym.OP_DIV, yychar, yyline, yytext());}


    "&&"    { lexemas.add(new Lexema(yytext(), "OP_AND", yyline, yycolumn)); return new Symbol(sym.OP_AND, yychar, yyline, yytext());}


    "||"    { lexemas.add(new Lexema(yytext(), "OP_OR", yyline, yycolumn)); return new Symbol(sym.OP_OR, yychar, yyline, yytext());}


    "!"     { lexemas.add(new Lexema(yytext(), "OP_NOT", yyline, yycolumn)); return new Symbol(sym.OP_NOT, yychar, yyline, yytext());}


/* Operadores condicionales */

    "=="    { lexemas.add(new Lexema(yytext(), "COND_IGUAL", yyline, yycolumn));  return new Symbol(sym.COND_IGUAL, yychar, yyline, yytext());}


    "<>"    { lexemas.add(new Lexema(yytext(), "COND_DIST", yyline, yycolumn));  return new Symbol(sym.COND_DIST, yychar, yyline, yytext());}


    ">"     { lexemas.add(new Lexema(yytext(), "COND_MAYOR", yyline, yycolumn)); return new Symbol(sym.COND_MAYOR, yychar, yyline, yytext());}


    "<"     { lexemas.add(new Lexema(yytext(), "COND_MENOR", yyline, yycolumn)); return new Symbol(sym.COND_MENOR, yychar, yyline, yytext());}


    ">="    { lexemas.add(new Lexema(yytext(), "COND_MAYORI", yyline, yycolumn)); return new Symbol(sym.COND_MAYORI, yychar, yyline, yytext());}


    "<="    { lexemas.add(new Lexema(yytext(), "COND_MENORI", yyline, yycolumn)); return new Symbol(sym.COND_MENORI, yychar, yyline, yytext());}


/* Palabras reservadas */

    "while"                { lexemas.add(new Lexema(yytext(), "CL_WHILE", yyline, yycolumn)); return new Symbol(sym.CL_WHILE, yychar, yyline, yytext());}


    "if"                   { lexemas.add(new Lexema(yytext(), "DECL_IF", yyline, yycolumn)); return new Symbol(sym.DECL_IF, yychar, yyline, yytext());}


    "else if"              { lexemas.add(new Lexema(yytext(), "DECL_ELIF", yyline, yycolumn)); return new Symbol(sym.DECL_ELIF, yychar, yyline, yytext());}


    "else"                 { lexemas.add(new Lexema(yytext(), "DECL_ELSE", yyline, yycolumn)); return new Symbol(sym.DECL_ELSE, yychar, yyline, yytext());}


    "write"                { lexemas.add(new Lexema(yytext(), "OUTPUT", yyline, yycolumn)); return new Symbol(sym.OUTPUT, yychar, yyline, yytext());}


    "return"               { lexemas.add(new Lexema(yytext(), "RETURN", yyline, yycolumn)); return new Symbol(sym.RETURN, yychar, yyline, yytext());}


    "DECLARE.SECTION"      { lexemas.add(new Lexema(yytext(), "ABRIR_DECLA", yyline, yycolumn)); return new Symbol(sym.ABRIR_DECLA, yychar, yyline, yytext());}


    "ENDDECLARE.SECTION"   { lexemas.add(new Lexema(yytext(), "CERRAR_DECLA", yyline, yycolumn)); return new Symbol(sym.CERRAR_DECLA, yychar, yyline, yytext());}


    "PROGRAM.SECTION"      { lexemas.add(new Lexema(yytext(), "ABRIR_PROG", yyline, yycolumn));  return new Symbol(sym.ABRIR_PROG, yychar, yyline, yytext());}


    "ENDPROGRAM.SECTION"   { lexemas.add(new Lexema(yytext(), "CERRAR_PROG", yyline, yycolumn)); return new Symbol(sym.CERRAR_PROG, yychar, yyline, yytext());}


    "countDistinct"        { lexemas.add(new Lexema(yytext(), "FUNC_COUNTDISTINCT", yyline, yycolumn)); return new Symbol(sym.FUNC_COUNTDISTINCT, yychar, yyline, yytext());}


/* Miscelaneos */

    "["     { lexemas.add(new Lexema(yytext(), "ABRIR_LISTA", yyline, yycolumn)); return new Symbol(sym.ABRIR_LISTA, yychar, yyline, yytext());}


    "]"     { lexemas.add(new Lexema(yytext(), "CERRAR_LISTA", yyline, yycolumn)); return new Symbol(sym.CERRAR_LISTA, yychar, yyline, yytext());}


    "("     { lexemas.add(new Lexema(yytext(), "ABRIR_COND", yyline, yycolumn)); return new Symbol(sym.ABRIR_COND, yychar, yyline, yytext());}


    ")"     { lexemas.add(new Lexema(yytext(), "CERRAR_COND", yyline, yycolumn)); return new Symbol(sym.CERRAR_COND, yychar, yyline, yytext());}


    "{"     { lexemas.add(new Lexema(yytext(), "ABRIR_BLOQUE", yyline, yycolumn)); return new Symbol(sym.ABRIR_BLOQUE, yychar, yyline, yytext());}


    "}"     { lexemas.add(new Lexema(yytext(), "CERRAR_BLOQUE", yyline, yycolumn)); return new Symbol(sym.CERRAR_BLOQUE, yychar, yyline, yytext());}


    ";"     { lexemas.add(new Lexema(yytext(), "TOK_EOI", yyline, yycolumn)); return new Symbol(sym.TOK_EOI, yychar, yyline, yytext());}


    ","     { lexemas.add(new Lexema(yytext(), "TOK_SEP", yyline, yycolumn)); return new Symbol(sym.TOK_SEP, yychar, yyline, yytext());}


    "::"    { lexemas.add(new Lexema(yytext(), "TOK_DOSP", yyline, yycolumn)); return new Symbol(sym.TOK_DOSP, yychar, yyline, yytext());}


/* Tipos de datos */

    "int"       { lexemas.add(new Lexema(yytext(), "TYPE_INT", yyline, yycolumn)); return new Symbol(sym.TYPE_INT, yychar, yyline, yytext());}


    "float"     { lexemas.add(new Lexema(yytext(), "TYPE_FLOAT", yyline, yycolumn)); return new Symbol(sym.TYPE_FLOAT, yychar, yyline, yytext());}


    "string"    { lexemas.add(new Lexema(yytext(), "TYPE_STR", yyline, yycolumn)); return new Symbol(sym.TYPE_STR, yychar, yyline, yytext());}


/* Regex */

    {ID}            {
                        try {
                            lexemas.add(new Lexema(yytext(), "ID", true, yyline, yycolumn));
                            return new Symbol(sym.ID, yychar, yyline, yytext());
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_INT}       {
                        try {
                            lexemas.add(new Lexema(yytext(), "CTE_INT", true, yyline, yycolumn));
                            return new Symbol(sym.CTE_INT, yychar, yyline, yytext());
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {NUMERICO}      {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFABETICO}    {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFANUM}       {/* No se realiza accion por lo tanto se ignoran*/}

    {CTE_BIN}       {
                        try {
                            lexemas.add(new Lexema(yytext(), "CTE_BIN", true, yyline, yycolumn));
                            return new Symbol(sym.CTE_BIN, yychar, yyline, yytext());
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_REAL}      {
                        try {
                            lexemas.add(new Lexema(yytext(), "CTE_REAL", true, yyline, yycolumn));
                            return new Symbol(sym.CTE_REAL, yychar, yyline, yytext());
                        } catch (ErrorCompilacion e) {
                             throw new RuntimeException(e);
                        }
                    }

    {CTE_STRING}    {
                        try {
                            lexemas.add(new Lexema(yytext(), "CTE_STRING", true, yyline, yycolumn));
                            return new Symbol(sym.CTE_STRING, yychar, yyline, yytext());
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {ESPACIO}       {/* No se realiza accion por lo tanto se ignoran*/}

    {COMENTARIOS}   {/* No se realiza accion por lo tanto se ignoran*/}
}

  [^]     { throw new RuntimeException("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);}