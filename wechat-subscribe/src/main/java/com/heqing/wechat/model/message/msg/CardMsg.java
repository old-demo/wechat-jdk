package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.model.message.msg.model.Card;

/**
 * 卡券消息
 * @author heqing
 * @date 2018/5/30
 */
public class CardMsg extends BaseMsg {

    /**
     * 卡券id
     */
    @JSONField(name = "card_id")
    private String cardId;

    /**
     * 卡券信息
     */
    @JSONField(name = "card_ext")
    private Card card;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public CardMsg() {
        this.msgType = MsgType.WXCARD.getName();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
