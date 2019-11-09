package com.xing.utils.test;

import com.xing.utils.gener.table.Table;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_AbsoluteEven;
import de.vandermeer.asciitable.CWC_FixedWidth;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.StandardExample;
import de.vandermeer.skb.interfaces.StandardExampleRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TestRunner
 *
 * @author : xingshukui
 * @date : 2019-08-30 16:34
 * @desc :
 */
@RunWith(JUnit4.class)
public class TestRunner implements StandardExampleRunner{


    @Override
    public void runExample(StandardExample example) {
        example.showOutput();
    }

    @Test
    public void r() {
        this.runExample(new Table());
    }


    /**
     *
     */


    @Test
    public void t() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("appealer", "respondent", "orderNo", "nickname", "merchantName");
        at.addRule();
        at.addRow("","  ","   ","   ","   ");
        at.addRule();

        at.getContext().setGrid(U8_Grids.borderDouble());

//        at.getRenderer().setCWC(new CWC_FixedWidth().add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30).add(30));
        at.getRenderer().setCWC(new CWC_AbsoluteEven());
//        System.out.println(at.render(100));
        System.out.println(at.render(80));
    }

}
