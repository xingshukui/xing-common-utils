package com.xing.utils.gener.table;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Table
 *
 * @author : xingshukui
 * @date : 2019-11-09 15:48
 * @desc :
 */
public class Table implements StandardExampleAsCmd {
    @Override
    public String getID() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "test table";
    }

    @Override
    public void showOutput() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("rc 11", "rc 12");
        at.addRule();
        at.addRow("rc 21", "rc 22");
        at.addRule();
        at.getContext().setWidth(13);

        System.out.println(at.render());

        at.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(at.render());
    }

    @Override
    public StrBuilder getSource() {
        String[] source = new String[]{
                "AsciiTable at = new AsciiTable();\n" +
                        "        at.addRule();\n" +
                        "        at.addRow(\"rc 11\", \"rc 12\");\n" +
                        "        at.addRule();\n" +
                        "        at.addRow(\"rc 21\", \"rc 22\");\n" +
                        "        at.addRule();\n" +
                        "        at.getContext().setWidth(13);\n" +
                        "\n" +
                        "        System.out.println(at.render());\n" +
                        "\n" +
                        "        at.getContext().setGrid(U8_Grids.borderDouble());\n" +
                        "        System.out.println(at.render());",
        };
        return new StrBuilder().appendWithSeparators(source, "\n");
    }
}
