package main.java;

import main.java.expr.EvalVisitor;
import main.java.expr.ExprLexer;
import main.java.expr.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

/**
 * adamj - 06/08/2015.
 */
public class Translate {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);

        ExprLexer lexer = new ExprLexer(inputStream);

        // Create a buffer to hold tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        List<Token> tokenList = tokens.getTokens();
        for (Token token : tokenList) {
            System.out.println(token.toString());
        }


        // Create a parser
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);



    }
}
