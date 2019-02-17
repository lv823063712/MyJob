package soexample.bigfly.com.myjob0216.data;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   21:00<p>
 * <p>更改时间：2019/2/16   21:00<p>
 * <p>版本号：1<p>
 */

public class RxxpBean {
    private int id;
    private String name;
    private List<CommodityListBean> commodityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CommodityListBean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<CommodityListBean> commodityList) {
        this.commodityList = commodityList;
    }
}
