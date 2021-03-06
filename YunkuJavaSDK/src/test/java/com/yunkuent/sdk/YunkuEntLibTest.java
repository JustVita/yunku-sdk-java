package com.yunkuent.sdk;

import com.yunkuent.sdk.data.ReturnResult;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qp on 2017/3/8.
 */
public class YunkuEntLibTest {

    public static final String CLIENT_ID = "";
    public static final String CLIENT_SECRET = "";

    @Ignore("create is ignored")
    @Test
    public void create() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.create("aaa", "1073741824", "destroy", "test lib", "");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void set() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.set(1258748, "ttt", "1073741824", "", "");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Ignore("getLibList is ignored")
    @Test
    public void getLibList() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getLibList();
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getLibListById() throws Exception {

        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getLibList(1258748);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getMember() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getMember(1258748, MemberType.MEMBER_ID,new String[]{"4"});
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getInfo() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getInfo(1258748);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Ignore("bind is ignored")
    @Test
    public void bind() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.bind(0,"YunkuJavaSDKDemo",null);
        ReturnResult r = ReturnResult.create(s);
        System.out.println(r);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Ignore("unBind is ignored")
    @Test
    public void unBind() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.unBind("");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getMembers() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getMembers(0, 10, 1258748);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void addMembers() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.addMembers(1258748,3330,new int[]{52064});
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void setMemberRole() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.setMemberRole(1258748,3208,new int[]{216144});
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void delMember() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.delMember(1258748,new int[]{52064});
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void addGroup() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.addGroup(1258748,71715,3208);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getGroups() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.getGroups(1258748);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void setGroupRole() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.setGroupRole(1258748,4448,3208);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void delGroup() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.delGroup(1258748,71715);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Ignore("destroy is ignored")
    @Test
    public void destroy() throws Exception {
        EntLibManager entLib = new EntLibManager(CLIENT_ID, CLIENT_SECRET);
        String s = entLib.destroy("b2013df96cbc23b4b0dd72f075e5cbf7");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

}