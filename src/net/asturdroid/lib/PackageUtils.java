package net.asturdroid.lib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageUtils {
	public static int VersionCode(Context mContext) {
		PackageInfo pinfo;
		try {
			pinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			return 0;
		}
		return pinfo.versionCode;
	}
}
