package com.medtap.network.commen_network_util

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.medtap.network.library.ObserverCallBack.DesCallBack
import com.medtap.network.library.data.DataBean
import com.medtap.network.vm.MainVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cityName = "西安"

    var requestStartTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        request(cityName)
        tv_request.setOnClickListener { request(cityName) }
    }

    fun request(cityName: String) {

        val mainVM = MainVM()
        requestStartTime = System.currentTimeMillis()
        mainVM.getData(cityName, object : DesCallBack<DataBean> {
            @SuppressLint("SetTextI18n")
            override fun success(any: DataBean) {
                val dataBean = Gson().fromJson(any.json, DataBean::class.java)
                tv_request_time.text = "请求耗时：${(System.currentTimeMillis()-requestStartTime)}ms"
                requestStartTime = System.currentTimeMillis()
                setData(dataBean)
            }

            override fun failed(e: Throwable) {
                Log.i("failed", e.message)
            }

        })
    }


    @SuppressLint("SetTextI18n")
    private fun setData(any: DataBean?) {
        tv_city.text = "城市:$cityName"
        tv_city_forecast1.text = "城市:$cityName"
        tv_city_forecast2.text = "城市:$cityName"
        tv_city_forecast3.text = "城市:$cityName"
        tv_city_forecast4.text = "城市:$cityName"
        tv_city_forecast5.text = "城市:$cityName"
        tv_city_yesterday.text = "城市:$cityName"

        tv_ganmao.text = "建议:${any?.ganmao}"
        tv_wendu.text = "温度:${any?.wendu}"

        tv_date_yesterday.text = "日期:${any?.yesterday?.date}"
        tv_fengli_yesterday.text = "风力:${any?.yesterday?.fl}"
        tv_fengxiang_yesterday.text = "风向:${any?.yesterday?.fx}"
        tv_high_yesterday.text = "最高温度:${any?.yesterday?.high}"
        tv_low_yesterday.text = "最低温度:${any?.yesterday?.low}"
        tv_type_yesterday.text = "天气:${any?.yesterday?.type}"

        tv_date_forecast1.text = "日期:${any!!.forecast?.get(0)!!.date}"
        tv_fengli_forecast1.text = "风力:${any.forecast?.get(0)!!.fengli}"
        tv_fengxiang_forecast1.text = "风向:${any.forecast?.get(0)!!.fengxiang}"
        tv_high_forecast1.text = "最高温度:${any.forecast?.get(0)!!.high}"
        tv_low_forecast1.text = "最低温度:${any.forecast?.get(0)!!.low}"
        tv_type_forecast1.text = "天气:${any.forecast?.get(0)!!.type}"

        tv_date_forecast2.text = "日期:${any.forecast?.get(1)!!.date}"
        tv_fengli_forecast2.text = "风力:${any.forecast?.get(1)!!.fengli}"
        tv_fengxiang_forecast2.text = "风向:${any.forecast?.get(1)!!.fengxiang}"
        tv_high_forecast2.text = "最高温度:${any.forecast?.get(1)!!.high}"
        tv_low_forecast2.text = "最低温度:${any.forecast?.get(1)!!.low}"
        tv_type_forecast2.text = "天气:${any.forecast?.get(1)!!.type}"

        tv_date_forecast3.text = "日期:${any.forecast?.get(2)!!.date}"
        tv_fengli_forecast3.text = "风力:${any.forecast?.get(2)!!.fengli}"
        tv_fengxiang_forecast3.text = "风向:${any.forecast?.get(2)!!.fengxiang}"
        tv_high_forecast3.text = "最高温度:${any.forecast?.get(2)!!.high}"
        tv_low_forecast3.text = "最低温度:${any.forecast?.get(2)!!.low}"
        tv_type_forecast3.text = "天气:${any.forecast?.get(2)!!.type}"

        tv_date_forecast4.text = "日期:${any.forecast?.get(3)!!.date}"
        tv_fengli_forecast4.text = "风力:${any.forecast?.get(3)!!.fengli}"
        tv_fengxiang_forecast4.text = "风向:${any.forecast?.get(3)!!.fengxiang}"
        tv_high_forecast4.text = "最高温度:${any.forecast?.get(3)!!.high}"
        tv_low_forecast4.text = "最低温度:${any.forecast?.get(3)!!.low}"
        tv_type_forecast4.text = "天气:${any.forecast?.get(3)!!.type}"

        tv_date_forecast5.text = "日期:${any.forecast?.get(4)!!.date}"
        tv_fengli_forecast5.text = "风力:${any.forecast?.get(4)!!.fengli}"
        tv_fengxiang_forecast5.text = "风向:${any.forecast?.get(4)!!.fengxiang}"
        tv_high_forecast5.text = "最高温度:${any.forecast?.get(4)!!.high}"
        tv_low_forecast5.text = "最低温度:${any.forecast?.get(4)!!.low}"
        tv_type_forecast5.text = "天气:${any.forecast?.get(4)!!.type}"

        tv_refush_time.text = "渲染耗时：${(System.currentTimeMillis()-requestStartTime)}ms"
    }
}
