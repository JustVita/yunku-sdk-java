package com.gokuai.yunku.demo.ent;

import com.gokuai.yunku.demo.helper.DeserializeHelper;
import com.gokuai.yunku.demo.helper.EntManagerHelper;
import com.yunkuent.sdk.DebugConfig;

/**
 * Created by qp on 2017/3/2.
 *
 * 添加同步分组
 */
public class AddSyncGroup {

    public static void main(String[] args) {

        DebugConfig.PRINT_LOG = true;
//        DebugConfig.LOG_PATH="LogPath/";


        String returnString = EntManagerHelper.getInstance().addSyncGroup("ParentGroup", "ParentGroup", "");
        String returnString1 = EntManagerHelper.getInstance().addSyncGroup("GroupTest", "Group", "ParentGroup");

        DeserializeHelper.getInstance().deserializeReturn(returnString);
        DeserializeHelper.getInstance().deserializeReturn(returnString1);
    }
}
