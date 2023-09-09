package com.nlf.calendar;

import com.nlf.calendar.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 多语言工具
 *
 * @author 6tail
 */
public class I18n {
  private static final String DEFAULT_LANG = "chs";
  private static String LANG;
  private static boolean INIT = false;
  private static final Pattern PATTERN = Pattern.compile("\\{(.[^}]*)\\}");

  private static final Map<String, Map<String, String>> MESSAGES = new HashMap<String, Map<String, String>>() {
    {
      put("chs", new HashMap<String, String>() {
        {
          put("tg.jia", "甲");
          put("tg.yi", "乙");
          put("tg.bing", "丙");
          put("tg.ding", "丁");
          put("tg.wu", "戊");
          put("tg.ji", "己");
          put("tg.geng", "庚");
          put("tg.xin", "辛");
          put("tg.ren", "壬");
          put("tg.gui", "癸");
          put("dz.zi", "子");
          put("dz.chou", "丑");
          put("dz.yin", "寅");
          put("dz.mao", "卯");
          put("dz.chen", "辰");
          put("dz.si", "巳");
          put("dz.wu", "午");
          put("dz.wei", "未");
          put("dz.shen", "申");
          put("dz.you", "酉");
          put("dz.xu", "戌");
          put("dz.hai", "亥");
          put("zx.jian", "建");
          put("zx.chu", "除");
          put("zx.man", "满");
          put("zx.ping", "平");
          put("zx.ding", "定");
          put("zx.zhi", "执");
          put("zx.po", "破");
          put("zx.wei", "危");
          put("zx.cheng", "成");
          put("zx.shou", "收");
          put("zx.kai", "开");
          put("zx.bi", "闭");
          put("jz.jiaZi", "甲子");
          put("jz.yiChou", "乙丑");
          put("jz.bingYin", "丙寅");
          put("jz.dingMao", "丁卯");
          put("jz.wuChen", "戊辰");
          put("jz.jiSi", "己巳");
          put("jz.gengWu", "庚午");
          put("jz.xinWei", "辛未");
          put("jz.renShen", "壬申");
          put("jz.guiYou", "癸酉");
          put("jz.jiaXu", "甲戌");
          put("jz.yiHai", "乙亥");
          put("jz.bingZi", "丙子");
          put("jz.dingChou", "丁丑");
          put("jz.wuYin", "戊寅");
          put("jz.jiMao", "己卯");
          put("jz.gengChen", "庚辰");
          put("jz.xinSi", "辛巳");
          put("jz.renWu", "壬午");
          put("jz.guiWei", "癸未");
          put("jz.jiaShen", "甲申");
          put("jz.yiYou", "乙酉");
          put("jz.bingXu", "丙戌");
          put("jz.dingHai", "丁亥");
          put("jz.wuZi", "戊子");
          put("jz.jiChou", "己丑");
          put("jz.gengYin", "庚寅");
          put("jz.xinMao", "辛卯");
          put("jz.renChen", "壬辰");
          put("jz.guiSi", "癸巳");
          put("jz.jiaWu", "甲午");
          put("jz.yiWei", "乙未");
          put("jz.bingShen", "丙申");
          put("jz.dingYou", "丁酉");
          put("jz.wuXu", "戊戌");
          put("jz.jiHai", "己亥");
          put("jz.gengZi", "庚子");
          put("jz.xinChou", "辛丑");
          put("jz.renYin", "壬寅");
          put("jz.guiMao", "癸卯");
          put("jz.jiaChen", "甲辰");
          put("jz.yiSi", "乙巳");
          put("jz.bingWu", "丙午");
          put("jz.dingWei", "丁未");
          put("jz.wuShen", "戊申");
          put("jz.jiYou", "己酉");
          put("jz.gengXu", "庚戌");
          put("jz.xinHai", "辛亥");
          put("jz.renZi", "壬子");
          put("jz.guiChou", "癸丑");
          put("jz.jiaYin", "甲寅");
          put("jz.yiMao", "乙卯");
          put("jz.bingChen", "丙辰");
          put("jz.dingSi", "丁巳");
          put("jz.wuWu", "戊午");
          put("jz.jiWei", "己未");
          put("jz.gengShen", "庚申");
          put("jz.xinYou", "辛酉");
          put("jz.renXu", "壬戌");
          put("jz.guiHai", "癸亥");
          put("sx.rat", "鼠");
          put("sx.ox", "牛");
          put("sx.tiger", "虎");
          put("sx.rabbit", "兔");
          put("sx.dragon", "龙");
          put("sx.snake", "蛇");
          put("sx.horse", "马");
          put("sx.goat", "羊");
          put("sx.monkey", "猴");
          put("sx.rooster", "鸡");
          put("sx.dog", "狗");
          put("sx.pig", "猪");
          put("dw.long", "龙");
          put("dw.niu", "牛");
          put("dw.gou", "狗");
          put("dw.yang", "羊");
          put("dw.tu", "兔");
          put("dw.shu", "鼠");
          put("dw.ji", "鸡");
          put("dw.ma", "马");
          put("dw.hu", "虎");
          put("dw.zhu", "猪");
          put("dw.hou", "猴");
          put("dw.she", "蛇");
          put("dw.huLi", "狐");
          put("dw.yan", "燕");
          put("dw.bao", "豹");
          put("dw.yuan", "猿");
          put("dw.yin", "蚓");
          put("dw.lu", "鹿");
          put("dw.wu", "乌");
          put("dw.jiao", "蛟");
          put("dw.lang", "狼");
          put("dw.fu", "蝠");
          put("dw.zhang", "獐");
          put("dw.xu", "獝");
          put("dw.xie", "獬");
          put("dw.han", "犴");
          put("dw.he", "貉");
          put("dw.zhi", "彘");
          put("wx.jin", "金");
          put("wx.mu", "木");
          put("wx.shui", "水");
          put("wx.huo", "火");
          put("wx.tu", "土");
          put("wx.ri", "日");
          put("wx.yue", "月");
          put("n.zero", "〇");
          put("n.one", "一");
          put("n.two", "二");
          put("n.three", "三");
          put("n.four", "四");
          put("n.five", "五");
          put("n.six", "六");
          put("n.seven", "七");
          put("n.eight", "八");
          put("n.nine", "九");
          put("n.ten", "十");
          put("n.eleven", "十一");
          put("n.twelve", "十二");
          put("d.one", "初一");
          put("d.two", "初二");
          put("d.three", "初三");
          put("d.four", "初四");
          put("d.five", "初五");
          put("d.six", "初六");
          put("d.seven", "初七");
          put("d.eight", "初八");
          put("d.nine", "初九");
          put("d.ten", "初十");
          put("d.eleven", "十一");
          put("d.twelve", "十二");
          put("d.thirteen", "十三");
          put("d.fourteen", "十四");
          put("d.fifteen", "十五");
          put("d.sixteen", "十六");
          put("d.seventeen", "十七");
          put("d.eighteen", "十八");
          put("d.nighteen", "十九");
          put("d.twenty", "二十");
          put("d.twentyOne", "廿一");
          put("d.twentyTwo", "廿二");
          put("d.twentyThree", "廿三");
          put("d.twentyFour", "廿四");
          put("d.twentyFive", "廿五");
          put("d.twentySix", "廿六");
          put("d.twentySeven", "廿七");
          put("d.twentyEight", "廿八");
          put("d.twentyNine", "廿九");
          put("d.thirty", "三十");
          put("m.one", "正");
          put("m.two", "二");
          put("m.three", "三");
          put("m.four", "四");
          put("m.five", "五");
          put("m.six", "六");
          put("m.seven", "七");
          put("m.eight", "八");
          put("m.nine", "九");
          put("m.ten", "十");
          put("m.eleven", "冬");
          put("m.twelve", "腊");
          put("w.sun", "日");
          put("w.mon", "一");
          put("w.tues", "二");
          put("w.wed", "三");
          put("w.thur", "四");
          put("w.fri", "五");
          put("w.sat", "六");
          put("xz.aries", "白羊");
          put("xz.taurus", "金牛");
          put("xz.gemini", "双子");
          put("xz.cancer", "巨蟹");
          put("xz.leo", "狮子");
          put("xz.virgo", "处女");
          put("xz.libra", "天秤");
          put("xz.scorpio", "天蝎");
          put("xz.sagittarius", "射手");
          put("xz.capricornus", "摩羯");
          put("xz.aquarius", "水瓶");
          put("xz.pisces", "双鱼");
          put("bg.qian", "乾");
          put("bg.kun", "坤");
          put("bg.zhen", "震");
          put("bg.xun", "巽");
          put("bg.kan", "坎");
          put("bg.li", "离");
          put("bg.gen", "艮");
          put("bg.dui", "兑");
          put("ps.center", "中");
          put("ps.dong", "东");
          put("ps.nan", "南");
          put("ps.xi", "西");
          put("ps.bei", "北");
          put("ps.zhong", "中宫");
          put("ps.zhengDong", "正东");
          put("ps.zhengNan", "正南");
          put("ps.zhengXi", "正西");
          put("ps.zhengBei", "正北");
          put("ps.dongBei", "东北");
          put("ps.dongNan", "东南");
          put("ps.xiBei", "西北");
          put("ps.xiNan", "西南");
          put("ps.wai", "外");
          put("ps.fangNei", "房内");
          put("jq.dongZhi", "冬至");
          put("jq.xiaoHan", "小寒");
          put("jq.daHan", "大寒");
          put("jq.liChun", "立春");
          put("jq.yuShui", "雨水");
          put("jq.jingZhe", "惊蛰");
          put("jq.chunFen", "春分");
          put("jq.qingMing", "清明");
          put("jq.guYu", "谷雨");
          put("jq.liXia", "立夏");
          put("jq.xiaoMan", "小满");
          put("jq.mangZhong", "芒种");
          put("jq.xiaZhi", "夏至");
          put("jq.xiaoShu", "小暑");
          put("jq.daShu", "大暑");
          put("jq.liQiu", "立秋");
          put("jq.chuShu", "处暑");
          put("jq.baiLu", "白露");
          put("jq.qiuFen", "秋分");
          put("jq.hanLu", "寒露");
          put("jq.shuangJiang", "霜降");
          put("jq.liDong", "立冬");
          put("jq.xiaoXue", "小雪");
          put("jq.daXue", "大雪");
          put("sn.qingLong", "青龙");
          put("sn.baiHu", "白虎");
          put("sn.zhuQue", "朱雀");
          put("sn.xuanWu", "玄武");
          put("sn.mingTang", "明堂");
          put("sn.tianXing", "天刑");
          put("sn.tianDe", "天德");
          put("sn.jinKui", "金匮");
          put("sn.yuTang", "玉堂");
          put("sn.siMing", "司命");
          put("sn.tianLao", "天牢");
          put("sn.gouChen", "勾陈");
          put("sn.tianEn", "天恩");
          put("sn.muCang", "母仓");
          put("sn.shiYang", "时阳");
          put("sn.shengQi", "生气");
          put("sn.yiHou", "益后");
          put("sn.zaiSha", "灾煞");
          put("sn.tianHuo", "天火");
          put("sn.siJi", "四忌");
          put("sn.baLong", "八龙");
          put("sn.fuRi", "复日");
          put("sn.xuShi", "续世");
          put("sn.yueSha", "月煞");
          put("sn.yueXu", "月虚");
          put("sn.xueZhi", "血支");
          put("sn.tianZei", "天贼");
          put("sn.wuXu", "五虚");
          put("sn.tuFu", "土符");
          put("sn.guiJi", "归忌");
          put("sn.xueJi", "血忌");
          put("sn.yueDe", "月德");
          put("sn.yueEn", "月恩");
          put("sn.siXiang", "四相");
          put("sn.wangRi", "王日");
          put("sn.tianCang", "天仓");
          put("sn.buJiang", "不将");
          put("sn.wuHe", "五合");
          put("sn.mingFeiDui", "鸣吠对");
          put("sn.yueJian", "月建");
          put("sn.xiaoShi", "小时");
          put("sn.tuHu", "土府");
          put("sn.wangWang", "往亡");
          put("sn.yaoAn", "要安");
          put("sn.siShen", "死神");
          put("sn.tianMa", "天马");
          put("sn.jiuHu", "九虎");
          put("sn.qiNiao", "七鸟");
          put("sn.liuShe", "六蛇");
          put("sn.guanRi", "官日");
          put("sn.jiQi", "吉期");
          put("sn.yuYu", "玉宇");
          put("sn.daShi", "大时");
          put("sn.daBai", "大败");
          put("sn.xianChi", "咸池");
          put("sn.shouRi", "守日");
          put("sn.tianWu", "天巫");
          put("sn.fuDe", "福德");
          put("sn.liuYi", "六仪");
          put("sn.jinTang", "金堂");
          put("sn.yanDui", "厌对");
          put("sn.zhaoYao", "招摇");
          put("sn.jiuKong", "九空");
          put("sn.jiuKan", "九坎");
          put("sn.jiuJiao", "九焦");
          put("sn.xiangRi", "相日");
          put("sn.baoGuang", "宝光");
          put("sn.tianGang", "天罡");
          put("sn.yueXing", "月刑");
          put("sn.yueHai", "月害");
          put("sn.youHuo", "游祸");
          put("sn.chongRi", "重日");
          put("sn.shiDe", "时德");
          put("sn.minRi", "民日");
          put("sn.sanHe", "三合");
          put("sn.linRi", "临日");
          put("sn.shiYin", "时阴");
          put("sn.mingFei", "鸣吠");
          put("sn.siQi", "死气");
          put("sn.diNang", "地囊");
          put("sn.yueDeHe", "月德合");
          put("sn.jingAn", "敬安");
          put("sn.puHu", "普护");
          put("sn.jieShen", "解神");
          put("sn.xiaoHao", "小耗");
          put("sn.tianDeHe", "天德合");
          put("sn.yueKong", "月空");
          put("sn.yiMa", "驿马");
          put("sn.tianHou", "天后");
          put("sn.chuShen", "除神");
          put("sn.yuePo", "月破");
          put("sn.daHao", "大耗");
          put("sn.wuLi", "五离");
          put("sn.yinDe", "阴德");
          put("sn.fuSheng", "福生");
          put("sn.tianLi", "天吏");
          put("sn.zhiSi", "致死");
          put("sn.yuanWu", "元武");
          put("sn.yangDe", "阳德");
          put("sn.tianXi", "天喜");
          put("sn.tianYi", "天医");
          put("sn.yueYan", "月厌");
          put("sn.diHuo", "地火");
          put("sn.fourHit", "四击");
          put("sn.daSha", "大煞");
          put("sn.daHui", "大会");
          put("sn.tianYuan", "天愿");
          put("sn.liuHe", "六合");
          put("sn.wuFu", "五富");
          put("sn.shengXin", "圣心");
          put("sn.heKui", "河魁");
          put("sn.jieSha", "劫煞");
          put("sn.siQiong", "四穷");
          put("sn.chuShuiLong", "触水龙");
          put("sn.baFeng", "八风");
          put("sn.tianShe", "天赦");
          put("sn.wuMu", "五墓");
          put("sn.baZhuan", "八专");
          put("sn.yinCuo", "阴错");
          put("sn.siHao", "四耗");
          put("sn.yangCuo", "阳错");
          put("sn.siFei", "四废");
          put("sn.sanYin", "三阴");
          put("sn.xiaoHui", "小会");
          put("sn.yinDaoChongYang", "阴道冲阳");
          put("sn.danYin", "单阴");
          put("sn.guChen", "孤辰");
          put("sn.yinWei", "阴位");
          put("sn.xingHen", "行狠");
          put("sn.liaoLi", "了戾");
          put("sn.jueYin", "绝阴");
          put("sn.chunYang", "纯阳");
          put("sn.suiBo", "岁薄");
          put("sn.yinYangJiaoPo", "阴阳交破");
          put("sn.yinYangJuCuo", "阴阳俱错");
          put("sn.yinYangJiChong", "阴阳击冲");
          put("sn.zhuZhen", "逐阵");
          put("sn.yangCuoYinChong", "阳错阴冲");
          put("sn.qiFu", "七符");
          put("sn.tianGou", "天狗");
          put("sn.chengRi", "成日");
          put("sn.tianFu", "天符");
          put("sn.guYang", "孤阳");
          put("sn.jueYang", "绝阳");
          put("sn.chunYin", "纯阴");
          put("sn.yinShen", "阴神");
          put("sn.jieChu", "解除");
          put("sn.yangPoYinChong", "阳破阴冲");
          put("ss.biJian", "比肩");
          put("ss.jieCai", "劫财");
          put("ss.shiShen", "食神");
          put("ss.shangGuan", "伤官");
          put("ss.pianCai", "偏财");
          put("ss.zhengCai", "正财");
          put("ss.qiSha", "七杀");
          put("ss.zhengGuan", "正官");
          put("ss.pianYin", "偏印");
          put("ss.zhengYin", "正印");
          put("s.none", "无");
          put("s.huangDao", "黄道");
          put("s.heiDao", "黑道");
          put("s.goodLuck", "吉");
          put("s.badLuck", "凶");
          put("s.yin", "阴");
          put("s.yang", "阳");
          put("s.white", "白");
          put("s.black", "黑");
          put("s.blue", "碧");
          put("s.green", "绿");
          put("s.yellow", "黄");
          put("s.red", "赤");
          put("s.purple", "紫");
          put("jr.chuXi", "除夕");
          put("jr.chunJie", "春节");
          put("jr.yuanXiao", "元宵节");
          put("jr.longTou", "龙头节");
          put("jr.duanWu", "端午节");
          put("jr.qiXi", "七夕节");
          put("jr.zhongQiu", "中秋节");
          put("jr.chongYang", "重阳节");
          put("jr.laBa", "腊八节");
          put("jr.yuanDan", "元旦节");
          put("jr.qingRen", "情人节");
          put("jr.fuNv", "妇女节");
          put("jr.zhiShu", "植树节");
          put("jr.xiaoFei", "消费者权益日");
          put("jr.wuYi", "劳动节");
          put("jr.qingNian", "青年节");
          put("jr.erTong", "儿童节");
          put("jr.yuRen", "愚人节");
          put("jr.jianDang", "建党节");
          put("jr.jianJun", "建军节");
          put("jr.jiaoShi", "教师节");
          put("jr.guoQing", "国庆节");
          put("jr.wanShengYe", "万圣节前夜");
          put("jr.wanSheng", "万圣节");
          put("jr.pingAn", "平安夜");
          put("jr.shengDan", "圣诞节");
          put("ds.changSheng", "长生");
          put("ds.muYu", "沐浴");
          put("ds.guanDai", "冠带");
          put("ds.linGuan", "临官");
          put("ds.diWang", "帝旺");
          put("ds.shuai", "衰");
          put("ds.bing", "病");
          put("ds.si", "死");
          put("ds.mu", "墓");
          put("ds.jue", "绝");
          put("ds.tai", "胎");
          put("ds.yang", "养");
          put("h.first", "初候");
          put("h.second", "二候");
          put("h.third", "三候");
          put("h.qiuYinJie", "蚯蚓结");
          put("h.miJiao", "麋角解");
          put("h.shuiQuan", "水泉动");
          put("h.yanBei", "雁北乡");
          put("h.queShi", "鹊始巢");
          put("h.zhiShi", "雉始雊");
          put("h.jiShi", "鸡始乳");
          put("h.zhengNiao", "征鸟厉疾");
          put("h.shuiZe", "水泽腹坚");
          put("h.dongFeng", "东风解冻");
          put("h.zheChongShiZhen", "蛰虫始振");
          put("h.yuZhi", "鱼陟负冰");
          put("h.taJi", "獭祭鱼");
          put("h.houYan", "候雁北");
          put("h.caoMuMengDong", "草木萌动");
          put("h.taoShi", "桃始华");
          put("h.cangGeng", "仓庚鸣");
          put("h.yingHua", "鹰化为鸠");
          put("h.xuanNiaoZhi", "玄鸟至");
          put("h.leiNai", "雷乃发声");
          put("h.shiDian", "始电");
          put("h.tongShi", "桐始华");
          put("h.tianShu", "田鼠化为鴽");
          put("h.hongShi", "虹始见");
          put("h.pingShi", "萍始生");
          put("h.mingJiu", "鸣鸠拂奇羽");
          put("h.daiSheng", "戴胜降于桑");
          put("h.louGuo", "蝼蝈鸣");
          put("h.qiuYinChu", "蚯蚓出");
          put("h.wangGua", "王瓜生");
          put("h.kuCai", "苦菜秀");
          put("h.miCao", "靡草死");
          put("h.maiQiu", "麦秋至");
          put("h.tangLang", "螳螂生");
          put("h.juShi", "鵙始鸣");
          put("h.fanShe", "反舌无声");
          put("h.luJia", "鹿角解");
          put("h.tiaoShi", "蜩始鸣");
          put("h.banXia", "半夏生");
          put("h.wenFeng", "温风至");
          put("h.xiShuai", "蟋蟀居壁");
          put("h.yingShi", "鹰始挚");
          put("h.fuCao", "腐草为萤");
          put("h.tuRun", "土润溽暑");
          put("h.daYu", "大雨行时");
          put("h.liangFeng", "凉风至");
          put("h.baiLu", "白露降");
          put("h.hanChan", "寒蝉鸣");
          put("h.yingNai", "鹰乃祭鸟");
          put("h.tianDi", "天地始肃");
          put("h.heNai", "禾乃登");
          put("h.hongYanLai", "鸿雁来");
          put("h.xuanNiaoGui", "玄鸟归");
          put("h.qunNiao", "群鸟养羞");
          put("h.leiShi", "雷始收声");
          put("h.zheChongPiHu", "蛰虫坯户");
          put("h.shuiShiHe", "水始涸");
          put("h.hongYanLaiBin", "鸿雁来宾");
          put("h.queRu", "雀入大水为蛤");
          put("h.juYou", "菊有黄花");
          put("h.caiNai", "豺乃祭兽");
          put("h.caoMuHuangLuo", "草木黄落");
          put("h.zheChongXianFu", "蛰虫咸俯");
          put("h.shuiShiBing", "水始冰");
          put("h.diShi", "地始冻");
          put("h.zhiRu", "雉入大水为蜃");
          put("h.hongCang", "虹藏不见");
          put("h.tianQi", "天气上升地气下降");
          put("h.biSe", "闭塞而成冬");
          put("h.heDan", "鹖鴠不鸣");
          put("h.huShi", "虎始交");
          put("h.liTing", "荔挺出");
          put("ts.zhan", "占");
          put("ts.hu", "户");
          put("ts.win", "窗");
          put("ts.fang", "房");
          put("ts.chuang", "床");
          put("ts.lu", "炉");
          put("ts.zao", "灶");
          put("ts.dui", "碓");
          put("ts.mo", "磨");
          put("ts.xi", "栖");
          put("ts.chu", "厨");
          put("ts.ce", "厕");
          put("ts.cang", "仓");
          put("ts.cangKu", "仓库");
          put("ts.daMen", "大门");
          put("ts.men", "门");
          put("ts.tang", "堂");
          put("ly.xianSheng", "先胜");
          put("ly.xianFu", "先负");
          put("ly.youYin", "友引");
          put("ly.foMie", "佛灭");
          put("ly.daAn", "大安");
          put("ly.chiKou", "赤口");
          put("yj.jiSi", "祭祀");
          put("yj.qiFu", "祈福");
          put("yj.qiuSi", "求嗣");
          put("yj.kaiGuang", "开光");
          put("yj.suHui", "塑绘");
          put("yj.qiJiao", "齐醮");
          put("yj.zhaiJiao", "斋醮");
          put("yj.muYu", "沐浴");
          put("yj.chouShen", "酬神");
          put("yj.zaoMiao", "造庙");
          put("yj.siZhao", "祀灶");
          put("yj.fenXiang", "焚香");
          put("yj.xieTu", "谢土");
          put("yj.chuHuo", "出火");
          put("yj.diaoKe", "雕刻");
          put("yj.jiaQu", "嫁娶");
          put("yj.DingHun", "订婚");
          put("yj.naCai", "纳采");
          put("yj.wenMing", "问名");
          put("yj.naXu", "纳婿");
          put("yj.guiNing", "归宁");
          put("yj.anChuang", "安床");
          put("yj.heZhang", "合帐");
          put("yj.guanJi", "冠笄");
          put("yj.dingMeng", "订盟");
          put("yj.jinRenKou", "进人口");
          put("yj.caiYi", "裁衣");
          put("yj.wanMian", "挽面");
          put("yj.kaiRong", "开容");
          put("yj.xiuFen", "修坟");
          put("yj.qiZuan", "启钻");
          put("yj.poTu", "破土");
          put("yj.anZang", "安葬");
          put("yj.liBei", "立碑");
          put("yj.chengFu", "成服");
          put("yj.chuFu", "除服");
          put("yj.kaiShengFen", "开生坟");
          put("yj.heShouMu", "合寿木");
          put("yj.ruLian", "入殓");
          put("yj.yiJiu", "移柩");
          put("yj.puDu", "普渡");
          put("yj.ruZhai", "入宅");
          put("yj.anXiang", "安香");
          put("yj.anMen", "安门");
          put("yj.xiuZao", "修造");
          put("yj.qiJi", "起基");
          put("yj.dongTu", "动土");
          put("yj.shangLiang", "上梁");
          put("yj.shuZhu", "竖柱");
          put("yj.kaiJing", "开井开池");
          put("yj.zuoBei", "作陂放水");
          put("yj.chaiXie", "拆卸");
          put("yj.poWu", "破屋");
          put("yj.huaiYuan", "坏垣");
          put("yj.buYuan", "补垣");
          put("yj.faMuZuoLiang", "伐木做梁");
          put("yj.zuoZhao", "作灶");
          put("yj.jieChu", "解除");
          put("yj.kaiZhuYan", "开柱眼");
          put("yj.chuanPing", "穿屏扇架");
          put("yj.gaiWuHeJi", "盖屋合脊");
          put("yj.kaiCe", "开厕");
          put("yj.zaoCang", "造仓");
          put("yj.saiXue", "塞穴");
          put("yj.pingZhi", "平治道涂");
          put("yj.zaoQiao", "造桥");
          put("yj.zuoCe", "作厕");
          put("yj.zhuDi", "筑堤");
          put("yj.kaiChi", "开池");
          put("yj.faMu", "伐木");
          put("yj.kaiQu", "开渠");
          put("yj.jueJing", "掘井");
          put("yj.saoShe", "扫舍");
          put("yj.fangShui", "放水");
          put("yj.zaoWu", "造屋");
          put("yj.heJi", "合脊");
          put("yj.zaoChuChou", "造畜稠");
          put("yj.xiuMen", "修门");
          put("yj.dingSang", "定磉");
          put("yj.zuoLiang", "作梁");
          put("yj.xiuShi", "修饰垣墙");
          put("yj.jiaMa", "架马");
          put("yj.kaiShi", "开市");
          put("yj.guaBian", "挂匾");
          put("yj.naChai", "纳财");
          put("yj.qiuCai", "求财");
          put("yj.kaiCang", "开仓");
          put("yj.maiChe", "买车");
          put("yj.zhiChan", "置产");
          put("yj.guYong", "雇庸");
          put("yj.chuHuoCai", "出货财");
          put("yj.anJiXie", "安机械");
          put("yj.zaoCheQi", "造车器");
          put("yj.jingLuo", "经络");
          put("yj.yunNiang", "酝酿");
          put("yj.zuoRan", "作染");
          put("yj.guZhu", "鼓铸");
          put("yj.zaoChuan", "造船");
          put("yj.geMi", "割蜜");
          put("yj.zaiZhong", "栽种");
          put("yj.quYu", "取渔");
          put("yj.jieWang", "结网");
          put("yj.muYang", "牧养");
          put("yj.anDuiWei", "安碓磑");
          put("yj.xiYi", "习艺");
          put("yj.ruXue", "入学");
          put("yj.liFa", "理发");
          put("yj.tanBing", "探病");
          put("yj.jianGui", "见贵");
          put("yj.chengChuan", "乘船");
          put("yj.duShui", "渡水");
          put("yj.zhenJiu", "针灸");
          put("yj.chuXing", "出行");
          put("yj.yiXi", "移徙");
          put("yj.fenJu", "分居");
          put("yj.TiTou", "剃头");
          put("yj.zhengShou", "整手足甲");
          put("yj.naChu", "纳畜");
          put("yj.buZhuo", "捕捉");
          put("yj.tianLie", "畋猎");
          put("yj.jiaoNiuMa", "教牛马");
          put("yj.huiQinYou", "会亲友");
          put("yj.fuRen", "赴任");
          put("yj.qiuYi", "求医");
          put("yj.zhiBing", "治病");
          put("yj.ciSong", "词讼");
          put("yj.qiJiDongTu", "起基动土");
          put("yj.poWuHuaiYuan", "破屋坏垣");
          put("yj.gaiWu", "盖屋");
          put("yj.zaoCangKu", "造仓库");
          put("yj.liQuanJiaoYi", "立券交易");
          put("yj.jiaoYi", "交易");
          put("yj.liQuan", "立券");
          put("yj.anJi", "安机");
          put("yj.huiYou", "会友");
          put("yj.qiuYiLiaoBing", "求医疗病");
          put("yj.zhuShi", "诸事不宜");
          put("yj.yuShi", "馀事勿取");
          put("yj.xingSang", "行丧");
          put("yj.duanYi", "断蚁");
          put("yj.guiXiu", "归岫");
          put("xx.bi", "毕");
          put("xx.yi", "翼");
          put("xx.ji", "箕");
          put("xx.kui", "奎");
          put("xx.gui", "鬼");
          put("xx.di", "氐");
          put("xx.xu", "虚");
          put("xx.wei", "危");
          put("xx.zi", "觜");
          put("xx.zhen", "轸");
          put("xx.dou", "斗");
          put("xx.lou", "娄");
          put("xx.liu", "柳");
          put("xx.fang", "房");
          put("xx.xin", "心");
          put("xx.shi", "室");
          put("xx.can", "参");
          put("xx.jiao", "角");
          put("xx.niu", "牛");
          put("xx.vei", "胃");
          put("xx.xing", "星");
          put("xx.zhang", "张");
          put("xx.tail", "尾");
          put("xx.qiang", "壁");
          put("xx.jing", "井");
          put("xx.kang", "亢");
          put("xx.nv", "女");
          put("xx.mao", "昴");
          put("sz.chun", "春");
          put("sz.xia", "夏");
          put("sz.qiu", "秋");
          put("sz.dong", "冬");
          put("od.first", "孟");
          put("od.second", "仲");
          put("od.third", "季");
          put("yx.shuo", "朔");
          put("yx.jiShuo", "既朔");
          put("yx.eMeiXin", "蛾眉新");
          put("yx.eMei", "蛾眉");
          put("yx.xi", "夕");
          put("yx.shangXian", "上弦");
          put("yx.jiuYe", "九夜");
          put("yx.night", "宵");
          put("yx.jianYingTu", "渐盈凸");
          put("yx.xiaoWang", "小望");
          put("yx.wang", "望");
          put("yx.jiWang", "既望");
          put("yx.liDai", "立待");
          put("yx.juDai", "居待");
          put("yx.qinDai", "寝待");
          put("yx.gengDai", "更待");
          put("yx.jianKuiTu", "渐亏凸");
          put("yx.xiaXian", "下弦");
          put("yx.youMing", "有明");
          put("yx.eMeiCan", "蛾眉残");
          put("yx.can", "残");
          put("yx.xiao", "晓");
          put("yx.hui", "晦");
          put("ny.sangZhe", "桑柘");
          put("ny.baiLa", "白蜡");
          put("ny.yangLiu", "杨柳");
          put("ny.jinBo", "金箔");
          put("ny.haiZhong", "海中");
          put("ny.daHai", "大海");
          put("ny.shaZhong", "沙中");
          put("ny.luZhong", "炉中");
          put("ny.shanXia", "山下");
          put("ny.daLin", "大林");
          put("ny.pingDi", "平地");
          put("ny.luPang", "路旁");
          put("ny.biShang", "壁上");
          put("ny.jianFeng", "剑锋");
          put("ny.shanTou", "山头");
          put("ny.fuDeng", "覆灯");
          put("ny.jianXia", "涧下");
          put("ny.tianHe", "天河");
          put("ny.chengTou", "城头");
          put("ny.daYi", "大驿");
          put("ny.chaiChuan", "钗钏");
          put("ny.quanZhong", "泉中");
          put("ny.daXi", "大溪");
          put("ny.wuShang", "屋上");
          put("ny.piLi", "霹雳");
          put("ny.tianShang", "天上");
          put("ny.songBo", "松柏");
          put("ny.shiLiu", "石榴");
          put("ny.changLiu", "长流");
        }
      });
      put("en", new HashMap<String, String>() {
        {
          put("tg.jia", "Jia");
          put("tg.yi", "Yi");
          put("tg.bing", "Bing");
          put("tg.ding", "Ding");
          put("tg.wu", "Wu");
          put("tg.ji", "Ji");
          put("tg.geng", "Geng");
          put("tg.xin", "Xin");
          put("tg.ren", "Ren");
          put("tg.gui", "Gui");
          put("dz.zi", "Zi");
          put("dz.chou", "Chou");
          put("dz.yin", "Yin");
          put("dz.mao", "Mao");
          put("dz.chen", "Chen");
          put("dz.si", "Si");
          put("dz.wu", "Wu");
          put("dz.wei", "Wei");
          put("dz.shen", "Shen");
          put("dz.you", "You");
          put("dz.xu", "Xu");
          put("dz.hai", "Hai");
          put("zx.jian", "Build");
          put("zx.chu", "Remove");
          put("zx.man", "Full");
          put("zx.ping", "Flat");
          put("zx.ding", "Stable");
          put("zx.zhi", "Hold");
          put("zx.po", "Break");
          put("zx.wei", "Danger");
          put("zx.cheng", "Complete");
          put("zx.shou", "Collect");
          put("zx.kai", "Open");
          put("zx.bi", "Close");
          put("jz.jiaZi", "JiaZi");
          put("jz.yiChou", "YiChou");
          put("jz.bingYin", "BingYin");
          put("jz.dingMao", "DingMao");
          put("jz.wuChen", "WuChen");
          put("jz.jiSi", "JiSi");
          put("jz.gengWu", "GengWu");
          put("jz.xinWei", "XinWei");
          put("jz.renShen", "RenShen");
          put("jz.guiYou", "GuiYou");
          put("jz.jiaXu", "JiaXu");
          put("jz.yiHai", "YiHai");
          put("jz.bingZi", "BingZi");
          put("jz.dingChou", "DingChou");
          put("jz.wuYin", "WuYin");
          put("jz.jiMao", "JiMao");
          put("jz.gengChen", "GengChen");
          put("jz.xinSi", "XinSi");
          put("jz.renWu", "RenWu");
          put("jz.guiWei", "GuiWei");
          put("jz.jiaShen", "JiaShen");
          put("jz.yiYou", "YiYou");
          put("jz.bingXu", "BingXu");
          put("jz.dingHai", "DingHai");
          put("jz.wuZi", "WuZi");
          put("jz.jiChou", "JiChou");
          put("jz.gengYin", "GengYin");
          put("jz.xinMao", "XinMao");
          put("jz.renChen", "RenChen");
          put("jz.guiSi", "GuiSi");
          put("jz.jiaWu", "JiaWu");
          put("jz.yiWei", "YiWei");
          put("jz.bingShen", "BingShen");
          put("jz.dingYou", "DingYou");
          put("jz.wuXu", "WuXu");
          put("jz.jiHai", "JiHai");
          put("jz.gengZi", "GengZi");
          put("jz.xinChou", "XinChou");
          put("jz.renYin", "RenYin");
          put("jz.guiMao", "GuiMao");
          put("jz.jiaChen", "JiaChen");
          put("jz.yiSi", "YiSi");
          put("jz.bingWu", "BingWu");
          put("jz.dingWei", "DingWei");
          put("jz.wuShen", "WuShen");
          put("jz.jiYou", "JiYou");
          put("jz.gengXu", "GengXu");
          put("jz.xinHai", "XinHai");
          put("jz.renZi", "RenZi");
          put("jz.guiChou", "GuiChou");
          put("jz.jiaYin", "JiaYin");
          put("jz.yiMao", "YiMao");
          put("jz.bingChen", "BingChen");
          put("jz.dingSi", "DingSi");
          put("jz.wuWu", "WuWu");
          put("jz.jiWei", "JiWei");
          put("jz.gengShen", "GengShen");
          put("jz.xinYou", "XinYou");
          put("jz.renXu", "RenXu");
          put("jz.guiHai", "GuiHai");
          put("sx.rat", "Rat");
          put("sx.ox", "Ox");
          put("sx.tiger", "Tiger");
          put("sx.rabbit", "Rabbit");
          put("sx.dragon", "Dragon");
          put("sx.snake", "Snake");
          put("sx.horse", "Horse");
          put("sx.goat", "Goat");
          put("sx.monkey", "Monkey");
          put("sx.rooster", "Rooster");
          put("sx.dog", "Dog");
          put("sx.pig", "Pig");
          put("dw.long", "Dragon");
          put("dw.niu", "Ox");
          put("dw.gou", "Dog");
          put("dw.yang", "Goat");
          put("dw.tu", "Rabbit");
          put("dw.shu", "Rat");
          put("dw.ji", "Rooster");
          put("dw.ma", "Horse");
          put("dw.hu", "Tiger");
          put("dw.zhu", "Pig");
          put("dw.hou", "Monkey");
          put("dw.she", "Snake");
          put("dw.huLi", "Fox");
          put("dw.yan", "Swallow");
          put("dw.bao", "Leopard");
          put("dw.yuan", "Ape");
          put("dw.yin", "Earthworm");
          put("dw.lu", "Deer");
          put("dw.wu", "Crow");
          put("dw.lang", "Wolf");
          put("dw.fu", "Bat");
          put("wx.jin", "Metal");
          put("wx.mu", "Wood");
          put("wx.shui", "Water");
          put("wx.huo", "Fire");
          put("wx.tu", "Earth");
          put("wx.ri", "Sun");
          put("wx.yue", "Moon");
          put("n.zero", "0");
          put("n.one", "1");
          put("n.two", "2");
          put("n.three", "3");
          put("n.four", "4");
          put("n.five", "5");
          put("n.six", "6");
          put("n.seven", "7");
          put("n.eight", "8");
          put("n.nine", "9");
          put("n.ten", "10");
          put("n.eleven", "11");
          put("n.twelve", "12");
          put("w.sun", "Sunday");
          put("w.mon", "Monday");
          put("w.tues", "Tuesday");
          put("w.wed", "Wednesday");
          put("w.thur", "Thursday");
          put("w.fri", "Friday");
          put("w.sat", "Saturday");
          put("xz.aries", "Aries");
          put("xz.taurus", "Taurus");
          put("xz.gemini", "Gemini");
          put("xz.cancer", "Cancer");
          put("xz.leo", "Leo");
          put("xz.virgo", "Virgo");
          put("xz.libra", "Libra");
          put("xz.scorpio", "Scorpio");
          put("xz.sagittarius", "Sagittarius");
          put("xz.capricornus", "Capricornus");
          put("xz.aquarius", "Aquarius");
          put("xz.pisces", "Pisces");
          put("bg.qian", "Qian");
          put("bg.kun", "Kun");
          put("bg.zhen", "Zhen");
          put("bg.xun", "Xun");
          put("bg.kan", "Kan");
          put("bg.li", "Li");
          put("bg.gen", "Gen");
          put("bg.dui", "Dui");
          put("ps.center", "Center");
          put("ps.dong", "East");
          put("ps.nan", "South");
          put("ps.xi", "West");
          put("ps.bei", "North");
          put("ps.zhong", "Center");
          put("ps.zhengDong", "East");
          put("ps.zhengNan", "South");
          put("ps.zhengXi", "West");
          put("ps.zhengBei", "North");
          put("ps.dongBei", "Northeast");
          put("ps.dongNan", "Southeast");
          put("ps.xiBei", "Northwest");
          put("ps.xiNan", "Southwest");
          put("jq.dongZhi", "Winter Solstice");
          put("jq.xiaoHan", "Lesser Cold");
          put("jq.daHan", "Great Cold");
          put("jq.liChun", "Spring Beginning");
          put("jq.yuShui", "Rain Water");
          put("jq.jingZhe", "Awakening from Hibernation");
          put("jq.chunFen", "Spring Equinox");
          put("jq.qingMing", "Fresh Green");
          put("jq.guYu", "Grain Rain");
          put("jq.liXia", "Beginning of Summer");
          put("jq.xiaoMan", "Lesser Fullness");
          put("jq.mangZhong", "Grain in Ear");
          put("jq.xiaZhi", "Summer Solstice");
          put("jq.xiaoShu", "Lesser Heat");
          put("jq.daShu", "Greater Heat");
          put("jq.liQiu", "Beginning of Autumn");
          put("jq.chuShu", "End of Heat");
          put("jq.baiLu", "White Dew");
          put("jq.qiuFen", "Autumnal Equinox");
          put("jq.hanLu", "Cold Dew");
          put("jq.shuangJiang", "First Frost");
          put("jq.liDong", "Beginning of Winter");
          put("jq.xiaoXue", "Light Snow");
          put("jq.daXue", "Heavy Snow");
          put("sn.qingLong", "Azure Dragon");
          put("sn.baiHu", "White Tiger");
          put("sn.zhuQue", "Rosefinch");
          put("sn.xuanWu", "Black Tortoise");
          put("sn.tianEn", "Serene Grace");
          put("sn.siShen", "Death");
          put("sn.tianMa", "Pegasus");
          put("sn.baLong", "Eight Dragon");
          put("sn.jiuHu", "Nine Tiger");
          put("sn.qiNiao", "Seven Bird");
          put("sn.liuShe", "Six Snake");
          put("s.none", "None");
          put("s.goodLuck", "Good luck");
          put("s.badLuck", "Bad luck");
          put("s.yin", "Yin");
          put("s.yang", "Yang");
          put("s.white", "White");
          put("s.black", "Black");
          put("s.blue", "Blue");
          put("s.green", "Green");
          put("s.yellow", "Yellow");
          put("s.red", "Red");
          put("s.purple", "Purple");
          put("jr.chuXi", "Chinese New Year's Eve");
          put("jr.chunJie", "Luna New Year");
          put("jr.yuanXiao", "Lantern Festival");
          put("jr.duanWu", "Dragon Boat Festival");
          put("jr.qiXi", "Begging Festival");
          put("jr.zhongQiu", "Mid-Autumn Festival");
          put("jr.laBa", "Laba Festival");
          put("jr.yuanDan", "New Year's Day");
          put("jr.qingRen", "Valentine's Day");
          put("jr.fuNv", "Women's Day");
          put("jr.xiaoFei", "Consumer Rights Day");
          put("jr.zhiShu", "Arbor Day");
          put("jr.wuYi", "International Worker's Day");
          put("jr.erTong", "Children's Day");
          put("jr.qingNian", "Youth Day");
          put("jr.yuRen", "April Fools' Day");
          put("jr.jianDang", "Party's Day");
          put("jr.jianJun", "Army Day");
          put("jr.jiaoShi", "Teachers' Day");
          put("jr.guoQing", "National Day");
          put("jr.wanShengYe", "All Saints' Eve");
          put("jr.wanSheng", "All Saints' Day");
          put("jr.pingAn", "Christmas Eve");
          put("jr.shengDan", "Christmas Day");
          put("ts.zhan", "At");
          put("ts.hu", "Household");
          put("ts.zao", "Cooker");
          put("ts.dui", "Pestle");
          put("ts.xi", "Habitat");
          put("ts.win", "Window");
          put("ts.fang", "Room");
          put("ts.chuang", "Bed");
          put("ts.lu", "Stove");
          put("ts.mo", "Mill");
          put("ts.chu", "Kitchen");
          put("ts.ce", "Toilet");
          put("ts.cang", "Depot");
          put("ts.cangKu", "Depot");
          put("ts.daMen", "Gate");
          put("ts.men", "Door");
          put("ts.tang", "Hall");
          put("ly.xianSheng", "Win first");
          put("ly.xianFu", "Lose first");
          put("ly.youYin", "Friend's referral");
          put("ly.foMie", "Buddhism's demise");
          put("ly.daAn", "Great safety");
          put("ly.chiKou", "Chikagoro");
          put("yj.jiSi", "Sacrifice");
          put("yj.qiFu", "Pray");
          put("yj.qiuSi", "Seek heirs");
          put("yj.kaiGuang", "Consecretion");
          put("yj.suHui", "Paint sculptural");
          put("yj.qiJiao", "Build altar");
          put("yj.zhaiJiao", "Taoist rites");
          put("yj.muYu", "Bathing");
          put("yj.chouShen", "Reward gods");
          put("yj.zaoMiao", "Build temple");
          put("yj.siZhao", "Offer kitchen god");
          put("yj.fenXiang", "Burn incense");
          put("yj.xieTu", "Earth gratitude");
          put("yj.chuHuo", "Expel the flame");
          put("yj.diaoKe", "Carving");
          put("yj.jiaQu", "Marriage");
          put("yj.DingHun", "Engagement");
          put("yj.naCai", "Proposing");
          put("yj.wenMing", "Ask name");
          put("yj.naXu", "Uxorilocal marriage");
          put("yj.guiNing", "Visit parents");
          put("yj.anChuang", "Bed placing");
          put("yj.heZhang", "Make up accounts");
          put("yj.guanJi", "Crowning adulthood");
          put("yj.dingMeng", "Make alliance");
          put("yj.jinRenKou", "Adopt");
          put("yj.caiYi", "Dressmaking");
          put("yj.wanMian", "Cosmeticsurgery");
          put("yj.kaiRong", "Open face");
          put("yj.xiuFen", "Grave repair");
          put("yj.qiZuan", "Open coffin");
          put("yj.poTu", "Break earth");
          put("yj.anZang", "Burial");
          put("yj.liBei", "Tombstone erecting");
          put("yj.chengFu", "Formation of clothes");
          put("yj.chuFu", "Mourning clothes removal");
          put("yj.kaiShengFen", "Open grave");
          put("yj.heShouMu", "Make coffin");
          put("yj.ruLian", "Body placing");
          put("yj.yiJiu", "Move coffin");
          put("yj.puDu", "Save soul");
          put("yj.ruZhai", "Enter house");
          put("yj.anXiang", "Incenst placement");
          put("yj.anMen", "Door placing");
          put("yj.xiuZao", "Repair");
          put("yj.qiJi", "Digging");
          put("yj.dongTu", "Break ground");
          put("yj.shangLiang", "Beam placing");
          put("yj.shuZhu", "Erecting pillars");
          put("yj.kaiJing", "Open pond and well");
          put("yj.zuoBei", "Make pond and fill water");
          put("yj.chaiXie", "Smash house");
          put("yj.poWu", "Break house");
          put("yj.huaiYuan", "Demolish");
          put("yj.buYuan", "Mending");
          put("yj.faMuZuoLiang", "Make beams");
          put("yj.zuoZhao", "Make stove");
          put("yj.jieChu", "Removal");
          put("yj.kaiZhuYan", "Build beam");
          put("yj.chuanPing", "Build door");
          put("yj.gaiWuHeJi", "Cover house");
          put("yj.kaiCe", "Open toilet");
          put("yj.zaoCang", "Build depot");
          put("yj.saiXue", "Block nest");
          put("yj.pingZhi", "Repair roads");
          put("yj.zaoQiao", "Build bridge");
          put("yj.zuoCe", "Build toilet");
          put("yj.zhuDi", "Fill");
          put("yj.kaiChi", "Open pond");
          put("yj.faMu", "Lumbering");
          put("yj.kaiQu", "Canalization");
          put("yj.jueJing", "Dig well");
          put("yj.saoShe", "Sweep house");
          put("yj.fangShui", "Drainage");
          put("yj.zaoWu", "Build house");
          put("yj.heJi", "Close ridge");
          put("yj.zaoChuChou", "Livestock thickening");
          put("yj.xiuMen", "Repair door");
          put("yj.dingSang", "Fix stone");
          put("yj.zuoLiang", "Beam construction");
          put("yj.xiuShi", "Decorate wall");
          put("yj.jiaMa", "Erect horse");
          put("yj.kaiShi", "Opening");
          put("yj.guaBian", "Hang plaque");
          put("yj.naChai", "Accept wealth");
          put("yj.qiuCai", "Seek wealth");
          put("yj.kaiCang", "Open depot");
          put("yj.maiChe", "Buy car");
          put("yj.zhiChan", "Buy property");
          put("yj.guYong", "Hire");
          put("yj.chuHuoCai", "Delivery");
          put("yj.anJiXie", "Build machine");
          put("yj.zaoCheQi", "Build car");
          put("yj.jingLuo", "Build loom");
          put("yj.yunNiang", "Brew");
          put("yj.zuoRan", "Dye");
          put("yj.guZhu", "Cast");
          put("yj.zaoChuan", "Build boat");
          put("yj.geMi", "Harvest honey");
          put("yj.zaiZhong", "Farming");
          put("yj.quYu", "Fishing");
          put("yj.jieWang", "Netting");
          put("yj.muYang", "Graze");
          put("yj.anDuiWei", "Build rub");
          put("yj.xiYi", "Learn");
          put("yj.ruXue", "Enter school");
          put("yj.liFa", "Haircut");
          put("yj.tanBing", "Visiting");
          put("yj.jianGui", "Meet noble");
          put("yj.chengChuan", "Ride boat");
          put("yj.duShui", "Cross water");
          put("yj.zhenJiu", "Acupuncture");
          put("yj.chuXing", "Travel");
          put("yj.yiXi", "Move");
          put("yj.fenJu", "Live apart");
          put("yj.TiTou", "Shave");
          put("yj.zhengShou", "Manicure");
          put("yj.naChu", "Feed livestock");
          put("yj.buZhuo", "Catch");
          put("yj.tianLie", "Hunt");
          put("yj.jiaoNiuMa", "Train horse");
          put("yj.huiQinYou", "Meet friends");
          put("yj.fuRen", "Go post");
          put("yj.qiuYi", "See doctor");
          put("yj.zhiBing", "Treat");
          put("yj.ciSong", "Litigation");
          put("yj.qiJiDongTu", "Lay foundation");
          put("yj.poWuHuaiYuan", "Demolish");
          put("yj.gaiWu", "Build house");
          put("yj.zaoCangKu", "Build depot");
          put("yj.liQuanJiaoYi", "Covenant trade");
          put("yj.jiaoYi", "Trade");
          put("yj.liQuan", "Covenant");
          put("yj.anJi", "Install machine");
          put("yj.huiYou", "Meet friends");
          put("yj.qiuYiLiaoBing", "Seek treatment");
          put("yj.zhuShi", "Everything Sucks");
          put("yj.yuShi", "Do nothing else");
          put("yj.xingSang", "Funeral");
          put("yj.duanYi", "Block ant hole");
          put("yj.guiXiu", "Place beam");
          put("xx.bi", "Finish");
          put("xx.yi", "Wing");
          put("xx.ji", "Sieve");
          put("xx.kui", "Qui");
          put("xx.gui", "Ghost");
          put("xx.di", "Foundation");
          put("xx.xu", "Virtual");
          put("xx.wei", "Danger");
          put("xx.zi", "Mouth");
          put("xx.zhen", "Cross-bar");
          put("xx.dou", "Fight");
          put("xx.lou", "Weak");
          put("xx.liu", "Willow");
          put("xx.fang", "House");
          put("xx.xin", "Heart");
          put("xx.shi", "Room");
          put("xx.can", "Join");
          put("xx.jiao", "Horn");
          put("xx.niu", "Ox");
          put("xx.vei", "Stomach");
          put("xx.xing", "Star");
          put("xx.zhang", "Chang");
          put("xx.tail", "Tail");
          put("xx.qiang", "Wall");
          put("xx.jing", "Well");
          put("xx.kang", "Kang");
          put("xx.nv", "Female");
          put("xx.mao", "Mao");
          put("sz.chun", "Spring");
          put("sz.xia", "Summer");
          put("sz.qiu", "Autumn");
          put("sz.dong", "Winter");
          put("yx.shuo", "New");
          put("yx.eMeiXin", "New waxing");
          put("yx.eMei", "Waxing");
          put("yx.xi", "Evening");
          put("yx.shangXian", "First quarter");
          put("yx.jiuYe", "Nine night");
          put("yx.night", "Night");
          put("yx.jianYingTu", "Gibbous");
          put("yx.xiaoWang", "Little full");
          put("yx.wang", "Full");
          put("yx.jianKuiTu", "Disseminating");
          put("yx.xiaXian", "Third quarter");
          put("yx.eMeiCan", "Waning waxing");
          put("yx.can", "Waning");
          put("yx.xiao", "Daybreak");
          put("yx.hui", "Obscure");
          put("ny.sangZhe", "Cudrania");
          put("ny.baiLa", "Wax");
          put("ny.yangLiu", "Willow");
          put("ny.jinBo", "Foil");
          put("ny.haiZhong", "Sea");
          put("ny.daHai", "Ocean");
          put("ny.shaZhong", "Sand");
          put("ny.luZhong", "Stove");
          put("ny.shanXia", "Piedmont");
          put("ny.daLin", "Forest");
          put("ny.pingDi", "Land");
          put("ny.luPang", "Roadside");
          put("ny.biShang", "Wall");
          put("ny.jianFeng", "Blade");
          put("ny.shanTou", "Hilltop");
          put("ny.fuDeng", "Light");
          put("ny.jianXia", "Valleyn");
          put("ny.tianHe", "River");
          put("ny.chengTou", "City");
          put("ny.daYi", "Post");
          put("ny.chaiChuan", "Ornaments");
          put("ny.quanZhong", "Spring");
          put("ny.daXi", "Stream");
          put("ny.wuShang", "Roof");
          put("ny.piLi", "Thunderbolt");
          put("ny.tianShang", "Sky");
          put("ny.songBo", "Coniferin");
          put("ny.shiLiu", "Pomegranate");
          put("ny.changLiu", "Flows");
        }
      });
    }
  };

  private static final Map<String, Map<String, Map<String, String>>> DICT_STRING = new HashMap<String, Map<String, Map<String, String>>>() {
    {
      put("LunarUtil", new HashMap<String, Map<String, String>>() {
        {
          put("TIAN_SHEN_TYPE", new HashMap<String, String>());
          put("TIAN_SHEN_TYPE_LUCK", new HashMap<String, String>());
          put("XIU_LUCK", new HashMap<String, String>());
          put("LU", new HashMap<String, String>());
          put("XIU", new HashMap<String, String>());
          put("SHA", new HashMap<String, String>());
          put("POSITION_DESC", new HashMap<String, String>());
          put("NAYIN", new HashMap<String, String>());
          put("WU_XING_GAN", new HashMap<String, String>());
          put("WU_XING_ZHI", new HashMap<String, String>());
          put("SHOU", new HashMap<String, String>());
          put("GONG", new HashMap<String, String>());
          put("FESTIVAL", new HashMap<String, String>());
          put("ZHENG", new HashMap<String, String>());
          put("ANIMAL", new HashMap<String, String>());
          put("SHI_SHEN_GAN", new HashMap<String, String>());
          put("SHI_SHEN_ZHI", new HashMap<String, String>());
          put("XIU_SONG", new HashMap<String, String>());
        }
      });
      put("SolarUtil", new HashMap<String, Map<String, String>>() {
        {
          put("FESTIVAL", new HashMap<String, String>());
        }
      });
      put("TaoUtil", new HashMap<String, Map<String, String>>() {
        {
          put("BA_HUI", new HashMap<String, String>());
          put("BA_JIE", new HashMap<String, String>());
        }
      });
    }
  };

  private static final Map<String, Map<String, Map<String, Integer>>> DICT_NUMBER = new HashMap<String, Map<String, Map<String, Integer>>>() {
    {
      put("LunarUtil", new HashMap<String, Map<String, Integer>>() {
        {
          put("ZHI_TIAN_SHEN_OFFSET", new HashMap<String, Integer>());
          put("CHANG_SHENG_OFFSET", new HashMap<String, Integer>());
        }
      });
    }
  };

  private static final Map<String, Map<String, Map<String, List<String>>>> DICT_ARRAY = new HashMap<String, Map<String, Map<String, List<String>>>>() {
    {
      put("LunarUtil", new HashMap<String, Map<String, List<String>>>() {
        {
          put("ZHI_HIDE_GAN", new HashMap<String, List<String>>());
        }
      });
    }
  };

  private static final Map<String, Map<String, String[]>> ARRAYS = new HashMap<String, Map<String, String[]>>() {
    {
      put("LunarUtil", new HashMap<String, String[]>() {
        {
          put("GAN", null);
          put("ZHI", null);
          put("JIA_ZI", null);
          put("ZHI_XING", null);
          put("XUN", null);
          put("XUN_KONG", null);
          put("CHONG", null);
          put("CHONG_GAN", null);
          put("CHONG_GAN_TIE", null);
          put("HE_GAN_5", null);
          put("HE_ZHI_6", null);
          put("SHENGXIAO", null);
          put("NUMBER", null);
          put("POSITION_XI", null);
          put("POSITION_YANG_GUI", null);
          put("POSITION_YIN_GUI", null);
          put("POSITION_FU", null);
          put("POSITION_FU_2", null);
          put("POSITION_CAI", null);
          put("POSITION_TAI_SUI_YEAR", null);
          put("POSITION_GAN", null);
          put("POSITION_ZHI", null);
          put("JIE_QI", null);
          put("JIE_QI_IN_USE", null);
          put("TIAN_SHEN", null);
          put("SHEN_SHA", null);
          put("PENGZU_GAN", null);
          put("PENGZU_ZHI", null);
          put("MONTH_ZHI", null);
          put("CHANG_SHENG", null);
          put("HOU", null);
          put("WU_HOU", null);
          put("POSITION_TAI_DAY", null);
          put("POSITION_TAI_MONTH", null);
          put("YI_JI", null);
          put("LIU_YAO", null);
          put("MONTH", null);
          put("SEASON", null);
          put("DAY", null);
          put("YUE_XIANG", null);
        }
      });
      put("SolarUtil", new HashMap<String, String[]>() {
        {
          put("WEEK", null);
          put("XINGZUO", null);
        }
      });
      put("TaoUtil", new HashMap<String, String[]>() {
        {
          put("AN_WU", null);
        }
      });
      put("FotoUtil", new HashMap<String, String[]>() {
        {
          put("XIU_27", null);
        }
      });
      put("NineStarUtil", new HashMap<String, String[]>() {
        {
          put("NUMBER", null);
          put("WU_XING", null);
          put("POSITION", null);
          put("LUCK_XUAN_KONG", null);
          put("YIN_YANG_QI_MEN", null);
          put("COLOR", null);
        }
      });
    }
  };

  private static String replace(String key) {
    String s = key;
    Matcher matcher = PATTERN.matcher(s);
    while (matcher.find()) {
      String k = matcher.group(1);
      s = s.replace("{" + k + "}", getMessage(k));
    }
    return s;
  }

  private static void updateArray(String className) {
    Map<String, String[]> klass = ARRAYS.get(className);
    for (Map.Entry<String, String[]> prop : klass.entrySet()) {
      String propName = prop.getKey();
      String[] propValue = prop.getValue();
      for (int i = 0, j = propValue.length; i < j; i++) {
        String v = replace(propValue[i]);
        if ("LunarUtil".equals(className)) {
          if ("GAN".equals(propName)) {
            LunarUtil.GAN[i] = v;
          } else if ("ZHI".equals(propName)) {
            LunarUtil.ZHI[i] = v;
          } else if ("JIA_ZI".equals(propName)) {
            LunarUtil.JIA_ZI[i] = v;
          } else if ("ZHI_XING".equals(propName)) {
            LunarUtil.ZHI_XING[i] = v;
          } else if ("XUN".equals(propName)) {
            LunarUtil.XUN[i] = v;
          } else if ("XUN_KONG".equals(propName)) {
            LunarUtil.XUN_KONG[i] = v;
          } else if ("CHONG".equals(propName)) {
            LunarUtil.CHONG[i] = v;
          } else if ("CHONG_GAN".equals(propName)) {
            LunarUtil.CHONG_GAN[i] = v;
          } else if ("CHONG_GAN_TIE".equals(propName)) {
            LunarUtil.CHONG_GAN_TIE[i] = v;
          } else if ("HE_GAN_5".equals(propName)) {
            LunarUtil.HE_GAN_5[i] = v;
          } else if ("HE_ZHI_6".equals(propName)) {
            LunarUtil.HE_ZHI_6[i] = v;
          } else if ("SHENGXIAO".equals(propName)) {
            LunarUtil.SHENGXIAO[i] = v;
          } else if ("NUMBER".equals(propName)) {
            LunarUtil.NUMBER[i] = v;
          } else if ("POSITION_XI".equals(propName)) {
            LunarUtil.POSITION_XI[i] = v;
          } else if ("POSITION_YANG_GUI".equals(propName)) {
            LunarUtil.POSITION_YANG_GUI[i] = v;
          } else if ("POSITION_YIN_GUI".equals(propName)) {
            LunarUtil.POSITION_YIN_GUI[i] = v;
          } else if ("POSITION_FU".equals(propName)) {
            LunarUtil.POSITION_FU[i] = v;
          } else if ("POSITION_FU_2".equals(propName)) {
            LunarUtil.POSITION_FU_2[i] = v;
          } else if ("POSITION_CAI".equals(propName)) {
            LunarUtil.POSITION_CAI[i] = v;
          } else if ("POSITION_TAI_SUI_YEAR".equals(propName)) {
            LunarUtil.POSITION_TAI_SUI_YEAR[i] = v;
          } else if ("POSITION_GAN".equals(propName)) {
            LunarUtil.POSITION_GAN[i] = v;
          } else if ("POSITION_ZHI".equals(propName)) {
            LunarUtil.POSITION_ZHI[i] = v;
          } else if ("JIE_QI".equals(propName)) {
            LunarUtil.JIE_QI[i] = v;
          } else if ("JIE_QI_IN_USE".equals(propName)) {
            LunarUtil.JIE_QI_IN_USE[i] = v;
          } else if ("TIAN_SHEN".equals(propName)) {
            LunarUtil.TIAN_SHEN[i] = v;
          } else if ("SHEN_SHA".equals(propName)) {
            LunarUtil.SHEN_SHA[i] = v;
          } else if ("PENGZU_GAN".equals(propName)) {
            LunarUtil.PENGZU_GAN[i] = v;
          } else if ("PENGZU_ZHI".equals(propName)) {
            LunarUtil.PENGZU_ZHI[i] = v;
          } else if ("MONTH_ZHI".equals(propName)) {
            LunarUtil.MONTH_ZHI[i] = v;
          } else if ("CHANG_SHENG".equals(propName)) {
            LunarUtil.CHANG_SHENG[i] = v;
          } else if ("HOU".equals(propName)) {
            LunarUtil.HOU[i] = v;
          } else if ("WU_HOU".equals(propName)) {
            LunarUtil.WU_HOU[i] = v;
          } else if ("POSITION_TAI_DAY".equals(propName)) {
            LunarUtil.POSITION_TAI_DAY[i] = v;
          } else if ("POSITION_TAI_MONTH".equals(propName)) {
            LunarUtil.POSITION_TAI_MONTH[i] = v;
          } else if ("YI_JI".equals(propName)) {
            LunarUtil.YI_JI[i] = v;
          } else if ("LIU_YAO".equals(propName)) {
            LunarUtil.LIU_YAO[i] = v;
          } else if ("MONTH".equals(propName)) {
            LunarUtil.MONTH[i] = v;
          } else if ("SEASON".equals(propName)) {
            LunarUtil.SEASON[i] = v;
          } else if ("DAY".equals(propName)) {
            LunarUtil.DAY[i] = v;
          } else if ("YUE_XIANG".equals(propName)) {
            LunarUtil.YUE_XIANG[i] = v;
          }
        } else if ("SolarUtil".equals(className)) {
          if ("WEEK".equals(propName)) {
            SolarUtil.WEEK[i] = v;
          } else if ("XINGZUO".equals(propName)) {
            SolarUtil.XINGZUO[i] = v;
          }
        } else if ("TaoUtil".equals(className)) {
          if ("AN_WU".equals(propName)) {
            TaoUtil.AN_WU[i] = v;
          }
        } else if ("FotoUtil".equals(className)) {
          if ("XIU_27".equals(propName)) {
            FotoUtil.XIU_27[i] = v;
          }
        } else if ("NineStarUtil".equals(className)) {
          if ("NUMBER".equals(propName)) {
            NineStarUtil.NUMBER[i] = v;
          } else if ("WU_XING".equals(propName)) {
            NineStarUtil.WU_XING[i] = v;
          } else if ("POSITION".equals(propName)) {
            NineStarUtil.POSITION[i] = v;
          } else if ("LUCK_XUAN_KONG".equals(propName)) {
            NineStarUtil.LUCK_XUAN_KONG[i] = v;
          } else if ("YIN_YANG_QI_MEN".equals(propName)) {
            NineStarUtil.YIN_YANG_QI_MEN[i] = v;
          } else if ("COLOR".equals(propName)) {
            NineStarUtil.COLOR[i] = v;
          }
        }
      }
    }
  }

  private static void updateStringDictionary(String className) {
    Map<String, Map<String, String>> klass = DICT_STRING.get(className);
    for (Map.Entry<String, Map<String, String>> prop : klass.entrySet()) {
      String propName = prop.getKey();
      Map<String, String> propValue = prop.getValue();
      for (Map.Entry<String, String> o : propValue.entrySet()) {
        String k = replace(o.getKey());
        String v = replace(o.getValue());
        if ("LunarUtil".equals(className)) {
          if ("TIAN_SHEN_TYPE".equals(propName)) {
            LunarUtil.TIAN_SHEN_TYPE.put(k, v);
          } else if ("TIAN_SHEN_TYPE_LUCK".equals(propName)) {
            LunarUtil.TIAN_SHEN_TYPE_LUCK.put(k, v);
          } else if ("XIU_LUCK".equals(propName)) {
            LunarUtil.XIU_LUCK.put(k, v);
          } else if ("LU".equals(propName)) {
            LunarUtil.LU.put(k, v);
          } else if ("XIU".equals(propName)) {
            LunarUtil.XIU.put(k, v);
          } else if ("SHA".equals(propName)) {
            LunarUtil.SHA.put(k, v);
          } else if ("POSITION_DESC".equals(propName)) {
            LunarUtil.POSITION_DESC.put(k, v);
          } else if ("NAYIN".equals(propName)) {
            LunarUtil.NAYIN.put(k, v);
          } else if ("WU_XING_GAN".equals(propName)) {
            LunarUtil.WU_XING_GAN.put(k, v);
          } else if ("WU_XING_ZHI".equals(propName)) {
            LunarUtil.WU_XING_ZHI.put(k, v);
          } else if ("SHOU".equals(propName)) {
            LunarUtil.SHOU.put(k, v);
          } else if ("GONG".equals(propName)) {
            LunarUtil.GONG.put(k, v);
          } else if ("FESTIVAL".equals(propName)) {
            LunarUtil.FESTIVAL.put(k, v);
          } else if ("ZHENG".equals(propName)) {
            LunarUtil.ZHENG.put(k, v);
          } else if ("ANIMAL".equals(propName)) {
            LunarUtil.ANIMAL.put(k, v);
          } else if ("SHI_SHEN_GAN".equals(propName)) {
            LunarUtil.SHI_SHEN_GAN.put(k, v);
          } else if ("SHI_SHEN_ZHI".equals(propName)) {
            LunarUtil.SHI_SHEN_ZHI.put(k, v);
          } else if ("XIU_SONG".equals(propName)) {
            LunarUtil.XIU_SONG.put(k, v);
          }
        } else if ("SolarUtil".equals(className)) {
          if ("FESTIVAL".equals(propName)) {
            SolarUtil.FESTIVAL.put(k, v);
          }
        } else if ("TaoUtil".equals(className)) {
          if ("BA_HUI".equals(propName)) {
            TaoUtil.BA_HUI.put(k, v);
          } else if ("BA_JIE".equals(propName)) {
            TaoUtil.BA_JIE.put(k, v);
          }
        }
      }
    }
  }

  private static void updateNumberDictionary(String className) {
    Map<String, Map<String, Integer>> klass = DICT_NUMBER.get(className);
    for (Map.Entry<String, Map<String, Integer>> prop : klass.entrySet()) {
      String propName = prop.getKey();
      Map<String, Integer> propValue = prop.getValue();
      for (Map.Entry<String, Integer> o : propValue.entrySet()) {
        String k = replace(o.getKey());
        int v = o.getValue();
        if ("LunarUtil".equals(className)) {
          if ("ZHI_TIAN_SHEN_OFFSET".equals(propName)) {
            LunarUtil.ZHI_TIAN_SHEN_OFFSET.put(k, v);
          } else if ("CHANG_SHENG_OFFSET".equals(propName)) {
            LunarUtil.CHANG_SHENG_OFFSET.put(k, v);
          }
        }
      }
    }
  }

  private static void updateArrayDictionary(String className) {
    Map<String, Map<String, List<String>>> klass = DICT_ARRAY.get(className);
    for (Map.Entry<String, Map<String, List<String>>> prop : klass.entrySet()) {
      String propName = prop.getKey();
      Map<String, List<String>> propValue = prop.getValue();
      for (Map.Entry<String, List<String>> o : propValue.entrySet()) {
        List<String> nv = new ArrayList<String>();
        for (String v : o.getValue()) {
          nv.add(replace(v));
        }
        if ("LunarUtil".equals(className)) {
          if ("ZHI_HIDE_GAN".equals(propName)) {
            LunarUtil.ZHI_HIDE_GAN.put(replace(o.getKey()), nv);
          }
        }
      }
    }
  }

  private static void update() {
    for (String c : ARRAYS.keySet()) {
      updateArray(c);
    }
    for (String c : DICT_STRING.keySet()) {
      updateStringDictionary(c);
    }
    for (String c : DICT_NUMBER.keySet()) {
      updateNumberDictionary(c);
    }
    for (String c : DICT_ARRAY.keySet()) {
      updateArrayDictionary(c);
    }
  }

  public static String getMessage(String key) {
    Map<String, String> messages = MESSAGES.get(LANG);
    String value = null;
    if (null != messages) {
      value = messages.get(key);
    }
    if (null == value) {
      messages = MESSAGES.get(DEFAULT_LANG);
    }
    if (null != messages) {
      value = messages.get(key);
    }
    return null == value ? key : value;
  }

  public static void setMessages(String lang, Map<String, String> messages) {
    if (null == messages) {
      return;
    }
    Map<String, String> v = MESSAGES.get(lang);
    if (null == v) {
      v = new HashMap<String, String>();
      MESSAGES.put(lang, v);
    }
    v.putAll(messages);
    update();
  }

  public static String getLanguage() {
    return LANG;
  }

  public static void setLanguage(String lang) {
    if (MESSAGES.containsKey(lang)) {
      LANG = lang;
      update();
    }
  }

  private static void initArray() {
    Map<String, String[]> klass = ARRAYS.get("LunarUtil");
    int n = LunarUtil.GAN.length;
    String[] v = new String[n];
    System.arraycopy(LunarUtil.GAN, 0, v, 0, n);
    klass.put("GAN", v);

    n = LunarUtil.ZHI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.ZHI, 0, v, 0, n);
    klass.put("ZHI", v);

    n = LunarUtil.JIA_ZI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.JIA_ZI, 0, v, 0, n);
    klass.put("JIA_ZI", v);

    n = LunarUtil.ZHI_XING.length;
    v = new String[n];
    System.arraycopy(LunarUtil.ZHI_XING, 0, v, 0, n);
    klass.put("ZHI_XING", v);

    n = LunarUtil.XUN.length;
    v = new String[n];
    System.arraycopy(LunarUtil.XUN, 0, v, 0, n);
    klass.put("XUN", v);

    n = LunarUtil.XUN_KONG.length;
    v = new String[n];
    System.arraycopy(LunarUtil.XUN_KONG, 0, v, 0, n);
    klass.put("XUN_KONG", v);

    n = LunarUtil.CHONG.length;
    v = new String[n];
    System.arraycopy(LunarUtil.CHONG, 0, v, 0, n);
    klass.put("CHONG", v);

    n = LunarUtil.CHONG_GAN.length;
    v = new String[n];
    System.arraycopy(LunarUtil.CHONG_GAN, 0, v, 0, n);
    klass.put("CHONG_GAN", v);

    n = LunarUtil.CHONG_GAN_TIE.length;
    v = new String[n];
    System.arraycopy(LunarUtil.CHONG_GAN_TIE, 0, v, 0, n);
    klass.put("CHONG_GAN_TIE", v);

    n = LunarUtil.HE_GAN_5.length;
    v = new String[n];
    System.arraycopy(LunarUtil.HE_GAN_5, 0, v, 0, n);
    klass.put("HE_GAN_5", v);

    n = LunarUtil.HE_ZHI_6.length;
    v = new String[n];
    System.arraycopy(LunarUtil.HE_ZHI_6, 0, v, 0, n);
    klass.put("HE_ZHI_6", v);

    n = LunarUtil.SHENGXIAO.length;
    v = new String[n];
    System.arraycopy(LunarUtil.SHENGXIAO, 0, v, 0, n);
    klass.put("SHENGXIAO", v);

    n = LunarUtil.NUMBER.length;
    v = new String[n];
    System.arraycopy(LunarUtil.NUMBER, 0, v, 0, n);
    klass.put("NUMBER", v);

    n = LunarUtil.POSITION_XI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_XI, 0, v, 0, n);
    klass.put("POSITION_XI", v);

    n = LunarUtil.POSITION_YANG_GUI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_YANG_GUI, 0, v, 0, n);
    klass.put("POSITION_YANG_GUI", v);

    n = LunarUtil.POSITION_YIN_GUI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_YIN_GUI, 0, v, 0, n);
    klass.put("POSITION_YIN_GUI", v);

    n = LunarUtil.POSITION_FU.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_FU, 0, v, 0, n);
    klass.put("POSITION_FU", v);

    n = LunarUtil.POSITION_FU_2.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_FU_2, 0, v, 0, n);
    klass.put("POSITION_FU_2", v);

    n = LunarUtil.POSITION_CAI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_CAI, 0, v, 0, n);
    klass.put("POSITION_CAI", v);

    n = LunarUtil.POSITION_TAI_SUI_YEAR.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_TAI_SUI_YEAR, 0, v, 0, n);
    klass.put("POSITION_TAI_SUI_YEAR", v);

    n = LunarUtil.POSITION_GAN.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_GAN, 0, v, 0, n);
    klass.put("POSITION_GAN", v);

    n = LunarUtil.POSITION_ZHI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_ZHI, 0, v, 0, n);
    klass.put("POSITION_ZHI", v);

    n = LunarUtil.JIE_QI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.JIE_QI, 0, v, 0, n);
    klass.put("JIE_QI", v);

    n = LunarUtil.JIE_QI_IN_USE.length;
    v = new String[n];
    System.arraycopy(LunarUtil.JIE_QI_IN_USE, 0, v, 0, n);
    klass.put("JIE_QI_IN_USE", v);

    n = LunarUtil.TIAN_SHEN.length;
    v = new String[n];
    System.arraycopy(LunarUtil.TIAN_SHEN, 0, v, 0, n);
    klass.put("TIAN_SHEN", v);

    n = LunarUtil.SHEN_SHA.length;
    v = new String[n];
    System.arraycopy(LunarUtil.SHEN_SHA, 0, v, 0, n);
    klass.put("SHEN_SHA", v);

    n = LunarUtil.PENGZU_GAN.length;
    v = new String[n];
    System.arraycopy(LunarUtil.PENGZU_GAN, 0, v, 0, n);
    klass.put("PENGZU_GAN", v);

    n = LunarUtil.PENGZU_ZHI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.PENGZU_ZHI, 0, v, 0, n);
    klass.put("PENGZU_ZHI", v);

    n = LunarUtil.MONTH_ZHI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.MONTH_ZHI, 0, v, 0, n);
    klass.put("MONTH_ZHI", v);

    n = LunarUtil.CHANG_SHENG.length;
    v = new String[n];
    System.arraycopy(LunarUtil.CHANG_SHENG, 0, v, 0, n);
    klass.put("CHANG_SHENG", v);

    n = LunarUtil.HOU.length;
    v = new String[n];
    System.arraycopy(LunarUtil.HOU, 0, v, 0, n);
    klass.put("HOU", v);

    n = LunarUtil.WU_HOU.length;
    v = new String[n];
    System.arraycopy(LunarUtil.WU_HOU, 0, v, 0, n);
    klass.put("WU_HOU", v);

    n = LunarUtil.POSITION_TAI_DAY.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_TAI_DAY, 0, v, 0, n);
    klass.put("POSITION_TAI_DAY", v);

    n = LunarUtil.POSITION_TAI_MONTH.length;
    v = new String[n];
    System.arraycopy(LunarUtil.POSITION_TAI_MONTH, 0, v, 0, n);
    klass.put("POSITION_TAI_MONTH", v);

    n = LunarUtil.YI_JI.length;
    v = new String[n];
    System.arraycopy(LunarUtil.YI_JI, 0, v, 0, n);
    klass.put("YI_JI", v);

    n = LunarUtil.LIU_YAO.length;
    v = new String[n];
    System.arraycopy(LunarUtil.LIU_YAO, 0, v, 0, n);
    klass.put("LIU_YAO", v);

    n = LunarUtil.MONTH.length;
    v = new String[n];
    System.arraycopy(LunarUtil.MONTH, 0, v, 0, n);
    klass.put("MONTH", v);

    n = LunarUtil.SEASON.length;
    v = new String[n];
    System.arraycopy(LunarUtil.SEASON, 0, v, 0, n);
    klass.put("SEASON", v);

    n = LunarUtil.DAY.length;
    v = new String[n];
    System.arraycopy(LunarUtil.DAY, 0, v, 0, n);
    klass.put("DAY", v);

    n = LunarUtil.YUE_XIANG.length;
    v = new String[n];
    System.arraycopy(LunarUtil.YUE_XIANG, 0, v, 0, n);
    klass.put("YUE_XIANG", v);

    klass = ARRAYS.get("SolarUtil");

    n = SolarUtil.WEEK.length;
    v = new String[n];
    System.arraycopy(SolarUtil.WEEK, 0, v, 0, n);
    klass.put("WEEK", v);

    n = SolarUtil.XINGZUO.length;
    v = new String[n];
    System.arraycopy(SolarUtil.XINGZUO, 0, v, 0, n);
    klass.put("XINGZUO", v);

    klass = ARRAYS.get("TaoUtil");
    n = TaoUtil.AN_WU.length;
    v = new String[n];
    System.arraycopy(TaoUtil.AN_WU, 0, v, 0, n);
    klass.put("AN_WU", v);

    klass = ARRAYS.get("FotoUtil");
    n = FotoUtil.XIU_27.length;
    v = new String[n];
    System.arraycopy(FotoUtil.XIU_27, 0, v, 0, n);
    klass.put("XIU_27", v);

    klass = ARRAYS.get("NineStarUtil");
    n = NineStarUtil.NUMBER.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.NUMBER, 0, v, 0, n);
    klass.put("NUMBER", v);

    n = NineStarUtil.WU_XING.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.WU_XING, 0, v, 0, n);
    klass.put("WU_XING", v);

    n = NineStarUtil.POSITION.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.POSITION, 0, v, 0, n);
    klass.put("POSITION", v);

    n = NineStarUtil.LUCK_XUAN_KONG.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.LUCK_XUAN_KONG, 0, v, 0, n);
    klass.put("LUCK_XUAN_KONG", v);

    n = NineStarUtil.YIN_YANG_QI_MEN.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.YIN_YANG_QI_MEN, 0, v, 0, n);
    klass.put("YIN_YANG_QI_MEN", v);

    n = NineStarUtil.COLOR.length;
    v = new String[n];
    System.arraycopy(NineStarUtil.COLOR, 0, v, 0, n);
    klass.put("COLOR", v);
  }

  private static void initStringDictionary() {
    Map<String, Map<String, String>> v = DICT_STRING.get("LunarUtil");
    v.get("TIAN_SHEN_TYPE").putAll(LunarUtil.TIAN_SHEN_TYPE);
    v.get("TIAN_SHEN_TYPE_LUCK").putAll(LunarUtil.TIAN_SHEN_TYPE_LUCK);
    v.get("XIU_LUCK").putAll(LunarUtil.XIU_LUCK);
    v.get("LU").putAll(LunarUtil.LU);
    v.get("XIU").putAll(LunarUtil.XIU);
    v.get("SHA").putAll(LunarUtil.SHA);
    v.get("POSITION_DESC").putAll(LunarUtil.POSITION_DESC);
    v.get("NAYIN").putAll(LunarUtil.NAYIN);
    v.get("WU_XING_GAN").putAll(LunarUtil.WU_XING_GAN);
    v.get("WU_XING_ZHI").putAll(LunarUtil.WU_XING_ZHI);
    v.get("SHOU").putAll(LunarUtil.SHOU);
    v.get("GONG").putAll(LunarUtil.GONG);
    v.get("FESTIVAL").putAll(LunarUtil.FESTIVAL);
    v.get("ZHENG").putAll(LunarUtil.ZHENG);
    v.get("ANIMAL").putAll(LunarUtil.ANIMAL);
    v.get("SHI_SHEN_GAN").putAll(LunarUtil.SHI_SHEN_GAN);
    v.get("SHI_SHEN_ZHI").putAll(LunarUtil.SHI_SHEN_ZHI);
    v.get("XIU_SONG").putAll(LunarUtil.XIU_SONG);

    v = DICT_STRING.get("SolarUtil");
    v.get("FESTIVAL").putAll(SolarUtil.FESTIVAL);

    v = DICT_STRING.get("TaoUtil");
    v.get("BA_HUI").putAll(TaoUtil.BA_HUI);
    v.get("BA_JIE").putAll(TaoUtil.BA_JIE);
  }

  private static void initNumberDictionary() {
    Map<String, Map<String, Integer>> v = DICT_NUMBER.get("LunarUtil");
    v.get("ZHI_TIAN_SHEN_OFFSET").putAll(LunarUtil.ZHI_TIAN_SHEN_OFFSET);
    v.get("CHANG_SHENG_OFFSET").putAll(LunarUtil.CHANG_SHENG_OFFSET);
  }

  private static void initArrayDictionary() {
    Map<String, Map<String, List<String>>> v = DICT_ARRAY.get("LunarUtil");
    Map<String, List<String>> m = v.get("ZHI_HIDE_GAN");
    for (Map.Entry<String, List<String>> o : LunarUtil.ZHI_HIDE_GAN.entrySet()) {
      m.put(o.getKey(), new ArrayList<String>(o.getValue()));
    }
  }

  public static void init() {
    if (INIT) {
      return;
    }
    INIT = true;
    initArray();
    initStringDictionary();
    initNumberDictionary();
    initArrayDictionary();
    setLanguage(DEFAULT_LANG);
  }

  static {
    init();
  }
}
