package com.yunkuent.sdk;

import com.yunkuent.sdk.data.ReturnResult;
import com.yunkuent.sdk.upload.UploadCallBack;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qp on 2017/3/8.
 */
public class YunkuEntFileTest {

    public static final String ORG_CLIENT_ID = "";
    public static final String ORG_CLIENT_SECRET = "";




    @Test
    public void getFileList() throws Exception{
            EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
            String s = entFile.getFileList();
            ReturnResult r = ReturnResult.create(s);
            Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getUpdateList() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getUpdateList(false, 0);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getFileInfo() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getFileInfo("qq.jpg", EntFileManager.NetType.DEFAULT);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFolder() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.createFolder("test","Brandon");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFile() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.createFile("qqq.jpg","Brandon","/Users/gokuai/Desktop/qq.jpg ",false);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFileAndOverWrite() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.createFile("qq.jpg","Brandon","/Users/gokuai/Desktop/qq.jpg ");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFileByStream() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        FileInputStream stream = new FileInputStream(new File("/Users/gokuai/Desktop/qq.jpg"));
        String s = entFile.createFile("qq.jpg","Brandon",stream,false);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFileByStreamAndOverWrite() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        FileInputStream stream = new FileInputStream(new File("/Users/gokuai/Desktop/qq.jpg"));
        String s = entFile.createFile("qqq.jpg","Brandon",stream);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void uploadByBlock() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        CountDownLatch latch = new CountDownLatch(1);
        entFile.uploadByBlock("ttt.zip", "Brandon", 0, "/Users/gokuai/Desktop/tt.zip", false, new UploadCallBack() {
            @Override
            public void onSuccess(long threadId, String fileHash) {
                latch.countDown();
                Assert.assertEquals(1,threadId);
                System.out.println("success:" + threadId);
            }

            @Override
            public void onFail(long threadId, String errorMsg) {
                Assert.fail();
                System.out.println("fail:" + threadId + " errorMsg:" + errorMsg);
            }

            @Override
            public void onProgress(long threadId, float percent) {
                System.out.println("onProgress:" + threadId + " onProgress:" + percent * 100);
            }
        });
            latch.await();
    }

    @Test
    public void uploadByBlockAndOverWrite() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        CountDownLatch latch = new CountDownLatch(1);
        entFile.uploadByBlock("tttt.zip", "Brandon", 0, "/Users/gokuai/Desktop/tt.zip", new UploadCallBack() {
            @Override
            public void onSuccess(long threadId, String fileHash) {
                latch.countDown();
                Assert.assertEquals(1,threadId);
                System.out.println("success:" + threadId);
            }

            @Override
            public void onFail(long threadId, String errorMsg) {
                Assert.fail();
                System.out.println("fail:" + threadId + " errorMsg:" + errorMsg);
            }

            @Override
            public void onProgress(long threadId, float percent) {
                System.out.println("onProgress:" + threadId + " onProgress:" + percent * 100);
            }
        });
            latch.await();
    }

    @Test
    public void uploadByStream() throws Exception {
        InputStream inputStream = new FileInputStream(new File("/Users/gokuai/Desktop/tt.zip"));
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        CountDownLatch Latch = new CountDownLatch(1);
        entFile.uploadByBlock("tt.zip", "Brandon",0, inputStream, false, new UploadCallBack() {
            @Override
            public void onSuccess(long threadId, String fileHash) {
                Latch.countDown();
                Assert.assertEquals(1,threadId);
                System.out.println("success:" + threadId);
            }

            @Override
            public void onFail(long threadId, String errorMsg) {
                Assert.fail();
                System.out.println("fail:" + threadId + " errorMsg:" + errorMsg);
            }

            @Override
            public void onProgress(long threadId, float percent) {
                System.out.println("onProgress:" + threadId + " onProgress:" + percent * 100);
            }
        });
        Latch.await();
    }

    @Test
    public void uploadByStreamAndOverWrite() throws Exception {
        InputStream inputStream = new FileInputStream(new File("/Users/gokuai/Desktop/tt.zip"));
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        CountDownLatch latch = new CountDownLatch(1);
        entFile.uploadByBlock("tt.zip", "Brandon",0, inputStream, new UploadCallBack() {
            @Override
            public void onSuccess(long threadId, String fileHash) {
                latch.countDown();
                Assert.assertEquals(1,threadId);
                System.out.println("success:" + threadId);
            }

            @Override
            public void onFail(long threadId, String errorMsg) {
                Assert.fail();
                System.out.println("fail:" + threadId + " errorMsg:" + errorMsg);
            }

            @Override
            public void onProgress(long threadId, float percent) {
                System.out.println("onProgress:" + threadId + " onProgress:" + percent * 100);
            }
        });
            latch.await();
    }

    @Test
    public void move() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.move("qqq.jpg","test/qqq.jpg","Brandon");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void link() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.link("qq.jpg", 0, EntFileManager.AuthType.DEFAULT, null);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void sendmsg() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.sendmsg("msgTest", "msg", "", "", "Brandon");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void links() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.links(true);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getUpdateCounts() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);//昨天
        Date date = calendar.getTime();
        String s = entFile.getUpdateCounts( date.getTime(), System.currentTimeMillis(), false);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFileByUrlAndOverWrite() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.createFileByUrl("qq.jpg", 0,
                "Brandon", "http://reso2.yiihuu.com/976162-z.jpg");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void createFileByUrl() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.createFileByUrl("qq.jpg", 0,
                "Brandon", true, "http://reso2.yiihuu.com/976162-z.jpg");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getUploadServers() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getUploadServers();
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Ignore
    public void getServerSite() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getServerSite("");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void search() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.search("tes", "", 0, 100, ScopeType.FILENAME, ScopeType.TAG, ScopeType.CONTENT);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getDownloadUrlByHash() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getDownloadUrlByHash("5ef2b3b8449cf3440b8a3b1874da5e4236b06dd8",false,EntFileManager.NetType.DEFAULT);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void getDownloadUrlByFullPath() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.getDownloadUrlByFullPath("qq.jpg",false, EntFileManager.NetType.DEFAULT);
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

    @Test
    public void del() throws Exception {
        EntFileManager entFile = new EntFileManager(ORG_CLIENT_ID, ORG_CLIENT_SECRET);
        String s = entFile.del("test","Brandon");
        ReturnResult r = ReturnResult.create(s);
        Assert.assertEquals(200,r.getStatusCode());
    }

}