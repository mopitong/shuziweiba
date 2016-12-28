package com.mpt.demo.model;

import java.util.List;

/**
 * Created by mpt on 2016/12/27.
 */

public class BusModel {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"retList":[{"stats":"富德新村;五一站;莫屋坡;中兴桥南;中尧路西;中尧南路口;新阳龙腾路口;龙腾铁路立交;新阳北大路口;新阳路水街市场;人民永宁路口;人民解放路口;人民西关路口;朝阳人民路口;朝阳济南路口;火车站(苏州路);中华友爱路口;中华安宁路口;中华北湖路口;中华园湖路口;望州南路南;望州南小区;望州岭站;望州路中;望州兴望路口;兴望路;东沟岭;东州南梧路口(景观南梧路口);沙江桥;小鸡村;二塘站;广西花鸟交易市场;药用植物园(大嘉汇商贸港);降桥村路口;南梧高速路口;大嘉汇建材家居城;金桥站","name":"202路(富德新村-金桥站)","info":"运行时间：6:15-22:30;一票制 票价：2.00元/人次"},{"stats":"金桥站;大嘉汇建材家居城;南梧高速路口;降桥村路口;药用植物园(大嘉汇商贸港);广西花鸟交易市场;二塘站;小鸡村;沙江桥;东州南梧路口(景观南梧路口);东沟岭;兴望路;望州兴望路口;望州路中;望州岭站;望州南小区;望州南路南;中华园湖路口;中华北湖路口;中华安宁路口;中华友爱路口;火车站(苏州路);朝阳济南路口;人民朝阳路口;人民西关路口;人民解放路口;人民永宁路口;新阳路水街市场;新阳北大路口;龙腾铁路立交;新阳龙腾路口;中尧南路口;中尧路西;中兴桥南;莫屋坡;五一站;富德新村","name":"202路(金桥站-富德新村)","info":"运行时间：6:15-22:30;"}]}
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

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * retList : [{"stats":"富德新村;五一站;莫屋坡;中兴桥南;中尧路西;中尧南路口;新阳龙腾路口;龙腾铁路立交;新阳北大路口;新阳路水街市场;人民永宁路口;人民解放路口;人民西关路口;朝阳人民路口;朝阳济南路口;火车站(苏州路);中华友爱路口;中华安宁路口;中华北湖路口;中华园湖路口;望州南路南;望州南小区;望州岭站;望州路中;望州兴望路口;兴望路;东沟岭;东州南梧路口(景观南梧路口);沙江桥;小鸡村;二塘站;广西花鸟交易市场;药用植物园(大嘉汇商贸港);降桥村路口;南梧高速路口;大嘉汇建材家居城;金桥站","name":"202路(富德新村-金桥站)","info":"运行时间：6:15-22:30;一票制 票价：2.00元/人次"},{"stats":"金桥站;大嘉汇建材家居城;南梧高速路口;降桥村路口;药用植物园(大嘉汇商贸港);广西花鸟交易市场;二塘站;小鸡村;沙江桥;东州南梧路口(景观南梧路口);东沟岭;兴望路;望州兴望路口;望州路中;望州岭站;望州南小区;望州南路南;中华园湖路口;中华北湖路口;中华安宁路口;中华友爱路口;火车站(苏州路);朝阳济南路口;人民朝阳路口;人民西关路口;人民解放路口;人民永宁路口;新阳路水街市场;新阳北大路口;龙腾铁路立交;新阳龙腾路口;中尧南路口;中尧路西;中兴桥南;莫屋坡;五一站;富德新村","name":"202路(金桥站-富德新村)","info":"运行时间：6:15-22:30;"}]
         */

        private int ret_code;
        private List<RetListBean> retList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<RetListBean> getRetList() {
            return retList;
        }

        public void setRetList(List<RetListBean> retList) {
            this.retList = retList;
        }

        public static class RetListBean {
            /**
             * stats : 富德新村;五一站;莫屋坡;中兴桥南;中尧路西;中尧南路口;新阳龙腾路口;龙腾铁路立交;新阳北大路口;新阳路水街市场;人民永宁路口;人民解放路口;人民西关路口;朝阳人民路口;朝阳济南路口;火车站(苏州路);中华友爱路口;中华安宁路口;中华北湖路口;中华园湖路口;望州南路南;望州南小区;望州岭站;望州路中;望州兴望路口;兴望路;东沟岭;东州南梧路口(景观南梧路口);沙江桥;小鸡村;二塘站;广西花鸟交易市场;药用植物园(大嘉汇商贸港);降桥村路口;南梧高速路口;大嘉汇建材家居城;金桥站
             * name : 202路(富德新村-金桥站)
             * info : 运行时间：6:15-22:30;一票制 票价：2.00元/人次
             */

            private String stats;
            private String name;
            private String info;

            public String getStats() {
                return stats;
            }

            public void setStats(String stats) {
                this.stats = stats;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }
        }
    }
}
