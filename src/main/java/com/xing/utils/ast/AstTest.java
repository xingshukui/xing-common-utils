package com.xing.utils.ast;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * AstTest
 *
 * @author : xingshukui
 * @date : 2019-09-12 10:29
 * @desc :
 */
public class AstTest {


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = new FileInputStream("/Users/xingshukui/workspace/github/xing-common-utils/src/main/java/com/xing/utils/delayTask/Slot.java");
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> compilationUnit = javaParser.parse(in);

        CompilationUnit cu = compilationUnit.getResult().get();

        cu.findAll(MethodDeclaration.class).stream()
                .filter(f -> f.isPublic() && !f.isStatic())
                .forEach(f -> System.out.println("Check field at line " +
                        f.getRange().map(r -> r.begin.line).orElse(-1) + "=="+f.getName()));

        System.out.println(cu.toString());

//        cu.accept(new VoidVisitorAdapter<Object>() {
//            @Override
//            public void visit(AnnotationDeclaration n, Object arg) {
//                System.out.println(n.getName());
//                System.out.println(n.getFields());
//                super.visit(n, arg);
//            }
//
//            @Override
//            public void visit(MethodDeclaration n, Object arg) {
//                System.out.println(n.getName());
//                super.visit(n, arg);
//            }
//        }, null);



    }
}
