package test;

import com.nlf.calendar.I18n;
import com.nlf.calendar.Lunar;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * 多语言测试
 *
 * @author 6tail
 */
public class I18nTest {

  @Test
  public void test1(){
    Assert.assertEquals("狗", I18n.getMessage("sx.dog"));

    I18n.setLanguage("en");
    Assert.assertEquals("Dog", I18n.getMessage("sx.dog"));

    I18n.setMessages("chs", new HashMap<String, String>(){
      {
        put("sx.dog", "小狗狗");
      }
    });
    I18n.setLanguage("chs");
    Assert.assertEquals("小狗狗", I18n.getMessage("sx.dog"));

    I18n.setMessages("chs", new HashMap<String, String>(){
      {
        put("sx.dog", "狗");
      }
    });
    Assert.assertEquals("狗", I18n.getMessage("sx.dog"));
  }

  @Test
  public void test2(){
    I18n.setLanguage("en");
    System.out.println(Lunar.fromDate(new Date()).toFullString());
    I18n.setLanguage("chs");
    System.out.println(Lunar.fromDate(new Date()).toFullString());
  }

}
