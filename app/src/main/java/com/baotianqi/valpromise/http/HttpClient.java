package com.baotianqi.valpromise.http;


import com.baotianqi.valpromise.application.MyApplication;
import com.baotianqi.valpromise.bean.AccountListBean;
import com.baotianqi.valpromise.bean.AddCoinOrderBean;
import com.baotianqi.valpromise.bean.CheckOldPasswordBean;
import com.baotianqi.valpromise.bean.CheckPayPasswordBean;
import com.baotianqi.valpromise.bean.CheckVersionBean;
import com.baotianqi.valpromise.bean.CityBean;
import com.baotianqi.valpromise.bean.CoinOrderResult;
import com.baotianqi.valpromise.bean.CoinProductBean;
import com.baotianqi.valpromise.bean.CountryListBean;
import com.baotianqi.valpromise.bean.CustomerDetailBean;
import com.baotianqi.valpromise.bean.DepositInfoBean;
import com.baotianqi.valpromise.bean.DepositListBean;
import com.baotianqi.valpromise.bean.EmptyBean;
import com.baotianqi.valpromise.bean.HomeBean;
import com.baotianqi.valpromise.bean.InviteBean;
import com.baotianqi.valpromise.bean.LoginBean;
import com.baotianqi.valpromise.bean.OrderCoinInfoBean;
import com.baotianqi.valpromise.bean.OrderListBean;
import com.baotianqi.valpromise.bean.OrderTempInfoBean;
import com.baotianqi.valpromise.bean.PaymentHistoryBean;
import com.baotianqi.valpromise.bean.PayoutHistoryBean;
import com.baotianqi.valpromise.bean.RainContractBean;
import com.baotianqi.valpromise.bean.TempContractBean;
import com.baotianqi.valpromise.bean.WalletAddressBean;
import com.baotianqi.valpromise.bean.WithdrawalListBean;
import com.example.http.bean.BaseBean;
import com.example.http.utils.BuildFactory;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author jingbin
 * @date 16/11/21
 * 网络请求类（一个接口一个方法）
 */
public interface HttpClient {


    class Builder {
        public static HttpClient getService () {
            return BuildFactory.getInstance().create(HttpClient.class, MyApplication.BASE_URL);
        }

    }

    /**
     * 下载新版本
     *
     * @param path
     * @return
     */
    @GET
    Observable<ResponseBody> downloadNewVersion (@Url String path);

    /**
     * 登录
     *
     * @param
     * @return
     */
    @POST("/app/login")
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> login (@FieldMap Map<String, Object> map);

    /**
     * 验证码登录
     *
     * @param
     * @return
     */
    @POST("/app/loginCode")
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> loginByCode (@FieldMap Map<String, Object> map);

    /**
     * 获取验证码
     *
     * @param
     * @return
     */
    @POST("/app/getMobileCode")
    @FormUrlEncoded
    Observable<BaseBean<String>> getCode (@FieldMap Map<String, Object> map);


    /**
     * 编辑钱包地址
     *
     * @param
     * @return
     */
    @POST("/app/withdrawal/updateWithdrawalAccount")
    @FormUrlEncoded
    Observable<BaseBean<String>> editWithdrawalAccount (@FieldMap Map<String, Object> map);

    /**
     * 添加提现钱包地址
     *
     * @param
     * @return
     */
    @POST("/app/withdrawal/insertWithdrawalAccount")
    @FormUrlEncoded
    Observable<BaseBean<String>> addWithdrawalAccount (@FieldMap Map<String, Object> map);

    /**
     * 提现
     *
     * @param
     * @return
     */
    @POST("/app/withdrawal/withdrawal")
    @FormUrlEncoded
    Observable<BaseBean<String>> withdrawalVpp (@FieldMap Map<String, Object> map);

    /**
     * 获取账户详情
     *
     * @param
     * @return
     */
    @POST("/app/customer/customerDetail")
    @FormUrlEncoded
    Observable<BaseBean<CustomerDetailBean>> getCustomerDetail (@FieldMap Map<String, Object> map);

    /**
     * 获取钱包列表
     *
     * @param
     * @return
     */
    @POST("/app/withdrawal/withdrawalAccountList")
    @FormUrlEncoded
    Observable<BaseBean<AccountListBean>> getWithdrawalAccountList (@FieldMap Map<String, Object> map);

    /**
     * 校验支付密码
     *
     * @param
     * @return
     */
    @POST("/app/customer/checkPayPassword")
    @FormUrlEncoded
    Observable<BaseBean<CheckPayPasswordBean>> checkPayPassword (@FieldMap Map<String, Object> map);

    /**
     * 修改支付密码
     *
     * @param
     * @return
     */
    @POST("/app/customer/updatePayPassword")
    @FormUrlEncoded
    Observable<BaseBean<String>> updatePayPassword (@FieldMap Map<String, Object> map);

    /**
     * 校验旧的支付密码
     *
     * @param
     * @return
     */
    @POST("/customer/checkOldPayPassword")
    @FormUrlEncoded
    Observable<BaseBean<CheckOldPasswordBean>> checkOldPayPassword (@FieldMap Map<String, Object> map);

    /**
     * 设置支付密码
     *
     * @param
     * @return
     */
    @POST("/customer/setPayPassword")
    @FormUrlEncoded
    Observable<BaseBean<EmptyBean>> setPayPassword (@FieldMap Map<String, Object> map);

    /**
     * 设置支付密码
     *
     * @param
     * @return
     */
    @POST("/customer/checkWhetherPayPassword")
    @FormUrlEncoded
    Observable<BaseBean<EmptyBean>> checkWhetherPayPassword (@FieldMap Map<String, Object> map);

    /**
     * 提交建议
     *
     * @param
     * @return
     */
    @POST("/app/suggestion/insert")
    @FormUrlEncoded
    Observable<BaseBean<String>> setSuggestion (@FieldMap Map<String, Object> map);

    /**
     * 获取购买明细
     *
     * @param
     * @return
     */
    @POST("/pay/paymentHistory")
    @FormUrlEncoded
    Observable<BaseBean<PaymentHistoryBean>> getPaymentHistory (@FieldMap Map<String, Object> map);

    /**
     * 获取履行明细
     *
     * @param
     * @return
     */
    @POST("/pay/payoutHistory")
    @FormUrlEncoded
    Observable<BaseBean<PayoutHistoryBean>> getPayoutHistory (@FieldMap Map<String, Object> map);

    /**
     * 获取充值明细
     *
     * @param
     * @return
     */
    @POST("/deposit/depositList")
    @FormUrlEncoded
    Observable<BaseBean<DepositListBean>> getDepositList (@FieldMap Map<String, Object> map);


    /**
     * 查询温度合约
     *
     * @param
     * @return
     */
    @POST("/app/temp/contract/getContract")
    @FormUrlEncoded
    Observable<BaseBean<TempContractBean>> getTempContract (@FieldMap Map<String, Object> map);

    /**
     * 查询降水合约
     *
     * @param
     * @return
     */
    @POST("/app/rain/contract/selectContract")
    @FormUrlEncoded
    Observable<BaseBean<RainContractBean>> getRainContract (@FieldMap Map<String, Object> map);

    /**
     * 添加高温订单（购买合约）
     *
     * @param
     * @return
     */
    @POST("/app/temp/order/addOrder")
    @FormUrlEncoded
    Observable<BaseBean<String>> addTempOrder (@FieldMap Map<String, Object> map);

    /**
     * 添加降雨订单（购买合约）
     *
     * @param
     * @return
     */
    @POST("/app/rain/order/addOrder")
    @FormUrlEncoded
    Observable<BaseBean<String>> addRainOrder (@FieldMap Map<String, Object> map);


    /**
     * 获取温度合约详情
     *
     * @param
     * @return
     */
    @POST("/app/{type}/order/getOrderInfo")
    @FormUrlEncoded
    Observable<BaseBean<OrderTempInfoBean>> getOrderInfo (@Path("type") String type, @FieldMap Map<String, Object> map);

    /**
     * 获取猜币合约详情
     *
     * @param
     * @return
     */
    @POST("/app/coinguess/getDetail")
    @FormUrlEncoded
    Observable<BaseBean<OrderCoinInfoBean>> getCoinOrderInfo (@FieldMap Map<String, Object> map);

    /**
     * 获取区号列表
     *
     * @param
     * @return
     */
    @POST("/app/country/getCountryList")
    @FormUrlEncoded
    Observable<BaseBean<CountryListBean>> getCountryList (@FieldMap Map<String, Object> map);

    /**
     * 注册
     *
     * @param
     * @return
     */
    @POST("/app/register")
    @FormUrlEncoded
    Observable<BaseBean<EmptyBean>> register (@FieldMap Map<String, Object> map);

    /**
     * 首页
     *
     * @param
     * @return
     */
    @POST("/app/index")
    @FormUrlEncoded
    Observable<BaseBean<HomeBean>> getIndex (@FieldMap Map<String, Object> map);

    /**
     * 获取城市列表
     *
     * @param
     * @return
     */
    @POST("/app/city/{type}/list")
    @FormUrlEncoded
    Observable<BaseBean<CityBean>> getCityList (@Path("type") String type, @FieldMap Map<String, Object> map);


    /**
     * 修改手机号
     *
     * @param
     * @return
     */
    @POST("/app/customer/updateMobile")
    @FormUrlEncoded
    Observable<BaseBean<String>> updateMobile (@FieldMap Map<String, Object> map);


    /**
     * 修改登录密码
     *
     * @param
     * @return
     */
    @POST("/app/customer/updatePassword")
    @FormUrlEncoded
    Observable<BaseBean<String>> updatePassword (@FieldMap Map<String, Object> map);


    /**
     * 版本更新
     *
     * @param
     * @return
     */
    @POST("/app/version/checkVersion")
    @FormUrlEncoded
    Observable<BaseBean<CheckVersionBean>> checkVersion (@FieldMap Map<String, Object> map);

    /**
     * 钱包地址
     *
     * @param
     * @return
     */
    @POST("/app/customer/getWalletAddress")
    @FormUrlEncoded
    Observable<BaseBean<WalletAddressBean>> getWalletAddress (@FieldMap Map<String, Object> map);


    /**
     * 获取充值列表
     *
     * @param
     * @return
     */
    @POST("/app/deposit/selectDepositInfo")
    @FormUrlEncoded
    Observable<BaseBean<DepositInfoBean>> selectDepositInfo (@FieldMap Map<String, Object> map);

    /**
     * 获取提现列表
     *
     * @param
     * @return
     */
    @POST("/app/withdrawal/withdrawalList")
    @FormUrlEncoded
    Observable<BaseBean<WithdrawalListBean>> getWithdrawalList (@FieldMap Map<String, Object> map);


    /**
     * 获取我的订单列表
     *
     * @param
     * @return
     */
    @POST("/app/{type}/order/getOrderList")
    @FormUrlEncoded
    Observable<BaseBean<OrderListBean>> getOrderList (@Path("type") String type, @FieldMap Map<String, Object> map);

    /**
     * 获取邀请码
     *
     * @param
     * @return
     */
    @POST("/app/customer/inviteCodePage")
    @FormUrlEncoded
    Observable<BaseBean<InviteBean>> getInviteCode (@FieldMap Map<String, Object> map);


    /**
     * 忘记密码
     *
     * @param
     * @return
     */
    @POST("/app/customer/forgetPassword")
    @FormUrlEncoded
    Observable<BaseBean<String>> forgetPassword (@FieldMap Map<String, Object> map);


    /**
     * 忘记支付密码
     *
     * @param
     * @return
     */
    @POST("/app/customer/forgetPayPassword")
    @FormUrlEncoded
    Observable<BaseBean<String>> forgetPayPassword (@FieldMap Map<String, Object> map);


    /**
     * 猜币产品列表
     *
     * @param
     * @return
     */
    @POST("/app/product_coinguess/getList")
    @FormUrlEncoded
    Observable<BaseBean<CoinProductBean>> getCoinContract (@FieldMap Map<String, Object> map);

    /**
     * 添加猜币订单
     *
     * @param
     * @return
     */
    @POST("/app/coinguess/add")
    @FormUrlEncoded
    Observable<BaseBean<AddCoinOrderBean>> addCoinGuessOrder (@FieldMap Map<String, Object> map);

    /**
     * 获取猜币订单结果
     *
     * @param
     * @return
     */
    @POST("/app/coinguess/getResult")
    @FormUrlEncoded
    Observable<BaseBean<CoinOrderResult>> getCoinGuessResult (@FieldMap Map<String, Object> map);


}