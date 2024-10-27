import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;
import exceptions.ErrorCompilacion;

/**
* Analizador léxico - Grupo 4
* 	Brero, Juan - 168557
*  	Ponti, Mateo - 175627
*  	Saracho, Franco Mateo - 182783
*  	Herrneder, Matias - 174264
*  	Romero Monteagudo, Valentín Joel - 190306
*/

%%

%cup
%public
%class Lexico
%line
%column
%char

%{
  // Buffer para almacenar los tokens
  private ArrayList<String> tokens = new ArrayList<>();
  private ArrayList<Lexema> lexemas = new ArrayList<>();

  public ArrayList<String> getTokens(){
    return tokens;
  }

  public ArrayList<Lexema> getLexemas(){
    return lexemas;
  }
%}

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

%%

<YYINITIAL> {

/* Operadores */

    ":="    { tokens.add("OP_DECLA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DECLA", yyline, yycolumn)); }

    "::="   { tokens.add("OP_ASIGN\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_ASIGN", yyline, yycolumn)); }

    "+"     { tokens.add("OP_SUMA\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_SUMA", yyline, yycolumn)); }

    "-"     { tokens.add("OP_RESTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_RESTA", yyline, yycolumn)); }

    "*"     { tokens.add("OP_PROD\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_PROD", yyline, yycolumn)); }

    "/"     { tokens.add("OP_DIV\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DIV", yyline, yycolumn)); }

    "&&"    { tokens.add("OP_AND\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_AND", yyline, yycolumn)); }

    "||"    { tokens.add("OP_OR\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_OR", yyline, yycolumn)); }

    "!"     { tokens.add("OP_NOT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_NOT", yyline, yycolumn)); }

/* Operadores condicionales */

    "=="    { tokens.add("COND_IGUAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_IGUAL", yyline, yycolumn)); }

    "<>"    { tokens.add("COND_DIST\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_DIST", yyline, yycolumn)); }

    ">"     { tokens.add("COND_MAYOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYOR", yyline, yycolumn)); }

    "<"     { tokens.add("COND_MENOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENOR", yyline, yycolumn)); }

    ">="    { tokens.add("COND_MAYORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYORI", yyline, yycolumn)); }

    "<="    { tokens.add("COND_MENORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENORI", yyline, yycolumn)); }

/* Palabras reservadas */

    "while"                 { tokens.add("CL_WHILE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CL_WHILE", yyline, yycolumn)); }

    "if"                    { tokens.add("DECL_IF\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_IF", yyline, yycolumn)); }

    "else if"               { tokens.add("DECL_ELIF\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELIF", yyline, yycolumn)); }

    "else"                  { tokens.add("DECL_ELSE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELSE", yyline, yycolumn)); }

    "write"                 { tokens.add("OUTPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "OUTPUT", yyline, yycolumn)); }

    "return"                { tokens.add("RETURN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "RETURN", yyline, yycolumn)); }

    "DECLARE.SECTION"       { tokens.add("ABRIR_DECLA\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_DECLA", yyline, yycolumn)); }

    "ENDDECLARE.SECTION"    { tokens.add("CERRAR_DECLA\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_DECLA", yyline, yycolumn)); }

    "PROGRAM.SECTION"       { tokens.add("ABRIR_PROG\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_PROG", yyline, yycolumn)); }

    "ENDPROGRAM.SECTION"    { tokens.add("CERRAR_PROG\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_PROG", yyline, yycolumn)); }

    "countDistinct"         { tokens.add("FUNC_COUNTDISTINCT\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "FUNC_COUNTDISTINCT", yyline, yycolumn)); }


/* Miscelaneos */

    "["     { tokens.add("ABRIR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_LISTA", yyline, yycolumn)); }

    "]"     { tokens.add("CERRAR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_LISTA", yyline, yycolumn)); }

    "("     { tokens.add("ABRIR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_COND", yyline, yycolumn)); }

    ")"     { tokens.add("CERRAR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_COND", yyline, yycolumn)); }

    "{"     { tokens.add("ABRIR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_BLOQUE", yyline, yycolumn)); }

    "}"     { tokens.add("CERRAR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_BLOQUE", yyline, yycolumn)); }

    ";"     { tokens.add("TOK_EOI\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_EOI", yyline, yycolumn));}

    ","     { tokens.add("TOK_SEP\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_SEP", yyline, yycolumn));}

    "::"    { tokens.add("TOK_DOSP\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_DOSP", yyline, yycolumn));}

/* Tipos de datos */

    "int"       { tokens.add("TYPE_INT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_INT", yyline, yycolumn)); }

    "float"     { tokens.add("TYPE_FLOAT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_FLOAT", yyline, yycolumn)); }

    "string"    { tokens.add("TYPE_STR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_STR", yyline, yycolumn)); }

/* Regex */

    {ID}            {
                        try {
                            tokens.add("ID\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                            lexemas.add(new Lexema(yytext(), "ID", true, yyline, yycolumn));
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_INT}       {
                        try {
                            tokens.add("CTE_INT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                            lexemas.add(new Lexema(yytext(), "CTE_INT", true, yyline, yycolumn));
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {NUMERICO}      {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFABETICO}    {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFANUM}       {/* No se realiza accion por lo tanto se ignoran*/}

    {CTE_BIN}       {
                        try {
                            tokens.add("CTE_BIN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                            lexemas.add(new Lexema(yytext(), "CTE_BIN", true, yyline, yycolumn));
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_REAL}      {
                        try {
                            tokens.add("CTE_REAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                            lexemas.add(new Lexema(yytext(), "CTE_REAL", true, yyline, yycolumn));
                        } catch (ErrorCompilacion e) {
                             throw new RuntimeException(e);
                        }
                    }

    {CTE_STRING}    {
                        try {
                            tokens.add("CTE_STRING\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                            lexemas.add(new Lexema(yytext(), "CTE_STRING", true, yyline, yycolumn));
                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {ESPACIO}       {/* No se realiza accion por lo tanto se ignoran*/}

    {COMENTARIOS}   {/* No se realiza accion por lo tanto se ignoran*/}
}

  [^]     { tokens.add("Illegal character <" + yytext() + "> \t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
            throw new RuntimeException("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);}