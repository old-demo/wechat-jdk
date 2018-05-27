package com.beginner.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 素材列表
 * @author heqing
 * @date 2018/5/26.
 */
public class ItemList {

    /**
     * totalCount : 该类型的素材的总数
     */
    @JSONField(name = "total_count")
    private Integer totalCount;

    /**
     * totalCount : 该类型的素材的总数
     */
    @JSONField(name = "item_count")
    private Integer itemCount;

    /**
     * item : 素材信息列表
     */
    @JSONField(name = "item")
    private List<Item> itemList;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
