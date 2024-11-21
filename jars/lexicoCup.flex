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
%class LexicoCup
%line
%column
%char

%{

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

    ":="    { return new Symbol(sym.OP_DECLA, yytext());}


    "::="   { return new Symbol(sym.OP_ASIGN, yytext());}


    "+"     { return new Symbol(sym.OP_SUMA, yytext());}


    "-"     { return new Symbol(sym.OP_RESTA, yytext());}


    "*"     { return new Symbol(sym.OP_PROD, yytext());}


    "/"     { return new Symbol(sym.OP_DIV, yytext());}


    "&&"    { return new Symbol(sym.OP_AND, yytext());}


    "||"    { return new Symbol(sym.OP_OR, yytext());}


    "!"     { return new Symbol(sym.OP_NOT, yytext());}


/* Operadores condicionales */

    "=="    { return new Symbol(sym.COND_IGUAL, yytext());}


    "<>"    { return new Symbol(sym.COND_DIST, yytext());}


    ">"     { return new Symbol(sym.COND_MAYOR, yytext());}


    "<"     { return new Symbol(sym.COND_MENOR, yytext());}


    ">="    { return new Symbol(sym.COND_MAYORI, yytext());}


    "<="    { return new Symbol(sym.COND_MENORI, yytext());}


/* Palabras reservadas */

    "while"                { return new Symbol(sym.CL_WHILE, yytext());}


    "if"                   { return new Symbol(sym.DECL_IF, yytext());}


    "else if"              { return new Symbol(sym.DECL_ELIF, yytext());}


    "else"                 { return new Symbol(sym.DECL_ELSE, yytext());}


    "write"                { return new Symbol(sym.OUTPUT, yytext());}


    "return"               { return new Symbol(sym.RETURN, yytext());}


    "DECLARE.SECTION"      { return new Symbol(sym.ABRIR_DECLA, yytext());}


    "ENDDECLARE.SECTION"   { return new Symbol(sym.CERRAR_DECLA, yytext());}


    "PROGRAM.SECTION"      { return new Symbol(sym.ABRIR_PROG, yytext());}


    "ENDPROGRAM.SECTION"   { return new Symbol(sym.CERRAR_PROG, yytext());}


    "countDistinct"        { return new Symbol(sym.FUNC_COUNTDISTINCT, yytext());}


/* Miscelaneos */

    "["     { return new Symbol(sym.ABRIR_LISTA, yytext());}


    "]"     { return new Symbol(sym.CERRAR_LISTA, yytext());}


    "("     { return new Symbol(sym.ABRIR_COND, yytext());}


    ")"     { return new Symbol(sym.CERRAR_COND, yytext());}


    "{"     { return new Symbol(sym.ABRIR_BLOQUE, yytext());}


    "}"     { return new Symbol(sym.CERRAR_BLOQUE, yytext());}


    ";"     { return new Symbol(sym.TOK_EOI, yytext());}


    ","     { return new Symbol(sym.TOK_SEP, yytext());}


    "::"    { return new Symbol(sym.TOK_DOSP, yytext());}


/* Tipos de datos */

    "int"       { return new Symbol(sym.TYPE_INT, yytext());}


    "float"     { return new Symbol(sym.TYPE_FLOAT, yytext());}


    "string"    { return new Symbol(sym.TYPE_STR, yytext());}


/* Regex */

    {ID}            {
                        try {
                            return new Symbol(sym.ID, yytext());

                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_INT}       {
                        try {
                            return new Symbol(sym.CTE_INT, yytext());

                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {NUMERICO}      {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFABETICO}    {/* No se realiza accion por lo tanto se ignoran*/}

    {ALFANUM}       {/* No se realiza accion por lo tanto se ignoran*/}

    {CTE_BIN}       {
                        try {
                            return new Symbol(sym.CTE_BIN, yytext());

                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {CTE_REAL}      {
                        try {
                            return new Symbol(sym.CTE_REAL, yytext());

                        } catch (ErrorCompilacion e) {
                             throw new RuntimeException(e);
                        }
                    }

    {CTE_STRING}    {
                        try {
                            return new Symbol(sym.CTE_STRING, yytext());

                        } catch (ErrorCompilacion e) {
                            throw new RuntimeException(e);
                        }
                    }

    {ESPACIO}       {/* No se realiza accion por lo tanto se ignoran*/}

    {COMENTARIOS}   {/* No se realiza accion por lo tanto se ignoran*/}
}

  [^]     { throw new RuntimeException("ERROR: Illegal character <" + yytext() + "> # Linea: " + yyline + " - Columna: " + yycolumn);}