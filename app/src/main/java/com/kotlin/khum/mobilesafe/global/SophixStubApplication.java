package com.kotlin.khum.mobilesafe.global;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.Log;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * <pre>
 *     author : yuanzhenkun
 *     time   : 2018/10/26
 *     desc   :
 * </pre>
 */
public class SophixStubApplication extends SophixApplication {

    public static final String APP_KEY = "25251205";
    public static final String APP_SECRET = "fdaa7af90d6a8813f1e3bf95c0db4505";
    public static final String RSASECRET = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCYH5zo9DiIt+WGunOfGQXIRCUsduS/5ij8DC2gq2Ct9OSLXZuuwBESZ3oY6AZCFS/S4W4t9anGJftCuhDEPFSGRZpPTRvJG3TZQIkYNTnq2zhmpwMCqSry/3ayByJTL15FMeYc0+QmDLEEYGOZrrYACUdWBCWHYqHFHWsBmM0f0f4WqdWp6wds09P0YkMdGnzvu+NdLcpHHQa8jS3aHSwOWnOMO8/sLZ6WkJniKFE2GZl5cjwk5jmEHzy/Cd9qFvRmV66uw6+0Vn3nzNJsdsA3kIQbHI52gnngtP1C5MDX8OKQLfPkOs8uybbTswmfK8RaWJ3NpXGPqcPsMpujWgU9AgMBAAECggEAIs5g5YAzizygXLI+kDF2fDrzUngloK61w+25ZuCvbz3wKN8TJum1PkPE0PwNqoMUfSitQADMhpTcJ4lRGsU/BbXZN7nJ2Lragnbcp1hOVykvf3VJIAu60vyWmOc++E+HP0fKgeANfJM80WaIg3pRFDMLSmgKei6cGvC/Mg9XJ6dWYLhCTbWqWzryIdf8aL0Lh3QINomadETsHNjTVMj9zlUhTHxzcb8PDwM1qNC2uuHwH1lIyFhmlFUPT1LATuJd/4XzIA0PLWOJh81Ko2IpZeYRSR2h1+Kad0n7zum8/W3dCwWLJFDKLvgFhlhe0WSn2bXLB0K7LHKIA3+fEZ361QKBgQDhoU2TgfjhEa5riJfR8Q8iCAXvD5XYILkntqMHgQ8/w0Tqk3hS/pER/WfNScDPnJ3qNrdjtnsoLd6JHb8JmIc858tl+ZjoIaeopGcmSx5W0FS7XmMa7m9jcpdX7A8JNJR6zabRxRx7wr9q9AywX45zrGz9Z29/Lyzl8jp8U9cGiwKBgQCsmXDDDYkV3a0cINdTz/LELo0slLhZcJ1DDdH46GwrXsCoVxe5ZSTBfLq0hdt8jZKCoO2dy0nqG/Twz5MOvnrj+D2agFeS1C1orWKo/pbmeWy6OPp7CNf+g3uTiNSXm4b5yB4Z8kDjjQ3+Hq7HkviC84NwPLqgMAHetcV527nkVwKBgQCSbN7uYoPEdHgQGzYDrgAXIsPPD/s7pojih/knLo9Z3vyDiy6kFcbJuP07UajKUyZ8UAQVtuAYBCSOMXq/3Hevg/IQ/LlJtEWdAQxb4pYO2uaSLj/8w04QaNZk3bIoVDIjvACN0/CXNJyK6VSuxWSqFvUoQo8uJ8xochmYg8Rg3wKBgQCe2WkqWx67fRWBOchzXoMzgxRy3zz7M+XIfMOurVpAYCg3xlATVL8LRFwhIMDsVO9uQeXuv9X7HFfF+YSCoVRA04r+0vfGLnjMSibvGcCPxVkH2sDM00rW9vOYyOm/zmffIwpxHsARrRQfuOVq0BzfiHaDqaCpJQXTjr98c3kWaQKBgQDBjyzjqu9FXrkN0vtifez15FvGejNHUr9qNQamBsjv7mZeA0XxoDSwrRVBZijn7TCwlzBz+g5zqR2v6/frRZfyiV2lbHJAiuLAzcRKt/U6Tsx1LaK3pewLrbTz4y7ZBpQhaNm2UBv4iXrNndMlNJC60fiL5uSltJUsPS3L9xIWkg==";
    private final String TAG = "SophixStubApplication";
    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(App.class)
    static class RealApplicationStub {}
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initSophix();
    }
    private void initSophix() {
        String appVersion;
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
            appVersion = "1.0.0";
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData(APP_KEY, APP_SECRET, RSASECRET)
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }
}
