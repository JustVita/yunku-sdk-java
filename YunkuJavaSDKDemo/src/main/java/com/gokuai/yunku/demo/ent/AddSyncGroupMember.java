package com.gokuai.yunku.demo.ent;

import com.gokuai.yunku.demo.helper.DeserializeHelper;
import com.gokuai.yunku.demo.helper.EntManagerHelper;
import com.yunkuent.sdk.DebugConfig;

/**
 * Created by qp on 2017/3/2.
 *
 * 添加同步分组的成员
 */
public class AddSyncGroupMember {

    public static void main(String[] args) {

        DebugConfig.PRINT_LOG = true;
//        DebugConfig.LOG_PATH="D://LogPath";//默认在D盘根目录

        String returnString = EntManagerHelper.getInstance().addSyncGroupMember("GroupTest",new String[]{"MemberTest1"});
        String returnString1 = EntManagerHelper.getInstance().addSyncGroupMember("ParentGroup", new String[] { "MemberTest2","MemberTest3" });

        DeserializeHelper.getInstance().deserializeReturn(returnString);
        DeserializeHelper.getInstance().deserializeReturn(returnString1);
    }
}
