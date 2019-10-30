package com.medtap.network.library.data

/**
 * 描述：
 *
 * @author ycy
 * @date 2019-10-22
 */
 data class DataBean(val json: String) {

    /**
     * yesterday : {"date":"16日星期三","high":"高温 -1℃","fx":"西南风","low":"低温 -16℃","fl":"<![CDATA[3-4级]]>","type":"晴"}
     * city : 沈阳
     * forecast : [{"date":"17日星期四","high":"高温 -3℃","fengli":"<![CDATA[<3级]]>","low":"低温 -17℃","fengxiang":"东北风","type":"晴"},{"date":"18日星期五","high":"高温 1℃","fengli":"<![CDATA[<3级]]>","low":"低温 -14℃","fengxiang":"西南风","type":"晴"},{"date":"19日星期六","high":"高温 -2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -14℃","fengxiang":"西北风","type":"晴"},{"date":"20日星期天","high":"高温 -2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -12℃","fengxiang":"西北风","type":"晴"},{"date":"21日星期一","high":"高温 3℃","fengli":"<![CDATA[<3级]]>","low":"低温 -10℃","fengxiang":"西南风","type":"晴"}]
     * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
     * wendu : -2
     */

     var yesterday: DataBean.YesterdayBean? = null
     var city: String? = null
     var ganmao: String? = null
     var wendu: String? = null
     var forecast: List<ForecastBean>? = null


    class YesterdayBean {
        /**
         * date : 16日星期三
         * high : 高温 -1℃
         * fx : 西南风
         * low : 低温 -16℃
         * fl : <![CDATA[3-4级]]>
         * type : 晴
         */

        var date: String? = null
        var high: String? = null
        var fx: String? = null
        var low: String? = null
        var fl: String? = null
        var type: String? = null
        override fun toString(): String {
            return "YesterdayBean(date=$date, high=$high, fx=$fx, low=$low, fl=$fl, type=$type)"
        }


    }

    class ForecastBean {
        /**
         * date : 17日星期四
         * high : 高温 -3℃
         * fengli : <![CDATA[<3级]]>
         * low : 低温 -17℃
         * fengxiang : 东北风
         * type : 晴
         */

        var date: String? = null
        var high: String? = null
        var fengli: String? = null
        var low: String? = null
        var fengxiang: String? = null
        var type: String? = null
        override fun toString(): String {
            return "ForecastBean(date=$date, high=$high, fengli=$fengli, low=$low, fengxiang=$fengxiang, type=$type)"
        }

    }

    override fun toString(): String {
        return json
    }


}