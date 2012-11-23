package net.asturdroid.lib;

import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;

public class Social {
	/**
	 * Open a contextual Menu with the available applications to share
	 * 
	 * @param ctx
	 *            Context (to open the menu and the new activity)
	 * @param subject
	 * @param text
	 */
	public static void share(Context ctx, String subject, String text) {
		final Intent intent = new Intent(Intent.ACTION_SEND);

		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, text);

		ctx.startActivity(Intent.createChooser(intent, ctx.getString(R.string.share)));
	}

	/**
	 * Open a contextual Menu with the available applications to share
	 * 
	 * @param ctx
	 *            Context (to open the menú and the new activity)
	 * @param subject
	 * @param text
	 */
	public static void share(Context ctx, String subject, CharSequence text) {
		share(ctx, subject, text.toString());
	}

	public static void share(Context ctx, String subject, String text,
			Uri imageURI) {
		final Intent intent = new Intent(Intent.ACTION_SEND);

		intent.setType("image/jpeg");
		// intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		// intent.putExtra(Intent.EXTRA_TEXT, text);
		intent.putExtra(Intent.EXTRA_STREAM, imageURI);
		ctx.startActivity(Intent.createChooser(intent, "Share"));
	}

	@Deprecated
	public static void share(Context ctx, String subject, String text,
			Bitmap image) {
		Uri uri = null;
		try {
			uri = ImageManager.SaveBitmapInSD(ctx, image);
		} catch (NoExternalMemoryFound e) {
			Toast.makeText(ctx, ctx.getResources().getString(R.string.no_sd_found), Toast.LENGTH_LONG);
		} catch (IOException e) {
			Toast.makeText(ctx, ctx.getResources().getString(R.string.IOException), Toast.LENGTH_LONG);
		}

		if (uri == null)
			return;

		share(ctx, subject, text, uri);
	}

}