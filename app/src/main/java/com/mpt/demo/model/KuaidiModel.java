package com.mpt.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mpt on 2016/12/27.
 */

public class KuaidiModel implements Serializable{


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"mailNo":"710312852010","update":1482827571794,"updateStr":"2016-12-27 16:32:51","ret_code":0,"flag":true,"status":4,"tel":"021-69777888/999","data":[{"time":"2016-12-21 13:44:03","context":"客户 签收人: 本人签收 已签收  感谢使用圆通速递，期待再次为您服务"},{"time":"2016-12-20 15:29:01","context":"广西省南宁市兴宁区朝阳公司(点击查询电话)郑** 派件中 派件员电话18507712287"},{"time":"2016-12-20 13:42:23","context":"广西省南宁市兴宁区朝阳公司 已收入"},{"time":"2016-12-20 10:23:06","context":"南宁转运中心 已发出,下一站 广西省南宁市兴宁区朝阳"},{"time":"2016-12-20 10:19:00","context":"南宁转运中心 已收入"},{"time":"2016-12-20 01:44:13","context":"江门转运中心 已发出,下一站 南宁转运中心"},{"time":"2016-12-20 01:42:54","context":"江门转运中心 已收入"},{"time":"2016-12-19 22:53:23","context":"广东省珠海市公司 已发出,下一站 江门转运中心"},{"time":"2016-12-19 22:53:10","context":"广东省珠海市公司 已打包"},{"time":"2016-12-19 19:37:42","context":"广东省珠海市香洲区一站公司(点击查询电话) 已揽收"}],"expSpellName":"yuantong","expTextName":"圆通速递"}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean implements Serializable{
        /**
         * mailNo : 710312852010
         * update : 1482827571794
         * updateStr : 2016-12-27 16:32:51
         * ret_code : 0
         * flag : true
         * status : 4
         * tel : 021-69777888/999
         * data : [{"time":"2016-12-21 13:44:03","context":"客户 签收人: 本人签收 已签收  感谢使用圆通速递，期待再次为您服务"},{"time":"2016-12-20 15:29:01","context":"广西省南宁市兴宁区朝阳公司(点击查询电话)郑** 派件中 派件员电话18507712287"},{"time":"2016-12-20 13:42:23","context":"广西省南宁市兴宁区朝阳公司 已收入"},{"time":"2016-12-20 10:23:06","context":"南宁转运中心 已发出,下一站 广西省南宁市兴宁区朝阳"},{"time":"2016-12-20 10:19:00","context":"南宁转运中心 已收入"},{"time":"2016-12-20 01:44:13","context":"江门转运中心 已发出,下一站 南宁转运中心"},{"time":"2016-12-20 01:42:54","context":"江门转运中心 已收入"},{"time":"2016-12-19 22:53:23","context":"广东省珠海市公司 已发出,下一站 江门转运中心"},{"time":"2016-12-19 22:53:10","context":"广东省珠海市公司 已打包"},{"time":"2016-12-19 19:37:42","context":"广东省珠海市香洲区一站公司(点击查询电话) 已揽收"}]
         * expSpellName : yuantong
         * expTextName : 圆通速递
         */

        private String mailNo;
        private long update;
        private String updateStr;
        private int ret_code;
        private boolean flag;
        private int status;
        private String tel;
        private String expSpellName;
        private String expTextName;
        private List<DataBean> data;

        public String getMailNo() {
            return mailNo;
        }

        public void setMailNo(String mailNo) {
            this.mailNo = mailNo;
        }

        public long getUpdate() {
            return update;
        }

        public void setUpdate(long update) {
            this.update = update;
        }

        public String getUpdateStr() {
            return updateStr;
        }

        public void setUpdateStr(String updateStr) {
            this.updateStr = updateStr;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getExpSpellName() {
            return expSpellName;
        }

        public void setExpSpellName(String expSpellName) {
            this.expSpellName = expSpellName;
        }

        public String getExpTextName() {
            return expTextName;
        }

        public void setExpTextName(String expTextName) {
            this.expTextName = expTextName;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable{
            /**
             * time : 2016-12-21 13:44:03
             * context : 客户 签收人: 本人签收 已签收  感谢使用圆通速递，期待再次为您服务
             */

            private String time;
            private String context;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }
        }
    }
}
