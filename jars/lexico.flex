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
    ESPACIO     = ((" ")|(\s|\r|\n|\r\n|\t))

/* Constantes */

    CTE_BIN     = "0b"(0|1)+
    CTE_INT     = {NUMERICO}+
    CTE_REAL    = ({NUMERICO}*("."){NUMERICO}+)|({NUMERICO}+("."){NUMERICO}*)
    CTE_CHAR    = ("'"){ALFANUM}?("'")
    CTE_STRING  = "\""({ALFANUM}|{ESPECIAL}|{ESPACIO})*"\""

/* Miscelaneos */

    ID          = {ALFABETICO}+("_"|{ALFANUM}*){ALFANUM}*
    COMENTARIOS = ("/*")({ALFANUM}|{ESPACIO}|{ESPECIAL})*("*/")

%%

<YYINITIAL> {

/* Operadores */

    ":="    { tokens.add("OP_DECLA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DECLA")); }

    "::="   { tokens.add("OP_ASIGN\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_ASIGN")); }

    "+"     { tokens.add("OP_SUMA\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_SUMA")); }

    "-"     { tokens.add("OP_RESTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_RESTA")); }

    "*"     { tokens.add("OP_PROD\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_PROD")); }

    "/"     { tokens.add("OP_DIV\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_DIV")); }

    "&&"    { tokens.add("OP_AND\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_AND")); }

    "||"    { tokens.add("OP_OR\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_OR")); }

    "!"     { tokens.add("OP_NOT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "OP_NOT")); }

/* Operadores condicionales */

    "=="    { tokens.add("COND_IGUAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_IGUAL")); }

    "<>"    { tokens.add("COND_DIST\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_DIST")); }

    ">"     { tokens.add("COND_MAYOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYOR")); }

    "<"     { tokens.add("COND_MENOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENOR")); }

    ">="    { tokens.add("COND_MAYORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MAYORI")); }

    "<="    { tokens.add("COND_MENORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "COND_MENORI")); }

/* Palabras reservadas */

    "while"                 { tokens.add("CL_WHILE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CL_WHILE")); }

    "if"                    { tokens.add("DECL_IF\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_IF")); }

    "else if"               { tokens.add("DECL_ELIF\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELIF")); }

    "else"                  { tokens.add("DECL_ELSE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "DECL_ELSE")); }

    "write"                 { tokens.add("OUTPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "OUTPUT")); }

    "read"                  { tokens.add("INPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "INPUT")); }

    "return"                { tokens.add("RETURN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "RETURN")); }

    "DECLARE.SECTION"       { tokens.add("ABRIR_DECLA\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_DECLA")); }

    "ENDDECLARE.SECTION"    { tokens.add("CERRAR_DECLA\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_DECLA")); }

    "PROGRAM.SECTION"       { tokens.add("ABRIR_PROG\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "ABRIR_PROG")); }

    "ENDPROGRAM.SECTION"    { tokens.add("CERRAR_PROG\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "CERRAR_PROG")); }

    "countDistinct"         { tokens.add("FUNC_COUNTDISTINCT\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn);
                              lexemas.add(new Lexema(yytext(), "FUNC_COUNTDISTINCT")); }


/* Miscelaneos */

    "["     { tokens.add("ABRIR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_LISTA")); }

    "]"     { tokens.add("CERRAR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_LISTA")); }

    "("     { tokens.add("ABRIR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_COND")); }

    ")"     { tokens.add("CERRAR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_COND")); }

    "{"     { tokens.add("ABRIR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "ABRIR_BLOQUE")); }

    "}"     { tokens.add("CERRAR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "CERRAR_BLOQUE")); }

    ";"     { tokens.add("TOK_EOI\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_EOI"));}

    ","     { tokens.add("TOK_SEP\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_SEP"));}

    "::"    { tokens.add("TOK_DOSP\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
              lexemas.add(new Lexema(yytext(), "TOK_DOSP"));}

/* Tipos de datos */

    "int"       { tokens.add("TYPE_INT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_INT")); }

    "float"     { tokens.add("TYPE_FLOAT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_FLOAT")); }

    "char"      { tokens.add("TYPE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_CHAR")); }

    "string"    { tokens.add("TYPE_STR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                  lexemas.add(new Lexema(yytext(), "TYPE_STR")); }

/* Regex */

    {ID}            { tokens.add("ID\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "ID"));}

    {CTE_INT}       { tokens.add("CTE_INT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_INT", true)); }

    {NUMERICO}      {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFABETICO}    {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFANUM}       {/* No se realiza accion por lo tanto se ignoran*/}

    {CTE_BIN}       { tokens.add("CTE_BIN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_BIN", true)); }

    {CTE_REAL}      { tokens.add("CTE_REAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_REAL", true)); }

    {CTE_CHAR}      { tokens.add("CTE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_CHAR", true)); }

    {CTE_STRING}    { tokens.add("CTE_STRING\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
                      lexemas.add(new Lexema(yytext(), "CTE_STRING", true)); }

    {ESPACIO}       {/* No se realiza accion por lo tanto se ignoran*/}

    {ESPECIAL}      {/* No se realiza accion por lo tanto se ignoran*/}

    {COMENTARIOS}   {/* No se realiza accion por lo tanto se ignoran*/}

}

  [^]     { tokens.add("Illegal character <" + yytext() + "> \t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
            System.err.println("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);}