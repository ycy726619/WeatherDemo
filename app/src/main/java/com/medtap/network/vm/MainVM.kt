package com.medtap.network.vm

import com.medtap.network.library.IOTransFormHelper.RxStreamHelper
import com.medtap.network.library.ObserverCallBack.DesCallBack
import com.medtap.network.library.api.ApiClient
import com.medtap.network.library.commen.Destiny
import com.medtap.network.library.data.DataBean

/**
 * VM层 数据callback给View层
 */
class MainVM {
    fun getData(cityName:String,callback: DesCallBack<DataBean>) {
        return ApiClient
                .instance
                .getApiService()
                .test(cityName)
                .compose(RxStreamHelper().io_Main())
                .map {
                    it.transform()
                }
                .subscribe(Destiny(callback))
    }
}