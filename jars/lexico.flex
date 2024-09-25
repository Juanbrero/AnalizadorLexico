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

  public ArrayList<String> getTokens(){
    return tokens;
  }
%}

/* Alfabetos */

    ALFABETICO  = [a-zA-Z]
    NUMERICO    = [0-9]
    ALFANUM     = ({ALFABETICO}|{NUMERICO})

/* Constantes */

    CTE_BIN     = "0b"(0|1)+
    CTE_INT     = {NUMERICO}+
    CTE_REAL    = ({NUMERICO}*("."){NUMERICO}+)|({NUMERICO}+("."){NUMERICO}*)
    CTE_CHAR    = ("'"){ALFANUM}?("'")
    CTE_STRING  = "\""{ALFANUM}*"\""

/* Miscelaneos */

    ID = {ALFABETICO}+("_"|{ALFANUM}*){ALFANUM}*
    ESPACIO = ((" ")|(\s|\r|\n|\r\n|\t))
    COMENTARIOS  = ("/*")({ALFANUM}|{ESPACIO})*("*/")

%%

<YYINITIAL> {

/* Operadores */

    ":="    { tokens.add("OP_DECLA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "::="   { tokens.add("OP_ASIGN\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "+"     { tokens.add("OP_SUMA\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "-"     { tokens.add("OP_RESTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "*"     { tokens.add("OP_PROD\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "/"     { tokens.add("OP_DIV\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "&&"    { tokens.add("OP_AND\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "||"    { tokens.add("OP_OR\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "!"     { tokens.add("OP_NOT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

/* Operadores condicionales */

    "=="    { tokens.add("COND_IGUAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "<>"    { tokens.add("COND_DIST\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    ">"     { tokens.add("COND_MAYOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "<"     { tokens.add("COND_MENOR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    ">="    { tokens.add("COND_MAYORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "<="    { tokens.add("COND_MENORI\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

/* Palabras reservadas */

    "while"                 { tokens.add("CL_WHILE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "if"                    { tokens.add("DECL_IF\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "else if"               { tokens.add("DECL_ELIF\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "else"                  { tokens.add("DECL_ELSE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "write"                 { tokens.add("OUTPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "read"                  { tokens.add("INPUT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "return"                { tokens.add("RETURN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "DECLARE.SECTION"       { tokens.add("ABRIR_DECLA\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "ENDDECLARE.SECTION"    { tokens.add("CERRAR_DECLA\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "PROGRAM.SECTION"       { tokens.add("ABRIR_PROG\t" + yytext() + "\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "ENDPROGRAM.SECTION"    { tokens.add("CERRAR_PROG\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "countDistinct"         { tokens.add("FUNC_COUNTDISTINCT\t" + yytext() + "\t# Linea: " + yyline + " - Columna: " + yycolumn); }


/* Miscelaneos */

    "["     { tokens.add("ABRIR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "]"     { tokens.add("CERRAR_LISTA\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "("     { tokens.add("ABRIR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    ")"     { tokens.add("CERRAR_COND\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "{"     { tokens.add("ABRIR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "}"     { tokens.add("CERRAR_BLOQUE\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    ";"     { tokens.add("TOK_EOI\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    ","     { tokens.add("TOK_SEP\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "::"    { tokens.add("TOK_DOSP\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

/* Tipos de datos */

    "int"       { tokens.add("TYPE_INT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "float"     { tokens.add("TYPE_FLOAT\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "char"      { tokens.add("TYPE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }

    "string"    { tokens.add("TYPE_STR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn); }


/* Regex */

    {ID}            {tokens.add("ID\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {ALFABETICO}    {/* No se realiza accion por lo tanto se ignoran*/}

    {NUMERICO}      {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFANUM}       {/* No se realiza accion por lo tanto se ignoran*/}

    {CTE_BIN}       {tokens.add("CTE_BIN\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {CTE_INT}       {tokens.add("CTE_INT\t\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {CTE_REAL}      {tokens.add("CTE_REAL\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {CTE_CHAR}      {tokens.add("CTE_CHAR\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {CTE_STRING}    {tokens.add("CTE_STRING\t" + yytext() + "\t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);}

    {ESPACIO}       {/* No se realiza accion por lo tanto se ignoran*/}

    {COMENTARIOS}   {/* No se realiza accion por lo tanto se ignoran*/}

}

  [^]     { tokens.add("Illegal character <" + yytext() + "> \t\t\t# Linea: " + yyline + " - Columna: " + yycolumn);
            System.err.println("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);}