package soexample.bigfly.com.myjob0216.data;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   20:53<p>
 * <p>更改时间：2019/2/16   20:53<p>
 * <p>版本号：1<p>
 */

public class ResultBean {
    private List<RxxpBean> rxxp;
    private List<RxxpBean> pzsh;
    private List<RxxpBean> mlss;

    public List<RxxpBean> getRxxp() {
        return rxxp;
    }

    public void setRxxp(List<RxxpBean> rxxp) {
        this.rxxp = rxxp;
    }

    public List<RxxpBean> getPzsh() {
        return pzsh;
    }

    public void setPzsh(List<RxxpBean> pzsh) {
        this.pzsh = pzsh;
    }

    public List<RxxpBean> getMlss() {
        return mlss;
    }

    public void setMlss(List<RxxpBean> mlss) {
        this.mlss = mlss;
    }
}
