package com.gokuai.yunku.demo.compat.v2.lib;

import com.gokuai.yunku.demo.compat.v2.helper.EntLibraryManagerHelper;
import com.gokuai.yunku.demo.helper.DeserializeHelper;
import com.yunkuent.sdk.DebugConfig;

/**
 * Created by qp on 2017/3/2.
 *
 * 获取某一个库的成员
 */
public class GetMembers {

    public static void main(String[] args) {

        DebugConfig.PRINT_LOG = true;
//        DebugConfig.LOG_PATH="LogPath/";

        String returnString = EntLibraryManagerHelper.getInstance().getMembers(0, 10, 1262679);

        DeserializeHelper.getInstance().deserializeReturn(returnString);
    }
}
