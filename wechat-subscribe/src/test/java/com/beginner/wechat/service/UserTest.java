package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private final static String TOKEN = "10_M4Fv9A8UPXX4zhNvddITwUAnw9Yv-Vn89YBAW2y_3_aLsr4oT-Y26l23FOmTSS2w5p7PCwoBgkNW-HRVZOZ-IOFSXQ0--12mwG9ni-vEI8p1tQgRKUmgn-9NN1qOOIA-MbqkIl9iwpaMLVCVSEYgADACOI";

    @Autowired
    UserService userService;

    @Test
    public void testCreateTag() {
        // 创建标签
        Result result = userService.createTag(TOKEN, "男");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTag() {
        //  获取公众号已创建的标签
        Result result = userService.getTag(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testUpdateTag() {
        // 编辑标签
        Result result = userService.updateTag(TOKEN, 104, "女性");
        System.out.println("--->"+result);
    }

    @Test
    public void testDeleteTag() {
        // 删除标签
        Result result = userService.deleteTag(TOKEN, 104);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetFansListByTag() {
        // 获取标签下粉丝列表
        Result result = userService.getFansListByTag(TOKEN, 103, "");
        System.out.println("--->"+result);
    }

    @Test
    public void testBatchTagging() {
        // 批量为用户打标签
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userService.batchTagging(TOKEN, 103, openidList);
        System.out.println("--->"+result);
    }

    @Test
    public void testBatchUnTagging() {
        // 批量为用户取消标签
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userService.batchUnTagging(TOKEN, 103, openidList);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTagIdByOpenId() {
        // 获取用户身上的标签列表
        Result result = userService.getTagIdByOpenId(TOKEN, "o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        System.out.println("--->"+result);
    }

    @Test
    public void testUpdateRemark() {
        // 设置用户备注名
        Result result = userService.updateRemark(TOKEN, "oa3070VHNTZojJ-zdhZPIe21ETHs", "小白");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetFansList() {
        // 获取关注用户列表
        Result result = userService.getFansList(TOKEN, "oa3070VHNTZojJ-zdhZPIe21ETHs");
        System.out.println("--->"+result);
    }

}
